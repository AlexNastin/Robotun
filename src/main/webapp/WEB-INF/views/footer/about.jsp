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
    <link href="<c:url value="/resources/css/main/about.css"  />" rel="stylesheet" />
    <script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
    <script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <link rel="icon" href="<c:url value="/resources/images/favicon.ico" />"
	type="image/x-icon">
	
<title>Как это работает? | Jobster.by  - Сервис разовой работы</title>
</head>
<body class="">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="policy" >
<h1 style="text-align:center; color:white">Как работает Jobster.by</h1>
<div class="container">
	<div class="row">
		<section>
        <div class="wizard">
            <div class="wizard-inner">
                <div class="connecting-line"></div>
                <ul class="nav nav-tabs" role="tablist">

                    <li role="presentation" class="active">
                        <a href="#step1" data-toggle="tab" aria-controls="step1" role="tab" title="Шаг 1">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-user"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" class="disabled">
                        <a href="#step2" data-toggle="tab" aria-controls="step2" role="tab" title="Шаг 2">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-list-alt"></i>
                            </span>
                        </a>
                    </li>
                    <li role="presentation" class="disabled">
                        <a href="#step3" data-toggle="tab" aria-controls="step3" role="tab" title="Шаг 3">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-phone"></i>
                            </span>
                        </a>
                    </li>

                    <li role="presentation" class="disabled">
                        <a href="#complete" data-toggle="tab" aria-controls="complete" role="tab" title="Готово">
                            <span class="round-tab">
                                <i class="glyphicon glyphicon-ok"></i>
                            </span>
                        </a>
                    </li>
                </ul>
            </div>

            <form role="form">
                <div class="tab-content">
                    <div class="tab-pane active" role="tabpanel" id="step1">
                        <h2>Шаг 1</h2>
                        <h3>Для исполнителей</h3>
                        <p>Для того, чтобы откликнуться на предложение, пользователь должен быть авторизован. 
                       Далее пользователю необходимо выбрать заинтересовавшее его предложение, сделать это он может нажав на главной странице кнопку «Хочу работать» и выбрать, в появившемся списке, одно из предложений. </p>
                       
                        <h3>Для заказчиков</h3>
                        <p>Для публикации предложения о работе или услуге, пользователь должен быть авторизован. Далее пользователю необходимо нажать на главной странице кнопку «Предлагаю работу»</p>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-primary next-step" style="background-color: #3abeb1; border-color: #3abeb1;">Понял</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step2">
                         <h2>Шаг 2</h2>
                        <h3>Для исполнителей</h3>
                        <p>Затем, подробно изучив предложение, в специальном поле необходимо указать сумму в BYN, за которую он готов выполнить данную услугу или работу, и нажать кнопку «Предложить». </p>
                        <h3>Для заказчиков</h3>
                        <p>заполнить в появившейся форме необходимые поля. При заполнении формы, пользователь должен указать дату и время окончания предложения. С помощью маркера на карте можно указать точное место, где необходимо выполнить работу или оказать услугу. Кроме этого, можно указать кто будет звонить в разделе формы «Кому звоним?». В случае нажатия на кнопку «Мне», исполнители будут видеть номер заказчика. Если же выбрать «Я сам», то исполнители не будут видеть номер заказчика, но при этом заказчик может просмотреть номера исполнителей и сам выбрать кому звонить. После заполнения формы пользователь должен нажать кнопку «Добавить». </p>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Вернуться</button></li>
                            <li><button type="button" class="btn btn-primary next-step" style="background-color: #3abeb1; border-color: #3abeb1;">Понял</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="step3">
                         <h2>Шаг 3</h2>
                        <h3>Для исполнителей</h3>
                        <p>Предложить другую сумму пользователь может не ранее, чем через 10 минут. Для просмотра телефона заказчика необходимо нажать кнопку «Посмотреть телефон». Все свои отклики пользователь может посмотреть в личном кабинете в разделе меню «Мои отклики».</p>
                        <h3>Для заказчиков</h3>
                        <p>После шага 2 Ваш заказ уходит на модерацию. Если пост имеет замечания, то они отобразятся в личном кабинете в разделе меню «Замечания по работам». Если же пост успешно прошёл модерацию, то он отобразится в общем списке лотов, который можно открыть, нажав на главной странице кнопку «Хочу работать». Все свои предложения о работе пользователь может посмотреть в личном кабинете в разделе меню «Мои работы».</p>
                        <ul class="list-inline pull-right">
                            <li><button type="button" class="btn btn-default prev-step">Вернуться</button></li>
                            <li><button type="button" class="btn btn-primary btn-info-full next-step" style="background-color: #3abeb1; border-color: #3abeb1;">Понял</button></li>
                        </ul>
                    </div>
                    <div class="tab-pane" role="tabpanel" id="complete">
                        <h3>Готово!</h3>
                        <p>Вы великолепны!</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </form>
        </div>
    </section>
   </div>
</div>

</div>
<script	src="<c:url value="/resources/js/about.js" />"></script>
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