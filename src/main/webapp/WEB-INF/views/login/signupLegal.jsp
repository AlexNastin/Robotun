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
<spring:url var="addUserPhysical" value="/signup/userPhysical" />
<spring:url var="addUserLegal" value="/signup/userLegal" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Регистрация</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/login/login.css" />"	rel="stylesheet">
	<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/js/script.js" />"></script>     

    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Регистрация</title>
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
<body>

<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

<div class="container-fluid" style='background-color:#3abeb1'>

    <div class="row row-offcanvas row-offcanvas-left" style="background-color: #3abeb1;">

        <div class="col-sm-3 col-md-2 sidebar-offcanvas"  id="sidebar" role="navigation">

            <ul class="nav nav-sidebar">
                <li  ><a href="<c:url value="/signup/userPhysical"/>"><i style='float: left' class="fa fa-check-square-o fa-3x"></i> <p style="padding-top: 4%;">Физическое лицо</p></a></li>
                <li class="active"><a href="<c:url value="/signup/userLegal"/>"><i style='float: left' class="fa fa-check-square-o fa-3x"></i> <p style="padding-top: 4%;">Юридическое лицо</p></a></li>
            </ul>


        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">
            <p class="visible-xs">
                <button type="button" class="btn btn-primary btn-xs load-button" data-toggle="offcanvas"><i class="fa fa-chevron-left"></i> <span>Тип пользователя</span></button>
            </p>

            <section id="login">
                
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-wrap">
                                <h1>Введите данные:</h1>
                                <div id="home" >
		<form:form modelAttribute="addUserLegalForm" action="${addUserLegal}" method="POST">
		<div class="col-md-12" style="line-height: 1">
		<div class="messagesValidStyle">
		<c:if test="${message != null }">
	${message}
	</c:if>
	</div>
		<div class="form-group form-group-required heightStyleValidation">
		<div>
		<form:input class="form-control" path="login" placeholder="Email" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="login" /></span>
		</div>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="login"></label>
		</div>
		<div class="form-group">
		<form:select class="form-control" path="idCity">
			<c:forEach items="${listCities}" var="city">
				<form:option value="${city.idCity}">${city.title}</form:option>
			</c:forEach>
		</form:select>
		<span class="error"><form:errors  path="idCity" /></span>
		</div>
		<div class="form-group form-group-required heightStyleValidation">
		<div>
		<form:input class="form-control" path="nameEnterprise" placeholder="Название компании" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="nameEnterprise" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="nameEnterprise"></label>
		</div>
		</div>
		<div class="form-group form-group-required heightStyleValidation">
		<div>
		<form:input class="form-control" path="unp" placeholder="УНП" />
		<form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="unp" />
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="unp"></label>
		</div>
		</div>
		<div class="form-group form-group-required heightStyleValidation">
		<div>
		<form:input class="form-control" path="address" placeholder="Адрес" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="address" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="address"></label>
		</div>
		</div>
		<div class="form-group form-group-required heightStyleValidation">
		<div>
		<form:input class="form-control" path="zipCode" placeholder="Индекс" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="zipCode" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="zipCode"></label>
		</div>
		</div>
			
		<div class="form-group form-group-required " style="margin-bottom: 5px; height: 4em;">
		<div>
		<form:password class="form-control" path="password" placeholder="Пароль" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="password" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="password"></label>
		</div>
		</div>
		<div class="form-group form-group-required" style="margin-bottom: 0px; height: 4em;">
		<div>
		<form:password class="form-control" path="confirmPassword" placeholder="Повторите пароль" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="confirmPassword" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="confirmPassword"></label>
		</div>
		</div>
		<div class="form-group col-md-12 form-group-required" style="margin-bottom:1.5em; padding: 0px; height: 2.8em;">
		<div class="input-group">
		<form:input id="phone1" class="form-control phone1 phone-group" path="phones[0]" placeholder="Номер телефона"  />
		<a id="open-close3" class="input-group-addon" href="#"><i class="fa fa-plus fa-1x" aria-hidden="true"></i></a>
		</div>
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="phones" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="phone1"></label>
		</div>
		<div id="block-links3">
   		<div class="form-group col-md-12" style="margin-bottom:1.5em; padding: 0px;  height: 2.8em;">
		<div class="input-group">
		<form:input id="phone2" class="form-control phone2 phone-group" path="phones[1]" placeholder="Доп.телефон" />
		<a id="open-close4" class="input-group-addon" href="#"><i class="fa fa-plus fa-1x" aria-hidden="true"></i></a>
		</div>
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="phones" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="phone2"></label>
		</div>
    	<div id="block-links4">
   		<div class="form-group fieldPhoneHeight">
		<form:input id="phone3" class="form-control phone3 phone-group" path="phones[2]" placeholder="Доп.телефон" />
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="phones" /></span>
		<label class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="phone3"></label>
		</div>
    	</div>
		</div>
		<div class="checkbox col-md-12 heightStyleValidation" style="padding-top:10px;min-height:3em;padding-left:22px; background-color:rgba(0,0,0,.5)">
		<div>
		<form:checkbox path="confirm" />
		</div>
		<div style="text-align:center">
		<label style="color:white; padding-left: 0px;">
		Я согласен с <a style="color:#3abeb1" href="<c:url value="/agreement" />">публичным договором</a>
		</label>
		</div>
		<span class="error"><form:errors class="textStyleValidation textStyleValidationColorWhite textStyleServerValidation" path="confirm" /></span>
		<label  style="padding-left: 0px;" class="error textStyleValidation textStyleValidationColorWhite" generated="true" for="confirm"></label>
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
<script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
<script src="<c:url value="/resources/js/validate/additional-methods.min.js" />"> </script>  
<script src="<c:url value="/resources/js/validate/validation.js" />"> </script> 
<!-- Yandex.Metrika counter -->
<script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter39345665 = new Ya.Metrika({
                    id:39345665,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true,
                    webvisor:true,
                    trackHash:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks");
</script>
<noscript><div><img src="https://mc.yandex.ru/watch/39345665" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
<!-- /Yandex.Metrika counter --> 
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
