<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="utf-8">
<title>Добавить работу</title>
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
	<div class="col-md-10 background-color-add_lot margin-bottom-button edit-users-legal-boards" style="padding-top: 1em;" >
	<div class="col-md-12">
		<div class="font-style-message">
		<c:if test="${message != null}">
			${message}
			   </c:if>
		</div>
	<div class="col-md-6" style="padding-left: 0px; padding-top: 1em;">
	<i class="fa fa-angle-left" style="font-size: 25px;" aria-hidden="true"></i> <a href='<c:url value="/result"/>' style="font-size:18px; color: black;">Посмотреть все предложения</a>
	</div>
	<div class="text-style-add-lot col-md-6">Добавить работу</div>
	</div>
	
	<div class="col-md-6">
	<form:form modelAttribute="addLotForm" method="POST" oninput="endDate.value = Date.value+' '+timeInputId.value+':00:00'" >
	
		<div hidden class="form-group">
		<form:input type="text" class="form-control" id="latitude" name="latitude" path="latitude"/> 
			<label class="error" generated="true" for="latitude"></label>
			<span class="error"><form:errors path="latitude" /></span>
		</div>
		<div hidden class="form-group">
		<form:input type="text" class="form-control" id="longitude" name="longitude" path="longitude"/> 
			<label class="error" generated="true" for="longitude"></label>
			<span class="error"><form:errors path="longitude" /></span>
		</div>
		<div class="form-group heightStyleValidation">
		<form:input path="name" placeholder="Название" class="form-control"/>
		<form:errors path="name" />
		<label class="error textStyleValidation" generated="true" for="name"></label>
		</div>
		<div class="form-group" style="height: 5.5em;">
		<form:textarea path="description" style="resize: none;" placeholder="Описание" class="form-control" />
		<form:errors path="description" />
		<label class="error textStyleValidation" generated="true" for="description"></label>
		</div>		
		<div class="form-group">
		 <form:select class="form-control" path="idCity" onchange="cityOnMap(this.selectedIndex)">
							<c:forEach items="${listCities}" var="city">
								<form:option value="${city.idCity}">${city.title}</form:option>
							</c:forEach>
						</form:select>
						</div>
		<form:errors path="idCity" />
		<div class="form-group heightStyleValidation">
				<form:select class="form-control" id="idCategory" path="idCategory">
				</form:select>
					<label class="error textStyleValidation" generated="true" for="idCategory"></label>
					<span class="error"><form:errors path="idCategory" /></span>
					</div>
					<div class="form-group heightStyleValidation">
				<form:select class="form-control" id="idSubcategory" path="idSubcategory">
					<form:option value="0">Подкатегория</form:option>
				</form:select>
				    <label class="error textStyleValidation" generated="true" for="idSubcategory"></label>
					<span class="error"><form:errors path="idSubcategory" /></span>
					</div>
					<div class="form-group heightStyleValidation">
					<input onkeydown="return false" type="text" class="form-control" name="Date" id="Date" placeholder="Дата конца">
					<label class="error textStyleValidation" generated="true" for="Date"></label>
					</div>
					<div class="form-group ignore" style="height: 4em;">
					
					   <input type="range" class="" name="timeInputName" id="timeInputId" value="12" min="0" step="1" max="24" oninput="timeOutputId.value = timeInputId.value">
					     <output class="ignore" style="text-align:center" name="timeOutputName" id="timeOutputId">12</output>
					<label class="error textStyleValidation" generated="true" for="timeInputId"></label>
					</div>
		<div hidden class="form-group heightStyleValidation">
		<form:input type="text" class="form-control" id="endDate" name="calendar" path="endDate" placeholder="endDate"/> 
			<label class="error" generated="true" for="endDate"></label>
			<span class="error"><form:errors path="endDate" /></span>
			</div>
			<div class="form-group heightStyleValidation">
		<form:input type="number" min="1" max="2147483647" path="budget" placeholder="Бюджет" class="form-control"/>
		<span class="error"><form:errors path="budget" /></span>
		<label class="error textStyleValidation" generated="true" for="budget"></label>
		</div>
		<div style="padding-bottom: 10px; text-align: center;">
			<div  class="tooltip1">Кому звоним?
  <span class="tooltiptext1">Если мне, то вам позвонят, если сам, то никто не увидит телефон</span>
