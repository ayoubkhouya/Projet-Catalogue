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