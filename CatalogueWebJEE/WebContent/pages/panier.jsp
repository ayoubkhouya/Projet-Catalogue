<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@include file="template/header.jsp"%>

<div class="container">
    <h3 class="font-weight-light">
        Catalogue web |
        <i class='fas fa-shopping-cart' style="color: #1717c8"></i>
        <b>Le panier</b>
    </h3>
    <br>
    <div class="row">
        <table class="table table-hover">
            <thead class="bg-primary">
                <th scope="col">Référence</th>
                <th scope="col">Nom</th>
                <th scope="col">Catégorie</th>
                <th scope="col">Quantité</th>
                <th scope="col">Prix</th>
                <th scope="col"></th>
            </thead>
            <tbody>
                <tr>
                    <td scope="row">RXS4454</td>
                    <td>CD-45 Rock</td>
                    <td>Musique</td>
                    <td><input style="max-width: 60px" type="number" min="1"value="1"></td>
                    <td><strong>15.00 €</strong></td>
                    <td><a href="#"><i title="Supprimer" style="color: red" class="fas fa-trash-alt"></i></a></td>
                </tr>
                <tr>
                    <td scope="row">RXS4454</td>
                    <td>CD-45 Rock</td>
                    <td>Musique</td>
                    <td><input style="max-width: 60px" type="number" min="1"value="1"></td>
                    <td><strong>5.00 €</strong></td>
                    <td><a href="#"><i title="Supprimer" style="color: red" class="fas fa-trash-alt"></i></a></td>
                </tr>
                <tr>
                    <td scope="row">RXS4454</td>
                    <td>CD-45 Rock</td>
                    <td>Musique</td>
                    <td><input style="max-width: 60px" type="number" min="1"value="1"></td>
                    <td><strong>5.86 €</strong></td>
                    <td><a href="#"><i title="Supprimer" style="color: red" class="fas fa-trash-alt"></i></a></td>
                </tr>
            </tbody>
            <hr>
            <tr>
                <th scope="col">Total: </th>
            </tr>
            <tr>
                <th scope="col">Frais de livraison: </th>
            </tr>
        </table>
    </div>

    <div class="row">
        <button class="btn btn-lg btn-success">
            <i class='fas fa-euro-sign'></i>
            Passer la commande
        </button>
        <button class="ml-3 btn btn-lg btn-warning">
            <i class='fas fa-shopping-cart'></i>
            Continuer l'achat
        </button>
    </div>
</div>

<%@include file="template/footer.jsp"%>
