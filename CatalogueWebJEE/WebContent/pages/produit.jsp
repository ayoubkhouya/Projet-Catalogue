<%@ page import="fr.catalogue.beans.Produit" %><%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<script src="../assets/js/scripts.js"></script>
<div class="container">
    <div class="row">
        <h3 class="font-weight-light">
            <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
            <i class='fas fa-compact-disc' style="color: #1717c8"></i>
            <b>Le produit</b>
        </h3>
    </div>
    <div class="row mt-5">

        <%
            Produit produit = (Produit) request.getAttribute("produit");
            if ( produit != null) {
                %>

                    <div class="col-md-6">
                        <h2 class="text-bold">Produit : <%= produit.getId() %> </h2>
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="../assets/images/cd.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 id="name" class="card-title"><%= produit.getNom() %></h5>
                                <p class="card-text">
                                    <%= produit.getDescription() %>
                                </p>
                                <a onclick="addToBasket(<%= produit.getId() %>)" href="#" class="btn btn-success">
                                    <i class='fas fa-shopping-cart'></i>
                                    Ajouter un panier
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="card" style="width: 18rem;">
                            <div class="card-header text-info">
                                Informations complémentaires
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Capacité: </li>
                                <li class="list-group-item">Type: <%= produit.getCategorie().getName() %> </li>
                                <li class="list-group-item">Auteur: </li>
                                <li class="list-group-item">Prix: <%= produit.getPrix() %> €</li>
                            </ul>
                        </div>
                    </div>

                <%
            } else {

            }
        %>

    </div>

</div>

<%@include file="template/footer.jsp"%>
