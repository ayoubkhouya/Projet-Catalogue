<%--
  Created by IntelliJ IDEA | Eclipse IDE.
  User: Ayoub KHOUYA | Hamza HRAMCHI
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="pages/template/header.jsp" %>

    <link rel="stylesheet" href="assets/css/index.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="assets/js/bootstrap.js"></script>

    <section id="hero" class="d-flex align-items-center">

        <div class="container-fluid" data-aos="fade-up">
            <div class="row justify-content-center">
                <div class="col-xl-5 col-lg-6 pt-3 pt-lg-0 order-2 order-lg-1 d-flex flex-column justify-content-center">
                    <h2 class="text-white">Vous aimez la musique ? Vous voulez regarder un film avec vos amis, vos proches et votre famille ?</h2>
                    <h4 class="text-white">Nous vous proposons des CD, DVD et films qui vont vous plaire </h4>
                    <div>
                        <a href="/categories" class="btn-get-started scrollto">
                            <i class="fas fa-basket"></i> Commencer l'achat
                        </a>
                    </div>
                </div>
                <div class="col-xl-4 col-lg-6 order-1 order-lg-2" data-aos="zoom-in" data-aos-delay="150">
                    <img src="assets/images/1.png" class="animated img-fluid" alt="">
                </div>
            </div>

        </div>
    </section>

<%@include file="pages/template/footer.jsp" %>
