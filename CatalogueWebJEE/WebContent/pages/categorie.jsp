<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page import="fr.catalogue.beans.Categorie" %>
<%@ page import="java.util.List" %>
<%@include file="template/header.jsp"%>

<div class="container">
    <div class="row">
        <h3 class="font-weight-light">
            <a href="#" title="Page d'accueil">Catalogue web</a> |
            <i class='fas fa-th-list' style="color: #1717c8"></i>
            <b>Les catalogue</b>
        </h3>
    </div>
    <div class="row row-cols-1 row-cols-md-3">

        <%
            List<Categorie> categories = (List<Categorie>) session.getAttribute("categories");
            if (categories != null) {
                for (Categorie cat : categories) {
                %>
                     <a href="${pageContext.request.contextPath}/categories?id=" <%= "\"" + cat.getId() + "\"" %> >
                         <div class="col mb-4">
                             <div class="card">
                                 <img  src="../assets/images/<%= cat.getName()%>.png"  class="card-img-top img-category" alt="...">
                                 <div class="card-body">
                                     <h5 class="card-title"> <%=cat.getName() %> </h5>
                                     <p class="card-text"> <%=cat.getDescrition() %> </p>
                                 </div>
                             </div>
                         </div>
                     </a>

                <%
                }
            } else {
                    // TODO : when the categories empty
                    }

        %>

    </div>
</div>

<%@include file="template/footer.jsp"%>
