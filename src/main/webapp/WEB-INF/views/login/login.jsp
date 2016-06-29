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
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/login/login.css"  />"
	rel="stylesheet" />
	<link href="<c:url value="/resources/css/validation.css"  />"
	rel="stylesheet" />
<title>Вход</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

</head>
<body>
	<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
	<div class="background-main-image">
		<div class="container padding-top-login-form">
			<div class="col-md-4"></div>
			<div class="col-md-4 form-login-style-login"
				style="padding-bottom: 0.5em">
				<div class="style-main-text-on-login-jsp col-md-12"
					style="border-bottom: solid">Вход</div>
				<div class="col-md-12" style="margin-bottom: 0em">
					<form id="contact-form" class="form-horizontal" method="post"
						action="${authUrl}">
						<div class="form-group heightStyleValidation">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="text"
								class="form-control" id="inputEmail3" name="j_username"
								placeholder="E-mail" style="font-family: Arial, FontAwesome">
								<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="inputEmail3"></label>
						</div>
						<div class="form-group heightStyleValidation">
							<input type="password" class="form-control" id="inputPassword3"
								name="j_password" placeholder="Пароль"
								style="font-family: Arial, FontAwesome">
								<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="inputPassword3"></label>
						</div>

						<div class="form-group">
							<div class="checkbox" style="padding-left: 0px">
								<label class="signin-text-color"> <input type="checkbox"
									name="_spring_security_remember_me">Запомнить меня
								</label>
							</div>


							<!-- 	<c:if test="${login_error != null}">
								<div style="text-align: center;">
									<span class="alert alert-danger" role="alert"
										style="padding: 1.1%; text-align: center">Ошибка</span>
								</div>
							</c:if> -->
						</div>
<c:if test="${not empty param.error}">
							<div class="messagesValidStyle row" role="">
								<font color="white">${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
								</font>
							</div>
						</c:if>

						<div class="row" style="margin-bottom: 0.5em">
							<button type="submit"
								class="btn btn-default btn-outline btn-circle signin-button">Войти</button>
							<a 	class="btn btn-default btn-outline btn-circle signin-button"
								href="<c:url value="/signup/userPhysical"/>">Зарегистрироваться</a>
						</div>
						

						<a href="<c:url value="/forgotPassword.html" />">Забыли
							пароль? </a>
							
					</form>

				</div>
			</div>
		</div>
		<div class="col-md-4"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
    <script src="<c:url value="/resources/js/validate/validation.js" />"> </script>       
</body>
</html>