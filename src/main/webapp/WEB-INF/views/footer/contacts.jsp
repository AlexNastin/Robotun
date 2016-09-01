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
<div class="policy" style="word-wrap: break-word; min-height:100%">
<div class="col-md-offset-2 col-md-8">
<a style="font-size: 25px; color:white;" href="index.html" class="text-style-size-result">Главная</a>
<i style="font-size: 25px; color:white;" class="fa fa-angle-right text-style-size-result"></i>
<span style="font-size: 25px; color:white;" class="text-style-size-result ">Связаться с нами</span>
</div>
<div class="mainpolicy" style="background-color: rgba(242, 222, 222, 0);">


<div class="col-md-10 col-md-offset-1" style="background-color: rgba(16,16,16, 0.8); padding: 2em;">
<div class="col-md-5">
<div class="textStyleContactPage" style="color:white">Мы в социальных сетях</div>
<ul class="list-group">
 				<li class="list-group-item "><a target="_blank" href="https://vk.com/jobsterby" class="fa fa-vk fa-2x socialIconContactColor"> VK</a></li>
 				<li class="list-group-item"><a  href="https://www.facebook.com/jobster.by/" class="fa fa-facebook-official fa-2x socialIconContactColor"> Facebook</a></li>  
 				<li class="list-group-item"><a  href="mailto:jobster.by@gmail.com" class="fa fa-envelope-o fa-2x socialIconContactColor" style="font-size:19px"> jobster.by@gmail.com</a></li>          
 </ul>
</div>
<div class="col-md-5 col-md-offset-2">
<div class="">
<div class="textStyleContactPage">Обратная связь</div>
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
<input class="btn btn-info buttonStyleContact" type="submit" value="Отправить">
</div>
</form:form>
<div style="color:white">
<c:if test="${message != null }">
${message}
</c:if>
</div>
</div>
</div>
</div>
<div class="col-md-2"></div>
</div>
</div>

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