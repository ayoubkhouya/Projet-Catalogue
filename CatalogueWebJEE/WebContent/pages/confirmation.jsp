<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
<script src="../assets/js/pdf.js"></script>

<div class="container">
    <div class="row">
        <h4><b>Catalogue web </b> | Récapitulatif de votre achat</h4>
    </div>
    <div id="recap" class="row">
        <table class="table table-hover">
            <thead class="bg-info">
            <th scope="col">Nom</th>
            <th scope="col">Prix</th>
            <th scope="col">Quantité</th>
            </thead>
            <tbody>
            <tr>
                <td scope="row">CD XF4</td>
                <td>25 €</td>
                <td>2</td>
            </tr>
            </tbody>
            <tr>
                <th scope="col">Total : 45€</th>
            </tr>
        </table>
    </div>

    <div class="row">
        <button onclick="getPDF()" class="btn btn-success">Générer le PDF</button>
    </div>

</div>
