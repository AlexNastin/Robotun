<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<title>Забыл пароль</title>
<!-- Init search variable -->

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="keywords" content=""> 
    
    <spring:message code="email.message.resetPassword.enteremailmessage" var="enteremailmessage"/>
   
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">

    <link href="<c:url value="/resources/css/main/error.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/fontawesome430/css/font-awesome.min.css"  />" rel="stylesheet" />
    <link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
   	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
   
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-12" style="padding-top: 3em;" >
    <h1 style="text-align:center"><i class="fa fa-envelope-o"></i> ${enteremailmessage} <i class="fa fa-envelope-o"></i></h1>
    <div class="col-md-4"></div>
    <div class="col-md-4">
            <div class="error-template" style="min-height:45em;">
               
               <form action="<c:url value="/resetPassword"></c:url>" method="POST">
				<input class="form-control" required id="email" name="email"	type="email" value="" placeholder="Email" />
				<input style="margin-top: 10px;" type="submit"  class="btn btn-primary" />
			   </form>
			   <c:if  test="${message != null}">
			  <div class="alert alert-info" role="alert" style="margin-top: 3%; padding:1%">${message}</div> 
			   </c:if>
		</div>
	</div>
	</div>
	<script type="text/javascript">
		function resetPass() {
			var email = $("#email").val();
			$.post("<c:url value="/resetPassword"></c:url>",{email : email},
					function(data){
	            window.location.href = 
	              "<c:url value="/go/signin"></c:url>" + "?message=" + data.message;
	    })
	    .fail(function(data) {
	        if(data.responseJSON.error.indexOf("MailError") > -1) {
	            window.location.href = 
	              "<c:url value="/emailError.html"></c:url>";
	        }
	        else {
	            window.location.href = 
	              "<c:url value="/login.html"></c:url>" + "?message=" + data.responseJSON.message;
	        }
	    });
	}
	</script>
            </div>
        </div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>