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
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<meta charset="utf-8">
<title>Работа</title>
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<!-- Spring Links -->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/login/login.css" />"	rel="stylesheet">  
	 
    <link href="<c:url value="/resources/css/results/lot.css"  />" rel="stylesheet" />
   
 
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
<body class="nonpersonal">

<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

<div class="container-fluid" style='background-color:#3abeb1'>

    <div class="row row-offcanvas row-offcanvas-left" style="background-color: #3abeb1;">
        
        <div class="col-sm-3 col-md-2 sidebar-offcanvas"  id="sidebar" role="navigation">
        <div class="sidebar-text-main-style">Фильтр</div>
            <div style="left: 0;width: 100%; padding-bottom: 1em;" class="nav nav-sidebar sidebar-nav">
            <div class="col-md-12 margin-for-sidebar-text form-group">
            <div style="color: white; font-weight: bold;">Регион:</div>
            <select  id="idCity" class="form-control">
									<option value="0">Все регионы</option>
<%-- 									<c:set var="idSelectedCity" value="${idCity}"/> --%>
									<c:forEach items="${listCities}" var="city">
<%-- 									<c:if test="${city.idCity == idSelectedCity}"> --%>
<%-- 																	<c:set var="selected" value="selected"/> --%>
<%-- 																</c:if> --%>
<%--   										<option ${selected} value="${city.idCity}">${city.title}</option> --%>
  										<option value="${city.idCity}">${city.title}</option>
<%--   										<c:set var="selected" value=""/> --%>
  									</c:forEach>
								</select>
            </div>
               <div class="col-md-12" id="side-menu">
                     <select class="form-control" id="idCategory"></select>
 				</div>
 				<div class="col-md-12" style="margin-top: 0.7em;">
 			<select class="form-control" id="idSubcategory">
 				<option value="0">Подкатегория</option>
 			</select>                           
                    </div>
            <div class="col-md-12 margin-for-sidebar-text">
            
            <input readonly="readonly" type="text" class="form-control" id="endDate" name="calendar" placeholder="Дата конца"/>
            </div>
            <div class="row" style="padding-left:15px; padding-right:15px;">
            <div class="col-md-6 margin-for-sidebar-text">
            <input type="text" class="form-control"  id="budgetFrom" name="budgetFrom" placeholder="От"/>
            </div>
            <div class="col-md-6 margin-for-sidebar-text">
            <input type="text" class="form-control"  id="budgetTo" name="budgetTo" placeholder="До"/>
            </div>
            </div>
            <div class="col-md-12 margin-for-sidebar-text">
            <div style="color: white; font-weight: bold;">Сначала:</div>
            <select id="desc" class="form-control">
  									<option value="new">Новые</option>
  									<option value="old">Старые</option>
  									<option value="expensive">Дорогие</option>
  									<option value="cheap">Дешёвые</option>
			</select>
            </div>
            
            <div class="col-md-12 margin-for-sidebar-text" style="text-align: center;">
								<a href="#" onclick="resetParam(); updcity();" class="btn btn-primary button-sort-style margin-top-button-sort-style">Уточнить</a>
            </div>
            </div>


        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main" style="min-height: 60em;">
            <p class="visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="fa fa-chevron-left"></i></button>
            </p>

            <h2>
                    <a style="font-size: 25px; color:white;" href="index.html" class="text-style-size-result">Главная</a>
                    <i style="font-size: 25px; color:white;" class="fa fa-angle-right text-style-size-result"></i>
                    <span style="font-size: 25px; color:white;"class="text-style-size-result ">Результаты для <span  style="font-size: 25px; color:#3abeb1" class="text-style-size-result result-city"> </span></span>
                </h2>
                
                <div class="inbox-mail">

                <!-- tab content -->
                <div class="col-md-12 tab-content tab-content-in">
                    <div class="container resize">
                        <div class="row">
                           <div class="style-page-result size-width-result">
                                <h1 class="text-center">Эти люди ждут твоей помощи:</h1>
                                <div class="form-group">
                                
                                <div class="list-group" id="list-group" ng-controller="LotsController as lotsCtrl" ng-cloak>
                                
                                <div class="btn-danger" style="text-align: center;" ng-if="lotsCtrl.lots.length == 0">Ой! По вашему запросу ничего не найдено. Попробуйте изменить параметры запроса.</div>
                                
                                    <a ng-href='/jobster.by/lot?id={{lot.id_lot}}&idPic={{lot.indexImage}}' class="list-group-item resize-result" ng-repeat="lot in lotsCtrl.lots" target="_blank">
                                    <div class="media col-md-3" >
                                            <figure  class="pull-left ">
                                                <img class="media-object img-rounded img-responsive centered-and-cropped" style=" width: 230px; height: 150px;"  ng-src="{{lot.logoImage}}">
                                            </figure>
                                        </div>
                                        <div class="col-md-6">
                                            <h4 class="list-group-item-heading " style="font-size: 25px;">{{lot.name}}</h4>
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
</div>


