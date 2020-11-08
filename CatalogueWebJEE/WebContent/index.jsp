<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="icon" href="./assets/images/logo.png" />

<%@include file="pages/template/header.jsp"%>
<div class="container">
    <h1>
        URL : <%= request.getAttribute("rObj") %>
    </h1>
</div>

<%@include file="pages/template/footer.jsp"%>
