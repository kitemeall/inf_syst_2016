
$(document).ready(function(){
	update_cars_select();
	update_clients_select();
	update_models_select();
})
var order = {};
var services;

function update_cars_select(){

	function car_to_string(car){
		return car.number + " " + car.model + " " + car.vin;
	}
	$.get( "http://localhost:8080/cars", function( carsArray ) {
		carsArray.forEach(function(car){

			$('#cars-select').append($('<option>', { 
				value: car.id,
				text : car_to_string(car) 
			}))

		})
		$('#cars-select').selectpicker('refresh');
	});
}

function update_clients_select(){
	function client_to_string(client){client
		return client.name + " " + client.phone
	}
	$.get( "http://localhost:8080/clients", function( clientsArray ) {
		clientsArray.forEach(function(client){

			$('#clients-select').append($('<option>', { 
				value: client.id,
				text : client_to_string(client) 
			}))

		})
		$('#clients-select').selectpicker('refresh');
	});
}

function update_models_select(){
	
	$.get( "http://localhost:8080/models", function( modelsArray ) {
		modelsArray.forEach(function(model){
			$('#models-select').append($('<option>', { 
				value: model.id,
				text : model.name 
			}))

		})
		$('#models-select').selectpicker('refresh');
	});
}
$("#button-add-car").click(function(){
	var modelId = $("#models-select").val();
	var number = $("#car-number").val();
	var VINNumber = $("#vin-number").val();
	if(modelId == "" || number == "" || VINNumber == ""){
		alert("Не все поля заполнены");
		return;
	}
	$.post("http://localhost:8080/cars", {
		model_id: modelId,
		number: number,
		vin:VINNumber
	}, function(e){
		alert("автомобиль добавлен");
		$("#addCar").modal('hide');
		update_cars_select();
	})

})

function get_service_list(){
	function client_to_string(client){client
		return client.name + " " + client.phone
	}
	$.get( "http://localhost:8080/clients", function( clientsArray ) {
		clientsArray.forEach(function(client){

			$('#clients-select').append($('<option>', { 
				value: client.id,
				text : client_to_string(client) 
			}))

		})
		$('#clients-select').selectpicker('refresh');
	});
}

$("#button-add-client").click(function(){
	var clientName = $("#client-name").val();
	var clientPhone = $("#client-phone").val();
	if(clientName == "" || clientPhone == ""){
		alert("Не все поля заполнены");
		return;
	}
	$.post("http://localhost:8080/clients", {
		name: clientName,
		phone: clientPhone
	}, function(e){
		alert("клиент добавлен");
		$("#addClient").modal('hide');
		update_clients_select();
	})

})

$("#button-next").click(function(){
	order.car_id = $("#cars-select").val()
	order.client_id = $("#clients-select").val()
	console.log(order);
	$(".choose-client").hide();
	$(".add-service").show();
	set_up_services();
})

