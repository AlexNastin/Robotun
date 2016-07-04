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
	<script>
        $(document).ready(function(){
            $("#linkActive").click(function(){
                $("#activeL").toggleClass("main");
            });
            $("#linkActive2").click(function(){
                $("#activeL2").toggleClass("main");
            });
            $("#linkActive3").click(function(){
                $("#activeL3").toggleClass("main");
            });
        });
    </script>
<title>Правила пользования сайтом</title>
</head>
<body class="">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container imageBackground" style="width: 100%; height: 80%; padding-top: 1em;">
<div class="col-md-2"></div>
<div class="col-md-8">
<div class="col-md-12">
<a style="font-size: 25px; color:white;" href="index.html" class="text-style-size-result">Главная</a>
<i style="font-size: 25px; color:white;" class="fa fa-angle-right text-style-size-result"></i>
<span style="font-size: 25px; color:white;" class="text-style-size-result ">Правила использования</span>
</div>
<div class="col-md-12 boardBackgroundColor">
<div class="col-md-12">
</div>
<div class="col-md-12 headlineTextStyle">
Правила использования
</div>
<div class="col-md-12">
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading" id="activeL">
                <h4 class="panel-title">
                    <a data-toggle="collapse" id="linkActive" data-parent="#accordion" href="#collapse1">
                        Collapsible Group 1</a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse">
                <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" id="activeL2">
                <h4 class="panel-title">
                    <a data-toggle="collapse" id="linkActive2" data-parent="#accordion" href="#collapse2">
                        Collapsible Group 2</a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse">
                <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" id="activeL3">
                <h4 class="panel-title">
                    <a data-toggle="collapse" id="linkActive3" data-parent="#accordion" href="#collapse3">
                        Collapsible Group 3</a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse">
                <div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                    sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad
                    minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                    commodo consequat.</div>
            </div>
        </div>
    </div>
   </div>
    </div>
    </div>
   <div class="col-md-2"></div>
</div>

<%@include file="/WEB-INF/views/footer.jsp"%> 
</body>
</html>