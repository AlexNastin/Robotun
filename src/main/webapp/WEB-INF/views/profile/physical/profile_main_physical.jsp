<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<security:authorize access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL')" var="userBool" />
<security:authorize access="hasRole('ROLE_MODERATOR')"
	var="moderatorBool" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="adminBool" />
<c:if test="${userBool}">
	<c:set value="/user/profile" var="profileURL" />
</c:if>
<c:if test="${moderatorBool}">
	<c:set value="/moderator/profile" var="profileURL" />
</c:if>
<c:if test="${adminBool}">
	<c:set value="/admin/profile" var="profileURL" />
</c:if>
<title>Личный кабинет физического лица</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch2.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/user/profile" />' class="list-group-item background-color-menu-profile active-menu">Мои лоты</a>
<a href='<c:url value="/user/myResponse" />' class="list-group-item background-color-menu-profile">Мои отклики</a>
<a href='<c:url value="/user/secure/updatePassword" />' class="list-group-item background-color-menu-profile ">Сменить пароль</a>
<a href='<c:url value="/user/secure/updatePersonalUserPhysical" />' class="list-group-item background-color-menu-profile ">Личные данные</a>
</div>
<div class="col-md-10">
<div class="text-admin-page-main col-md-12">Мои лоты:</div>
<c:forEach items="${listLots}" var="lot">
<div class="col-md-12 users-legal-boards">
<div class="col-md-3">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail users-legal-img" alt="Image">
</div>
<div class="col-md-9 moderator-descripton">
<div class="col-md-12 text-moderator-description"><a href='<c:url value="/lot?id=${lot.idLot}" />' style="font-size: 18pt;">${lot.name}</a></div>
<div class="col-md-12 text-moderator-description">${lot.description}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Бюджет: ${lot.budget}</div>
<div class="col-md-12 text-moderator-description legal-users-board-margin">Осталось: ${lot.endDate} </div>
<div class="col-md-12" style="text-align:right;"><a class="btn btn-primary button-legal-style-main" href='<c:url value="/lot?id=${lot.idLot}" />'>Подробнее</a></div>
</div>
</div>
</c:forEach>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
