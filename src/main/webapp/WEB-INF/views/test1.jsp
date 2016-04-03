<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html>
<head>
	<title>Test1</title>
</head>
<body>
<div class="text">

</div>


<a href="<c:url value="/"/>">Test</a>

<a href="<c:url value="/redisTest"/>">Redis</a>

</body>
</html>
