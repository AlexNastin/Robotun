<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html ng-app="app">
<head>
<meta charset="utf-8">
<title>Проверка лота</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/moderator.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-3"></div>
<div class="col-md-6 edit-users-legal-boards" style="padding-bottom:1em;" ng-controller="LotController as lotCtrl">	
Название лота: {{lotCtrl.lot.name}} <br>
Категория: {{lotCtrl.lot.category.title}} <br>
Подкатегория: {{lotCtrl.lot.subcategory.title}} <br>
Город: {{lotCtrl.lot.city.title}} <br>
Дата начала: {{lotCtrl.lot.startDate | date:'yyyy-MM-dd HH:mm:ss'}} <br>
Дата окончания: {{lotCtrl.lot.endDate | date:'yyyy-MM-dd HH:mm:ss'}} <br>
Описание: {{lotCtrl.lot.description}} <br>
Никнейм пользователя: {{lotCtrl.lot.user.nickname}} <a ng-href='/jobster.by/viewUserProfile?id={{lotCtrl.lot.user.idUser}}'>Посмотреть профиль</a><br>
Бюджет: {{lotCtrl.lot.budget}} <br>
Я звоню/мне звонят: {{lotCtrl.lot.isCall}} <br>
<div class="col-md-12 text-style-legal-user">Проверка лота:</div>
<form:form modelAttribute="rejectMessageForm" method="POST">
<div class="form-group">
<form:input class="form-control" path="text" placeholder="text"/>
			<form:errors path="text" />
	        </div>
	        <div class="form-group">
			<form:input class="form-control" path="idLot" value="{{lotCtrl.lot.idLot}}"/>
			</div>
			<div style="text-align:center;">
			<input class="button-on-add-lot btn btn-primary button-moderator-style" type="submit" value="Отправить причину" />
<a class="button-on-add-lot btn btn-primary button-moderator-style" ng-href='/jobster.by/moderator/confirmLot?id={{lotCtrl.lot.idLot}}'>Утвердить лот</a>
</div>
</form:form>

</div>
<div class="col-md-3"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
		var jsonData = '${lotJson}';

		app.controller('LotController', ['$scope', '$http', lotController]);

		function lotController ($scope) {
			var vm = this;
			console.log(jsonData);
			var data = JSON.parse(jsonData);
			vm.lot = data;
		}
		</script>
</body>
</html>
