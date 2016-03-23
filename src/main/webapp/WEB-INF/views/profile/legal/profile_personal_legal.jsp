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
<title>Изменение личных данных</title>
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
<a href='<c:url value="/user/profile" />' class="list-group-item background-color-menu-profile ">Профиль</a>
<a href='<c:url value="/user/secure/updatePersonalUserLegal" />' class="list-group-item background-color-menu-profile active-menu">Личные данные</a>
</div>
<div class="col-md-10">
	<form:form modelAttribute="updatePersonalLegalForm" method="POST">
		<form:input path="nameEnterprise" placeholder="nameEnterprise" value="${user.legal.nameEnterprise}"/>
		<form:input path="unp" placeholder="unp" value="${user.legal.unp}"/>
		<form:input path="address" placeholder="address" value="${user.legal.address}"/>
		<form:input path="zipCode" placeholder="zipCode" value="${user.legal.zipCode}"/>
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
		<c:forEach items="${user.phones}" var="phone">
				<form:input path="phones" placeholder="phone" value="${phone.phone}"/>
		</c:forEach>
		<input type="submit" class="button-on-add-lot" value="Добавить" />
	</form:form>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