<!--/.container-->

<!-- Menu Toggle Script -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/autoload.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/constant.js" />"></script>
  <script	src="<c:url value="/resources/js/results/jquery.ui.datepicker-ru.js" />"></script>
 <script>
$.datepicker.setDefaults(
  $.extend(
    {'dateFormat':'dd-mm-yy'},
    $.datepicker.regional['ru']
  )
);
</script>   

<script>
function updcity(){
	var selectedCityName = document.getElementById("idCity").options[document.getElementById("idCity").selectedIndex].text;
	$(".result-city").text(selectedCityName);
}
$(document).ready(function() {
	var selectedCityName = document.getElementById("idCity").options[document.getElementById("idCity").selectedIndex].text;
	$(".result-city").text(selectedCityName);
	var queryText = '${query}';
	$("#q").val(queryText);
 });

// var idCity = ${idCity};
var idCity = 0;
var q = '${querySolr}';
var fq = ['end_date:[* TO NOW+181DAY]'];
if(idCity != 0) {
	fq.push('id_city:' + idCity)
}
var sort = 'start_date desc, budget desc';

function resetParam() {
	// FQ params
	var idCity = document.getElementById('idCity').value;
	var idCategory = document.getElementById('idCategory').value;
	var idSubcategory = document.getElementById('idSubcategory').value;
	var endDate = document.getElementById('endDate').value;
	var budgetFrom = document.getElementById('budgetFrom').value;
	var budgetTo = document.getElementById('budgetTo').value;
	fq = [];
	if(idCity != 0) {
		fq.push('id_city:' + idCity)
	}
	var selectedCityName = document.getElementById("idCity").options[document.getElementById("idCity").selectedIndex].text;
	{$(".result-city").text(selectedCityName);}
	
	if(idCategory != 0) {
		fq.push('id_category:' + idCategory)
	}
	if(idSubcategory != 0) {
		fq.push('id_subcategory:' + idSubcategory)
	}
	if(endDate != '') {
		fq.push('end_date:[* TO ' + endDate + 'T24:00:00Z]')
	}
	if(budgetFrom != '' || budgetTo != '') {
		if(budgetFrom == '') {
			budgetFrom = '0';
		} else if (budgetTo == '') {
			budgetTo = '*';
		}
		fq.push('budget:[' + budgetFrom + ' TO ' + budgetTo + ']')
	}
	
	//SORT param
	var desc = document.getElementById('desc').value;
	if(desc == 'new') {
		sort = 'start_date desc, budget desc';
	} else if(desc == 'old') {
		sort = 'start_date asc, budget desc';
	} else if(desc == 'expensive') {
		sort = 'budget desc, start_date desc';
	} else if(desc == 'cheap') {
		sort = 'budget asc, start_date desc';
	}
	
	// call sorting function
	sortLots();
	
}

app.controller('LotsController', ['$scope', '$http', mainLotsController]);

