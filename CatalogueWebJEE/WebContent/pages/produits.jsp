<%@ page import="java.util.List" %>
<%@ page import="fr.catalogue.beans.Produit" %><%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="template/header.jsp" %>

    <div class="container mb-3">
        <div class="row mb-2">
            <h2 class="font-weight-light">
                <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
                <i class='fas fa-compact-disc' style="color: #1717c8"></i>
                <b>Les produits</b>
            </h2>
        </div>
        <div class="row row-cols-1 row-cols-md-3">

            <%
                List<Produit> produits = (List<Produit>) session.getAttribute("produits");
                if (produits.isEmpty()) {

            %>
                <div class="row alert alert-danger" role="alert">
                    Aucuns produits pour cette catégorie !
                </div>

                <% } else {
                    int i = 0;
                    for (Produit produit : produits) {
                    %>
                        <div class="ml-2">
                            <h4 class="text-bold">Produit N°: <%= i +=1 %></h4>
                            <div class="card" style="width: 18rem;">
                                <img class="card-img-top" height="30%" width="30%" src="../assets/images/cd.png">
                                <div class="card-body">
                                    <h5 class="card-title"><%= produit.getNom() %></h5>
                                    <p class="card-text">
                                        <%= produit.getDescription() %>
                                    </p>
                                    <p class="card-subtitle" style="color: red">
                                        <%= produit.getPrix() %> €
                                    </p>
                                    <a onclick="addToBasket(<%= produit.getId() %>)"  class="btn btn-success">
                                        <i class='fas fa-shopping-cart'></i>
                                        Ajouter au panier
                                    </a>
                                </div>
                            </div>
                        </div>
                    <%
                    }
                }
            %>

        </div>

    </div>

<script src="../assets/js/scripts.js"></script>
<%@include file="template/footer.jsp" %>


