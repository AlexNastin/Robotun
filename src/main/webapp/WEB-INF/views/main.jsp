<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
    <link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<title>main</title>
</head>
<body>
<nav class="navbar navbar-default header-background-color">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed burger-button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar" style="background-color: white"></span>
                <span class="icon-bar" style="background-color: white"></span>
                <span class="icon-bar" style="background-color: white"></span>
            </button>
            <a class="navbar-brand text-color" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/test"/>" class="text-color active-block">Test<span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="/signup"/>" class="text-color">Sign Up</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="text-color">Link</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!--Banner-image, search and buttons-->
<div class="background-main-image search-margin-top blur">
    <div class="container">
        <div class="main-text-style">Ищите услугу?</div>
        <div class="row row-margin">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <div class="input-group">
            <input type="text" class="form-control search-style" placeholder="Введите запрос">
      <span class="input-group-btn">
        <button class="btn btn-default search-button-style" type="button">Поиск</button>
      </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
    <div class="col-lg-4"></div>
    <div class="container">
        <div class="col-md-5 button-align-left">
            <a class="btn btn-primary btn-lg main-button-style" style="min-width: 11em" href="#" role="button">Хочу работать</a>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-5 button-align-right">
            <a class="btn btn-primary btn-lg main-button-style" style="min-width: 11em" href="#" role="button">Предлагаю работу</a>
        </div>
    </div>
    </div>
    </div>
    </div>
<!--Footer-->
<div class="footer position-sign sign-footer-margin">
    <div class="container">
        <div class="footer_grids">
            <div class="footer-grid">
                <h4>Lorem ipsum</h4>
                <ul class="list1">
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>Lorem ipsum</h4>
                <ul class="list1">
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>Lorem ipsum</h4>
                <ul class="list1">
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                </ul>
            </div>
            <div class="footer-grid">
                <h4>Lorem ipsum</h4>
                <ul class="list1">
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                    <li><a href="#">Lorem ipsum</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--end-Footer-->
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</body>
</html>