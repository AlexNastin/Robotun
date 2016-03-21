<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Личный кабинет физического лица</title>
</head>
<body>
	<a href='<c:url value="/user/secure/updatePassword" />'>Сменить пароль</a> <br>
	<a href='<c:url value="/user/secure/updatePersonalUserPhysical" />'>Изменить личные данные</a>
</body>
</html>
