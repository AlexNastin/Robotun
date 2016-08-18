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
<body>
<div class="body-color backgroundImageStyle nonpersonal">
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
		<form:input path="name" placeholder="Название работы" class="form-control"/>
		<form:errors path="name" />
		<label class="error textStyleValidation" generated="true" for="name"></label>
		</div>
		<div class="form-group" style="height: 5.5em;">
		<form:textarea path="description"  style="resize: none;" placeholder="Описание работы" class="form-control" />
		<form:errors path="description" />
		<label class="error textStyleValidation" generated="true" for="description"></label>
		</div>		
		<div class="form-group">
		 <form:select class="form-control" path="idCity" onchange="cityOnMap(this.selectedIndex)">
								<option value="0">Не выбрано</option>
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
					<input onkeydown="return false" type="text" class="form-control" name="Date" id="Date" placeholder="Дата окончания">
					<label class="error textStyleValidation" generated="true" for="Date"></label>
					</div>
					<div class="form-group ignore" style="height: 4em;">
					
					   <input type="range" class="" name="timeInputName" id="timeInputId" value="12" min="0" step="1" max="24" oninput="timeOutputId.value = 'в ' +timeInputId.value +' часов' ">
					     <output class="ignore" style="text-align:center" name="timeOutputName" id="timeOutputId">в 12 часов</output>
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
	var latitude;
	var longitude;
	var zoom;
	ymaps.ready(init);
	var myMap;
	var myPlacemark;
	
    function cityOnMap(index) {
    	if(index == 0) {
    		// Маркер - центр Минска 
    		latitude = 53.907588432690744;
        	longitude = 27.573501562499583;
    		zoom = 6;
    	} else {
    		index--;
    		latitude = cities[index].latitude;
        	longitude = cities[index].longitude;
    		zoom = cities[index].scale;
    	}
		myMap.setCenter([latitude, longitude], zoom, {
		    checkZoomRange: true
		});
		myPlacemark.geometry.setCoordinates([latitude, longitude]);
		
    }
    
    function addressOnMap(latitude, longitude) {
    	$('#textSearch').val('');
    	$('#list').empty();
		myMap.setCenter([latitude, longitude], 15, {
		    checkZoomRange: true
		});
		myPlacemark.geometry.setCoordinates([latitude, longitude]);
		
    }
    
    function addressFind(text) {
    	$('#list').empty();
    	var myGeocoder = ymaps.geocode(text, {
            boundedBy: [[51.212001111979866, 22.313501562499554], [56.439072125307426, 32.833501562499585]],
            strictBounds: true,
            results: 10
          });	
    	myGeocoder.then(
    	    function (res) {
    	    	res.geoObjects.each(function (geoObject) {
    	    	    $('#list').append('<a  href="#" onclick="addressOnMap(' + geoObject.geometry._coordinates[0] +',' + geoObject.geometry._coordinates[1] + ')"><div style="margin:0px; font-size:12px;opacity: 0.7;" class="well well-sm">'+geoObject.properties._data.name+'<br>' + geoObject.properties._data.text + '</div></a>');
    	    	});
    	    },
    	    function (err) {
    	        console.log('Ошибка');
    	    }
    	);
    }
    
    function init() {
        myMap = new ymaps.Map("YMapsID", {
            center: [latitude, longitude],
            zoom: zoom,
            controls: ['fullscreenControl', 'zoomControl', 'rulerControl'],
            // Область поиска - Беларусь, маркер - центр Минска
        	bounds: [[51.212001111979866, 22.313501562499554], [56.439072125307426, 32.833501562499585]]
        });
        
     // Создание макета содержимого хинта.
        // Макет создается через фабрику макетов с помощью текстового шаблона.
            HintLayout = ymaps.templateLayoutFactory.createClass( "<div class='my-hint'>" +
                "<b>{{ properties.message }}</b><br /></div>", {
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
            message: "Здесь нужна помощь!"
        }, {
            hintLayout: HintLayout,
            draggable: true,
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
<script>
$('textarea').bind('keypress', function(e) {
	  if ((e.keyCode || e.which) == 13) {
	    $(this).parents('form').submit();
	    return false;
	  }
	});
</script>
</body>
</html>
