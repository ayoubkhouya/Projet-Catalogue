<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="pages/template/header.jsp" %>

<div class="container">
    <div class="row mb-2">
        <h2 class="font-weight-light">
            <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
            <i class='fas fa-home' style="color: #1717c8"></i>
            Bienvenue dans ma boutique <b>Catalogue Web</b>
        </h2>
    </div>
    <div  style="position: center; width: 100%; height: 100%" id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class=".flex-lg-row carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-90" src="assets/images/1.png">
            </div>
            <div class="carousel-item">
                <img class="d-block w-90" src="assets/images/2.png">
            </div>
            <div class="carousel-item">
                <img class="d-block w-90" src="assets/images/3.png">
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../assets/js/bootstrap.js"></script>

<%@include file="pages/template/footer.jsp" %>
