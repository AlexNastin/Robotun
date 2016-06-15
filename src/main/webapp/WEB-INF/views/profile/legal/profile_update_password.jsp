<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<meta charset="utf-8">
<title>Личный кабинет физического лица</title>

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
<div class="style-nickname">${nickname}</div>
<a href='<c:url value="/legal/profile/myResponses" />' class="list-group-item background-color-menu-profile">Мои отклики</a>
<a href='<c:url value="/legal/profile/myLots" />' class="list-group-item background-color-menu-profile">Мои работы</a>
<a href='<c:url value="/legal/profile/archiveLots" />' class="list-group-item background-color-menu-profile">Архив работ</a>
<a href='<c:url value="/legal/profile/lotsOnUpdate" />' class="list-group-item background-color-menu-profile">Замечания по работам</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Сменить пароль</a>
<a href='<c:url value="/legal/profile/updatePersonalData" />' class="list-group-item background-color-menu-profile">Личные данные</a>
<a href='<c:url value="/user/addLot"/>' class="list-group-item background-color-menu-profile ">Добавить работу</a>
</div>
<div class="col-md-10">
<div class="col-md-2"></div>	
<div class="col-md-8 edit-users-legal-boards" style="padding-top: 1em;">
<div class="col-md-12 text-style-legal-user">Обновление пароля:</div>	

	<form:form id="contact-form" name="contact-form"
		modelAttribute="userUpdatePasswordForm" method="POST">
		<div class="form-group">
		<form:password id="oldPassword" name="oldPassword"
			class="form-control input-md" path="oldPassword"
			placeholder="Старый пароль"></form:password>		
		<form:errors path="oldPassword" />
		</div>
		<div class="form-group">
		<form:password id="password" name="password"
			class="form-control input-md" path="password"
			placeholder="Новый пароль"></form:password>
		<form:errors path="password" />
		</div>
		<div class="form-group">
		<form:password id="confirmPassword" name="confirmPassword"
			class="form-control input-md" path="confirmPassword"
			placeholder="Подтверждение нового пароля"></form:password>
		<form:errors path="confirmPassword" />
		</div>
		<div class="font-style-message">
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
</body>
</html>
