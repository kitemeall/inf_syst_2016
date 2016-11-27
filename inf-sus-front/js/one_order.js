var orderId;

$(document).ready(function(){
	orderId = window.location.href.split("=")[1];

	$.get( "http://localhost:8080/orderDetails?id="+ orderId, 
		function(details){
			$("#client").text(details.client);
			$("#phone").text(details.phone);
			$("#vin").text(details.vin);
			$("#title").text(details.model + "  "+ details.number);
		} )





	$.get( "http://localhost:8080/workDetails?order_id="+ orderId, 
		function(details){
			details.forEach(function(detail){
				console.log("each")
				$(".service-list").append(`
					<div class="info-line">
					<span class="label label-primary col-md-4">`+detail.serviceName+`</span>
					<span class="label label-default col-md-4">`+detail.workerSpec+" "+detail.workerName+`</span>
					<span class="label label-primary col-md-4">`+detail.price+` р</span>
					</div>
					`)			
			})
		} )
})

$("#button-end").click(function(){
	$.get( "http://localhost:8080/endOrder?id="+ orderId, 
		function(details){
			alert("Заказ успешно завершен");
			document.location.href="opened-orders.html"
		} )
})