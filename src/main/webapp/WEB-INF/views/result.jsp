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

<c:url value="/user/lot" var="userLot" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    
    
	<!-- Spring Links -->
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
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
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

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
                                <div class="list-group" id="list-group">
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
                                <div class="load"></div>
                            </div>
                        </div>
                    </div>

                 </div>
</div>
<div class="clearfix"> </div>
</div>
</div>
    </div>
    
<%@include file="/WEB-INF/views/footer.jsp"%>
<script type="text/javascript"
		src="<c:url value="/resources/js/results/autoload.js" />"></script>
		<script type="text/javascript">
		function loader(){         
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url:"autoloader/allResults",
								type:"GET",
								data:{
									//передаем параметры
									offset: offset*limit
								},
								success:function(data) {
									console.log(data)
									if(data.length == 0) {
										isEnd = true;
									}
									for(var i=0; i<data.length; i++) {
										print(data[i].idLot, data[i].name, data[i].description, data[i].budget);
									}
									offset++;
									block = false;
								}
							});
						});
			}
		</script>

</body>
</html>

