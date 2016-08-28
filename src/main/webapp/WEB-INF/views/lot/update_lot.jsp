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
<title>Изменить работу Jobster.by -  лучшая разовая работа </title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/results/add_lot.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/legal.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/font-awesome.min.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/jquery-ui.min.css"  />" rel="stylesheet" />
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
	 <link href="<c:url value="/resources/css/validation.css"  />"
	rel="stylesheet" />

</head>
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<body class="body-color backgroundImageStyle nonpersonal">
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
	
	<div class="container container-style-addlot">
	<div class="col-md-1"></div>
	<div class="col-md-10 background-color-add_lot margin-bottom-button edit-users-legal-boards" style="padding-top: 1em;">
	<div class="col-md-12">
	<div class="col-md-6" style="padding-left: 0px; padding-top: 1em;">
	<i class="fa fa-angle-left" style="font-size: 25px;" aria-hidden="true"></i> <a href='<c:url value="/result"/>' style="font-size:18px; color: black;">Вернуться в личный кабинет</a>
	</div>
	<div class="text-style-add-lot col-md-6">Изменить работу</div>
	</div>
	
	<div class="col-md-6">
			<div class="font-style-message">
		<c:if test="${message != null}">
			${message}
			   </c:if>
		</div>
	<form:form modelAttribute="updateLotForm" method="POST" onsubmit="endDate.value = Date.value+' '+timeInputId.value+':00:00'">
	<form:input path="idLot" class="form-control visibility-field"/>
		
		<div hidden class="form-group">
		<form:input type="text" class="form-control" id="latitude" name="latitude" path="latitude"/> 
			<label class="error" generated="true" for="latitude"></label>
			<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="latitude" /></span>
		</div>
		<div hidden class="form-group">
		<form:input type="text" class="form-control" id="longitude" name="longitude" path="longitude"/> 
			<label class="error" generated="true" for="longitude"></label>
			<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="longitude" /></span>
		</div>
		<div class="form-group heightStyleValidation">
		<form:input path="name" placeholder="Название" class="form-control"/>
		<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="name" /></span>
		<label class="error textStyleValidation" generated="true" for="name"></label>
		</div>
		<div class="form-group" style="height: 5.5em;">
		<form:textarea style="resize: none;" path="description" placeholder="Описание" class="form-control"/>
		<label class="error textStyleValidation" generated="true" for="description"></label>
		<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="description" /></span>
		</div>
		<div class="form-group heightStyleValidation">
		<form:input path="budget" placeholder="Бюджет" class="form-control"/>
		<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="budget" /></span>
		<label class="error textStyleValidation" generated="true" for="budget"></label>
		</div>
		<div class="form-group">
		 <form:select class="form-control" path="idCity" onchange="cityOnMap(this.selectedIndex)">
		 <c:forEach items="${listCities}" var="city">
							<form:option value="${city.idCity}">${city.title}</form:option>
								</c:forEach>
						</form:select>
						</div>
							<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="idCity" /></span>
		<div class="form-group heightStyleValidation">
				<form:select class="form-control" id="idCategory" path="idCategory">
				</form:select>
				
					<label class="error textStyleValidation" generated="true" for="idCategory"></label>
					<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="idCategory" /></span>
					</div>
					<div class="form-group heightStyleValidation">
				<form:select class="form-control" id="idSubcategory" path="idSubcategory">
					<form:option value="0">Подкатегория</form:option>
				</form:select>
				    <label class="error textStyleValidation" generated="true" for="idSubcategory"></label>
					<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="idSubcategory" /></span>
					</div>
		<div class="form-group heightStyleValidation">
					<input onkeydown="return false" type="text" class="form-control" name="Date" id="Date" placeholder="Дата конца" value="${dateEndLot}">
					<label class="error textStyleValidation" generated="true" for="Date"></label>
					</div>
					
			<div class="form-group" style="height: 4em;">
					
					   <input type="range" name="timeInputName" id="timeInputId" value="${hourEndLot}" min="0" step="1" max="24" oninput="timeOutputId.value = timeInputId.value">
    <output style="text-align:center" name="timeOutputName" id="timeOutputId">${hourEndLot}</output>
					<label class="error textStyleValidation" generated="true" for="timeInputId"></label>
					</div>
					<div hidden class="form-group heightStyleValidation">
		<form:input type="text" class="form-control" id="endDate" name="calendar" path="endDate" placeholder="endDate"/> 
			<label class="error textStyleValidation" generated="true" for="endDate"></label>
			<span class="error"><form:errors class="textStyleValidation textStyleServerValidation" path="endDate" /></span>
			</div>
			<p style="text-align:center; color:black;">Кому звоним?</p>
    <div class="switch-field">
      
      <form:radiobutton id="switch_right" name="switch_2" value="false" path="isCall" />
      <label id="switch_right1" for="switch_right">Мне</label>
      <form:radiobutton id="switch_left" name="switch_2" value="true" path="isCall"/>
      <label id="switch_left1" for="switch_left">Я сам!</label>
    </div>
   
    
			<div class="form-group" style="text-align:center;">
		<button type="button" data-toggle="modal" data-target="#edit" class="button-add-lot-style btn btn-primary" onclick="setCoordinates()">Изменить</button>
		
		<div class="modal fade" id="edit" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Подтверждение изменения</h4>
        </div>
        <div class="modal-body">
          <p>После нажатия подтверждения лот отправится на модерацию снова.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
          <button type="submit" class="btn btn-success" >Изменить</button>
        </div>
      </div>
      
    </div>
  </div>
		
		</div>
	</form:form>
	</div>
	<div class="col-md-6">
	
	 <div id="YMapsID" style="width: 100%; height: 350px;position:relative">
		 <div class="form-inline">
		 <div class="form-group">
		 
		 <form action="#">
			 <div style='position:absolute; z-index:10; padding:10px; background-color: rgba(255,255,255,0);'>
				<input class="form-control" id="textSearch" type="text" placeholder="Введите адрес">
				<input class="btn btn-default" type="button" value="Поиск" onclick="addressFind( $('#textSearch').val() )">
				<input class="btn btn-default" type="button" value="Очистить" onclick="$('#textSearch').val(''); $('#list').empty();">
				<div id='list' style='background-color: rgba(255,255,255,0.7);'></div>
			</div>
		</form>
		</div>
		</div>
	 </div>
	 <span>Перемещая маркер <img style="width:20px; height:20px" src="<c:url value="/resources/images/location_marker.png"  />" > на карте, Вы можете указать точное место, где нужна помощь</span>
	 </div>
	</div>
    <div class="col-md-1"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<!-- scripts -->
    <script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="<c:url value="/resources/js/jquery.ui.datepicker-ru.js" />"> </script> 
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
    <script src="<c:url value="/resources/js/validate/validation.js" />"> </script>     
