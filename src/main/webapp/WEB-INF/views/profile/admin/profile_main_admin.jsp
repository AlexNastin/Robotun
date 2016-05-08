<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html ng-app="app">
<head>
<title>Личный кабинет администратора</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px;">
<div class="min-height-admin-page">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/admin/profile" />' class="list-group-item background-color-menu-profile active-menu">Профиль</a>
<a href='<c:url value="/admin/addModerator" />' class="list-group-item background-color-menu-profile">Добавить модератора</a>
</div>
<div class="col-md-10" id="list-group" ng-controller="UsersController as usersCtrl">
<div class="text-admin-page-main col-md-12">Модераторы: </div>

<div ng-repeat="user in usersCtrl.users">
<p> {{user.login}} <a type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal{{user.idUser}}">Удалить этого урода</a></p>
<div class="modal fade" id="myModal{{user.idUser}}" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Подтверждение удаления</h4>
        </div>
        <div class="modal-body">
          <p>Разжаловать ублюдка?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Не удалять</button>
          <a class="btn btn-danger" ng-href='/jobster.by/admin/deleteModerator?id={{user.idUser}}'>Удалить</a>
        </div>
      </div>
      
    </div>
  </div>
</div>
</div>
<div class="load"></div>
</div>
</div>
  

<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/autoload.js" />"></script>
<script type="text/javascript">

var jsonData = '${listUsersJson}';

app.controller('UsersController', ['$scope', '$http', mainUsersController]);


function mainUsersController ($scope) {
	var vm = this;
	vm.updateCustomRequest = function (scope) {
		vm.users = scope.usersCtrl.users;
	};
	var data = JSON.parse(jsonData);
	vm.users = [];
	angular.forEach(data, function(user) {
		vm.users.push(user);
	});
	console.log(vm.users);
}

		function loader(){       
			var scope = angular.element(document.getElementById("list-group")).scope();
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url:"/jobster.by/autoloader/admin/moderators",
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
										scope.usersCtrl.users.push(data[i]);
									}
									scope.$apply(function () {
										scope.usersCtrl.updateCustomRequest(scope);
									});
									offset++;
									block = false;
								}
							});
						});
			}
		</script>
</body>
</html>
