var workers;
function set_up_workers(){

	$.get( "http://localhost:8080/workers", function( workersArr ) {
		workers = workersArr;
		update_workers_tab();

	});
}
function update_workers_tab(){
	order.services.forEach(function( service){
		var create_select = function(){
			var select = `<select class="selectpicker col-md-6">`;
			workers.forEach(function(worker){
				console.log(worker);
				select += '<option value="'+worker.id+'">'+ worker.speciality+"  "+worker.name+'</option>'
			})
			select += "</select>";
			return select;
		}

		$(".add-worker-list").append(`
			<div class="add-worker-item">
			<span class="label label-default col-md-6"  >`+service.name+`</span>
			`+create_select()+`
			</div>
			`)
		$(".add-worker-list select").selectpicker('refresh');
		console.log(create_select());

		
	})
}
$("#button-done").click(function(){
	add_workers_to_services();
	send_order();
})

function add_workers_to_services(){
	var  sv = $(".add-worker-list").children();
	for(var i = 0; i < sv.length; i++){
		var id = $(sv[i]).find("select").val();
		order.services[i].worker_id = id;
	}
}
function send_order(){
	$.post("http://localhost:8080/orders", {
		car_id: order.car_id,
		client_id: order.client_id
	}, function(newOrderId){
		workUnits = [];
		order.services.forEach(function(service){
			workUnits.push({
				serviceId:service.id,
				workerId: service.worker_id
			})
		})
		console.log(workUnits);
		orderData = JSON.stringify({
			orderId: newOrderId,
			workUnits: workUnits
		})
		$.post("http://localhost:8080/workDetails", {
			order_data:orderData
		}, function(){
			alert("Заказ успешно добавлен")
			document.location.href="opened-orders.html"
		})

	})
}