function mainLotsController ($scope, $http) {
	var vm = this;
	vm.lotsImages = lotsImages;
	$.ajax({	
		url: solrUrl,
		type:"GET",
		traditional: true,
	    cache: true,
	    async: true,
	    dataType: 'jsonp',
		data:{
			//передаем параметры
			q: q,
			fq: fq,
			sort: sort,
			start: offsetStart,
			rows: ajaxLotMaxSize,
			wt: 'json',
			indent: 'true'
		},
		success:function(data) {
			vm.createByData(data);
		},
		jsonp: 'json.wrf'
	});
	vm.updateCustomRequest = function (scope) {
		vm.lots = scope.lotsCtrl.lots;
		console.log(vm.lots.length == 0)
	};
	vm.lots = [];
	vm.createByData = function(data) {
		var scope = angular.element(document.getElementById("list-group")).scope();
		angular.forEach(data.response.docs, function(lot) {
			var randomInt = getRandomInt(0,vm.lotsImages.length-1);
			lot.logoImage = vm.lotsImages[randomInt];
			lot.indexImage = randomInt;
			scope.lotsCtrl.lots.push(lot);
		});
		scope.$apply(function () {
			scope.lotsCtrl.updateCustomRequest(scope);
		});
	}
}

function sortLots(){
 	var scope = angular.element(document.getElementById("list-group")).scope();
 	// «теневой» запрос к серверу
 					$.ajax({
 						url: solrUrl,
 						type:"GET",
 						traditional: true,
 					    cache: true,
 					    async: true,
 					    dataType: 'jsonp',
 						data:{
 							//передаем параметры
 							q: q,
 							fq: fq,
 							sort: sort,
 							start: offsetStart,
 							rows: ajaxLotMaxSize,
 							wt: 'json',
 							indent: 'true'
						},
						success:function(data) {
 							scope.lotsCtrl.lots = [];
 							for(var i=0; i<data.response.docs.length; i++) {
 								var randomInt = getRandomInt(0,scope.lotsCtrl.lotsImages.length-1);
 								data.response.docs[i].logoImage = scope.lotsCtrl.lotsImages[randomInt];
 								data.response.docs[i].indexImage = randomInt;
 								scope.lotsCtrl.lots.push(data.response.docs[i]);
 							}
 							scope.$apply(function () {
 								scope.lotsCtrl.updateCustomRequest(scope);
 							});
 							isEnd = false;
 							block = false;
 							offset = ajaxLotMaxSize;
						},
						jsonp: 'json.wrf'
					});
	}
function loader(){
	var scope = angular.element(document.getElementById("list-group")).scope();
	// «теневой» запрос к серверу
	$(".load").fadeIn(500, function () {
					$.ajax({
						url: solrUrl,
						type:"GET",
						traditional: true,
 					    cache: true,
 					    async: true,
 					    dataType: 'jsonp',
						data:{
							//передаем параметры
							q: q,
 							fq: fq,
 							sort: sort,
 							start: offset,
 							rows: ajaxLotMaxSize,
 							wt: 'json',
 							indent: 'true'
						},
						success:function(data) {
							if(data.response.docs.length == 0) {
								isEnd = true;
							}
							for(var i=0; i<data.response.docs.length; i++) {
								var randomInt = getRandomInt(0,scope.lotsCtrl.lotsImages.length-1);
								data.response.docs[i].logoImage = scope.lotsCtrl.lotsImages[randomInt];
 								data.response.docs[i].indexImage = randomInt;
								scope.lotsCtrl.lots.push(data.response.docs[i]);
							}
							scope.$apply(function () {
								scope.lotsCtrl.updateCustomRequest(scope);
							});
							offset+=ajaxLotMaxSize;
							block = false;
						},
						jsonp: 'json.wrf'
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
$(document).ready(
		function() {
			$('#idCategory').change(function() {
				$.getJSON('${getSubcategories}',{idCategory : $(this).val(),ajax : 'true'},
					function(data) {
						var html = '<option value="0">Подкатегория</option>';
						var len = data.length;
						for (var i = 0; i < len; i++) {
							html += '<option value="' + data[i].idSubcategory + '">'
								+ data[i].title
								+ '</option>';
						}
						html += '</option>';
						$('#idSubcategory').html(html);
					});
			});
		});
</script>
<script type="text/javascript">
$(document).ready(
function() {
	$.getJSON('${getCategories}', {
		ajax : 'true'
	}, function(data) {
		var html = '<option value="0">Категория</option>';
		var len = data.length;
		for (var i = 0; i < len; i++) {
			html += '<option value="' + data[i].idCategory + '">'
					+ data[i].title + '</option>';
		}
		html += '</option>';
		$('#idCategory').html(html);
	});
});
</script> 
<div class="clearfix"></div>
		  <%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>

<!-- script references -->

