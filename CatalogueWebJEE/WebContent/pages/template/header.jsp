<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="fr.catalogue.beans.Client" %>
<%@ page import="fr.catalogue.beans.Panier" %>
<%
    Panier panier = (Panier) session.getAttribute("panier");
%>

<html>
<head>
    <title>Catalogue web</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../assets/css/bootstrap.css">
    <link rel="stylesheet" href="../assets/css/style.css">
    <link rel="icon" href="../assets/images/logo.png" />
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
</head>

<body>
<header>
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
        <a class="navbar-brand" href="#">
            <img src="../assets/images/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
            Catalogue web
        </a>
        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/home">Accueil <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/categories">Catégories</a>
                </li>
                <li class="nav-item text-bold ml-12">
                    <a class="btn btn-light nav-link" href="${pageContext.request.contextPath}/panier">
                    <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-basket" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M5.757 1.071a.5.5 0 0 1 .172.686L3.383 6h9.234L10.07 1.757a.5.5 0 1 1 .858-.514L13.783 6H15a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1v4.5a2.5 2.5 0 0 1-2.5 2.5h-9A2.5 2.5 0 0 1 1 13.5V9a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1h1.217L5.07 1.243a.5.5 0 0 1 .686-.172zM2 9v4.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V9H2zM1 7v1h14V7H1zm3 3a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 4 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 6 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3A.5.5 0 0 1 8 10zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5zm2 0a.5.5 0 0 1 .5.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 1 .5-.5z"></path>
					</svg>
                     Panier
                     <span class="badge badge-danger" style="margin-bottom: 3px;">
                        <% if (panier != null )
                            {
                        %>
                            <%= panier.getProduits().size() %>
                        <%
                            } else {
                        %>
                            0
                        <%
                            }
                        %>
                    </span>
                    </a>
                </li>
            </ul>
            <div class="form-inline my-3 my-lg-0">
                <%
                    if(session.getAttribute("client") == null) {
                %>
                    <a title="se connecter" class="mr-sm-4" href="#">Connexion <i class="fas fa-sign-in-alt"></i></a>
                    <a title="créer compte" class="text-info mr-sm-3" href="${pageContext.request.contextPath}/client?signin">Créer compte <i class="fas fa-user-plus"></i></a>
                <% }
                    else {
                    Client client = (Client) session.getAttribute("client");
                %>
                    <h5 class="text-primary font-weight-bold mr-sm-2"> <%= client.getNom() %> | </h5>
                    <a title="créer compte" class="text-danger mr-sm-2" href=${pageContext.request.contextPath}/client?logout">Déconnexion <i class="fas fa-sign-out-alt"></i></a>
                <%
                    }
                %>
            </div>
        </div>

    </nav>
</header>
