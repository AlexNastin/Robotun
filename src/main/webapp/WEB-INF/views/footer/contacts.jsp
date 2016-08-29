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
    <link href="<c:url value="/resources/css/validation.css"  />" rel="stylesheet" />
    <script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
    <script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <link rel="icon" href="<c:url value="/resources/images/favicon.ico" />"
	type="image/x-icon">
	
<title>Контакты</title>
</head>
<spring:url var="sendFeedback" value="/contacts/send" />
<body class="">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="policy" style="word-wrap: break-word; height:100%">
<div class="col-md-offset-2 col-md-8">
<a style="font-size: 25px; color:white;" href="index.html" class="text-style-size-result">Главная</a>
<i style="font-size: 25px; color:white;" class="fa fa-angle-right text-style-size-result"></i>
<span style="font-size: 25px; color:white;" class="text-style-size-result ">Связаться с нами</span>
</div>
<div class="container mainpolicy" style="    background-color: rgba(242, 222, 222, 0);">
<div class="col-md-4 col-sm-4 col-sm-offset-4 col-md-offset-4">
<div class="">
<form:form modelAttribute="feedBackForm" action="${sendFeedback}">
<div class="form-group" style="height: 2.8em;">
<form:input class="form-control"   path="email" placeholder="Ваш e-mail адрес" />
<label for="email" class="error textStyleValidation textStyleValidationColorWhite" id="email-error"></label>
</div>
<form:errors  path="email" />
<div class="form-group" style="height: 2.8em;">
<form:input class="form-control"   path="name"  placeholder="Как к вам обращаться?" />
<label for="name" class="error textStyleValidation textStyleValidationColorWhite" id="name-error"></label>
</div>
<div class="form-group" style="height: 2.8em;">
<form:input class="form-control"  path="title" placeholder="Тема письма" />
<label for="title" class="error textStyleValidation textStyleValidationColorWhite" id="title-error"></label>
</div>
<div class="form-group" style="height: 9.8em;">
<form:textarea class="form-control"   path="text" placeholder="Текст письма" rows="5" style="resize: none;"/>
<label for="text" class="error textStyleValidation textStyleValidationColorWhite" id="text-error"></label>
</div>
<div class="form-group">
<input class="btn btn-info" type="submit" value="Отправить">
</div>
</form:form>
</div>
</div>
</div>
</div>
	<script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
	<script src="<c:url value="/resources/js/validate/additional-methods.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/validate/validation.js" />"> </script> 
<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>