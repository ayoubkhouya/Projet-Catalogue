<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>

<%@ page import="fr.catalogue.beans.Produit" %>
<%@ page import="fr.catalogue.beans.Panier" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="template/header.jsp" %>

<div class="container">
    <h3 class="font-weight-light">
        Catalogue web |
        <i class='fas fa-shopping-cart' style="color: #1717c8"></i>
        <b>Le panier</b>
    </h3>
    <br>
        <%
            Panier basket = (Panier) session.getAttribute("panier");
            if (basket != null) {
                if (!basket.getProduits().isEmpty()) {

        %>
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

            <%
                float total = 0;
                float shipping = 10.25F;
                for (Produit produit : basket.getProduits()) {
                    total += produit.getPrix();
            %>

                <tr>
                    <td scope="row"> <%= produit.getId() %> </td>
                    <td> <%= produit.getNom() %> </td>
                    <td> <%= produit.getCategorie().getName().toUpperCase() %> </td>
                    <td> 1 </td>
                    <td><strong><%= produit.getPrix() %> €</strong></td>
                    <td><a style="cursor: pointer" onclick="deleteProduct(<%= basket.getProduits().indexOf(produit) %>)"><i title="Supprimer" style="color: red" class="fas fa-trash-alt"></i></a></td>
                </tr>

            <%
                }
            %>

            </tbody>
            <hr>
            <tr>
                <th scope="col">Total: <%= total %> €</th>
            </tr>
            <tr>
                <th scope="col">Frais de livraison: <%= shipping %> € </th>
            </tr><hr>
            <tr>
                <th scope="col" bgcolor="#f0fff0">Total à payer : <%= total + shipping %> €</th>
            </tr>
        </table>
    </div>

    <div class="row">
        <form action="/commande?passer" method="post">
            <button class="btn btn-lg btn-success">
                <i class='fas fa-credit-card'></i>
                Passer la commande
            </button>
        </form>
        <button onclick="goBack()" class="ml-3 btn btn-lg btn-warning">
            <i class='fas fa-shopping-cart'></i>
            Continuer l'achat
        </button>
    </div>

    <%
                } else {

                    %>

                        <div class="row alert alert-danger" role="alert">
                            Panier vide !
                        </div>

                    <%
                }
            } else {

    %>
        <div class="row alert alert-danger" role="alert">
            Panier vide !
        </div>
    <% } %>


</div>

<script src="../assets/js/scripts.js"></script>
<%@include file="template/footer.jsp" %>
