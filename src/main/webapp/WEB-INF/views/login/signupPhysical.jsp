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

<meta charset="utf-8">
<spring:url var="addUserPhysical" value="/signup/userPhysical" />
<spring:url var="addUserLegal" value="/signup/userLegal" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Test</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/login/login.css" />"	rel="stylesheet">
	<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/js/script.js" />"></script> 
	<script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
    <script src="<c:url value="/resources/js/validate/validation.js" />"> </script>       

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Login page</title>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
    	<link href="<c:url value="/resources/css/validation.css"  />"
	rel="stylesheet" />
    

</head>
<body class="nonpersonal">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container-fluid" style='background-color:#3abeb1'>

    <div class="row row-offcanvas row-offcanvas-left" style="background-color: #3abeb1;">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas"  id="sidebar" role="navigation">

            <ul class="nav nav-sidebar">
                <li  class="active"><a href="<c:url value="/signup/userPhysical"/>"><i style='float: left' class="fa fa-check-square-o fa-3x"></i> <p style="padding-top: 4%;">Физическое лицо</p></a></li>
                <li><a href="<c:url value="/signup/userLegal"/>"><i style='float: left' class="fa fa-check-square-o fa-3x"></i> <p style="padding-top: 4%;">Юридическое лицо</p></a></li>
                <li><a style="float:left" href ='#' class="fa fa-vk "></a> <a style="float:left" href ='#' class="fa fa-google-plus"></a><a style="float:left" href ='#' class="fa fa-twitter"></a><a style="float:left" href ='#' class="fa fa-facebook"></a> </li>
            </ul>


        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">
            <p class="visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="fa fa-chevron-left"></i></button>
            </p>

            <section id="login">
                
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-wrap">
                                <h1>Введите данные:</h1>
                                <div id="home" >
		<form:form modelAttribute="addUserPhysicalForm" action="${addUserPhysical}" method="POST">
		<div class="col-md-12">
		
		<c:if test="${message != null }">
	<div class="messagesValidStyle">
	${message}
	</div>
	</c:if>
	   
		<div class="form-group heightStyleValidation">
		<form:input class="form-control" path="login" placeholder="Email" />
			<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="login"></label>
			<form:errors path="login" />
		</div>
		<div class="form-group">
		<form:select class="form-control" path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
	    </div>
		<div class="form-group heightStyleValidation">
		<form:input class="form-control" path="name" placeholder="Имя" />
		<form:errors path="name" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="name"></label>
		</div>
		<div class="form-group heightStyleValidation">
		<form:input class="form-control" path="surname" placeholder="Фамилия" />
		<form:errors path="surname" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="surname"></label>
		</div>
		<div class="form-group col-md-12" style="margin-bottom: 1.5em; padding: 0px; height: 2.8em;">
		<div class="field-phone-style">
		<form:input id="phone1" class="form-control phone1" path="phones" placeholder="Телефон"  />
		</div>
		<div class="field-phone-style-plus" style="margin-bottom:0px;">
		<a id="open-close" class="hover-style-for-plus" href="#"><i class="fa fa-plus-square fa-2x" aria-hidden="true"></i></a>
		</div>
		<form:errors path="phones" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="phone1"></label>
		</div>
		
		<div id="block-links">
   		<div class="form-group col-md-12" style="margin-bottom: 1.5em; padding: 0px;  height: 2.8em;">
		<div class="field-phone-style">
		<form:input id="phone2" class="form-control phone2" path="phones" placeholder="Доп.телефон" />

		</div>
		<div class="field-phone-style-plus">
		<a id="open-close2" class="hover-style-for-plus" href="#"><i class="fa fa-plus-square fa-2x" aria-hidden="true"></i></a>
		</div>
		<form:errors path="phones" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="phone2"></label>
		</div>
   		
    	<div id="block-links2">
   		<div class="form-group fieldPhoneHeight">
		<form:input id="phone3" class="form-control phone3" path="phones" placeholder="Доп.телефон" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="phone3"></label>
		<form:errors path="phones" />
		</div>
    	</div>
		</div>
		
		<div class="form-group" style="margin-bottom: 5px;" >
		<form:password class="form-control" path="password" placeholder="Пароль" />
		<form:errors class="form-control" path="password" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="password"></label>
		</div>
		<div class="form-group" style="margin-bottom: 0px;">
		<form:password class="form-control" path="confirmPassword" placeholder="Повторите пароль" />
		<form:errors path="confirmPassword" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="confirmPassword"></label>
		</div>
		<div class="checkbox col-md-12 heightStyleValidation" style="padding-left:22px; height: 5.3em;">
		<div>
		<form:checkbox path="confirm" />
		</div>
		<div>
		<label style="color:white; padding-left: 0px;">
		Я согласен с <a style="color:#3abeb1" href="<c:url value="/signup/userPhysical"/>">правилами пользования</a> сайтом
		</label>
		</div>
		<form:errors path="confirm" />
		<label style="padding-left: 0px;" class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="confirm"></label>
		</div>
		</div>
		<input class="btn btn-custom btn-lg btn-block" type="submit" value="Зарегистрироваться" />
	</form:form>
	</div>

                                <hr>
                            </div>
                        </div> <!-- /.col-xs-12 -->
                    </div> <!-- /.row -->
                
            </section>

        </div><!--/row-->
    </div>
</div><!--/.container-->



<!-- script references -->

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
<!-- Код для валидации телефонов -->
<script>

</script>

<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
