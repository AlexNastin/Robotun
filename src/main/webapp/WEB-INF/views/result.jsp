<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Результаты поиска</title>

<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />

    <title>Jobстер</title>
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
                        <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">Де Ниро<i class="caret"></i></span><img src="<c:url value="/resources/images/niro.jpg" />"></a>
                        <ul class="dropdown-menu " role="menu">
                            <li><a href="profile.html"><i class="fa fa-user"></i>Мой профиль</a></li>
                            <li><a href="inbox.html"><i class="fa fa-envelope"></i>Входящие</a></li>
                            <li><a href="calendar.html"><i class="fa fa-calendar"></i>Расписание</a></li>
                            <li><a href="inbox.html"><i class="fa fa-clipboard"></i>Заказы</a></li>
                        </ul>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
            <div class="clearfix">

            </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">

                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-dashboard nav_icon "></i><span class="nav-label">Дети</span><span class="fa arrow"></span> </a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"> <i class="fa fa-area-chart nav_icon"></i>графики</a></li>

                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-map-marker nav_icon"></i>карты</a></li>

                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-file-text-o nav_icon"></i>два ствола</a></li>

                            </ul>
                        </li>

                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-indent nav_icon"></i> <span class="nav-label">стройка</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"> <i class="fa fa-area-chart nav_icon"></i>графики</a></li>

                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-map-marker nav_icon"></i>карты</a></li>

                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-file-text-o nav_icon"></i>два ствола</a></li>

                            </ul>
                        </li>
                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-inbox nav_icon"></i> <span class="nav-label">сантехника</span> <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"> <i class="fa fa-info-circle nav_icon"></i>404</a></li>
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-question-circle nav_icon"></i>403</a></li>

                            </ul>
                        </li>

                        <li>
                            <a href="#l" class=" hvr-bounce-to-right"><i class="fa fa-picture-o nav_icon"></i> <span class="nav-label">it</span><span class="fa arrow"></span> </a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"> <i class="fa fa-info-circle nav_icon"></i>404</a></li>
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-question-circle nav_icon"></i>403</a></li>

                            </ul>
                        </li>
                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-desktop nav_icon"></i> <span class="nav-label">дача</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"> <i class="fa fa-info-circle nav_icon"></i>404</a></li>
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-question-circle nav_icon"></i>403</a></li>

                            </ul>
                        </li>
                        <li>
                            <a href="layout.html" class=" hvr-bounce-to-right"><i class="fa fa-th nav_icon"></i> <span class="nav-label">лесная прмышденность</span> <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-align-left nav_icon"></i>продажа</a></li>
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-check-square-o nav_icon"></i>дщобыча</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-list nav_icon"></i> <span class="nav-label">нефть</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-align-left nav_icon"></i>продажа</a></li>
                                <li><a href="#" class=" hvr-bounce-to-right"><i class="fa fa-check-square-o nav_icon"></i>дщобыча</a></li>
                            </ul>
                        </li>

                        <li>
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-cog nav_icon"></i> <span class="nav-label">иное</span><span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li><a href="signin.html" class=" hvr-bounce-to-right"><i class="fa fa-sign-in nav_icon"></i>персонал</a></li>
                                <li><a href="signup.html" class=" hvr-bounce-to-right"><i class="fa fa-sign-in nav_icon"></i>рабы</a></li>
                            </ul>
                        </li>
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
                                    <a href="#" class="list-group-item">
                                        <div class="media col-md-3">
                                            <figure class="pull-left">
                                                <img class="media-object img-rounded img-responsive"  src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading"> Первый лот </h4>
                                            <p class="list-group-item-text"> Qui diam libris ei, vidisse incorrupte at mel. His euismod salutandi dissentiunt eu. Habeo offendit ea mea. Nostro blandit sea ea, viris timeam molestiae an has. At nisl platonem eum.
                                                Vel et nonumy gubergren, ad has tota facilis probatus. Ea legere legimus tibique cum, sale tantas vim ea, eu vivendo expetendis vim. Voluptua vituperatoribus et mel, ius no elitr deserunt mediocrem. Mea facilisi torquatos ad.
                                            </p>
                                        </div>
                                        <div class="col-md-3 text-center">
                                            <h2> 14240 <small> ставок </small></h2>
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
                                    <a href="#" class="list-group-item">
                                        <div class="media col-md-3">
                                            <figure class="pull-left">
                                                <img class="media-object img-rounded img-responsive" src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading"> List group heading </h4>
                                            <p class="list-group-item-text"> Eu eum corpora torquatos, ne postea constituto mea, quo tale lorem facer no. Ut sed odio appetere partiendo, quo meliore salutandi ex. Vix an sanctus vivendo, sed vocibus accumsan petentium ea.
                                                Sed integre saperet at, no nec debet erant, quo dico incorrupte comprehensam ut. Et minimum consulatu ius, an dolores iracundia est, oportere vituperata interpretaris sea an. Sed id error quando indoctum, mel suas saperet at.
                                            </p>
                                        </div>
                                        <div class="col-md-3 text-center">
                                            <h2> 12424 <small> ставок </small></h2>
                                            <button type="button" class="btn btn-primary btn-lg btn-block">Помочь!</button>
                                            <div class="stars">
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </div>
                                            <p> Средний 3.9 <small> / </small> 5 </p>
                                        </div>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <div class="media col-md-3">
                                            <figure class="pull-left">
                                                <img class="media-object img-rounded img-responsive" src="http://placehold.it/350x250" alt="placehold.it/350x250">
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading"> Ещё один Лот </h4>
                                            <p class="list-group-item-text"> Ut mea viris eripuit theophrastus, cu ponderum accusata consequuntur cum. Suas quaestio cotidieque pro ea. Nam nihil persecuti philosophia id, nam quot populo ea.
                                                Falli urbanitas ei pri, eu est enim volumus, mei no volutpat periculis. Est errem iudicabit cu. At usu vocibus officiis, ad ius eros tibique appellantur.
                                            </p>
                                        </div>
                                        <div class="col-md-3 text-center">
                                            <h2> 13540 <small> ставок </small></h2>
                                            <button type="button" class="btn btn-primary btn-lg btn-block">Сделать ставку</button>
                                            <div class="stars">
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star-empty"></span>
                                            </div>
                                            <p> Шакалов 4.1 <small> / </small> 5 </p>
                                        </div>
                                    </a>
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
    <c:forEach items="${listLots}" var="lot">
	${lot.name} <br>
	${lot.budget} <br>
	<a href="<c:url value="/user/lot?id=${lot.idLot}"/>">Принять участие</a> <br>
	</c:forEach>
    
<!--add footer here-->



</body>
</html>

