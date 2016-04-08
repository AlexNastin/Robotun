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

<nav class="navbar navbar-default header-background-color">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed burger-button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar" style="background-color: white"></span>
                <span class="icon-bar" style="background-color: white"></span>
                <span class="icon-bar" style="background-color: white"></span>
            </button>
            <a class="navbar-brand text-color" href="<c:url value="/"/>">Brand</a>
        </div>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/test"/>" class="text-color active-block">Test<span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="/signup"/>" class="text-color">Sign Up</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
            <input type="text" class="form-control search-mini-style" placeholder="Search"></input>
            <button type="submit" class="glyphicon glyphicon-search search-mini-button-style"></button>
            </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                <label class="dropdown-toggle header-right-dropdown-style text-color" style="" data-toggle="dropdown" role="button">Аккаунт
                <span class="caret"></span>
                </label>
                <ul class="dropdown-menu">
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
    </div><!-- /.container-fluid -->
</nav>
<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script>
var app = angular.module('app', []);
</script>