<script type="text/javascript">
	var cities = '${listCitiesJson}';
		cities = JSON.parse(cities);
	var latitude = ${lot.latitude};
	var longitude = ${lot.longitude};
	var zoom;
	ymaps.ready(init);
	var myMap;
	var myPlacemark;
	
	function cityOnMap(index) {
		latitude = cities[index].latitude;
		longitude = cities[index].longitude;
		zoom = cities[index].scale;
		myMap.setCenter([ latitude, longitude ], zoom, {
			checkZoomRange : true
		});
		myPlacemark.geometry.setCoordinates([ latitude, longitude ]);

	}

	function addressOnMap(latitude, longitude) {
		$('#textSearch').val('');
		$('#list').empty();
		myMap.setCenter([ latitude, longitude ], 15, {
			checkZoomRange : true
		});
		myPlacemark.geometry.setCoordinates([ latitude, longitude ]);

	}

	function addressFind(text) {
		$('#list').empty();
		var myGeocoder = ymaps.geocode(text, {
			boundedBy : [ [ 51.212001111979866, 22.313501562499554 ],
					[ 56.439072125307426, 32.833501562499585 ] ],
			strictBounds : true,
			results : 10
		});
		myGeocoder
				.then(
						function(res) {
							res.geoObjects
									.each(function(geoObject) {
										$('#list')
												.append(
														'<a  href="#" onclick="addressOnMap('
																+ geoObject.geometry._coordinates[0]
																+ ','
																+ geoObject.geometry._coordinates[1]
																+ ')"><div style="margin:0px; font-size:12px;opacity: 0.7;" class="well well-sm">'
																+ geoObject.properties._data.name
																+ '<br>'
																+ geoObject.properties._data.text
																+ '</div></a>');
									});
						}, function(err) {
							console.log('Ошибка');
						});
	}

	function init() {
		myMap = new ymaps.Map("YMapsID", {
			center : [ latitude, longitude ],
			controls : [ 'fullscreenControl', 'zoomControl', 'rulerControl' ],
			// Область поиска - Беларусь, маркер - центр Минска
			bounds : [ [ 51.212001111979866, 22.313501562499554 ],
					[ 56.439072125307426, 32.833501562499585 ] ]
		});
		// Создание макета содержимого хинта.
		// Макет создается через фабрику макетов с помощью текстового шаблона.
		HintLayout = ymaps.templateLayoutFactory
				.createClass(
						"<div class='my-hint'>"
								+ "<b>{{ properties.message }}</b><br /></div>",
						{
							// Определяем метод getShape, который
							// будет возвращать размеры макета хинта.
							// Это необходимо для того, чтобы хинт автоматически
							// сдвигал позицию при выходе за пределы карты.
							getShape : function() {
								var el = this.getElement(), result = null;
								if (el) {
									var firstChild = el.firstChild;
									result = new ymaps.shape.Rectangle(
											new ymaps.geometry.pixel.Rectangle(
													[
															[ 0, 0 ],
															[
																	firstChild.offsetWidth,
																	firstChild.offsetHeight ] ]));
								}
								return result;
							}
						});

		myPlacemark = new ymaps.Placemark(myMap.getCenter(), {
			message : "Здесь нужна помощь!"
		}, {
			hintLayout : HintLayout,
			draggable : true,
			// Опции.
			// Необходимо указать данный тип макета.
			iconLayout : 'default#image',
			// Своё изображение иконки метки.
			iconImageHref : '/jobster.by/resources/images/location_marker.png'
		});
		myPlacemark.geometry._coordinates[0] = latitude;
		myPlacemark.geometry._coordinates[1] = longitude;
		console.log(myPlacemark.geometry._coordinates)
		myMap.geoObjects.add(myPlacemark);
	}

	function setCoordinates() {
		var coordinates = myPlacemark.geometry.getCoordinates();
		document.getElementById("latitude").value = coordinates[0];
		document.getElementById("longitude").value = coordinates[1];
	}
