<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/error.css" />"	rel="stylesheet">
		<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
	
	<title>404 Ошибка</title>
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

<div class="error" style="min-height: 50em;">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>
                <h2>
                    Такой страницы нет</h2>
                <div class="error-details">
                    Запрошенная страница удалена, перемещена или никогда не существовала
                </div>
                <div class="error-actions">
                    <a href='<c:url value="/index" />' class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        На главную </a><a href='<c:url value="/contacts" />' class="btn btn-default btn-lg"><span class="glyphicon glyphicon-envelope"></span> Позвать на помощь </a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
    <script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
