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
                title: 'Le produit est ajouté avec succès au panier',
                showConfirmButton: false,
                timer: 1500
            });
            setTimeout(() => {
                window.location.reload();
            }, 1800)
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
    Swal.fire({
        title: 'Etes vous sùr ?',
        text: "Vous voulez supprimer ce produit ?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Oui, supprimer!',
        cancelButtonText: "Non, annuler"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: '/panier',
                data: {remove: id},
                method: 'POST'
            });
            Swal.fire(
                'Supprimé!',
                'Votre produit a été supprimé avec succès',
                'success'
            );
            setTimeout(() => {
                window.location.reload();
            }, 1800)
        }
    })
}

function goBack() {
    window.history.back();
}