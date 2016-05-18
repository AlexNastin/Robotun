<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
 <!DOCTYPE html>
<html ng-app="app">
<head>
<title>Работа</title>

<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<!-- Spring Links -->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/login/login.css" />"	rel="stylesheet">  
	 
    <link href="<c:url value="/resources/css/results/lot.css"  />" rel="stylesheet" />
   
    <link href="<c:url value="/resources/css/results/custom.css"  />" rel="stylesheet" />    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link href="<c:url value="/resources/css/jquery-ui.min.css"  />" rel="stylesheet" />
    <script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/js/results/jquery.metisMenu.js" />"></script>
	<script	src="<c:url value="/resources/js/script.js" />"></script>  
	
	<!-- Custom plugin -->
	<link href="<c:url value="/resources/css/results/custom.css"  />" rel="stylesheet" />
	<script	src="<c:url value="/resources/js/results/custom.js" />"></script>    


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    

    <!-- Bootstrap Core CSS -->
   

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

<div class="container-fluid" style='background-color:#3abeb1'>

    <div class="row row-offcanvas row-offcanvas-left" style="background-color: #3abeb1;">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas"  id="sidebar" role="navigation">

            <ul style="left: 0;width: 100%;" class="nav nav-sidebar sidebar-nav">
               <ul class="nav" id="side-menu" ng-controller="CategoriesController as categoriesCtrl">
						
                        <li style="text-align:left;" ng-repeat="category in categoriesCtrl.categories" ng-click="showMenu = !showMenu">
                            <a style="text-align:left; padding-left:0px" href="#" class=" hvr-bounce-to-right"><i style='color:white'class="fa fa-dashboard nav_icon "></i><span style='color:white' class="nav-label">{{category.title}}</span><span class="fa arrow"></span> </a>
                            <ul class="nav nav-second-level" ng-show="showMenu">

                                	<li style="text-align:left;" ng-repeat="subcategory in category.subcategories"><a style='color:white; text-align:left;    padding-left: 30px;' ng-href='/jobster.by/result?idCategory={{category.idCategory}}&idSubcategory={{subcategory.idSubcategory}}' class=" hvr-bounce-to-right"> <i style='color:white' class="fa fa-area-chart nav_icon"></i>{{subcategory.title}}</a></li>

                            </ul>
                        </li>
						
                        
                    </ul>
            </ul>


        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">
            <p class="visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="fa fa-chevron-left"></i></button>
            </p>

            <h2>
                    <a href="index.html" class="text-style-size-result">Главная</a>
                    <i class="fa fa-angle-right text-style-size-result"></i>
                    <span class="text-style-size-result">Результаты по запросу</span>
                </h2>
                
                <div class="inbox-mail">

                <!-- tab content -->
                <div class="col-md-12 tab-content tab-content-in">
                    <div class="container resize">
                        <div class="row">
                        <div class="sort-style">
                                <div class="col-md-1 margin-top-sort-style">
                                <input type="text" class="form-control" id="endDate" name="calendar" placeholder="endDate"/> 
                                </div>
                                <div class="col-md-2 margin-top-sort-style">
                                <input type="text" class="form-control" id="budgetFrom" name="budgetFrom" placeholder="budgetFrom"/> 
                                </div>
                                <div class="col-md-2 margin-top-sort-style">
                                <input type="text" class="form-control" id="budgetTo" name="budgetTo" placeholder="budgetTo"/> 
                                </div>
                                 <div class="col-md-6 margin-top-sort-style" style="padding: 0px;">
                                 <div class="col-md-1 text-sort-style" style="max-width: 12em;">
                                 Сначала: 
                                 </div>
                                 <div class="col-md-4 padding-field-sort">
                                 <select id="desc" class="form-control">
  									<option value="new">Новые</option>
  									<option value="old">Старые</option>
  									<option value="expensive">Дорогие</option>
  									<option value="cheap">Дешёвые</option>
								</select>
								
								</div>
								 <div class="col-md-2 text-sort-style">
								Регион:
								</div>
								<div class="col-md-4">
								
								<select id="idCity" class="form-control">
									<option value="0">Все регионы</option>
									<c:forEach items="${listCities}" var="city">
  										<option value="${city.idCity}">${city.title}</option>
  									</c:forEach>
								</select>
								</div>
								<div class="col-md-1">
								<a href="#" onclick="sortLots()" class="btn btn-primary button-sort-style margin-top-button-sort-style">Найти</a>
								</div>
								</div>
							
                                </div>
                            <div class="style-page-result size-width-result">
                                <h1 class="text-center">Эти люди ждут твоей помощи:</h1>
                                <div class="form-group">
                                
                               
                                <div class="list-group" id="list-group" ng-controller="LotsController as lotsCtrl">
                                
                                    <a ng-href='/jobster.by/lot?id={{lot.idLot}}' class="list-group-item resize-result" ng-repeat="lot in lotsCtrl.lots">
                                    <div class="media col-md-3">
                                            <figure class="pull-left">
                                                <img class="media-object img-rounded img-responsive"  src="/jobster.by/resources/images/logoJob.png">
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading ">{{lot.name}}</h4>
                                            <p class="list-group-item-text result-description ">{{lot.description}}</p>
                                        </div>
                                        <div class="col-md-3 text-center">
                                            <h2>{{lot.budget}}<small> бел. руб. </small></h2>
                                            <button type="button" class="btn btn-default btn-lg btn-block main-button-style"> Помочь! </button>
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
        </div><!--/row-->
    </div>
