<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<spring:url var="addUserPhysical" value="/signup/userPhysical" />
<spring:url var="addUserLegal" value="/signup/userLegal" />
<title>Регестрация</title>
</head>
<body>
		<form:form modelAttribute="addUserPhysicalForm" action="${addUserPhysical}" method="POST">
		<form:input path="login" placeholder="login" />
			<form:errors path="login" />
		<form:select path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
		<form:input path="name" placeholder="name" />
		<form:errors path="name" />
		<form:input path="surname" placeholder="surname" />
		<form:errors path="surname" />
		<form:input path="middleName" placeholder="middleName" />
		<form:errors path="middleName" />
		<form:input path="phones" placeholder="phone1" />
		<form:errors path="phones" />
		<form:input path="phones" placeholder="phone2" />
		<form:errors path="phones" />
		<form:password path="password" placeholder="password" />
		<form:errors path="password" />
		<form:password path="confirmPassword" placeholder="confirmPassword" />
		<form:errors path="confirmPassword" />
		<input type="submit" value="Отправить" />
	</form:form>
	<form:form modelAttribute="addUserLegalForm" action="${addUserLegal}" method="POST">
		<form:input path="login" placeholder="login" />
		<form:errors path="login" />
		<form:select path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
		<form:input path="nameEnterprise" placeholder="nameEnterprise" />
		<form:errors path="nameEnterprise" />
		<form:input path="unp" placeholder="unp" />
		<form:errors path="unp" />
		<form:input path="address" placeholder="address" />
		<form:errors path="address" />
		<form:input path="zipCode" placeholder="zipCode" />
		<form:errors path="zipCode" />
		<form:input path="phones" placeholder="phone1" />
		<form:errors path="phones" />
		<form:input path="phones" placeholder="phone2" />
		<form:errors path="phones" />
		<form:password path="password" placeholder="password" />
		<form:errors path="password" />
		<form:password path="confirmPassword" placeholder="confirmPassword" />
		<form:errors path="confirmPassword" />
		<input type="submit" value="Отправить" />
	</form:form>
	<c:if test="${message != null }">
	${message}
	</c:if>
</body>
</html>