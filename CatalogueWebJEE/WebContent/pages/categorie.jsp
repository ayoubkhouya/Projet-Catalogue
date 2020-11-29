<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page import="fr.catalogue.beans.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="row mb-lg-5">
        <h3 class="font-weight-light">
            <a href="../index.jsp" title="Page d'accueil">Catalogue web</a> |
            <i class='fas fa-th-list' style="color: #1717c8"></i>
            <b>Les catégories
            </b>
        </h3>
    </div>
    <div class="row card-columns mt-xl-5">
        <%
            List<Categorie> categories = (List<Categorie>) session.getAttribute("categories");
            if (categories != null) {
                for (Categorie cat : categories) {
                %>
                     <a style="color: white" href=${pageContext.request.contextPath}<%= "/categories?id=" + cat.getId() %> >
                         <div class="ml-lg-12 mb-lg-5 card bg-info">
                             <div class="card-body text-center">
                                 <strong><h4 class="card-title"> <%=cat.getName() %> </h4></strong>
                                 <p class="card-text"> <%=cat.getDescrition() %> </p>
                             </div>
                         </div>
                     </a>

                <%
                }
            } else {
                %>

        <%
            }

        %>
    </div>
    <%@include file="template/footer.jsp"%>
</div>