</script>
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
																var html = '<option value="0">Подкатегория</option>';
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
					var html = '<option value="0">Категория</option>';
					var len = data.length;
					var idCategory = ${updateLotForm.idCategory};
					var fff;
					for (var i = 0; i < len; i++) {
						html += '<option ';
						if(data[i].idCategory == idCategory) {
							html += 'selected="true" ';
							fff = data[i].idCategory;
						}
						html += 'value="' + data[i].idCategory + '">'
								+ data[i].title + '</option>';
					}
					html += '</option>';
					$('#idCategory').html(html);
					$.getJSON('${getSubcategories}',
							{
						idCategory : fff,
						ajax : 'true'
							},
							function(data) {
							var html = '<option value="0">Подкатегория</option>';
							var len = data.length;
							var idSubcategory = ${updateLotForm.idSubcategory};
							for (var i = 0; i < len; i++) {
							html += '<option ';
							if(data[i].idSubcategory == idSubcategory) {
								html += 'selected="true" ';
							}
							html += 'value="' + data[i].idSubcategory + '">'
							+ data[i].title
							+ '</option>';
							}
						html += '</option>';
						$('#idSubcategory').html(html);
						});
				});
			});
	  $(function() {

		    $( "#Date" ).datepicker({dateFormat:'yy-mm-dd', maxDate: "+180",changeMonth: true,
				changeYear: true, minDate:"+1",
				yearRange: "-0:+10"});
		    $(document).ready(function(){
			    $( "#datepicker" ).datepicker( $.datepicker.regional[ "ru" ] );
			});

		  });
</script>
<script>
$('textarea').bind('keypress', function(e) {
	  if ((e.keyCode || e.which) == 13) {
	    $(this).parents('form').submit();
	    return false;
	  }
	});</script>
</body>
</html>
