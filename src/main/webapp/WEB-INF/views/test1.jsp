<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
	<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>Test1</title>
<link rel="stylesheet" type="text/css"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type="text/javascript"
	src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

</head>
<body>
	<a href="<c:url value="/"/>">Test</a>
	<a href="<c:url value="/redisTest"/>">Redis</a>
	<a href="<c:url value="/voting?mark=10&idLot=2&idUser=3"/>">VotingInseret</a>
	<a href="<c:url value="/getVoting?idLot=2"/>">VotingGET</a>
	<a href="<c:url value="/checkVoting?idLot=2"/>">VotingCHECK</a>
	<a href="<c:url value="/testBase?count=500"/>">TestBASE</a>

	<script type="text/javascript">
		var RestGet2 = function() {
			$.ajax({
				type : 'GET',
				url : prefix2 + '/subscriber/' + 1,
				dataType : 'json',
				async : true,
				success : function(result) {
					alert('message: ' + result.message + ', httpStatus: '
							+ result.httpStatus);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.status + ' ' + jqXHR.responseText);
				}
			});
		}
	</script>

</body>
</html>
