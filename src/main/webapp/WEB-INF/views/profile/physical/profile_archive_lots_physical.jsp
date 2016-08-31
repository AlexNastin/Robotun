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
<title>Личный кабинет физического лица</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container user-profile">
<div id="sameheight" >
<div class="col-md-2 nopadiing-left main-left-col">
<div style="background-color:white; text-align:center">
<img src="<c:url value="/resources/images/avatar_user/avatar_big/${avatarPath}.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
</div>
<div class="style-nickname">${nickname}</div>
<div class="user-navigation">
<a href='<c:url value="/physical/profile/myLots" />' class="list-group-item background-color-menu-profile">Мои работы</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Архив работ</a>
<a href='<c:url value="/physical/profile/myResponses" />' class="list-group-item background-color-menu-profile">Мои отклики</a>
<a href='<c:url value="/physical/profile/lotsOnUpdate" />' class="list-group-item background-color-menu-profile ">Замечания по работам</a>
<a href='<c:url value="/physical/secure/updatePassword" />' class="list-group-item background-color-menu-profile ">Сменить пароль</a>
<a href='<c:url value="/physical/profile/updatePersonalData" />' class="list-group-item background-color-menu-profile ">Личные данные</a>
<a href='<c:url value="/user/addLot"/>' class="list-group-item background-color-menu-profile ">Добавить работу</a>
</div>
</div>
<div class="col-md-10 main-right-col" id="list-group" ng-controller="LotsController as lotsCtrl" ng-cloak>
<div class="text-admin-page-main col-md-12">Архив работ:</div>
<div ng-repeat="lot in lotsCtrl.lots">
<div class="col-md-12 users-legal-boards">
<div class="col-md-3">
<img ng-src="{{lot.logoImage}}" class="img-responsive img-thumbnail users-legal-img" alt="Image">
</div>
<div class="col-md-9 moderator-descripton">
<div class="col-md-12 text-moderator-description"><a ng-href='/jobster.by/archiveLot?id={{lot.idArchiveLot}}&idPic={{lot.indexImage}}' style="font-size: 18pt;">{{lot.name}}</a></div>
<div class="col-md-12 text-moderator-description">{{lot.description}}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Бюджет: {{lot.budget}}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Активен до: {{lot.endDate | date:'yyyy-MM-dd HH:mm:ss'}} </div>

<div class="col-md-12" style="text-align:right;">
<a class="btn btn-primary button-legal-style-main" ng-href='/jobster.by/archiveLot?id={{lot.idArchiveLot}}&idPic={{lot.indexImage}}'>Подробнее</a>
</div>
</div>
</div>

		
	</div>
	<div style="text-align:center;">
										<a class="btn btn-primary load-button"
											onclick='buttonLoader()'><i class="fa fa-repeat" aria-hidden="true"></i> Подгрузить еще </a>
            						</div>
<div class="load"></div>	
</div>
</div>


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
	vm.lotsImages = lotsImages;
	vm.updateCustomRequest = function (scope) {
		vm.lots = scope.lotsCtrl.lots;
	};
	var data = JSON.parse(jsonData);
	vm.lots = [];
	angular.forEach(data, function(lot) {
		var randomInt = getRandomInt(0,vm.lotsImages.length-1);
		lot.logoImage = vm.lotsImages[randomInt];
		lot.indexImage = randomInt;
		vm.lots.push(lot);
	});
}

		function loader(){       
			var scope = angular.element(document.getElementById("list-group")).scope();
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url:"/jobster.by/autoloader/physical/archiveLots",
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
										var randomInt = getRandomInt(0,scope.lotsCtrl.lotsImages.length-1);
										data[i].logoImage = scope.lotsCtrl.lotsImages[randomInt];
										data[i].indexImage = randomInt;
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
		<script>
		$(document).ready(function() {
			if($(window).width() >= 992){
				var dynamic = $('.user-navigation');
			    var static = $('.ng-scope');
			    
			    dynamic.height(static.height());
				}
		    
		});
		</script>
		<!-- Yandex.Metrika counter -->
<script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter39345665 = new Ya.Metrika({
                    id:39345665,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true,
                    webvisor:true,
                    trackHash:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks");
</script>
<noscript><div><img src="https://mc.yandex.ru/watch/39345665" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
<!-- /Yandex.Metrika counter -->
</body>
</html>
