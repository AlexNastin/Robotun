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
<spring:url var="addUserPhysical" value="/signup/userPhysical" />
<spring:url var="addUserLegal" value="/signup/userLegal" />
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/login/login.css"  />" rel="stylesheet" />
<title>Регистрация</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
		<div class="background-main-image height-main-block">
		<!-- Начало табов -->
		<div class="col-md-2"></div>		
		<div class="col-md-8 form-login-style">

			<ul class="nav nav-tabs tab-style">
				<li class="active"><a href='<c:url value="/signup/userPhysical" />'>Физическиое лицо</a></li>
				<li><a href='<c:url value="/signup/userLegal" />'>Юридическое лицо</a></li>
			</ul>
			<div class="form-main-text">Регистрация</div>
		<div class="tab-content">
		<div id="home" class="tab-pane fade in active">
		<form:form modelAttribute="addUserPhysicalForm" action="${addUserPhysical}" method="POST">
		<div class="col-md-6">
		<div class="form-group">
		<form:input class="form-control" path="login" placeholder="login" />
			<form:errors path="login" />
		</div>
		<div class="form-group">
		<form:select class="form-control" path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
	    </div>
		<div class="form-group">
		<form:input class="form-control" path="name" placeholder="name" />
		<form:errors path="name" />
		</div>
		<div class="form-group">
		<form:input class="form-control" path="surname" placeholder="surname" />
		<form:errors path="surname" />
		</div>
		<div class="form-group">
		<form:input class="form-control" path="middleName" placeholder="middleName" />
		<form:errors path="middleName" />
		</div>
		<div class="form-group" style='margin-bottom:0px'>
		<form:input class="form-control" path="phones" placeholder="phone1"  />
		<form:errors path="phones" />
		</div>
		<a id="open-close" href="#">Ещё телефон</a>
		<div id="block-links">
   		<div class="form-group" style='margin-bottom:0px'>
		<form:input class="form-control" path="phones" placeholder="phone2" />
		<form:errors path="phones" />
		</div>
   		<a id="open-close2" href="#"> добавить ещё телефон</a>
    	<div id="block-links2">
   		<div class="form-group">
		<form:input class="form-control" path="phones" placeholder="phone3" />
		<form:errors path="phones" />
		</div>
    	</div>
		</div>
		
		<div class="form-group">
		<form:password class="form-control" path="password" placeholder="password" />
		<form:errors class="form-control" path="password" />
		</div>
		<div class="form-group">
		<form:password class="form-control" path="confirmPassword" placeholder="confirmPassword" />
		<form:errors path="confirmPassword" />
		</div>
		</div>
		<div class="col-md-6">
		<div class="form-login-text-color">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec condimentum, ex gravida blandit porttitor, lectus libero blandit tellus, eu tempor sapien enim non velit. Curabitur hendrerit leo at nisl consectetur hendrerit. Fusce tincidunt, est ac accumsan finibus, elit sapien tempus magna, vitae imperdiet tortor nisi vitae nisi. Vivamus iaculis ullamcorper quam non malesuada. Morbi imperdiet diam non ex gravida, ac porttitor ipsum vehicula. 
		</div>
		<div style="margin-top: 4em;">
		<div class="col-md-6">
		<input class="btn btn-default login-button-style" type="submit" value="Зарегистрироваться" />
	    </div>
	    <div class="col-md-6">
	    <a href="<c:url value="/login"/>" class="text-color"><button class="btn btn-default login-button-style" type="button">Войти</button></a>
	    </div>
	    </div>
	    </div>
	</form:form>
	</div>
		<!-- 2 блок -->
		<div id="menu1" class="tab-pane fade">
		<form:form modelAttribute="addUserLegalForm" action="${addUserLegal}" method="POST">
		<div class="col-md-6">
		<div class="form-group">
		<form:input class="form-control" path="login" placeholder="login" />
		<form:errors path="login" />
		</div>
		<div class="form-group">
		<form:select class="form-control" path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
		</div>
		<div class="form-group">
		<form:input class="form-control" path="nameEnterprise" placeholder="nameEnterprise" />
		<form:errors  path="nameEnterprise" />
		</div>
		<div class="form-group">
		<form:input class="form-control" path="unp" placeholder="unp" />
		<form:errors path="unp" />
		</div>
		<div class="form-group">
		<form:input class="form-control" path="address" placeholder="address" />
		<form:errors path="address" />
		</div>
		<div class="form-group">
		<form:input class="form-control" path="zipCode" placeholder="zipCode" />
		<form:errors path="zipCode" />
		</div>
		<div class="form-group" style='margin-bottom:0px'>
		<form:input class="form-control" path="phones" placeholder="phone1"  />
		<form:errors path="phones" />
		</div>
		<a id="open-close3" href="#">Ещё телефон</a>
		<div id="block-links3">
   		<div class="form-group" style='margin-bottom:0px'>
		<form:input class="form-control" path="phones" placeholder="phone2" />
		<form:errors path="phones" />
		</div>
   		<a id="open-close4" href="#"> добавить ещё телефон</a>
    	<div id="block-links4">
   		<div class="form-group">
		<form:input class="form-control" path="phones" placeholder="phone3" />
		<form:errors path="phones" />
		</div>
    	</div>
		</div>
		<div class="form-group">
		<form:password class="form-control" path="password" placeholder="password" />
		<form:errors path="password" />
		</div>
		<div class="form-group">
		<form:password class="form-control" path="confirmPassword" placeholder="confirmPassword" />
		<form:errors path="confirmPassword" />
		</div>
		</div>
		<div class="col-md-6">
		<div class="form-login-text-color">
		Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec condimentum, ex gravida blandit porttitor, lectus libero blandit tellus, eu tempor sapien enim non velit. Curabitur hendrerit leo at nisl consectetur hendrerit. Fusce tincidunt, est ac accumsan finibus, elit sapien tempus magna, vitae imperdiet tortor nisi vitae nisi. Vivamus iaculis ullamcorper quam non malesuada. Morbi imperdiet diam non ex gravida, ac porttitor ipsum vehicula. 
		</div>
		<div style="margin-top: 4em;">
		<div class="col-md-6">
		<input class="btn btn-default login-button-style" type="submit" value="Зарегистрироваться" />
		</div>
		<div class="col-md-6">
		<a href="<c:url value="/login"/>" class="text-color"><button class="btn btn-default login-button-style" type="button">Войти</button></a>
		</div>
		</div>
		</div>
	</form:form>
	</div>
	</div>
	</div>
	<div class="col-md-2"></div>
	</div>
	<c:if test="${message != null }">
	${message}
	</c:if>
	<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
    $(document).ready(function() {
        $('#open-close').show();
        $('#block-links').hide();

        $('#open-close').click(function(event) {
            event.preventDefault(); // телефон 2
            $('#block-links').slideToggle();
        });
    });
    $(document).ready(function() {
        $('#open-close2').show();
        $('#block-links2').hide();

        $('#open-close2').click(function(event) {
            event.preventDefault(); // телефон 3
            $('#block-links2').slideToggle();
        });
    });
    $(document).ready(function() {
        $('#open-close3').show();
        $('#block-links3').hide();

        $('#open-close3').click(function(event) {
            event.preventDefault(); // телефон юрика
            $('#block-links3').slideToggle();
        });
    });
    $(document).ready(function() {
        $('#open-close4').show();
        $('#block-links4').hide();

        $('#open-close4').click(function(event) {
            event.preventDefault(); // телефон юрика 2
            $('#block-links4').slideToggle();
        });
    });
</script>
</body>
</html>