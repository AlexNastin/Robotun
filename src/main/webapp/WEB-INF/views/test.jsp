<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Test</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/login/login.css" />"	rel="stylesheet">
	<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/js/script.js" />"></script>       

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Login page</title>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Dashboard</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">Profile</a></li>
                <li><a href="#">Help</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input size="40" type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <div class="row row-offcanvas row-offcanvas-left" style="background-color: #3abeb1;">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas"  id="sidebar" role="navigation">

            <ul class="nav nav-sidebar">
                <li  class="active"><a href=""><i style='float: left' class="fa fa-check-square-o fa-3x"></i> <p style="padding-top: 4%;">Физическое лицо</p></a></li>
                <li><a href=""><i  style='float: left' class="fa fa-check-square-o fa-3x"></i> <p style="padding-top: 4%;">Частное лицо</p></a></li>
                <li><a style="float:left" href ='#' class="fa fa-vk "></a> <a style="float:left" href ='#' class="fa fa-google-plus"></a><a style="float:left" href ='#' class="fa fa-twitter"></a><a style="float:left" href ='#' class="fa fa-facebook"></a> </li>
            </ul>


        </div><!--/span-->
Ц
        <div class="col-sm-9 col-md-10 main">
            <p class="visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="fa fa-chevron-left"></i></button>
            </p>

            <section id="login">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-wrap">
                                <h1>Введите данные:</h1>
                                <form role="form" action="javascript:;" method="post" id="login-form" autocomplete="off">
                                    <div class="form-group">
                                        <label for="email" class="sr-only">Email</label>
                                        <input type="email" name="email" id="email" class="form-control" placeholder="Эл.почта">
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="sr-only">Никнейм</label>
                                        <input type="email" name="email" id="nickname" class="form-control" placeholder="Никнейм">
                                    </div>
                                    <div class="form-group">
                                        <label for="email" class="sr-only">Email</label>
                                        <input type="email" name="email" id="phone" class="form-control" placeholder="Телефон">
                                    </div>
                                    <div class="form-group">
                                        <label for="key" class="sr-only">Password</label>
                                        <input type="password" name="key" id="key" class="form-control" placeholder="Пароль">
                                    </div>
                                    <div class="form-group">
                                        <label for="key" class="sr-only">Password</label>
                                        <input type="password" name="key"  class="form-control" placeholder="Повторите пароль">
                                    </div>

                                    <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Зарегестрироваться">
                                </form>

                                <hr>
                            </div>
                        </div> <!-- /.col-xs-12 -->
                    </div> <!-- /.row -->
                </div> <!-- /.container -->
            </section>

        </div><!--/row-->
    </div>
</div><!--/.container-->

<footer>
    <p class="pull-right">©2016 Company</p>
</footer>

<!-- script references -->


<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
