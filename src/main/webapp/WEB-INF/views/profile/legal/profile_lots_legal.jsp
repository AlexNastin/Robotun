<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
		<!DOCTYPE HTML>
<html ng-app="app">
<head>
<meta charset="utf-8">
<title>Личный кабинет юридического лица</title>
${nickname}
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/legal/profile/myResponses" />' class="list-group-item background-color-menu-profile">Мои отклики</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Мои лоты</a>
<a href='<c:url value="/legal/profile/lotsOnUpdate" />' class="list-group-item background-color-menu-profile">Замечания по лотам</a>
<a href='<c:url value="/legal/secure/updatePassword" />' class="list-group-item background-color-menu-profile">Сменить пароль</a>
<a href='<c:url value="/legal/profile/updatePersonalData" />' class="list-group-item background-color-menu-profile">Личные данные</a>
<a href='<c:url value="/user/addLot"/>' class="list-group-item background-color-menu-profile ">Добавить работу</a>
</div>
<div class="col-md-10" id="list-group" ng-controller="LotsController as lotsCtrl" ng-cloak>
<div class="text-admin-page-main col-md-12">Мои лоты:</div>
<div ng-repeat="lot in lotsCtrl.lots">
<div class="col-md-12 users-legal-boards">
<div class="col-md-3">
<img src="/jobster.by/resources/images/fabian-perez.jpg" class="img-responsive img-thumbnail users-legal-img" alt="Image">
</div>
<div class="col-md-9 moderator-descripton">
<div class="col-md-12 text-moderator-description"><a ng-href='/jobster.by/lot?id={{lot.idLot}}' style="font-size: 18pt;">{{lot.name}}</a></div>
<div class="col-md-12 text-moderator-description">{{lot.description}}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Бюджет: {{lot.budget}}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Активен до: {{lot.endDate | date:'yyyy-MM-dd HH:mm:ss'}} </div>
<div class="col-md-12" style="text-align:right;">
<a class="btn btn-primary button-legal-style-main" ng-href='/jobster.by/user/updateLot?id={{lot.idLot}}'>Изменить</a>
<a class="btn btn-primary button-legal-style-main" ng-href='/jobster.by/lot?id={{lot.idLot}}'>Подробнее</a>
<button type="button" data-toggle="modal" data-target="#delete" class="btn btn-primary button-legal-style-main" ng-click="lotsCtrl.preRemoveLot = lot">Удалить</button>
</div>

</div>
</div>
<div class="modal fade" id="delete" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Подтверждение удаления</h4>
        </div>
        <div class="modal-body">
          <p>Это действие удалит лот навсегда и никто о нём не узнает :(</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
          <a  class="btn btn-danger" ng-click="lotsCtrl.remove(lot)" data-dismiss="modal">Удалить</a>
        </div>
      </div>
      
    </div>
  </div>
</div>
</div>
<div class="load"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/autoload.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/constant.js" />"></script>
<script type="text/javascript">

var jsonData = '${listLotsJson}';

app.controller('LotsController', ['$scope', '$http', mainLotsController]);


function mainLotsController ($scope) {
	var vm = this;
	vm.updateCustomRequest = function (scope) {
		vm.lots = scope.lotsCtrl.lots;
	};
	var data = JSON.parse(jsonData);
	vm.lots = [];
	angular.forEach(data, function(lot) {
		vm.lots.push(lot);
	});
	vm.preRemoveLot;
	vm.remove = function(lot) {
		var scope = angular.element(document.getElementById("list-group")).scope();
		var index = scope.lotsCtrl.lots.indexOf(vm.preRemoveLot);
		$.ajax({
			url:"/jobster.by/user/deleteLot",
			type:"GET",
			data:{
				//передаем параметры
				id: vm.lots[index].idLot
			},
			success:function(data) {
				if(data=='0'){
					console.log(index);
					scope.lotsCtrl.lots.splice(index, 1);
					offset--;
					scope.$apply(function () {
							scope.lotsCtrl.updateCustomRequest(scope);
					});
				}
			}
		});
		  
		  
	}
}

		function loader(){      
			var scope = angular.element(document.getElementById("list-group")).scope();
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url:"/jobster.by/autoloader/legal/myLots",
								type:"GET",
								data:{
									//передаем параметры
									offset: offset
								},
								success:function(data) {
									var data = JSON.parse(data);
									if(data.length == 0) {
										isEnd = true;
									}
									for(var i=0; i<data.length; i++) {
										scope.lotsCtrl.lots.push(data[i]);
									}
									scope.$apply(function () {
										scope.lotsCtrl.updateCustomRequest(scope);
									});
									offset+=ajaxLotMaxSize;
									block = false;
								}
							});
						});
			}
		</script>
</body>
</html>
