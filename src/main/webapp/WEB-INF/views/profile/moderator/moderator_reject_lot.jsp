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
<form:form modelAttribute="rejectMessageForm" method="POST">
<form:input class="form-control" path="text" placeholder="text"/>
			<form:errors path="text" />
			<form:input class="form-control" path="idLot" value="${lot.idLot}" disabled="true"/>
			<input class="btn btn-default login-button-style" type="submit" value="Отправить причину" />
</form:form>
<a href='<c:url value="/moderator/confirmLot?id=${lot.idLot}" />'>Утвердить лот</a>


</body>
</html>
