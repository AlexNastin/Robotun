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
<title>Личный кабинет юридического лица</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch2.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/legal/profile/myResponses" />' class="list-group-item background-color-menu-profile active-menu">Мои отклики</a>
<a href='<c:url value="/legal/profile/myLots" />' class="list-group-item background-color-menu-profile">Мои лоты</a>
<a href='<c:url value="/legal/secure/updatePassword" />' class="list-group-item background-color-menu-profile">Сменить пароль</a>
<a href='<c:url value="/legal/profile/updatePersonalData" />' class="list-group-item background-color-menu-profile">Личные данные</a>
</div>
<div class="col-md-10">
<div class="text-admin-page-main col-md-12" id="list-group">Мои отклики:</div>
<c:forEach items="${listLots}" var="lot">
<div class="col-md-12 users-legal-boards">
<div class="col-md-3">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail users-legal-img" alt="Image">
</div>
<div class="col-md-9 moderator-descripton">
<div class="col-md-12 text-moderator-description"><a href='<c:url value="/lot?id=${lot.idLot}" />' style="font-size: 18pt;">${lot.name}</a></div>
<div class="col-md-12 text-moderator-description">${lot.description}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Бюджет: ${lot.endDate}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Осталось: 01 дней : 14 часов : 00 минут </div>
<div class="col-md-12" style="text-align:right;"><a class="btn btn-primary button-legal-style-main" href='<c:url value="/lot?id=${lot.idLot}" />'>Подробнее</a></div>
</div>
</div>
</c:forEach>
</div>
<div class="load"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
		src="<c:url value="/resources/js/profile/legal/autoloadMyResponses.js" />"></script>
		<script type="text/javascript">
		function loader(){         
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url:"/webapp/autoloader/legal/myResponses",
								type:"GET",
								data:{
									//передаем параметры
									offset: offset
								},
								success:function(data) {
									if(data.length == 0) {
										isEnd = true;
									}
									for(var i=0; i<data.length; i++) {
										print(data[i].idLot, data[i].name, data[i].description, data[i].budget, data[i].endDate);
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
