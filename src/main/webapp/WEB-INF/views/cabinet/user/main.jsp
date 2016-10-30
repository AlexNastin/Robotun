<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User - main</title>
<link href="<c:url value="/resources/css/templatemo_style.css" />"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/ddsmoothmenu.css" />" />

<script type="text/javascript"
	src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/ddsmoothmenu.js"/>"></script>

<script type="text/javascript">
	ddsmoothmenu.init({
		mainmenuid : "templatemo_menu", //menu DIV id
		orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
		classname : 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
	})

	function clearText(field) {
		if (field.defaultValue == field.value)
			field.value = '';
		else if (field.value == '')
			field.value = field.defaultValue;
	}
</script>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/styles.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/cabinet.css" />" />
<script language="javascript" type="text/javascript"
	src="<c:url value="/resources/scripts/mootools-1.2.1-core.js"/>"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value="/resources/scripts/mootools-1.2-more.js"/>"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value="/resources/scripts/slideitmoo-1.1.js"/>"></script>
<script language="javascript" type="text/javascript">
	window.addEvents({
		'domready' : function() {
			/* thumbnails example , div containers */
			new SlideItMoo({
				overallContainer : 'SlideItMoo_outer',
				elementScrolled : 'SlideItMoo_inner',
				thumbsContainer : 'SlideItMoo_items',
				itemsVisible : 5,
				elemsSlide : 2,
				duration : 200,
				itemsSelector : '.SlideItMoo_element',
				itemWidth : 171,
				showControls : 1
			});
		},

	});
</script>

</head>

<body id="subpage">

	<div id="templatemo_wrapper">
		<%@include file="/WEB-INF/views/header.jsp"%>

		<div id="templatemo_menu" class="ddsmoothmenu">
			<ul>
				<li><a href="<c:url value="/private/user/main" />"
					class="selected">Продукты</a></li>
				<li><a href="<c:url value="/logout" />">Выход</a></li>
			</ul>
			<br style="clear: left" />
		</div>
		<!-- end of templatemo_menu -->

		<div class="cleaner h20"></div>
		<div id="templatemo_main_top"></div>
		<div id="templatemo_main">
			<div id="sidebar">
				<h2>Личный кабинет</h2>
				<h3>Здравствуйте, ${login}</h3>
				<p>На этой странице Вы можете просматривать и удалять
					продукты.</p>
			</div>
			<!-- END of sidebar -->
			<div id="content">
				<a href="<c:url value="/private/user/main/add-product"/>">Добавить
					новый продукт</a> <br />
				<br />
				<table>
					<caption>Продукты</caption>
					<tr>
						<th>Изображение</th>
						<th>ID продукта</th>
						<th>Производитель</th>
						<th>Цена, BYN</th>
						<th>Подробнее</th>
						<th>Удаление</th>
					</tr>
					<c:forEach items="${listProducts}" var="product">
						<tr>
							<td>${product.path}</td>
							<td>${product.idProduct}</td>
							<td>${product.producer.name}</td>
							<td>${product.price}</td>
							<td><a
								href="#">Подробнее</a></td>
							<td><a
								href="<c:url value="/private/user/main/delete-product?id=${product.idProduct}" />">Удалить</a></td>
						</tr>
					</c:forEach>

				</table>
				<div class="cleaner"></div>
			</div>
			<!-- END of content -->
			<div class="cleaner"></div>
		</div>
		<!-- END of main -->

		<%@include file="/WEB-INF/views/footer.jsp"%>

	</div>

</body>
</html>