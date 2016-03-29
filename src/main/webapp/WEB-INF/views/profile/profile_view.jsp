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
	<title>Просмотр профиля</title>
</head>
<body>
${user.nickname}
<c:if test="${idRole == 3}">
	${user.physical.name}
</c:if>
<c:if test="${idRole == 2}">
	${user.legal.nameEnterprise}
</c:if>
</body>
</html>
