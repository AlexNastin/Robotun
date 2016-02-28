<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Добавить работу</title>
</head>
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<body>
	<form:form modelAttribute="addLotForm" method="POST">
		<form:input path="name" placeholder="name" />
		<form:input path="description" placeholder="description" />
		<form:input path="budget" placeholder="budget" />
				<form:select class="form-control" id="idCategory" path="idCategory">
				</form:select>
					<label class="error" generated="true" for="idCategory""></label>
					<span class="error"><form:errors path="idCategory" /></span>
				<form:select class="form-control" id="idSubcategory" path="idSubcategory">
					<form:option value="0">Subcategory</form:option>
				</form:select>
				    <label class="error" generated="true" for="idSubcategory"></label>
					<span class="error"><form:errors path="idSubcategory" /></span>
		<form:input type="text" id="endDate" name="calendar" path="endDate" placeholder="endDate"/> 
			<label class="error" generated="true" for="endDate"></label>
			<span class="error"><form:errors path="endDate" /></span>
		<input type="submit" value="Отправить" />
	</form:form>
	<!-- scripts -->
    <script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
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

		    $( "#endDate" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+3650",changeMonth: true,
				changeYear: true, minDate:"+0",
				yearRange: "-0:+10"});
		    

		  });
</script>

</body>
</html>
