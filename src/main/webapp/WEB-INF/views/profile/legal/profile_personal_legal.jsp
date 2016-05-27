<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>Изменение личных данных</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/legal/profile/myResponses" />' class="list-group-item background-color-menu-profile">Мои отклики</a>
<a href='<c:url value="/legal/profile/myLots" />' class="list-group-item background-color-menu-profile">Мои лоты</a>
<a href='<c:url value="/legal/profile/lotsOnUpdate" />' class="list-group-item background-color-menu-profile">Замечания по лотам</a>
<a href='<c:url value="/legal/secure/updatePassword" />' class="list-group-item background-color-menu-profile">Сменить пароль</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Личные данные</a>
<a href='<c:url value="/user/addLot"/>' class="list-group-item background-color-menu-profile ">Добавить работу</a>
</div>
<div class="col-md-10">
<div class="col-md-2"></div>
<div class="col-md-8 edit-users-legal-boards" style="padding-top: 1em;">
<div class="col-md-12 text-style-legal-user">Изменение личных данных</div>
	<form:form modelAttribute="updatePersonalLegalForm" method="POST">
		<div class="form-group">
		<form:input path="nameEnterprise" class="form-control" placeholder="nameEnterprise" value="${user.legal.nameEnterprise}"/>
		</div>
		<div class="form-group">
		<form:input path="unp" class="form-control" placeholder="unp" value="${user.legal.unp}"/>
		</div>
		<div class="form-group">
		<form:input path="address" class="form-control" placeholder="address" value="${user.legal.address}"/>
		</div>
		<div class="form-group">
		<form:input path="zipCode" class="form-control" placeholder="zipCode" value="${user.legal.zipCode}"/>
		</div>
		<div class="form-group">
		<form:select class="form-control" path="idCity">
			<c:set var="idSelectCity" value="${user.idCity}"/>
			<c:forEach items="${listCities}" var="city">
				<c:if test="${city.idCity == idSelectCity}">
					<c:set var="selected" value="true"/>
				</c:if>
				<form:option value="${city.idCity}" selected="${selected}">${city.title}</form:option>
				<c:set var="selected" value=""/>
			</c:forEach>
		</form:select>
		</div>
		<c:forEach items="${user.phones}" var="phone">
				<form:input path="phones" placeholder="phone" value="${phone.phone}"/>
		</c:forEach>
		<div style="text-align:center;">
		<input type="submit" style="margin-bottom: 1em" class="button-on-add-lot btn btn-primary button-legal-style" value="Изменить" />
		</div>
	</form:form>
	</div>
	<div class="col-md-2"></div>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
