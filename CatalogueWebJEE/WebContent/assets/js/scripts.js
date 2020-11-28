function addToBasket(id) {
    $.ajax({
        type: "post",
        url: "/",
        data: id,
        success: function(data){

        }
    });
}