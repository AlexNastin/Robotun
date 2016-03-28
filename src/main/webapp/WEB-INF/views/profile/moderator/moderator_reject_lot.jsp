<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>Добавление модератора</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/moderator.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch2.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-3"></div>
<div class="col-md-6 edit-users-legal-boards" style="padding-bottom:1em;">	
${lot.name} <br>
${lot.category.title} <br>
${lot.subcategory.title} <br>
${lot.startDate} <br>
${lot.endDate} <br>
${lot.description} <br>
${lot.user.nickname} <br>
${lot.budget} <br>
${lot.isCall} <br>
<div class="col-md-12 text-style-legal-user">Проверка лота:</div>
<form:form modelAttribute="rejectMessageForm" method="POST">
<div class="form-group">
<form:input class="form-control" path="text" placeholder="text"/>
			<form:errors path="text" />
	        </div>
	        <div class="form-group">
			<form:input class="form-control" path="idLot" value="${lot.idLot}" disabled="true"/>
			</div>
			<div style="text-align:center;">
			<input class="button-on-add-lot btn btn-primary button-moderator-style" type="submit" value="Отправить причину" />
<a class="button-on-add-lot btn btn-primary button-moderator-style" href='<c:url value="/moderator/confirmLot?id=${lot.idLot}" />'>Утвердить лот</a>
</div>
</form:form>

</div>
<div class="col-md-3"></div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
