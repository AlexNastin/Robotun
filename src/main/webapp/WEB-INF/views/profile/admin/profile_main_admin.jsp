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
<title>Личный кабинет администратора</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch2.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px;">
<div class="min-height-admin-page">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/admin/profile" />' class="list-group-item background-color-menu-profile active-menu">Профиль</a>
<a href='<c:url value="/admin/addModerator" />' class="list-group-item background-color-menu-profile">Добавить модератора</a>
</div>
<div class="col-md-10">
<div class="text-admin-page-main col-md-12">Модераторы: </div>
<div class="col-md-12 moderator-boards">
<div class="col-md-3">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail moderators-img" alt="Image">
</div>
<div class="col-md-8 moderator-descripton">
<div class="col-md-12 text-moderator-description ">Ник: Moderator</div>
<div class="col-md-12 text-moderator-description">Email: moderator1@jobster.by</div>
<div class="col-md-12 text-moderator-description">Телефон: +375447777777</div>
</div>
<div class="col-md-1 glyphicon-style2">
<a href="#" ><span class="glyphicon glyphicon-remove btn-lg glyphicon-style" aria-hidden="true"></span></a>
</div>
</div>

<div class="col-md-12 moderator-boards">
<div class="col-md-3">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail moderators-img" alt="Image">
</div>
<div class="col-md-8 moderator-descripton">
<div class="col-md-12 text-moderator-description ">Ник: Moderator</div>
<div class="col-md-12 text-moderator-description">Email: moderator1@jobster.by</div>
<div class="col-md-12 text-moderator-description">Телефон: +375447777777</div>
</div>
<div class="col-md-1 glyphicon-style2">
<a href="#" ><span class="glyphicon glyphicon-remove btn-lg glyphicon-style" aria-hidden="true"></span></a>
</div>
</div>

<div class="col-md-12 moderator-boards">
<div class="col-md-3">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail moderators-img" alt="Image">
</div>
<div class="col-md-8 moderator-descripton">
<div class="col-md-12 text-moderator-description ">Ник: Moderator</div>
<div class="col-md-12 text-moderator-description">Email: moderator1@jobster.by</div>
<div class="col-md-12 text-moderator-description">Телефон: +375447777777</div>
</div>
<div class="col-md-1 glyphicon-style2">
<a href="#" ><span class="glyphicon glyphicon-remove btn-lg glyphicon-style" aria-hidden="true"></span></a>
</div>
</div>

<div class="col-md-12 moderator-boards">
<div class="col-md-3">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail moderators-img" alt="Image">
</div>
<div class="col-md-8 moderator-descripton">
<div class="col-md-12 text-moderator-description ">Ник: Moderator</div>
<div class="col-md-12 text-moderator-description">Email: moderator1@jobster.by</div>
<div class="col-md-12 text-moderator-description">Телефон: +375447777777</div>
</div>
<div class="col-md-1 glyphicon-style2">
<a href="#" ><span class="glyphicon glyphicon-remove btn-lg glyphicon-style" aria-hidden="true"></span></a>
</div>
</div>
<c:forEach items="${listUsers}" var="user">
${user.login} <a href='<c:url value="/admin/deleteModerator?id=${user.idUser}" />'>Удалить</a> <br> <br>
</c:forEach>
</div>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
