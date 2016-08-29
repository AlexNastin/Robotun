<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
	<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script>
var app = angular.module('app', []);
</script>
<html ng-app="app">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<title>Личный кабинет модератора</title>
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />"
	rel="stylesheet" />
</head>
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

<body>
	<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
	<div class="container user-profile"		>
		<div class="col-md-2 nopadiing-left">
			<div style="background-color:white; text-align:center">
<img src="<c:url value="/resources/images/avatar_user/avatar_big/${avatarPath}.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
</div>
				<div class="user-navigation">
				 <a href='#' class="list-group-item background-color-menu-profile active-menu">Профиль</a>
				<a href='<c:url value="/moderator/secure/updatePassword" />' class="list-group-item background-color-menu-profile">Сменить пароль</a>
		</div>
		</div>
        <div class="table-responsive" ng-controller="LotsController as lotsCtrl" id="list-group" ng-cloak>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Название</th>
							<th>Описание</th>
							<th>Бюджет</th>
							<th>Активен до</th>
							<th>Причина отказа</th>
							<th>Модерация</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="lot in lotsCtrl.lots">
							<td>{{lot.name}}</td>
							<td>{{lot.description}}</td>
							<td>{{lot.budget}}</td>
							<td>{{lot.endDate | date:'yyyy-MM-dd HH:mm:ss'}}</td>
							<td><div ng-repeat="message in lot.rejectMessages">{{message.message}} {{message.date | date:'yyyy-mm-dd HH:mm:ss'}}</div></td>
							<td><a class="btn btn-primary button-legal-style-main"
								ng-href='/jobster.by/moderator/rejectLot?id={{lot.idLot}}'>Модерировать</a></td>
						</tr>
					</tbody>
				</table>
			<div style="text-align:center;">
			<a class="btn btn-primary button-legal-style-main"
								onclick='loader()'>Подгрузить еще</a>
            </div>
			</div>
			
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/constant.js" />"></script>
	<script type="text/javascript">
		var jsonData = '${listLotsJson}';

		app.controller('LotsController', [ '$scope', '$http',
				mainLotsController ]);
		
		var block = false;
		//если true, то лотов больше нет
		var isEnd = false;
		//начиная с
		var offset = 1;

		function mainLotsController($scope) {
			var vm = this;
			vm.updateCustomRequest = function(scope) {
				vm.lots = scope.lotsCtrl.lots;
			};
			var data = JSON.parse(jsonData);
			vm.lots = [];
			angular.forEach(data, function(lot) {
				vm.lots.push(lot);
			});
		}
		function loader() {
			var scope = angular.element(document.getElementById("list-group"))
					.scope();
			// «теневой» запрос к серверу
			if(!block && !isEnd) {
			block = true;
				$.ajax({
					url : "/jobster.by/autoloader/moderator/onModeration",
					type : "GET",
					data : {
						//передаем параметры
						offset : offset
					},
					success : function(data) {
						var data = JSON.parse(data);
						if (data.length == 0) {
							isEnd = true;
						}
						for (var i = 0; i < data.length; i++) {
							scope.lotsCtrl.lots.push(data[i]);
						}
						scope.$apply(function() {
							scope.lotsCtrl.updateCustomRequest(scope);
						});
						offset++;
						block = false;
					}
				});
			}
		}
	</script>
</body>
</html>
