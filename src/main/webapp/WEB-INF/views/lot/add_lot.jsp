<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>Добавить работу</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/results/add_lot.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/font-awesome.min.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/jquery-ui.min.css"  />" rel="stylesheet" />

</head>
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<body class="body-color">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
	
	<div class="container container-style-addlot">
	<div class="col-md-1"></div>
	<div class="col-md-10 background-color-add_lot margin-bottom-button edit-users-legal-boards" >
	<div class="col-md-12">
	<div class="text-style-add-lot ">Добавить работу</div>
	</div>
	<div class="col-md-6 vertical-line text-align-justify horizontal-line">
	<p><i class="fa fa-angle-right fa-2x"></i> <span class="text-style-board-add-lot">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam scelerisque quis libero et pretium. Donec eu risus scelerisque, venenatis mi at, imperdiet sapien. Fusce felis nibh, vulputate id purus nec, cursus aliquam nisl.</span> 
	<p><i class="fa fa-angle-right fa-2x"></i> <span class="text-style-board-add-lot">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam scelerisque quis libero et pretium. Donec eu risus scelerisque, venenatis mi at, imperdiet sapien. Fusce felis nibh, vulputate id purus nec, cursus aliquam nisl.</span>
	<p><i class="fa fa-angle-right fa-2x"></i> <span class="text-style-board-add-lot">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam scelerisque quis libero et pretium. Donec eu risus scelerisque, venenatis mi at, imperdiet sapien. Fusce felis nibh, vulputate id purus nec, cursus aliquam nisl.</span>
	</div>
	<div class="col-md-6">
	<form:form modelAttribute="addLotForm" method="POST">
	
		<div class="form-group">
		<form:input path="name" placeholder="name" class="form-control"/>
		</div>
		<div class="form-group">
		<form:textarea path="description" placeholder="description" class="form-control" />
		</div>
		<div class="form-group">
		<form:input path="budget" placeholder="budget" class="form-control"/>
		</div>
		 <form:select class="form-group" path="idCity">
							<c:forEach items="${listCities}" var="city">
								<form:option value="${city.idCity}">${city.title}</form:option>
							</c:forEach>
						</form:select>
		<div class="form-group">
				<form:select class="form-control" id="idCategory" path="idCategory">
				</form:select>
					<label class="error" generated="true" for="idCategory""></label>
					<span class="error"><form:errors path="idCategory" /></span>
					</div>
					<div class="form-group">
				<form:select class="form-control" id="idSubcategory" path="idSubcategory">
					<form:option value="0">Subcategory</form:option>
				</form:select>
				    <label class="error" generated="true" for="idSubcategory"></label>
					<span class="error"><form:errors path="idSubcategory" /></span>
					</div>
		<div class="form-group">
		<form:input type="text" class="form-control" id="endDate" name="calendar" path="endDate" placeholder="endDate"/> 
			<label class="error" generated="true" for="endDate"></label>
			<span class="error"><form:errors path="endDate" /></span>
			</div>
			<p style="text-align:center; color:black;">Кому звоним?</p>
    <div class="switch-field">
      
      <form:radiobutton id="switch_right" name="switch_2" value="false" path="isCall"/>
      <label for="switch_right">Мне</label>
      <form:radiobutton id="switch_left" name="switch_2" value="true" path="isCall"/>
      <label for="switch_left">Я сам!</label>
    </div>
   
    
			<div class="form-group" style="text-align:center;">
		<input type="submit" class="button-add-lot-style btn btn-primary" value="Добавить"/>
		</div>
	</form:form>
	</div>
	
	</div>
    <div class="col-md-1"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<!-- scripts -->
    <script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/jquery.ui.datepicker-ru.js" />"> </script> 
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="<c:url value="/resources/js/timepicker.js" />"> </script> 
    <script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#idCategory')
								.change(
										function() {
											$
													.getJSON(
															'${getSubcategories}',
															{
																idCategory : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="0">Subcategory</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].idSubcategory + '">'
																			+ data[i].title
																			+ '</option>';
																}
																html += '</option>';
																$(
																		'#idSubcategory')
																		.html(
																				html);
															});
										});
					});
</script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON('${getCategories}', {
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">Category</option>';
					var len = data.length;
					for (var i = 0; i < len; i++) {
						html += '<option value="' + data[i].idCategory + '">'
								+ data[i].title + '</option>';
					}
					html += '</option>';
					$('#idCategory').html(html);
				});
			});
	  $(function() {

		    $( "#endDate" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+180",changeMonth: true,
				changeYear: true, minDate:"+0",
				yearRange: "-0:+1"});
		    

		  });
	  $(document).ready(function(){
		    $( "#datepicker" ).datepicker( $.datepicker.regional[ "ru" ] );
		});
</script>

</body>
</html>
