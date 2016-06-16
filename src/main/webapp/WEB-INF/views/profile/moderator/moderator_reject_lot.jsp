<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html ng-app="app">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<title>Проверка лота</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/moderator.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-12" style="text-align:center; font-weight: bold; font-size: 18pt; ">Проверка лота: </div>	
<div class="col-md-3"></div>
<div class="col-md-6 edit-users-legal-boards" style="padding-bottom:1em; margin-top: 1em;" ng-controller="LotController as lotCtrl" ng-cloak>
 <div style="margin-top: 1em;" class="table-responsive" id="list-group">
<table class="table table-bordered">
					<tbody>
						<tr>
							<td>Категория:</td>
							<td>{{lotCtrl.lot.category.title}}</td>
						</tr>
						<tr>
							<td>Подкатегория:</td>
							<td>{{lotCtrl.lot.subcategory.title}}</td>
						</tr>
						<tr>
							<td>Город:</td>
							<td>{{lotCtrl.lot.city.title}}</td>
						</tr>
						<tr>
							<td>Дата начала:</td>
							<td>{{lotCtrl.lot.startDate | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						</tr>
						<tr>
							<td>Дата окончания:</td>
							<td>{{lotCtrl.lot.endDate | date:'yyyy-MM-dd HH:mm:ss'}}</td>
						</tr>
						<tr>
							<td>Описание:</td>
							<td>{{lotCtrl.lot.description}}</td>
						</tr>		
							<tr>
							<td>Никнейм пользователя:</td>
							<td><a ng-href='/jobster.by/viewUserProfile?id={{lotCtrl.lot.user.idUser}}'>{{lotCtrl.lot.user.nickname}}</a></td>
						</tr>
						<tr>
							<td>Бюджет:</td>
							<td>{{lotCtrl.lot.budget}}</td>
						</tr>
						<tr>
							<td>Я звоню/мне звонят:</td>
							<td>{{lotCtrl.lot.isCall}}</td>
						</tr>
						<tr>
							<td>История причин отказа:</td>
							<td></td>
						</tr>									
					</tbody>
</table>
</div>
<form:form modelAttribute="rejectMessageForm" method="POST">
<div class="form-group">
<form:textarea style="resize:none" class="form-control" path="text" placeholder="Причина"/>
			<form:errors path="text" />
	        </div>
	        <div class="form-group">
			<form:input type="hidden" class="form-control" path="idLot" value="{{lotCtrl.lot.idLot}}"/>
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
			var data = JSON.parse(jsonData);
			vm.lot = data;
		}
		</script>
		
<script>
$('html').bind('keypress', function(e)
		{
		   if(e.keyCode == 13)
		   {
		      return false;
		   }
		});
</script>
</body>
</html>
