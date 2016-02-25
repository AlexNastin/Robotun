<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Добавить работу</title>
</head>
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<body>
	
	<c:forEach items="${listLots}" var="lot">
	${lot.name} <br>
	${lot.budget} <br>
	<a href="<c:url value="/user/lot?id=${lot.idLot}"/>">Принять участие</a> <br>
	</c:forEach>

</body>
</html>
