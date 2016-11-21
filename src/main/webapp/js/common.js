
$(document).ready(function () {
    var workDetails = {
        orderId: 3,
        workUnits:[
            {
                serviceId: 4,
                workerId: 3
            },
            {
                serviceId: 1,
                workerId: 1,
            },
            {
                serviceId: 3,
                workerId: 2
            }
        ]};
    var order_data = {order_data:JSON.stringify(workDetails)};

    $("#send_button").click(function () {
        $.ajax({
            type: "POST",
            url: "workDetails",
            data: order_data
        });
    })


})