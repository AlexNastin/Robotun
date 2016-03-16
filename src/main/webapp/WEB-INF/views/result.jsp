<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	
	<security:authorize access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL')" var="userBool" />
<security:authorize access="hasRole('ROLE_MODERATOR')"
	var="moderatorBool" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="adminBool" />

<c:if test="${userBool}">
	<c:set value="/user/profile" var="profileURL" />
</c:if>
<c:if test="${moderatorBool}">
	<c:set value="/moderator/profile" var="profileURL" />
</c:if>
<c:if test="${adminBool}">
	<c:set value="/admin/profile" var="profileURL" />
</c:if>

<!DOCTYPE HTML>
<html>
<head>
<title>Результаты поиска</title>

<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    
    
	<!-- Spring Links -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
    <link href="<c:url value="/resources/css/results/results.css"  />" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/js/results/jquery.metisMenu.js" />"></script>
	
	<!-- Custom plugin -->
	<link href="<c:url value="/resources/css/results/custom.css"  />" rel="stylesheet" />
	<script	src="<c:url value="/resources/js/results/custom.js" />"></script>       
   
    
	</head>

<body>
<div style="height: 30px"> </div>
<div id="wrapper">
    
    <nav class="navbar-default navbar-static-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h1> <a class="navbar-brand" href="index.html">Jobster</a></h1>
        </div>
        <div class=" border-bottom">
            <div class="full-left">

                <form class=" navbar-left-right">
                    <input  type="text"  value="Ищу..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Ищу...';}">
                    <input type="submit" value="" class="fa fa-search">
                </form>
                <div class="clearfix"> </div>
            </div>


            <!-- Brand and toggle get grouped for better mobile display -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="drop-men" >
                <ul class=" nav_1">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">Профиль<i class="caret"></i></span><img src="<c:url value="/resources/images/niro.jpg" />"></a>
                        <ul class="dropdown-menu " role="menu">
                        <li><security:authorize access="hasRole('ROLE_GUEST')">
								<a href="<c:url value="/login" />"'> Войти <i
									class="fa fa-sign-in"></i>
								</a>
								<a href="<c:url value="/signup" />"'> Зарегистрироваться <i
									class="fa fa-user-plus"></i>
								</a>
							</security:authorize> <security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<a href="<c:url value="${profileURL}" />"'>Мой профиль<i
									class="fa fa-suitcase"></i>
								</a>
							</security:authorize></li>
						<li><security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<a href="<c:url value="/logout" />"'> Выйти <i
									class="fa fa-user-times"></i>
								</a>
							</security:authorize></li>
                        </ul>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
            <div class="clearfix">

            </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
						<c:forEach items="${listCategories}" var="category">
                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-dashboard nav_icon "></i><span class="nav-label">${category.title}</span><span class="fa arrow"></span> </a>
                            <ul class="nav nav-second-level">
                            	<c:forEach items="${category.subcategories}" var="subcategory">
                                	<li><a href='<c:url value="/result?idCategory=${category.idCategory}&idSubcategory=${subcategory.idSubcategory}"/>' class=" hvr-bounce-to-right"> <i class="fa fa-area-chart nav_icon"></i>${subcategory.title}</a></li>
								</c:forEach>
                            </ul>
                        </li>
						</c:forEach>
                        
                    </ul>
                </div>
            </div>
            </div>
    </nav>
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="content-main">

            <!--banner-->
            <div class="banner">
                <h2>
                    <a href="index.html">Главная</a>
                    <i class="fa fa-angle-right"></i>
                    <span>Результаты по запросу</span>
                </h2>
            </div>
            <!--//banner-->
            <!--grid-->
            <div class="inbox-mail">

                <!-- tab content -->
                <div class="col-md-12 tab-content tab-content-in">
                    <div class="container">
                        <div class="row">
                            <div class="well">
                                <h1 class="text-center">Эти люди ждут твоей помощи:</h1>
                                <div class="list-group">
                                <c:forEach items="${listLots}" var="lot">
                                    <a href='<c:url value="/user/lot?id=${lot.idLot}"/>' class="list-group-item">
                                        <div class="media col-md-3">
                                            <figure class="pull-left">
                                                <img class="media-object img-rounded img-responsive"  src="<c:url value="/resources/images/logoJob.png"/>">
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading"> ${lot.name} </h4>
                                            <p class="list-group-item-text"> ${lot.description}</p>
                                        </div>
                                        <div class="col-md-3 text-center">
                                            <h2> ${lot.budget} <small> бел. руб. </small></h2>
                                            <button type="button" class="btn btn-default btn-lg btn-block"> Помочь! </button>
                                            <div class="stars">
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </div>
                                            <p> рейтинг 4.5 <small> / </small> 5 </p>
                                        </div>
                                    </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                 </div>
</div>
<div class="clearfix"> </div>
</div>
</div>
    </div>
    
<!--add footer here-->

</body>
</html>