</div>
			</div>
			
    <div class="switch-field">
      
      <form:radiobutton id="switch_right" name="switch_2" value="false" path="isCall"/>
      <label for="switch_right">Мне</label>
      <form:radiobutton id="switch_left" name="switch_2" value="true" path="isCall"/>
      <label for="switch_left">Я сам!</label>
    </div>
   
    
			<div class="form-group" style="text-align:center;">
		<input type="submit" class="button-add-lot-style btn btn-primary" value="Добавить" onclick="setCoordinates()"/>
		</div>
	</form:form>
	</div>
	<div class="col-md-6">
	 <div id="YMapsID" style="width: 100%; height: 350px;"></div>
	 </div>
	</div>
    <div class="col-md-1"></div>
	</div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
	<!-- scripts -->
	
    <script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
    <script src="<c:url value="/resources/js/jquery.ui.datepicker-ru.js" />"> </script> 
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/validate/jquery.validate.min.js" />"> </script>
    <script src="<c:url value="/resources/js/validate/validation.js" />"> </script>     
<script type="text/javascript">
	var cities = '${listCitiesJson}';
		cities = JSON.parse(cities);
	var latitude = cities[0].latitude;
	var longitude = cities[0].longitude;
	var zoom = cities[0].scale;
	ymaps.ready(init);
	var myMap;
	var myPlacemark;
	
    function cityOnMap(index) {
    	var latitude = cities[index].latitude;
    	var longitude = cities[index].longitude;
		zoom = cities[index].scale;
		myMap.setCenter([latitude, longitude], zoom, {
		    checkZoomRange: true
		});
		myPlacemark.geometry.setCoordinates([latitude, longitude]);
		
    }
    function init() {
        myMap = new ymaps.Map("YMapsID", {
            center: [latitude, longitude],
            zoom: zoom
        });
        
     // Создание макета содержимого хинта.
        // Макет создается через фабрику макетов с помощью текстового шаблона.
            HintLayout = ymaps.templateLayoutFactory.createClass( "<div class='my-hint'>" +
                "<b>{{ properties.object }}</b><br />" +
                "{{ properties.address }}" +
                "</div>", {
                    // Определяем метод getShape, который
                    // будет возвращать размеры макета хинта.
                    // Это необходимо для того, чтобы хинт автоматически
                    // сдвигал позицию при выходе за пределы карты.
                    getShape: function () {
                        var el = this.getElement(),
                            result = null;
                        if (el) {
                            var firstChild = el.firstChild;
                            result = new ymaps.shape.Rectangle(
                                new ymaps.geometry.pixel.Rectangle([
                                    [0, 0],
                                    [firstChild.offsetWidth, firstChild.offsetHeight]
                                ])
                            );
                        }
                        return result;
                    }
                }
            );

        myPlacemark = new ymaps.Placemark(myMap.getCenter(), {
            address: "Москва, ул. Зоологическая, 13, стр. 2",
            object: "Центр современного искусства"
        }, {
            hintLayout: HintLayout,
        
            // Опции.
            // Необходимо указать данный тип макета.
            iconLayout: 'default#image',
            // Своё изображение иконки метки.
            iconImageHref: '/jobster.by/resources/images/location_marker.png'
        });

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
					var idCategory = ${addLotForm.idCategory};
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
							var idSubcategory = ${addLotForm.idSubcategory};
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
				yearRange: "-0:+1"});
		    

		  });
	  $(document).ready(function(){
		    $( "#datepicker" ).datepicker( $.datepicker.regional[ "ru" ] );
		});
	 
	  
</script>

</body>
</html>
