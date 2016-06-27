<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html ng-app="app">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/profile/profile.css" />"	rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script type="text/javascript">
var app = angular.module('app', []);
</script>
	<title>Просмотр профиля</title>
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
	
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

<!--This stylesheet should be moved to the head of the document -->
 <div class="container main">
    <div class="row">
        <div class=" col-lg-offset-3 col-lg-6">
        <h2 class="title">Name of company</h2>
            <div class="panel panel-default">
            
                <div class="panel-body" ng-controller="UserController as userCtrl" ng-cloak>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-sm-offset-3 col-sm-6 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
                                    <img class="img-responsive" src="http://api.adorable.io/avatars/300/abott@adorable.png">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="centered-text col-sm-offset-3 col-sm-6 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
                                    <div itemscope="" itemtype="http://schema.org/Person">
                                        <h2> <span itemprop="name">{{userCtrl.user.nickname}}</span></h2>
                                        <c:if test="${idRole == 3}">
                                         <h2> <span itemprop="name">{{userCtrl.user.physical.name}}</span></h2>										
										</c:if>
										<c:if test="${idRole == 2}">
										<h2> <span itemprop="name">{{userCtrl.user.legal.nameEnterprise}}</span></h2>	
												
										</c:if>
                                        <p>
                                            <i class="fa fa-map-marker"></i> <span itemprop="addressRegion">{{userCtrl.user.city.title}}</span>
                                        </p>
                                       </div>
                                </div>
                            </div>
                        </div>
                       
                    </div>
                </div>
                <div class="panel-footer">
                <div>
    <div class="row">
		<div class="well">
        <h1 class="text-center">Работы от этого чувака</h1>
        <div class="list-group">
          <a href="#" class="list-group-item active">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive"  src="http://placehold.it/350x250" alt="placehold.it/350x250" >
                    </figure>
                </div>
                <div class="col-md-6">
                    <h4 class="list-group-item-heading"> Заголовок халтурки </h4>
                    
                </div>
                <div class="col-md-3 text-center">
                    <h2> 14240 <small> рублей </small></h2>
                    <button type="button" class="btn btn-success btn-lg btn-block"> Помочь! </button>
                    
                </div>
          </a>
          
          
        </div>
        </div>
	</div>
</div>
                    <div class="row">
                        <div id="social-links" class=" col-lg-12">
                            <div class="row">
                                <div class="col-xs-6 col-sm-3 col-md-2 col-lg-3 social-btn-holder">
                                    <a title="google" class="btn btn-social btn-block btn-google" target="_BLANK" href="http://plus.google.com/+You/">
                                        <i class="fa fa-google"></i> +You
                                    </a>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-2 col-lg-3 social-btn-holder">
                                    <a title="twitter" class="btn btn-social btn-block btn-twitter" target="_BLANK" href="http://twitter.com/yourid">
                                        <i class="fa fa-twitter"></i> /yourid
                                    </a>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-2 col-lg-3 social-btn-holder">
                                    <a title="github" class="btn btn-social btn-block btn-github" target="_BLANK" href="http://github.com/yourid">
                                        <i class="fa fa-github"></i> /yourid
                                    </a>
                                </div>
                                <div class="col-xs-6 col-sm-3 col-md-2 col-lg-3 social-btn-holder">
                                    <a title="stackoverflow" class="btn btn-social btn-block btn-stackoverflow" target="_BLANK" href="http://stackoverflow.com/users/youruserid/yourid">
                                        <i class="fa fa-stack-overflow"></i> /yourid
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script>
		var jsonData = '${userJson}';
		
		var idRole = ${idRole};

		app.controller('UserController', ['$scope', '$http', userController]);

		function userController ($scope) {
			var vm = this;
			var data = JSON.parse(jsonData);
			vm.idRole = idRole;
			vm.user = data;
		}
		</script>
		<script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
</body>
</html>
