<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Работа</title>
</head>
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<body>
	
	${lot.name} <br>
	${lot.budget} <br>
	
	<input type="text" id="cost">
	<a id="btn" href="#">Send</a>
	
	<div id="output">
	<c:forEach items="${lot.bets}" var="bet">
			<div>${bet.cost}</div>
			</c:forEach>
	</div>

<script type="text/javascript">
var id = ${lot.idLot};
var idUser = ${idUser}
</script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/socket/websocket_message.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/socket/message.js" />"></script>
</body>
</html>
