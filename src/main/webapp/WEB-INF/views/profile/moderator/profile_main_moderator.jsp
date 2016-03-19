<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Личный кабинет модератора</title>
</head>
<body>
Личный кабинет модератора <br>
	<c:forEach items="${listLots}" var="lot">
	Имя лота: 
		${lot.name} <a href='<c:url value="/moderator/rejectLot?id=${lot.idLot}" />'>Модерировать</a><br>
	</c:forEach>

</body>
</html>
