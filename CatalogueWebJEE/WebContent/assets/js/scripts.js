function addToBasket(id) {
    var name = $("#name").html();
    $.ajax({
        url: '/panier',
        method: 'POST',
        data: {add: id},
        success: function() {
            Swal.fire({
                position: 'top',
                icon: 'success',
                title: '<br>' + name + '<br>' + '\n ajouté avec succès au panier',
                showConfirmButton: false,
                timer: 1500
            });
        },
        error: function() {
            Swal.fire({
                position: top,
                icon: 'error',
                title: 'Problème servenue',
                text: "Impossible d'ajouter ce produit au panier",
                showConfirmButton: false,
                timer: 1500
            });
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

function goBack() {
    window.history.back();
}