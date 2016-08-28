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
	
<title>FAQ</title>
</head>
<body class="">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container imageBackground" style="width: 100%;  padding-top: 1em;">
<div class="col-md-offset-2 col-md-8">
<a style="font-size: 25px; color:white;" href="index.html" class="text-style-size-result">Главная</a>
<i style="font-size: 25px; color:white;" class="fa fa-angle-right text-style-size-result"></i>
<span style="font-size: 25px; color:white;" class="text-style-size-result ">FAQ - часто задаваемые вопросы</span>
</div>
<div class="col-md-offset-2 col-md-8 boardBackgroundColor">
<div class=""></div>
<div class="col-md-12 headlineTextStyle">FAQ - часто задаваемые вопросы</div>
<div class="col-md-12">
<div id="accordion2" class="panel-group" style="margin: auto!important;">
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseOne22">
<h4 class="panel-title">▼ Что такое jobster.by? </h4>
</div>
<div id="collapseOne22" class="panel-collapse collapse">
<div class="panel-body">Jobster.by – это сайт, который может помочь найти Вам разовую работу или же помочь найти специалиста для её выполнения.</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseTwo22">
<h4 class="panel-title">▼  Что нужно для регистрации на сайте?</h4>
</div>
<div id="collapseTwo22" class="panel-collapse collapse">
<div class="panel-body">Для регистрации на сайте необходимо выбрать Ваш статус (физическое или юридическое лицо), затем заполнить стандартную форму регистрации.</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseThree22">
<h4 class="panel-title">▼  Нужно ли обладать специфическими навыками для регистрации на сайте?</h4>
</div>
<div id="collapseThree22" class="panel-collapse collapse">
<div class="panel-body">Не обязательно. На нашем сайте представлены предложения о разовой работе из различных профессиональных сфер, в том числе, не требующих наличия специфических профессиональных навыков.</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseFour22">
<h4 class="panel-title">▼  Можно ли быть одновременно исполнителем и заказчиком?</h4>
</div>
<div id="collapseFour22" class="panel-collapse collapse">
<div class="panel-body">Да, Вы можете быть одновременно и заказчиком, и исполнителем, на нашем сайте нет ограничений по данному вопросу как для физических, так и для юридических лиц</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseFive22">
<h4 class="panel-title">▼  Кому платить/кто мне заплатит?</h4>
</div>
<div id="collapseFive22" class="panel-collapse collapse">
<div class="panel-body">Все финансовые вопросы решаются только между заказчиком и исполнителем. Если Вы исполнитель и Вас выбрал заказчик для выполнения работы, то Вам платит заказчик. Если же Вы заказчик и выбрали исполнителя работ, то Вы платите исполнителю</div>
</div>
</div>
<div class="panel panel-default">
<div class="panel-heading accordion-toggle collapsed" data-toggle="collapse" data-parent="#accordion2,#accordion3" data-target="#collapseSix22">
<h4 class="panel-title">▼  Не могу войти на сайт. Кажется, меня взломали. Что делать?</h4>
</div>
<div id="collapseSix22" class="panel-collapse collapse">
<div class="panel-body">Для начала, попробуйте сбросить пароль на странице Входа. Если доступ к почтовому ящику утерян, свяжитесь со службой поддержки.</div>
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