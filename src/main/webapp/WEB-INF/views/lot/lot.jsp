<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="utf-8">
<title>Работа</title>

<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<!-- Spring Links -->
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/css/main/main.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/login/login.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/results/lot.css"  />"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/results/custom.css"  />"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script
	src="<c:url value="/resources/js/results/jquery.metisMenu.js" />"></script>
<script src="<c:url value="/resources/js/script.js" />"></script>

<!-- Custom plugin -->
<link href="<c:url value="/resources/css/results/custom.css"  />"
	rel="stylesheet" />
<script src="<c:url value="/resources/js/results/custom.js" />"></script>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">



<!-- Bootstrap Core CSS -->


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

	<div class="container-fluid" style='background-color: #3abeb1'>

		<div class="row row-offcanvas row-offcanvas-left"
			style="background-color: #3abeb1;">

			
			<!--/span-->

			<div class="col-sm-12 col-md-12 main">
				

				<div class="inbox-mail">

					<!-- tab content -->
					<div class="col-md-12"
						style="margin-top: 20px; margin-bottom: 20px; color: white"
						ng-controller="LotController as lotCtrl" ng-cloak>
						<div class="row panel item">
							<div class="col-md-4 bg_blur " style="background-image: url(./resources/images/avatar_lot/{{lotCtrl.lot.indexImage}}.jpg);"></div>
							<div class="col-md-8"
								style="padding-left: 0px; padding-right: 0px">
								<div id="1" class="col-md-4 col-xs-4 well height-block-lot">
									<div class="fa fa-weixin fa-lg" id="countBet">{{lotCtrl.lot.bets.length}}</div>
								</div>
								<div id="2" class="col-md-4 col-xs-4 well height-block-lot">
									<i class="fa fa fa-money fa-lg"></i> {{lotCtrl.lot.budget}}
								</div>
								<div id="3" class="col-md-4 col-xs-4 well height-block-lot"
									style="padding-bottom: 0px; padding-top: 6px;">
									<div id="countdown">
													   													    
													    <ul class="countdown font-size-time">													    
														<li><span class="days">00</span>
														<a  style="color:white" class="seperator">:</a>
														<p class="days_ref timeRefDays">дней</p></li>
														
														<li><span class="hours">00</span>
														<a style="color:white" class="seperator">:</a>
														<p class="hours_ref timeRefHours">часов</p></li>
														
														<li><span class="minutes">00</span>
														<a style="color:white" class="seperator">:</a>
														<p class="minutes_ref timeRefMinutes">минут</p></li>														
														<li><span class="seconds">00</span>
														<p class="seconds_ref timeRefSeconds">секунд</p></li>
														</ul>
                                     </div>
								</div>

								<div class="header">
									<h1>{{lotCtrl.lot.name}}</h1>
									<h4>
										<a style="color: #3abeb1"
											ng-href="/jobster.by/viewUserProfile?id={{lotCtrl.lot.user.idUser}}">{{lotCtrl.lot.user.nickname}}</a>
									</h4>
								    	<div class="lot-description">
									<span>{{lotCtrl.lot.description}}</span>
								</div>
									<div id="showPhoneOwner">

										<a href class="text-style-on-lot" ng-if="lotCtrl.isMeCall" id="ownerNumbera"
											ng-click="lotCtrl.showNumberICall(lotCtrl.idUser)">Посмотреть номер</a>
										<div id="ownerNumber"></div>

										<security:authorize
											access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">

											<div id="inputs" class="col-md-12" style="padding-left: 0px;"
												ng-if="lotCtrl.isShowSendButton">
												<div class="col-md-4" style="padding-left: 0px;">
												<div class="input-group">												
													<span class="input-group-btn"> <input id="myBtn1"
														type="button" class="btn btn-danger btn-number" value="-"
														data-type="minus" data-field="quant[2]">
													</span> 
													<input type="text" style="text-align: center;" disabled
														id="cost" name="quant[2]"
														class="form-control input-number" value="{{lotCtrl.lot.budget}}" min="1"
														max="1000000"> 
														<span style="" id="anchor"
														class="input-group-btn"> 
														<input id="displus"
														type="button" class="btn btn-success btn-number" value="+"
														data-type="plus" data-field="quant[2]">
													</span>
													
												</div>
												</div>
												<div class="col-md-5 btn-mobile"  style="padding-left: 0px;">
												<a id="btn"
													class="button-on-add-lot btn btn-primary button-legal-style send-button"
													onclick="someFunc(); defineText(); $('#btn').click(function() {$(this).hide(10);}); setTimeout(function(){$('#btn').show()},600000);">Предложить</a>
		                                        </div>
											</div>
											

										</security:authorize>
										<security:authorize access="hasRole('ROLE_GUEST')">
											<a class="btn btn-default login-button-mini-style" style="color: #3abeb1" href='<c:url value="/login" />'>Войти</a>
										</security:authorize>
									</div>
								</div>
								<div id="YMapsID" style="width: 100%; height: 350px; padding-top:100px;"></div>
							</div>
						</div>

						<br> <br>



						<div id="output">

							<div style="margin-bottom: 30px">
								<div class="row">
									<h2 style="text-align: center">Отклики</h2>
									<div id="callNumber"></div>
								</div>
								<div class="qa-message-list" id="wallmessages"
									ng-controller="BetController as betCtrl" ng-cloak>

									<div class="message-item" id="m16"
										ng-repeat="bet in betCtrl.bets | orderBy:'-date'">
										<div class="message-inner">
											<div class="message-head clearfix">
												<div class="avatar pull-left">
													<a ng-href="/jobster.by/viewUserProfile?id={{bet.idUser}}"><img
														style="min-height: 40px; max-height: 40px;"
														src='/jobster.by/resources/images/avatar_2x.png' /></a>
												</div>
												<div class="user-detail">
													<h5 class="handle">
													<a ng-href="/jobster.by/viewUserProfile?id={{bet.idUser}}">{{bet.user.nickname}}</a></h5>
													
													<a href ng-if="betCtrl.isICall" id="{{$index}}a"
														ng-click="betCtrl.showNumberICall(bet.idUser, $index)">Посмотреть номер</a>
													<div style="color: black;" id="{{$index}}"></div>

													<div class="post-meta">
														<div class="asker-meta">
															<span class="qa-message-what"></span> <span
																class="qa-message-when"> <span
																class="qa-message-when-data">{{bet.date |
																	date:'yyyy-MM-dd HH:mm:ss'}}</span>
															</span>
														</div>
													</div>
												</div>
											</div>
											<div class="qa-message-content" style="color: black">{{bet.cost}}</div>
										</div>
									</div>



								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!--/row-->
	</div>
	<!--/.container-->
	
