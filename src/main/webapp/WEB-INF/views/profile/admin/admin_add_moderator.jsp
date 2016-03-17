<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Добавление модератора</title>
</head>
<body>
	Добавление модератора
<form:form modelAttribute="addModeratorForm" method="POST">
<form:input class="form-control" path="login" placeholder="login" />
			<form:errors path="login" />
			<input class="btn btn-default login-button-style" type="submit" value="Создать модератора" />
</form:form>


</body>
</html>
