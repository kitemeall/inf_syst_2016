

function set_up_services(){
	$.get( "http://localhost:8080/services", function( serviceArray ) {
		services = serviceArray;
		update_service_select($("#add-service-item"), services);
	});
}
function update_service_select(select, services){
	services.forEach(function(service){

		select.append($('<option>', { 
			value: service.id,
			text : service.name, 
			pirce : service.price, 
		}))

	})
	var p = select.parent().next();
	p.text(services[0].price + " р")
	select.change(function(){
		var index = $(this).prop('selectedIndex')
		$(this).parent().next().text(services[index].price + " р")
	})
	select.selectpicker('refresh');
}
var currServiceItemCount = 1;
$("#service-add-button").click(function(){
	$(".add-service-list").append(`
		<div class="add-service-item">
              <select class="selectpicker col-md-8" data-live-search="true" id="add-service-item`+ currServiceItemCount +`">
              </select> 
              <span class="label label-primary col-md-4" >1000 р</span>
            </div>
		`)
	update_service_select($("#add-service-item"+currServiceItemCount), services);
	currServiceItemCount++;
})
function create_service_object(){
	var  sv = $(".add-service-list").children();
	var servicesArr = [];
	for(var i = 0; i < sv.length; i++){
		 var name = $(sv[i]).find("select").find(":selected").text();
		 var id = $(sv[i]).find("select").val();
		 servicesArr.push({
		 	name: name,
		 	id: id
		 })
	}
	console.log(servicesArr);
	order.services = servicesArr;
}
$("#button-service-next").click(function(){
	create_service_object();
	$(".add-service").hide();
	$(".add-workers").show();
	set_up_workers();
})
