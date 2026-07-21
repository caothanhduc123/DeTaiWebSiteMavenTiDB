<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="utils.API" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<!-- Navbar start -->
<div class="container-fluid fixed-top px-0">
    <div class="container px-0">
        <div class="topbar">
            <div class="row align-items-center justify-content-center">
                <div class="col-md-8">
                    <div class="topbar-info d-flex flex-wrap">
                        <a href="#" class="text-light me-4"><i class="fas fa-envelope text-white me-2"></i>23T1020637@husc.edu.vn</a>
                        <a href="#" class="text-light"><i class="fas fa-phone-alt text-white me-2"></i>0906362598</a>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="topbar-icon d-flex align-items-center justify-content-end">
                        <a href="#" class="btn-square text-white me-2"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="btn-square text-white me-2"><i class="fab fa-twitter"></i></a>
                        <a href="#" class="btn-square text-white me-2"><i class="fab fa-instagram"></i></a>
                        <a href="#" class="btn-square text-white me-2"><i class="fab fa-pinterest"></i></a>
                        <a href="#" class="btn-square text-white me-0"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <nav class="navbar navbar-light bg-light navbar-expand-xl">
            <a href="home" class="navbar-brand ms-3">
                <h1 class="text-primary display-5">supercar brands</h1>
            </a>
            <button class="navbar-toggler py-2 px-3 me-3" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars text-primary"></span>
            </button>
            <div class="collapse navbar-collapse bg-light" id="navbarCollapse">
                <div class="navbar-nav ms-auto">
                    <a href="home" class="nav-item nav-link active">Home</a>
                    <a href="chatbot" class="nav-item nav-link">chatbot</a>
                    <!--<a href="service.html" class="nav-item nav-link">Services</a>-->
                    <!--<a href="causes.html" class="nav-item nav-link">Causes</a>-->
                    <a href="home#shop" class="nav-item nav-link">Shop</a>                                   
                </div>

                <div class="d-flex align-items-center flex-nowrap pt-xl-0" style="margin-left: 15px;">
                    <c:if test="${user == null}">
                        <a href="login-register" class="btn-hover-bg btn btn-primary text-white py-2 px-4 me-3">Login/Register  </a>
                    </c:if>
                    <c:if test="${user != null}">
                        <div class="nav-item dropdown" style="background: #fbbf24; margin-right: 10px">
                            <a href="#" class="nav-link dropdown-toggle " data-bs-toggle="dropdown" style="color: black">Hi ${API.getName(user.getName())}</a>
                            <div class="dropdown-menu m-0 bg-secondary rounded-0">
                                <a href="mycart" class="dropdown-item">mycart</a>
                                <a href="profile" class="dropdown-item">profile</a>       
                                <a href="logout" class="dropdown-item">Logout </a>
                            </div>
                        </div>
                    </c:if>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Navbar End -->