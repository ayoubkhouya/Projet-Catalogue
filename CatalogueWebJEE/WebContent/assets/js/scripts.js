function addToBasket(id) {
    $.ajax({
        url: '/panier',
        method: 'POST',
        data: id,
        succes: function() {
            alert("Product added to basket!")
        }
    });
}

function deleteProduct(id) {
    $.ajax({
        url: '/panier',
        data: id,
        method: 'POST',
        succes: function() {
            alert("Product removed ! ");
        }
    })
}