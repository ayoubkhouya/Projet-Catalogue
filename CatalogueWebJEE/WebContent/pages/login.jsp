<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="template/header.jsp" %>

<script src="../assets/js/scripts.js"></script>
<div class="container">
    <h3 class="mb-lg-5 font-weight-light">
        <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
        <i class='fas fa-user' style="color: #1717c8"></i>
        <b>Connexion</b>
    </h3>

    <form action="/client?login" method="POST">
        <div class="form-group">
            <label for="name"><b>Nom</b></label>
            <input type="text" class="form-control" id="name" placeholder="Votre nom" name="name" required>
        </div>
        <div class="form-group">
            <label for="email"><b>Email</b></label>
            <input type="email" class="form-control" id="email" placeholder="Votre Email" name="email" required>
        </div>
        <div class="form-group">
            <button class="form-control btn btn-success" type="submit"> Connexion </button>
        </div>
    </form>
</div>

<%@include file="template/footer.jsp" %>