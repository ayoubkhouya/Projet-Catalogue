function addToBasket(id) {
    $.ajax({
        url: '/panier',
        method: 'POST',
        data: {add: id},
        success: function() {
            alert("Product added to basket!");
        }
    });
}

function deleteProduct(id) {
    $.ajax({
        url: '/panier',
        data: {remove: id},
        method: 'POST',
        success: function() {
            alert("Product removed ! ");
        }
    })
}