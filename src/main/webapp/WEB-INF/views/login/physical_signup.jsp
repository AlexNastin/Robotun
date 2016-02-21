<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Регистрация</title>
</head>
<body>
	<form:form modelAttribute="addUserPhysicalForm" method="POST">
		<form:input path="login" placeholder="login" />
		<form:select path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
		<form:input path="name" placeholder="name" />
		<form:input path="surname" placeholder="surname" />
		<form:input path="middleName" placeholder="middleName" />
		<form:input path="phones" placeholder="phone1" />
		<form:input path="phones" placeholder="phone2" />
		<form:password path="password" placeholder="password" />
		<form:password path="confirmPassword" placeholder="confirmPassword" />
		<input type="submit" value="Отправить" />
	</form:form>
</body>
</html>
