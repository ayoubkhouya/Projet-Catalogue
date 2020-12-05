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
                    <a class="nav-link text-primary" href="${pageContext.request.contextPath}/panier">
                    <i class="fas fa-shopping-basket"></i> Panier
                     <span class="badge badge-danger">
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
<<<<<<< HEAD
                    <a title="Se connecter" class="mr-sm-4" href="#">Connexion <i class="fas fa-sign-in-alt"></i></a>
                    <a title="Créer compte" class="text-info mr-sm-3" href="${pageContext.request.contextPath}/client?signin">Créer compte <i class="fas fa-user-plus"></i></a>
=======
                    <a title="se connecter" class="mr-sm-4" href="${pageContext.request.contextPath}/client?login">Connexion <i class="fas fa-sign-in-alt"></i></a>
                    <a title="créer compte" class="text-info mr-sm-3" href="${pageContext.request.contextPath}/client?signin">Créer compte <i class="fas fa-user-plus"></i></a>
>>>>>>> 092f72d... Add login an signin and fix some issues
                <% }
                    else {
                    Client client = (Client) session.getAttribute("client");
                %>
                    <span class="mr-sm-2 mr-1 text-dark"> <i class="fas fa-user"></i> <%= client.getNom() %> | </span>
                    <a title="Déconnexion" class="text-danger mr-sm-2" href=${pageContext.request.contextPath}/client?logout>Déconnexion <i class="fas fa-sign-out-alt"></i></a>
                <%
                    }
                %>
            </div>
        </div>

    </nav>
</header>
