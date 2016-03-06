<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
    <link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<title>main</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<!--Banner-image, search and buttons-->
<div class="background-main-image search-margin-top blur">
    <div class="container">
        <div class="main-text-style">Ищите услугу?</div>
        <div class="row row-margin">
    <div class="col-lg-4"></div>
    <div class="col-lg-4">
        <div class="input-group">
            <input type="text" class="form-control search-style" placeholder="Введите запрос">
      <span class="input-group-btn">
        <button class="btn btn-default search-button-style" type="button">Поиск</button>
      </span>
        </div><!-- /input-group -->
    </div>
    <!-- /.col-lg-6 -->
    <div class="col-lg-4"></div>
    <div class="container">
        <div class="col-md-5 button-align-left">
            <a class="btn btn-primary btn-lg main-button-style" style="min-width: 11em" href="#" role="button">Хочу работать</a>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-5 button-align-right">
            <a class="btn btn-primary btn-lg main-button-style" style="min-width: 11em" href="#" role="button">Предлагаю работу</a>
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