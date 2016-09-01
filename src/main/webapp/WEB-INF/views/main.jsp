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
<meta name="yandex-verification" content="e6c5456914c00f39" />
<meta name="google-site-verification" content="fWLSEgnvT-YWRdNU_zs0KVkjyC__AFH-jHA_rfNzQig" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
    <link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
    <link rel="icon" href="<c:url value="/resources/images/favicon.ico" />"
	type="image/x-icon">
    
<title>Jobster.by | Лучшая разовая работа</title>
</head>
<body class="nonpersonal">
<%@include file="/WEB-INF/views/header.jsp"%>
<!--Banner-image, search and buttons-->
<div class="wrapper">
<div class="content background-main-image search-margin-top blur">
    <div class="container">
        <div class="main-text-style">Ищете услугу?</div>
        <div class="row row-margin">
    <div class="col-lg-3"></div>
    <div class="col-lg-6">
       
        <form action="<c:url value="/result" />" method="get">
         <div class="input-group">
            <input type="text" class="form-control search-style" placeholder="Введите запрос..." name="q">
      <span class="input-group-btn">
        <button class="btn btn-default search-button-style" type="submit">Поиск</button>
      </span>
      </div>
      </form>
        <!-- /input-group -->
    </div>
    <!-- /.col-lg-6 -->
    <div class="col-lg-3"></div>
    <div class="container">
        <div class="col-md-5 button-align-left">
            <a class="btn btn-primary btn-lg main-button-style" style="min-width: 11em" href='<c:url value="/result"/>' role="button">Хочу работать</a>
        </div>
        <div class="col-md-2"></div>
        <div class="col-md-5 button-align-right">
            <a class="btn btn-primary btn-lg main-button-style" style="min-width: 11em" href='<c:url value="/user/addLot"/>' role="button">Предлагаю работу</a>
        </div>
    </div>
    </div>
    </div>
    </div>
    
   </div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
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
</body>
</html>