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
<title>Личный кабинет физического лица Обновления пароля</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
 <link href="<c:url value="/resources/css/validation.css"  />"
	rel="stylesheet" />

</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px; min-height:30em; margin-bottom: 1em;">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/avatar_user/avatar_big/${avatarPath}.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/moderator/profile" />' class="list-group-item background-color-menu-profile">Профиль</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Сменить пароль</a>
</div>
<div class="col-md-10">
<div class="col-md-2"></div>	
<div class="col-md-8 edit-users-legal-boards" style="padding-top: 1em;">
<div class="col-md-12 text-style-legal-user">Обновление пароля:</div>	

	<form:form id="contact-form" name="contact-form"
		modelAttribute="userUpdatePasswordForm" method="POST">
		<div class="form-group" style="height: 6em;">
		<form:password id="oldPassword" name="oldPassword"
			class="form-control input-md" path="oldPassword"
			placeholder="Старый пароль"></form:password>		
		<form:errors path="oldPassword" />
			<label class="error textStyleValidation" generated="true" for="oldPassword"></label>
		</div>
		<div class="form-group" style="height: 2.8em;">
		<form:password id="password" name="password"
			class="form-control input-md" path="password"
			placeholder="Новый пароль"></form:password>
		<form:errors path="password" />
		<label class="error textStyleValidation" generated="true" for="password"></label>
		</div>
		<div class="form-group" style="height: 2.8em;">
		<form:password id="confirmPassword" name="confirmPassword"
			class="form-control input-md" path="confirmPassword"
			placeholder="Подтверждение нового пароля"></form:password>
		<form:errors path="confirmPassword" />
			<label class="error textStyleValidation" generated="true" for="confirmPassword"></label>
		</div>
		<div class="messagesValidStyle">
		<c:if test="${message != null}">
			${message}
			   </c:if>
		</div>
		<br>
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
<script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/validate/validation.js" />"> </script>   
</body>
</html>