<div id='popup' class="cd-popup" role="alert">
	<div class="cd-popup-container">
		<p>К сожалению, время принятия предложений вышло</p>
		
		<a href="#0" class="cd-popup-close img-replace">Close</a>
	</div> <!-- cd-popup-container -->
</div>
	<!-- Menu Toggle Script -->
	<script type="text/javascript"
		src="<c:url value="/resources/js/socket/message.js" />"></script>
		<script type="text/javascript"
		src="<c:url value="/resources/js/constant.js" />"></script>
		<script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
	<script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

var nickname = "${nickname}";
var idUser = ${idUser};
var id;
var isICall = ${isICall};
var isMeCall = ${isMeCall};
var isElse = ${isElse};
var currentDate = ${currentDate};
var websocket;
var showcounter = '';
var latitude;
var longitude;
var idPicture = ${idPicture};

var jsonData = '${lotJson}';

		app.controller('LotController', ['$scope', '$http', lotController]);
		
		app.controller('BetController', ['$scope', '$http', betController]);


		function lotController ($scope) {
			var vm = this;
			var data = JSON.parse(jsonData);
			vm.lot = data;
			vm.lot.indexImage = idPicture;
			
			// Start WebSockets
			id = vm.lot.idLot;
			latitude = vm.lot.latitude;
			longitude = vm.lot.longitude;
			var wsUri = "ws://" + document.location.host + "/jobster.by/messagesocket/"+id;
			websocket = new WebSocket(wsUri);
			websocket.onerror = function(evt) {
				onError(evt) 
			};
			websocket.onopen = function() {
			};
			websocket.onmessage = function(evt) { onMessage(evt) };
			// End WebSockets
			
			vm.isMeCall = isMeCall;
			vm.idUser = idUser;
			vm.isShowSendButton = !(vm.idUser == vm.lot.idUser);
			vm.showNumberICall = function(idUser) {
					$.ajax({
						url:"lot/showNumber/owner",
						type:"GET",
						data:{
							//передаем параметры
							idLot: vm.lot.idLot
						},
						success:function(number) {
							var contentNumber = document.getElementById('ownerNumber').innerHTML + 'Связаться можно по телефонам:<br>';
							for(var i=0; i<number.length; i++) {
								if(number[i] != "") {
									contentNumber = contentNumber + '<a href="tel:'+ number[i] + '">' + number[i] + '</a><br>';
								}
							}
							document.getElementById('ownerNumber').innerHTML = contentNumber;
							document.getElementById('ownerNumbera').remove();
						}
					});
			}
		}
		
		// Start WebSockets
		function onError(evt) {
    		writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
		}
		function sendText(json) {
    		websocket.send(json);
		}      
		function onMessage(evt) {
    		printText(evt.data, isICall);
		}
		// End WebSockets
		
		function betController ($scope) {
			var vm = this;
			var data = JSON.parse(jsonData);
			vm.currentDate = ${currentDate};
			vm.bets = data.bets;
			vm.betsByUser = [];
			angular.forEach(vm.bets, function(bet) {
				if(bet.idUser == idUser) {
					vm.betsByUser.push(bet);
				}
			});
			vm.betsByUser.sort(function(a, b){return b.date-a.date});
			if(vm.betsByUser == '') {
			} else if(vm.currentDate - vm.betsByUser[0].date >= timeBlockSendButton) {
				showcounter = vm.currentDate - vm.betsByUser[0].date; 			
			} else {
				showcounter = vm.currentDate - vm.betsByUser[0].date;
				document.documentElement.className = "js";
							 		
			}
					
			vm.isICall = isICall;
			vm.showNumberICall = function(idUser, index) {
					$.ajax({
						url:"lot/showNumber/client",
						type:"GET",
						data:{
							//передаем параметры
							id: idUser,
							idLot: id
						},
						success:function(number) {
							var contentNumber = document.getElementById(index).innerHTML + 'Связаться можно по телефонам:<br>';
							console.log(number)
							for(var i=0; i<number.length; i++) {
								if(number[i] != "") {
									contentNumber = contentNumber + '<a href="tel:'+ number[i] + '">' + number[i] + '</a><br>';
								}
							}
							document.getElementById(index).innerHTML = contentNumber;  
							document.getElementById(index+'a').remove();
						}
					});
			}
		}
		
		// map
		
		var myMap;
		var myPlacemark;
		
		ymaps.ready(init);
	    function init() {
	        myMap = new ymaps.Map("YMapsID", {
	            center: [latitude, longitude],
	            zoom: 13
	        });
	        myPlacemark = new ymaps.Placemark(myMap.getCenter(), { hintContent: 'Работа!', balloonContent: 'Работа здесь!'});
	        myMap.geoObjects.add(myPlacemark);
	    }
	     
		// end map
		
		
		$( document ).ready(function() {
		    $('.btn-number').click(function(e){
		        e.preventDefault();
		        var fieldName = $(this).attr('data-field');
		        var type      = $(this).attr('data-type');
		        var input = $("input[name='"+fieldName+"']");
		        var currentVal = parseInt(input.val());
		        if (!isNaN(currentVal)) {
		            if(type == 'minus') {
		            	
		                var minValue = parseInt(input.attr('min')); 
		                if(!minValue) minValue = 0;
		                if(currentVal >= minValue) {
		                	if(currentVal>=0){
			                    input.val(currentVal - 100).change();
			                }	if(currentVal>1000){
			                    input.val(currentVal - 1000).change();
			                }	if(currentVal>100000){
			                    input.val(currentVal - 10000).change();
			                }	if(currentVal>1000000){
			                    input.val(currentVal - 100000).change();
			                }	if(currentVal>1000000){
			                    input.val(currentVal - 500000).change();
			                }	
		                } 
		                if(parseInt(input.val()) == minValue) {
		                    $(this).attr('disabled', true);
		                }
		    
		            } else if(type == 'plus') {
		                var maxValue = parseInt(input.attr('max'));
		                if(!maxValue) maxValue = 9999999999999;
		                if(currentVal <= maxValue) {
		                	if(currentVal>=0){
		                    input.val(currentVal + 100).change();
		                }	if(currentVal>1000){
		                    input.val(currentVal + 1000).change();
		                }	if(currentVal>100000){
		                    input.val(currentVal + 10000).change();
		                }	if(currentVal>1000000){
		                    input.val(currentVal + 100000).change();
		                }	if(currentVal>1000000){
		                    input.val(currentVal + 500000).change();
		                }	
		                }
		                if(parseInt(input.val()) == maxValue) {
		                    $(this).attr('disabled', true);
		                }
		    
		            }
		        } else {
		            input.val(0);
		        }
		    });
		    $('.input-number').focusin(function(){
		       $(this).data('oldValue', $(this).val());
		    });
		    $('.input-number').change(function() {
		        
		        var minValue =  parseInt($(this).attr('min'));
		        var maxValue =  parseInt($(this).attr('max'));
		        if(!minValue) minValue = 1;
		        if(!maxValue) maxValue = 9999999999999;
		        var valueCurrent = parseInt($(this).val());
		        
		        var name = $(this).attr('name');
		        if(valueCurrent >= minValue) {
		            $(".btn-number[data-type='minus'][data-field='"+name+"']").removeAttr('disabled')
		        } else {
		            
		            $(this).val($(this).data('oldValue'));
		        }
		        if(valueCurrent <= maxValue) {
		            $(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
		        } else {
		            
		            $(this).val($(this).data('oldValue'));
		        }
		        
		        
		    });
		    $(".input-number").keydown(function (e) {
		            // Allow: backspace, delete, tab, escape, enter and .
		            if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
		                 // Allow: Ctrl+A
		                (e.keyCode == 65 && e.ctrlKey === true) || 
		                 // Allow: home, end, left, right
		                (e.keyCode >= 35 && e.keyCode <= 39)) {
		                     // let it happen, don't do anything
		                     return;
		            }
		            // Ensure that it is a number and stop the keypress
		            if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
		                e.preventDefault();
		            }
		    });
		});
		
