<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="template/header.jsp" %>
<%@ page import="fr.catalogue.beans.Commande" %>
<%@ page import="fr.catalogue.beans.Produit" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
<script src="../assets/js/pdf.js"></script>

<%
    Commande commande = (Commande) session.getAttribute("commande");
%>
<div class="container">
    <div id="recap" class="row">
        <h4><b>Catalogue web </b> |  Récapitulatif de votre achat</h4>
        <hr>
        <table class="table table-hover">
            <thead class="bg-info">
            <th scope="col">Nom</th>
            <th scope="col">Prix</th>
            </thead>
            <tbody>
            <%
                for(Produit produit : commande.getProduits())
                {
            %>
            <tr>
                <td scope="row"> <%= produit.getNom() %> </td>
                <td> <%= produit.getPrix() %> €</td>
            </tr>
            <% } %>
            </tbody>
            <tr>
                <th scope="col">Total : <%= commande.getMontant() %> €</th>
                <th scope="col">Référence : <%= commande.getNo_confirmation() %></th>
            </tr>


        </table>
    </div>

    <div class="row">
        <button onclick="getPDF()" class="btn btn-block btn-success">Générer le PDF</button>
    </div>

</div>

<%@include file="template/footer.jsp" %>