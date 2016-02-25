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
<spring:url var="authUrl" value="/static/j_spring_security_check" />
<title>Login</title>
</head>
<body>
	<form id="contact-form" class="form-horizontal" method="post"
				action="${authUrl}">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
				<div class="form-group sign-feld-margin-top">
					<div class="col-md-12 height-input-string-signin">
						<input type="text" class="form-control" id="inputEmail3"
							name="j_username" placeholder="&#xf003; E-mail"
							style="font-family: Arial, FontAwesome">
							<label class="error" generated="true" for="inputEmail3" style="font-size:9pt;"></label>
							
					</div>
					
				</div>
				<div class="form-group">
					<div class="col-md-12 ">
						<div class="signin-margin-input height-input-string-signin" style="height:4em;">
							<input type="password" class="form-control" id="inputPassword3"
								name="j_password" placeholder="&#xf084; ${password}"
								style="font-family: Arial, FontAwesome">
								
							<label class="error" generated="true" for="inputPassword3" style="font-size:9pt; line-height: 1.2;"></label>
								
						</div>
					</div>

				</div>
				
				<div class="form-group">
					<div class="col-md-12">
					<div class="col-md-6">
						<div class="checkbox" style="padding-left:0px">
							<label class="signin-text-color"> <input type="checkbox"
								name="_spring_security_remember_me">Запомнить меня
							</label>
						</div>
						</div>
						<div class="col-md-6">
						<c:if test="${login_error != null}">
					<div style="text-align:center;"><span class="alert alert-danger" role="alert" style="padding: 1.1%; text-align:center">Ошибка</span></div>
				</c:if>
					</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-8">
						<button type="submit"
							class="btn btn-default btn-outline btn-circle">Войти</button>
						<button type="button"
							class="btn btn-default btn-outline btn-circle"
							onClick='location.href="<c:url value="/signup"  />"'>
							Зарегистрироваться</button>
							
					</div>
				</div>
				
				<div class="margin-forgot-password">
					<a href="<c:url value="/forgotPassword.html" />">Забыли пароль?
					</a>
				</div>
			</form>
			<c:if test="${message != null}">
			  <div class="alert alert-success" role="alert" style="padding: 1%; text-align:center">${message}</div> 
			   </c:if>
			   
		</div>
</body>
</html>