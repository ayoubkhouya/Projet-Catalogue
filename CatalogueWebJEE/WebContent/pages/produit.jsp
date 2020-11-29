<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="row">
        <h3 class="font-weight-light">
            <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
            <i class='fas fa-compact-disc' style="color: #1717c8"></i>
            <b>Le produit</b>
        </h3>
    </div>
    <div class="row mt-5">
        <div class="col-md-6">
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
        <div class="col-md-6">
            <div class="card" style="width: 18rem;">
                <div class="card-header text-info">
                    Informations complémentaires
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">Capacité: </li>
                    <li class="list-group-item">Type: </li>
                    <li class="list-group-item">Auteur: </li>
                </ul>
            </div>
        </div>
    </div>

</div>

<%@include file="template/footer.jsp"%>
