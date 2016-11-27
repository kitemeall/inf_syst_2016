$(document).ready(function(){
	$.get( "http://localhost:8080/orders", function( orders ) {
		orders.forEach(function(order){
			function normDate(date){
				pd = new Date(date);
				return pd.toLocaleDateString("ru-RU");
				
			}
			$('.table-opened-orders tbody').append(`
				<tr onclick="aaa(`+order.id+`)">
				<td>`+order.model+`</td>
				<td>`+order.number+`</td>
				<td>`+order.clientName+`</td>
				<td>`+normDate(order.startDate)+`</td>
				</tr>
				`)

		})
	});

})
function aaa(ddd){
 document.location.href="one-order.html?id=" + ddd;
}