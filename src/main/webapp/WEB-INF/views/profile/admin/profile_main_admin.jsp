<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Личный кабинет администратора</title>
</head>
<body>
	Личный кабинет администратора
<a href='<c:url value="/admin/addModerator" />'>Добавить модератора</a> <br>

<c:forEach items="${listUsers}" var="user">
${user.login} <a href='<c:url value="/admin/deleteModerator?id=${user.idUser}" />'>Удалить</a> <br> <br>
</c:forEach>

</body>
</html>
