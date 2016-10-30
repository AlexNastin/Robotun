<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<spring:url var="authUrl" value="/static/j_spring_security_check" />
<link href="<c:url value="/resources/css/login.css"  />"
	rel="stylesheet" />
<title>Вход</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

</head>
<body>
	<form id="contact-form" class="login" method="post"
							action="${authUrl}">
							<p>
							<label generated="true" for="inputEmail3">Логин</label>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> 
									<input type="text" name="j_username"
									placeholder="E-mail" id="inputEmail3">
							</p>
							<p>
							<label generated="true" for="inputPassword3">Пароль</label>
								<input type="password" id="inputPassword3"
									name="j_password" placeholder="Пароль"> 
									
							</p>

							<p class="login-submit">
								<button type="submit"
									class="login-button" >Войти</button>
							</p>

						</form>
						
</body>
</html>