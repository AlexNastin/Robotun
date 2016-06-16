<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<title>Добавление модератора</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em;">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/admin/profile" />' class="list-group-item background-color-menu-profile ">Профиль</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Добавить модератора</a>
</div>
<div class="col-md-10">
<div class="col-md-2"></div>
<div class="col-md-8 add-moderator-boards">
<div class="text-admin-page-main col-md-12">Добавление модератора:</div>
<div class="col-md-12">
<form:form modelAttribute="addModeratorForm" method="POST">
<form:input class="form-control" path="login" placeholder="login" />
			<form:errors path="login" />
			<input class="btn btn-default login-button-style" style="margin-top: 1em;" type="submit" value="Создать модератора" />
</form:form>
</div>
</div>
<div class="col-md-2"></div>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
