<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="template/header.jsp" %>

<div class="container">
    <button class="btn btn-info" id="pdf" onclick="getPDF()">Get PDF</button>
    <h3 id="index" class="mb-lg-5 font-weight-light">
        <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
        <i class='fas fa-money-check-alt' style="color: #1717c8"></i>
        <b>Paiement</b>
    </h3>
    <form action="${pageContext.request.contextPath}/commande?payer" method="POST" class="was-validated">
        <div class="form-group">
            <label for="name"><b>Nom de titulaire</b></label>
            <input type="text" class="form-control" id="name" placeholder="Votre nom" name="name" required>
            <div class="valid-feedback">Champ <b>Nom</b> valide</div>
            <div class="invalid-feedback">Veuillez renseigner le champ <b>Nom</b></div>
        </div>
        <div class="form-group">
            <label for="numcarde"><b>Numéro de la carte</b></label>
            <input type="text" class="form-control" id="numcarde" placeholder="Numéro : XXXX XXXX XXXX XXXX" pattern="[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}" name="numcarde" required>
            <div class="valid-feedback">Champ <b>Numéro de la carte</b> valide</div>
            <div class="invalid-feedback">Veuillez renseigner le champ <b>Numéro de la carte</b></div>
        </div>
        <div class="form-row">
            <div class="col-md-6 form-group">
                <label for="expiration"><b>Date d'éxpiration</b></label>
                <input type="text" class="form-control" id="expiration" placeholder="Expiration : XX/XX" pattern="[0-9]{2}/[0-9]{2}" name="expiration" required>
                <div class="valid-feedback">Champ <b>Date d'éxpiration</b> valide</div>
                <div class="invalid-feedback">Veuillez renseigner le champ <b>Date d'éxpiration</b>.</div>
            </div>
            <div class="col-md-6 form-group">
                <label for="cvv"><b>Code CVV</b></label>
                <input type="text" class="form-control" id="cvv" placeholder="CVV : XXX" name="cvv" pattern="[0-9]{3}" required>
                <div class="valid-feedback">Champ <b>CVV</b> valide</div>
                <div class="invalid-feedback">Veuillez renseigner le champ <b>CVV</b>.</div>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 form-group">
                <button type="reset" class="form-control btn-block btn btn-warning">Annuler</button>
            </div>
        </div>
    </form>

    <div class="row">
        <button onclick="confirmShopping()" class="btn btn-block btn-success">Payer</button>
    </div>
</div>

<script src="../assets/js/scripts.js"></script>

<%@include file="template/footer.jsp" %>