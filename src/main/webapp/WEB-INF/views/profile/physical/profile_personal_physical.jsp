<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<title>Изменение личных данных</title>

<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
 <link href="<c:url value="/resources/css/validation.css"  />"
	rel="stylesheet" />

</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container user-profile" >
<div class="col-md-2 nopadiing-left">
<div style="background-color:white; text-align:center">
<img src="<c:url value="/resources/images/avatar_user/avatar_big/${avatarPath}.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
</div>
<div class="style-nickname">${nickname}</div>
<div class="user-navigation">
<a href='<c:url value="/physical/profile/myLots" />' class="list-group-item background-color-menu-profile">Мои работы</a>
<a href='<c:url value="/physical/profile/archiveLots" />' class="list-group-item background-color-menu-profile">Архив работ</a>
<a href='<c:url value="/physical/profile/myResponses" />' class="list-group-item background-color-menu-profile">Мои отклики</a>
<a href='<c:url value="/physical/profile/lotsOnUpdate" />' class="list-group-item background-color-menu-profile ">Замечания по работам</a>
<a href='<c:url value="/physical/secure/updatePassword" />' class="list-group-item background-color-menu-profile ">Сменить пароль</a>
<a href='#' class="list-group-item background-color-menu-profile active-menu">Личные данные</a>
<a href='<c:url value="/user/addLot"/>' class="list-group-item background-color-menu-profile ">Добавить работу</a>
</div>
</div>
<div class="col-md-10">
<div class="col-md-2"></div>
<div class="col-md-8 edit-users-legal-boards" style="padding-top: 1em;">
<div class="messagesValidStyle">
		<c:if test="${message != null}">
			${message}
			   </c:if>
		</div>
<div class="col-md-12 text-style-legal-user">Изменение личных данных</div>
		
	<form:form modelAttribute="updatePersonalPhysicalForm" method="POST">
		<div class="form-group heightStyleValidation2">
		<form:input path="name" class="form-control" placeholder="name" value="${user.physical.name}"/>
		<label class="error textStyleValidation" generated="true" for="name"></label>
		</div>
		<div class="form-group" style="height: 2.8em">
		<form:input path="surname" class="form-control" placeholder="surname" value="${user.physical.surname}"/>
		<label class="error textStyleValidation" generated="true" for="surname"></label>
		</div>
		<div class="form-group" style="height: 2.8em">
		<form:select class="form-control" path="idCity">
			<c:set var="idSelectCity" value="${user.idCity}"/>
			<c:forEach items="${listCities}" var="city">
				<c:if test="${city.idCity == idSelectCity}">
					<c:set var="selected" value="true"/>
				</c:if>
				<form:option value="${city.idCity}" selected="${selected}">${city.title}</form:option>
				<c:set var="selected" value=""/>
			</c:forEach>
		</form:select>
		</div>
		<div class="form-group" style="height: 14em">
		<c:forEach items="${user.phones}" var="phone" varStatus="i">
				<div style="height: 3.8em">
				<form:input id="phone${i.count}" path="phones[${i.index}]" class="form-control phone-group" placeholder="Телефон" value="${phone.phone}"/>
				<label class="error textStyleValidation" generated="true" for="phone${i.count}"></label>
		        </div>
		</c:forEach>
		<div style="text-align:center;">
		<input type="submit" style="margin-bottom: 1em" class="button-on-add-lot btn btn-primary button-legal-style" value="Изменить" />
		</div>
		</div>
	</form:form>
</div>
<div class="col-md-2"></div>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
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
</body>
</html>