$(document).ready(function() {
	$("a.scroll").click(function () { 
     elementClick = $(this).attr("href");
     destination = $(elementClick).offset().top;
     if($.browser.safari){
       $('body').animate( { scrollTop: destination }, 1100 );
     }else{
       $('html').animate( { scrollTop: destination }, 1100 );
     }
     return false;
   });
 });

var timing = ${dateEndLot};
var time = new Date(timing).getTime();
var date = new Date(time);
var now = new Date();

if (now>=date){
	$('#inputs').remove();
	}
if(now>=date){
	$('.cd-popup').addClass('is-visible');
}	
jQuery(document).ready(function($){
	//open popup
	$('.cd-popup-trigger').on('click', function(event){
		event.preventDefault();
		$('.cd-popup').addClass('is-visible');
	});
	
	//close popup
	$('.cd-popup').on('click', function(event){
		if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') ) {
			event.preventDefault();
			$(this).removeClass('is-visible');
		}
	});
	//close popup when clicking the esc keyboard button
	$(document).keyup(function(event){
    	if(event.which=='27'){
    		$('.cd-popup').removeClass('is-visible');
	    }
    });
});
if (now==date){}
$('.countdown').downCount({
    date: date,
    offset: +10
}, function () {
	
		
});
		

function drawButtonPhoneOwner() {
	if(!isMeCall && !isElse) {
		var scope = angular.element(document.getElementById("showPhoneOwner")).scope();
		scope.$apply(function () {
			scope.lotCtrl.isMeCall = true;
		});
	    isMeCall = true;
	}
}
</script>
<script>
if ( $(window).width() < 700) {  
	
	$( "#1" ).removeClass( "col-md-4 col-xs-4" ).addClass( "col-md-12 col-xs-12" );
	$( "#2" ).removeClass( "col-md-4 col-xs-4" ).addClass( "col-md-12 col-xs-12" );
	$( "#3" ).removeClass( "col-md-4 col-xs-4" ).addClass( "col-md-12 col-xs-12" );
	} 