</div><!--/.container-->

<!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

<script>
    var jsonDataCategories = '${listCategoriesJson}';
    
    app.controller('CategoriesController', ['$scope', '$http', categoriesController]);
    
    function categoriesController ($scope) {
    	var vm = this;
    	var dataCategories = JSON.parse(jsonDataCategories);
    	vm.categories = [];
    	vm.subcategories = [];
    	angular.forEach(dataCategories, function(category) {
    		vm.categories.push(category);
    	});
    	vm.selectSubcategories = function (index) {
    		vm.subcategories = vm.categories[index].subcategories;
    	};
    }
		
		
$(document).ready(function() {
	$("a.scroll").click(function () { 
     elementClick = $(this).attr("href");
     destination = $(elementClick).offset().top;
     if($.browser.safari){
       $('body').animate( { scrollTop: destination }, 1100 );
     }else{
       $('html').animate( { scrollTop: destination }, 1100 );
     }
     return false;
   });
 });
</script>
     
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
var idCategory = ${idCategory};
var idSubcategory = ${idSubcategory};
function sortLots(){
	var idCity = document.getElementById('idCity').value;
	var endDate = document.getElementById('endDate').value;
	var budgetFrom = document.getElementById('budgetFrom').value;
	var budgetTo = document.getElementById('budgetTo').value;
	var desc = document.getElementById('desc').value;
 	var scope = angular.element(document.getElementById("list-group")).scope();
 	// «теневой» запрос к серверу
 					$.ajax({
 						url:"autoloader/filterResults",
 						type:"GET",
 						data:{
 							//передаем параметры
 							idCity: idCity,
							endDate: endDate,
							budgetFrom: budgetFrom,
							budgetTo: budgetTo,
							desc: desc
						},
						success:function(data) {
 							var data = JSON.parse(data);
 							console.log(data);
 							scope.lotsCtrl.lots = [];
 							for(var i=0; i<data.length; i++) {
 								scope.lotsCtrl.lots.push(data[i]);
 							}
 							console.log(scope.lotsCtrl.lots);
 							scope.$apply(function () {
 								scope.lotsCtrl.updateCustomRequest(scope);
 							});
 							isEnd = false;
 							block = false;
 							offset = 1;
						}
					});
	}
function loader(){
	var idCity = document.getElementById('idCity').value;
	var endDate = document.getElementById('endDate').value;
	var budgetFrom = document.getElementById('budgetFrom').value;
	var budgetTo = document.getElementById('budgetTo').value;
	var desc = document.getElementById('desc').value;
	var scope = angular.element(document.getElementById("list-group")).scope();
	// «теневой» запрос к серверу
	$(".load").fadeIn(500, function () {
					$.ajax({
						url:"autoloader/allResults",
						type:"GET",
						data:{
							//передаем параметры
							offset: offset,
							endDate: endDate,
							budgetFrom: budgetFrom,
							budgetTo: budgetTo,
							desc: desc,
							idCategory: idCategory,
							idSubcategory: idSubcategory,
							idCity: idCity
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
<div class="clearfix"></div>
		  <%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>

<!-- script references -->

