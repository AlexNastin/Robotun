<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<security:authorize access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL')" var="userBool" />
<security:authorize access="hasRole('ROLE_MODERATOR')"
	var="moderatorBool" />
<security:authorize access="hasRole('ROLE_ADMIN')" var="adminBool" />
<c:if test="${userBool}">
	<c:set value="/user/profile" var="profileURL" />
</c:if>
<c:if test="${moderatorBool}">
	<c:set value="/moderator/profile" var="profileURL" />
</c:if>
<c:if test="${adminBool}">
	<c:set value="/admin/profile" var="profileURL" />
</c:if>
	
<html>
<head>
<title>Работа</title>
</head>
<c:url value="/get/subcategories" var="getSubcategories" />
<c:url value="/get/categories" var="getCategories" />
<!-- Spring Links -->
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />   
    <link href="<c:url value="/resources/css/results/lot.css"  />" rel="stylesheet" />
     <link href="<c:url value="/resources/css/results/results.css"  />" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
	<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<script	src="<c:url value="/resources/js/results/jquery.metisMenu.js" />"></script>
	
	<!-- Custom plugin -->
	<link href="<c:url value="/resources/css/results/custom.css"  />" rel="stylesheet" />
	<script	src="<c:url value="/resources/js/results/custom.js" />"></script>       
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>
	 <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="content-main">


<div class="container" style="margin-top: 20px; margin-bottom: 20px;">
	<div class="row panel item">
		<div class="col-md-4 bg_blur ">
    	    <a href="#anchor" class="follow_btn hidden-xs scroll">Помочь!</a>
		</div>
        <div class="col-md-8  col-xs-12">
           
           <div class="header">
                <h1>${lot.name}</h1>
                <h4>${lot.user.nickname}</h4>
                <span>${lot.description}</span>
                <div id="showPhoneOwner">
                <c:if test="${isMeCall}">
                <a href="#" onclick="showNumberICall(${idUser})" id="${idUser}a">Посмотреть номер</a>
				<div id="${idUser}"></div>
				</c:if>
				</div>
           </div>
        </div>
    </div>   
    
	<div class="row nav item">    

        <div class="col-md-12 col-xs-12" style="margin: 0px;padding: 0px; color:white">
            <div class="col-md-4 col-xs-4 well" style="height: 69px;"><div class="fa fa-weixin fa-lg" id="countBet">${countBet}</div></div>
            <div class="col-md-4 col-xs-4 well"><i class="fa fa fa-money fa-lg"></i> ${lot.budget}</div>
            <div class="col-md-4 col-xs-4 well" style="padding-bottom: 0px; padding-top: 6px;"><ul class="countdown">
<li> <span class="days">00</span>
<p class="days_ref">дней</p>
</li>
<li class="seperator">.</li>
<li> <span class="hours">00</span>
<p class="hours_ref">часов</p>
</li>
<li class="seperator">:</li>
<li> <span class="minutes">00</span>
<p class="minutes_ref">минут</p>
</li>
<li class="seperator">:</li>
<li> <span class="seconds">00</span>
<p class="seconds_ref">секунд</p>
</li>
</ul>
</div>
        </div>
    </div>
</div>
	 <br>
	 <br>
	

	
	<div id="output">

<div class="container" style="margin-bottom:30px">
	<div class="row">
		<h2 style="text-align:center">Ставки</h2>
		<div id="callNumber"></div>
	</div>
    <div class="qa-message-list" id="wallmessages">
    <c:forEach items="${lot.bets}" var="bet">
    				<div class="message-item" id="m16">
						<div class="message-inner">
							<div class="message-head clearfix">
								<div class="avatar pull-left"><a href="<c:url value="/viewUserProfile?id=${bet.user.idUser}"/>"><img style="min-height: 40px; max-height: 40px;" src='<c:url value="/resources/images/avatar_2x.png" />'></a></div>
								<div class="user-detail">
									<h5 class="handle">${bet.user.nickname}</h5>
									<c:if test="${isICall}">
									<a href="#" onclick="showNumberICall(${bet.user.idUser})" id="${bet.user.idUser}a">Посмотреть номер</a>
									<div id="${bet.user.idUser}"></div>
									</c:if>
									<div class="post-meta">
										<div class="asker-meta">
											<span class="qa-message-what"></span>
											<span class="qa-message-when">
												<span class="qa-message-when-data">${bet.date}</span>
											</span>
											<span class="qa-message-who">
												<span class="qa-message-who-pad">by </span>
												<span class="qa-message-who-data"><a href="<c:url value="/viewUserProfile?id=${bet.user.idUser}"/>">${bet.user.nickname}</a></span>
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="qa-message-content">
								${bet.cost}
							</div>
					</div></div>
					</c:forEach>
					
					
