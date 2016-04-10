<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<security:authorize access="hasRole('ROLE_USER_LEGAL')" var="userLegalBool" />
<security:authorize access="hasRole('ROLE_USER_PHYSICAL')" var="userPhysicalBool" />
<security:authorize access="hasRole('ROLE_MODERATOR')" var="moderatorBool" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="adminBool" />
<c:if test="${userLegalBool}">
	<c:set value="/legal/profile/myResponses" var="profileURL" />
</c:if>
<c:if test="${userPhysicalBool}">
	<c:set value="/physical/profile/myLots" var="profileURL" />
</c:if>
<c:if test="${moderatorBool}">
	<c:set value="/moderator/profile" var="profileURL" />
</c:if>
<c:if test="${adminBool}">
	<c:set value="/admin/profile" var="profileURL" />
</c:if>

<nav class="navbar-default navbar-static-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <h1> <a class="navbar-brand" href="index.html">Jobster</a></h1>
        </div>
        <div class=" border-bottom">
            <div class="full-left">

                <form class="navbar-left-right">
                    <input type="text"  value="Ищу..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Ищу...';}" >
                    <input  type="submit" value="" class="fa fa-search">
                </form>
                <div class="clearfix"> </div>
            </div>


            <!-- Brand and toggle get grouped for better mobile display -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="drop-men" >
                <ul class=" nav_1">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle dropdown-at" data-toggle="dropdown"><span class=" name-caret">Профиль<i class="caret"></i></span><img src="<c:url value="/resources/images/niro.jpg" />"></a>
                        <ul class="dropdown-menu " role="menu">
                        <li><security:authorize access="hasRole('ROLE_GUEST')">
								<a href="<c:url value="/login" />"> Войти <i
									class="fa fa-sign-in"></i>
								</a>
								<a href="<c:url value="/signup" />"> Зарегистрироваться <i
									class="fa fa-user-plus"></i>
								</a>
							</security:authorize> <security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<a href="<c:url value="${profileURL}" />">Мой профиль<i
									class="fa fa-suitcase"></i>
								</a>
							</security:authorize></li>
						<li><security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<a href="<c:url value="/logout" />"> Выйти <i
									class="fa fa-user-times"></i>
								</a>
							</security:authorize></li>
                        </ul>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
            <div class="clearfix">

            </div>

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu" ng-controller="CategoriesController as categoriesCtrl">
						
                        <li ng-repeat="category in categoriesCtrl.categories" ng-click="showMenu = !showMenu">
                            <a href="#" class=" hvr-bounce-to-right"><i class="fa fa-dashboard nav_icon "></i><span class="nav-label">{{category.title}}</span><span class="fa arrow"></span> </a>
                            <ul class="nav nav-second-level" ng-show="showMenu">

                                	<li ng-repeat="subcategory in category.subcategories"><a ng-href='/jobster.by/result?idCategory={{category.idCategory}}&idSubcategory={{subcategory.idSubcategory}}' class=" hvr-bounce-to-right"> <i class="fa fa-area-chart nav_icon"></i>{{subcategory.title}}</a></li>

                            </ul>
                        </li>
						
                        
                    </ul>
                </div>
            </div>
            </div>
    </nav>
    <script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
    <script>
    var jsonDataCategories = '${listCategoriesJson}';
    
    var app = angular.module('app', []);
    
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
    </script>