<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Test</title>
</head>
<body>
<a href="<c:url value="/test1"/>">Test1</a>
<a href="<c:url value="/addUserPhysical"/>">Добавить пользователя физ</a>
<a href="<c:url value="/addUserLegal"/>">Добавить пользователя юр</a>
<a href="<c:url value="/login"/>">Login</a>
<a href="<c:url value="/user/addLot"/>">Добавить работу</a>
<a href="<c:url value="/result"/>">Результат</a>
</body>
</html>