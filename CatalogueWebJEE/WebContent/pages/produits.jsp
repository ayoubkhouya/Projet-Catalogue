<%@ page import="java.util.List" %>
<%@ page import="fr.catalogue.beans.Produit" %><%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="template/header.jsp" %>

    <div class="container mb-3">

        <%
            List<Produit> produits = (List<Produit>) session.getAttribute("produits");
            if (produits.isEmpty()) {
                System.out.println("VIIIIIIIIDE");
            } else {
                for (Produit produit : produits) {
                    System.out.println("Produit : " + produit.getNom());
                }
            }
        %>

        <div class="row">
            <h3 class="font-weight-light">
                <a href="#" title="Page d'accueil">Catalogue web</a> |
                <i class='fas fa-compact-disc' style="color: #1717c8"></i>
                <b>Les produits</b>
            </h3>
        </div>
        <div class="row row-cols-1 row-cols-md-3">
            <div>
                <h2 class="text-bold">Produit N° 12</h2>
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="../assets/images/cd.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">CD-14 Rock</h5>
                        <p class="card-text">
                            Description du produit
                        </p>
                        <a href="#" class="btn btn-success">
                            <i class='fas fa-shopping-cart'></i>
                            Ajouter un panier
                        </a>
                    </div>
                </div>
            </div>
            <div>
                <h2 class="text-bold">Produit N° 12</h2>
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="../assets/images/cd.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">CD-14 Rock</h5>
                        <p class="card-text">
                            Description du produit
                        </p>
                        <a href="#" class="btn btn-success">
                            <i class='fas fa-shopping-cart'></i>
                            Ajouter un panier
                        </a>
                    </div>
                </div>
            </div>
            <div>
                <h2 class="text-bold">Produit N° 12</h2>
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="../assets/images/cd.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">CD-14 Rock</h5>
                        <p class="card-text">
                            Description du produit
                        </p>
                        <a href="#" class="btn btn-success">
                            <i class='fas fa-shopping-cart'></i>
                            Ajouter un panier
                        </a>
                    </div>
                </div>
            </div>
            <div>
                <h2 class="text-bold">Produit N° 12</h2>
                <div class="card" style="width: 18rem;">
                    <img class="card-img-top" src="../assets/images/cd.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">CD-14 Rock</h5>
                        <p class="card-text">
                            Description du produit
                        </p>
                        <a href="#" class="btn btn-success">
                            <i class='fas fa-shopping-cart'></i>
                            Ajouter un panier
                        </a>
                    </div>
                </div>
            </div>
        </div>

    </div>

<%@include file="template/footer.jsp" %>


