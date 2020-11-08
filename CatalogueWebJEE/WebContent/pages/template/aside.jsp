<%--
  Created by IntelliJ IDEA.
  User: Hamza HRAMCHI
  Date: 08/11/2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="./assets/css/style.css">
</head>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#">Connexion</a>
    <a href="#">Créer compte</a>
</div>

<span style="font-size:20px;cursor:pointer" onclick="openNav()">&#9776; Créer compte/Connexion</span>

<script>
    function openNav() {
        document.getElementById("mySidenav").style.width = "250px";
    }

    function closeNav() {
        document.getElementById("mySidenav").style.width = "0";
    }
</script>

