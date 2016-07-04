<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
    <link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/footer.css"  />" rel="stylesheet" />
    <script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
    <script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <link rel="icon" href="<c:url value="/resources/images/favicon.ico" />"
	type="image/x-icon">
	
<title>Правила пользования сайтом</title>
</head>
<body class="">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container imageBackground" style="width: 100%; height: 80%; padding-top: 1em;">
<div class="col-md-offset-2 col-md-8">
<a style="font-size: 25px; color:white;" href="index.html" class="text-style-size-result">Главная</a>
<i style="font-size: 25px; color:white;" class="fa fa-angle-right text-style-size-result"></i>
<span style="font-size: 25px; color:white;" class="text-style-size-result ">Правила использования</span>
</div>
<div class="col-md-offset-2 col-md-8 boardBackgroundColor">
<div class=""></div>
<div class="col-md-12 headlineTextStyle">Правила использования</div>
<div class="col-md-12">
<div id="accordion2" class="panel-group" style="margin: auto!important;">
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseOne22">
<h4 class="panel-title">Option 1 ▼</h4>
</div>
<div id="collapseOne22" class="panel-collapse collapse">
<div class="panel-body">Lorem ipsum</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseTwo22">
<h4 class="panel-title">Option 2 ▼</h4>
</div>
<div id="collapseTwo22" class="panel-collapse collapse">
<div class="panel-body">Lorem ipsum</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseThree22">
<h4 class="panel-title">Option 3 ▼</h4>
</div>
<div id="collapseThree22" class="panel-collapse collapse">
<div class="panel-body">Lorem ipsum</div>
</div>
</div>
</div>
</div>
</div>
<!--COLUMN TWO-->

</div>

<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>