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
<link href="<c:url value="/resources/css/main/header.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/font-awesome.min.css"  />" rel="stylesheet" />
<nav class="navbar navbar-inverse navbar-fixed-top header-position" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a  href="<c:url value="/"/>"><img  style="margin-left: 15px;" class="navbar-brand" src="<c:url value="/resources/images/logotip.png"  />" alt="logo"></a>
            
        </div>
        <div class="navbar-collapse collapse">
        <ul style="font-weight:bold; font-size:15px" class="nav navbar-nav">
        <li><a href="<c:url value="/result" />">Хочу работать</a></li>
        <li ><a href="<c:url value="/user/addLot" />">Предлагаю работу</a></li>
        
      </ul>
            <ul style="font-weight:bold; font-size:15px" class="nav navbar-nav navbar-right">
               <li class="dropdown">
                <a class="dropdown-toggle font-weight-text-header" style="" data-toggle="dropdown" role="button">Аккаунт
                <span class="caret"></span>
                </a>
                <ul class="dropdown-menu">
                 <li><security:authorize access="hasRole('ROLE_GUEST')">
								<a style="text-align:left;" href="<c:url value="/login" />"> Войти <i
									class="fa fa-sign-in"></i>
								</a>
								<a style="text-align:left;" href="<c:url value="/signup/userPhysical"/>">Регистрация <i
									class="fa fa-user-plus"></i>
								</a>
							</security:authorize> <security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<a style="text-align:left;" href="<c:url value="${profileURL}" />">Мой профиль<i
									class="fa fa-suitcase"></i>
								</a>
							</security:authorize></li>
						<li><security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<a style="text-align:left;" href="<c:url value="/logout" />"> Выйти <i
									class="fa fa-user-times"></i>
								</a>
							</security:authorize></li>
                </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script>
var app = angular.module('app', []);
</script>