</div>
<security:authorize
								access="hasAnyRole('ROLE_USER_LEGAL','ROLE_USER_PHYSICAL', 'ROLE_MODERATOR', 'ROLE_ADMIN')">
								<c:if test="${!(idUser == lot.idUser)}">
								<div class="center">
    <div class="input-group">
          <span class="input-group-btn">
              <input id="myBtn1" type="button" class="btn btn-danger btn-number" value="-" data-type="minus" data-field="quant[2]">
                
             
          </span>
          <input type="text"  disabled id="cost" name="quant[2]" class="form-control input-number" value="500000" min="1" max="1000000">
          <span id="anchor" class="input-group-btn">
              <input id="displus"  type="button" class="btn btn-success btn-number" value="+" data-type="plus" data-field="quant[2]">
                          
          </span>
          
      </div>
      <a id="btn" href="#">Send</a>
	</div>
	</c:if>
							</security:authorize>
							<security:authorize access="hasRole('ROLE_GUEST')">
								<a href='<c:url value="/login" />'>Войти</a>
							</security:authorize>
</div>
</div>
</div>
</div>
<script type="text/javascript">
var nickname = "${nickname}";
var id = ${lot.idLot};
var idUser = ${idUser};
var isICall = ${isICall};
var isMeCall = ${isMeCall}
</script>
	<script async type="text/javascript"
		src="<c:url value="/resources/js/socket/websocket_message.js" />"></script>
	<script async type="text/javascript"
		src="<c:url value="/resources/js/socket/message.js" />"></script>
		<script type="text/javascript"
		src="<c:url value="/resources/js/date.format.js" />"></script>
		<script>
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
		                if(!minValue) minValue = 1;
		                if(currentVal > minValue) {
		                    input.val(currentVal - 1).change();
		                } 
		                if(parseInt(input.val()) == minValue) {
		                    $(this).attr('disabled', true);
		                }
		    
		            } else if(type == 'plus') {
		                var maxValue = parseInt(input.attr('max'));
		                if(!maxValue) maxValue = 9999999999999;
		                if(currentVal < maxValue) {
		                    input.val(currentVal + 1).change();
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
		            alert('Sorry, the minimum value was reached');
		            $(this).val($(this).data('oldValue'));
		        }
		        if(valueCurrent <= maxValue) {
		            $(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
		        } else {
		            alert('Sorry, the maximum value was reached');
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
		</script>
		<script type="text/javascript">
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
</script>
<script type="text/javascript">
function showNumberICall(idUser) {
	$.ajax({
		url:"lot/showNumber",
		type:"GET",
		data:{
			//передаем параметры
			id: idUser
		},
		success:function(number) {
			var contentNumber = document.getElementById(idUser).innerHTML;
			for(var i=0; i<number.length; i++) {
				contentNumber = contentNumber + number[i]+ "<br>";
			}
			document.getElementById(idUser).innerHTML = contentNumber;
			document.getElementById(idUser+"a").removeAttribute('onclick');
		}
	});
}
</script>
<!-- date -->
<script>
var timing = ${dateEndLot};
var time = new Date(timing).getTime();
var date = new Date(time);
var now = new Date();

if (now==date){
	 document.getElementById("myBtn1").disabled = true;
	 document.getElementById("displus").disabled = true;
}

$('.countdown').downCount({
    date: date,
    offset: +10
}, function () {
	
		
});
</script>

<script type="text/javascript">
function drawButtonPhoneOwner() {
	if(!isMeCall) {
	    var content = document.getElementById("showPhoneOwner").innerHTML;
	    var contentIsCall = "<a href=\"#\" onclick=\"showNumberICall(" + ${idUser} + ")\" id=\"" + ${idUser} + "a" + "\">Посмотреть номер</a><div id=\"" + ${idUser} + "\"></div>";
	    var contentBeforeIsCall = "";
	    var contentAfterIsCall = "";
	    var contentSum = contentBeforeIsCall;
	    contentSum = contentSum + contentIsCall;
	    contentSum = contentSum + contentAfterIsCall;
	    document.getElementById("showPhoneOwner").innerHTML = contentSum + content;
	    isMeCall = true;
	}
}
</script>

<script class="source" type="text/javascript">
       
    </script> 
		<%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>
