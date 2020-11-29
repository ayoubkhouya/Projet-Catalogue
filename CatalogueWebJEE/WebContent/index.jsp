<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="pages/template/header.jsp" %>

<div class="container">
    <h3 class="text-center">
        Accueil <br> <b style="color: #446d0b">Bienvenue dans ma boutique : CATALOGUE WEB </b>
    </h3>
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
        <div class=".flex-lg-row carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-90" src="assets/images/1.png" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-90" src="assets/images/2.png" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-90" src="assets/images/3.png" alt="Third slide">
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../assets/js/bootstrap.js"></script>

<%@include file="pages/template/footer.jsp" %>
