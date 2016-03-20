<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Личный кабинет физического лица Обновления пароля</title>
</head>
<body>
	Обновления пароля

	<form:form id="contact-form" name="contact-form"
		modelAttribute="userUpdatePasswordForm" method="POST">
		<form:password id="oldPassword" name="oldPassword"
			class="form-control input-md" path="oldPassword"
			placeholder="${oldPassword}"></form:password>
		<form:errors path="oldPassword" />
		<form:password id="password" name="password"
			class="form-control input-md" path="password"
			placeholder="${password}"></form:password>
		<form:errors path="password" />
		<form:password id="confirmPassword" name="confirmPassword"
			class="form-control input-md" path="confirmPassword"
			placeholder="${confirmPassword}"></form:password>
		<form:errors path="confirmPassword" />
		<c:if test="${message != null}">
			${message}
			   </c:if>
		<br>
		<input type="submit" class="btn btn-primary" value="${save}" />
	</form:form>
</body>
</html>
