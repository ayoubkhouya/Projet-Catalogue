<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="template/header.jsp" %>

<div class="container">
    <h3 class="mb-lg-5 font-weight-light">
        <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
        <i class='fas fa-user-plus' style="color: #1717c8"></i>
        <b>Créer compte</b>
    </h3>
    <form action="" class="was-validated">
        <div class="form-group">
            <label for="name"><b>Nom</b></label>
            <input type="text" class="form-control" id="name" placeholder="Votre nom" name="name" required>
            <div class="valid-feedback">Champ <b>Nom</b> valide</div>
            <div class="invalid-feedback">Veuillez renseigner le champ <b>Nom</b></div>
        </div>
        <div class="form-group">
            <label for="email"><b>Adresse électronique</b></label>
            <input type="email" class="form-control" id="email" placeholder="Votre email" name="email" required>
            <div class="valid-feedback">Champ <b>Adresse électronique</b> valide</div>
            <div class="invalid-feedback">Veuillez renseigner le champ <b>Adresse éléctronique</b></div>
        </div>
        <div class="form-group">
            <label for="adress"><b>Adresse</b></label>
            <input type="text" class="form-control" id="adress" placeholder="Votre adresse" name="adress" required>
            <div class="valid-feedback">Champ <b>Adresse</b> valide</div>
            <div class="invalid-feedback">Veuillez renseigner le champ <b>Adresse</b>.</div>
        </div>
        <div class="form-group">
            <label for="phone"><b>Téléphone</b></label>
            <input type="text" class="form-control" id="phone" placeholder="Votre numéro de téléphone (Format: 07 XX XX XX XX)" name="phone" pattern="[0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2} [0-9]{2}" required>
            <div class="valid-feedback">Champ <b>Téléphone</b> valide</div>
            <div class="invalid-feedback">Veuillez renseigner le champ <b>Téléphone</b>.</div>
        </div>
        <div class="form-row">
            <div class="col-md-6 form-group">
                <button type="submit" class="form-control btn btn-success">Créer compte</button>
            </div>
            <div class="col-md-6 form-group">
                <button type="reset" class="form-control btn btn-info">Annuler</button>
            </div>
        </div>

    </form>
</div>

<script src="../assets/js/scripts.js"></script>
<%@include file="template/footer.jsp" %>