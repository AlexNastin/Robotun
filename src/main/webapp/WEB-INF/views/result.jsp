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
<title>Результаты поиска</title>

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
                                <div class="form-group">
                                <input type="text" class="form-control" id="startDate" name="calendar" placeholder="startDate"/> 
                                <input type="text" class="form-control" id="endDate" name="calendar" placeholder="endDate"/> 
                                <input type="text" class="form-control" id="budgetFrom" name="budgetFrom" placeholder="budgetFrom"/> 
                                <input type="text" class="form-control" id="budgetTo" name="budgetTo" placeholder="budgetTo"/> 
                                Сначала: <select id="desc">
  									<option value="new">Новые</option>
  									<option value="old">Старые</option>
  									<option value="expensive">Дорогие</option>
  									<option value="cheap">Дешёвые</option>
								</select>
								<a href="#" onclick="sortLots()">Найти</a>
                                </div>
                                <a href="#" onClick="sortLots()"></a>
                               
                                <div class=" resize list-group" id="list-group" ng-controller="LotsController as lotsCtrl">
                                
                                    <a ng-href='/jobster.by/lot?id={{lot.idLot}}' class="list-group-item" ng-repeat="lot in lotsCtrl.lots">
                                    <div class="media col-md-3">
                                            <figure class="pull-left">
                                                <img class="media-object img-rounded img-responsive"  src="/jobster.by/resources/images/logoJob.png">
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading">{{lot.name}}</h4>
                                            <p class="list-group-item-text">{{lot.description}}</p>
                                        </div>
                                        <div class="col-md-3 text-center">
                                            <h2>{{lot.budget}}<small> бел. руб. </small></h2>
                                            <button type="button" class="btn btn-default btn-lg btn-block"> Помочь! </button>
                                        </div>
                                    </a>
                                    
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
<script type="text/javascript" src="<c:url value="/resources/js/autoload.js" />"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> 
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
}

function sortLots(startDate, endDate, budgetFrom, budgetTo, desc){
	var startDate = document.getElementById('startDate').value;
	var endDate = document.getElementById('endDate').value;
	console.log(typeof startDate)
	var budgetFrom = document.getElementById('budgetFrom').value;
	var budgetTo = document.getElementById('budgetTo').value;
	var desc = document.getElementById('desc').value;
	console.log("startDate: " + startDate + " endDate: " + endDate +" budgetFrom: " + budgetFrom + " budgetTo: " + budgetTo + " desc: " + desc);
 	var scope = angular.element(document.getElementById("list-group")).scope();
 	// «теневой» запрос к серверу
 					$.ajax({
 						url:"autoloader/filterResults",
 						type:"GET",
 						data:{
 							//передаем параметры
							startDate: startDate,
							endDate: endDate,
							budgetFrom: budgetFrom,
							budgetTo: budgetTo,
							desc: desc
						},
						success:function(data) {
							console.log(data);
// 							var data = JSON.parse(data);
// 							if(data.length == 0) {
// 								isEnd = true;
// 							}
// 							for(var i=0; i<data.length; i++) {
// 								scope.lotsCtrl.lots.push(data[i]);
// 							}
// 							scope.$apply(function () {
// 								scope.lotsCtrl.updateCustomRequest(scope);
// 							});
// 							offset++;
// 							block = false;
						}
					});
	}

function loader(){
	var scope = angular.element(document.getElementById("list-group")).scope();
	// «теневой» запрос к серверу
	$(".load").fadeIn(500, function () {
					$.ajax({
						url:"autoloader/allResults",
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
							offset++;
							block = false;
						}
					});
				});
	}
	
$(function() {

    $( "#endDate" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+365",changeMonth: true,
		changeYear: true, minDate:"+0",
		yearRange: "-0:+1"});
    
    $( "#startDate" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+0",changeMonth: true,
		changeYear: true, minDate:"-3650",
		yearRange: "-1:+0"});
    

  });
</script>

</body>
</html>