</script>
<script>
$('#btn').click(function() {
    $(this).hide(3000);
});

</script>
<script>
(function (e) {
    e.fn.countdown = function (t, n) {
        function i() {
            eventDate = Date.parse(r.date) / 1e3;
            currentDate = Math.floor(e.now() / 1e3);
            if (eventDate <= currentDate) {
                n.call(this);
                clearInterval(interval)
            }
            seconds = eventDate - currentDate-1;
            days = Math.floor(seconds / 86400);
            seconds -= days * 60 * 60 * 24;
            hours = Math.floor(seconds / 3600);
            seconds -= hours * 60 * 60;
            minutes = Math.floor(seconds / 60);
            seconds -= minutes * 60;
            days == 1 ? thisEl.find(".timeRefDays").text("День") : thisEl.find(".timeRefDays").text("Дней");
            hours == 1 ? thisEl.find(".timeRefHours").text("Час") : thisEl.find(".timeRefHours").text("Часа");
            minutes == 1 ? thisEl.find(".timeRefMinutes").text("Минута") : thisEl.find(".timeRefMinutes").text("Минут");
            seconds == 1 ? thisEl.find(".timeRefSeconds").text("Секунда") : thisEl.find(".timeRefSeconds").text("Секунд");
            if (r["format"] == "on") {
                days = String(days).length >= 2 ? days : "0" + days;
                hours = String(hours).length >= 2 ? hours : "0" + hours;
                minutes = String(minutes).length >= 2 ? minutes : "0" + minutes;
                seconds = String(seconds).length >= 2 ? seconds : "0" + seconds
            }
            if (!isNaN(eventDate)) {
                thisEl.find(".days").text(days);
                thisEl.find(".hours").text(hours);
                thisEl.find(".minutes").text(minutes);
                thisEl.find(".seconds").text(seconds)
            } else {
                alert("Invalid date. Example: 30 Tuesday 2013 15:50:00");
                clearInterval(interval)
            }
        }
        var thisEl = e(this);
        var r = {
            date: null,
            format: null
        };
        t && e.extend(r, t);
        i();
        interval = setInterval(i, 1e3)    }
})(jQuery);


$(document).ready(function () {
    function e() {
        var e = new Date;
        e.setDate(e.getDate() + 60);
        dd = e.getDate();
        mm = e.getMonth() + 1;
        y = e.getFullYear();
        futureFormattedDate = mm + "/" + dd + "/" + y;
        return futureFormattedDate
    }
    datetime=${dateEndLot};
    solved = new Date(datetime);
    $("#countdown").countdown({
        date: solved, // Change this to your desired date to countdown to
        format: "off"
    });
});
function addButton(){
$('html').removeClass("js");
}
setTimeout(addButton, timeBlockSendButton - showcounter);

</script>
	<div class="clearfix"></div>
	<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>

