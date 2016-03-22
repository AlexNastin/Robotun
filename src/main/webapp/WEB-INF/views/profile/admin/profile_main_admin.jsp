<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<security:authorize access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL')" var="userBool" />
<security:authorize access="hasRole('ROLE_MODERATOR')"
	var="moderatorBool" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="adminBool" />
<c:if test="${userBool}">
	<c:set value="/user/profile" var="profileURL" />
</c:if>
<c:if test="${moderatorBool}">
	<c:set value="/moderator/profile" var="profileURL" />
</c:if>
<c:if test="${adminBool}">
	<c:set value="/admin/profile" var="profileURL" />
</c:if>
<title>Личный кабинет администратора</title>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
   
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
	Личный кабинет администратора
<a href='<c:url value="/admin/addModerator" />'>Добавить модератора</a> <br>

<c:forEach items="${listUsers}" var="user">
${user.login} <a href='<c:url value="/admin/deleteModerator?id=${user.idUser}" />'>Удалить</a> <br> <br>
</c:forEach>

<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript"
		src="<c:url value="/resources/js/results/autoload.js" />"></script>
		<script type="text/javascript">
		function loader(){         
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url:"autoloader/allResults",
								type:"GET",
								data:{
									//передаем параметры
									offset: offset
								},
								success:function(data) {
									console.log(data)
									if(data.length == 0) {
										isEnd = true;
									}
									for(var i=0; i<data.length; i++) {
										print(data[i].idLot, data[i].name, data[i].description, data[i].budget);
									}
									offset++;
									block = false;
								}
							});
						});
			}
		</script>
</body>
</html>
