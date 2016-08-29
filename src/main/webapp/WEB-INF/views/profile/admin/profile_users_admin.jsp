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
<title>Личный кабинет администратора</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container user-profile" >
<div class="min-height-admin-page">
<div class="col-md-2 nopadiing-left">
<div style="background-color:white; text-align:center">
<img src="<c:url value="/resources/images/avatar_user/avatar_big/${avatarPath}.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
</div>
<div class="user-navigation">
<a href='<c:url value="/admin/profile" />' class="list-group-item background-color-menu-profile">Профиль</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Пользователи</a>
<a href='<c:url value="/admin/addModerator" />' class="list-group-item background-color-menu-profile">Добавить модератора</a>
<a href='<c:url value="/admin/secure/updatePassword" />' class="list-group-item background-color-menu-profile">Сменить пароль</a>
</div>		
</div>
<span id="message"></span>
<div class="col-md-10" ng-controller="UsersController as usersCtrl" ng-cloak>
<input placeholder="Имя или никнейм" id="findName"/>
<input placeholder="ID" id="findID" type="number" min="1"/>
<a type="button" class="btn btn-danger" ng-click="usersCtrl.find()">Найти совпадения</a>
<br>
<span id="alertSearch"></span>
<div class="table-responsive" id="list-group">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Никнейм</th>
							<th>Дата регистрации</th>
							<th>Удалить</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="user in usersCtrl.users">
							<td>{{user.idUser}}</td>
							<td>{{user.nickname}}</td>
							<td>{{user.registrationDate | date:'yyyy-mm-dd HH:mm:ss'}}</td>
							<td><a type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal{{user.idUser}}">Удалить</a></td>
						</tr>
					</tbody>
				</table>
			</div>
								
<div ng-repeat="user in usersCtrl.users">
<div class="modal fade" id="myModal{{user.idUser}}" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Подтверждение удаления</h4>
        </div>
        <div class="modal-body">
          <p>Удалить пользователя?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Не удалять</button>
          <button type="button" class="btn btn-danger" ng-click="usersCtrl.deleteUser(user.idUser, $index)" data-dismiss="modal">Удалить</button>
        </div>
      </div>
      
    </div>
  </div>
</div>
</div>
</div>
</div>
  

<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript">

//var jsonData = '${listUsersJson}';

app.controller('UsersController', ['$scope', '$http', mainUsersController]);


function mainUsersController ($scope, $http) {
	var vm = this;
	vm.users = [];
	vm.find = function () {
		var textName = document.getElementById("findName").value;
		var textID = document.getElementById("findID").value;
		if($.trim(textName) == '' && $.trim(textID) == '') {
			document.getElementById("alertSearch").innerHTML = "Заполните хотя бы одно поле"
		} else {
			var link = '/jobster.by/admin/findUsers?name=' + textName + "&id=" + textID;
			$http({
		        method : "GET",
		        url : link
		    }).then(function mySucces(response) {
		    	vm.users = [];
		    	angular.forEach(response.data, function(user) {
		    		vm.users.push(user);
		    	});
		    });
		}
	};
	vm.deleteUser = function (idUser, index) {
		$http({
	        method : "GET",
	        url : '/jobster.by/admin/deleteUser?id=' + idUser
	    }).then(function mySucces(response) {
	    	if(response.data == 1) {
	    		 vm.users.splice(index, 1);
	    		 document.getElementById("message").innerHTML = "Пользователь успешно удалён"
	    	} else {
	    		document.getElementById("message").innerHTML = "Ошибка при удалении"
	    	}
	    });
	}
}
		</script>
</body>
</html>
