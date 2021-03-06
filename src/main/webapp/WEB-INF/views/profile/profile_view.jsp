<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="app">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta charset="utf-8">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/main/main.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/profile/profile.css" />"	rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
	<link href="<c:url value="/resources/css/profile/fontawesome-stars.css" />"	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Просмотр профиля | Jobster.by - Сервис разовой работы</title>
	<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">
	<meta property="og:type" content="website" />
<meta property="og:title" content=" Jobster.by | Сервис разовой работы" />
<meta property="og:description" content="
Jobster.by  - совершенно новый сервис в Беларуси по поиску разовой работы, где любой желающий может как подработать, так и найти тех, кто готов помочь." />
<meta property="og:url" content="http://jobster.by" />
<meta property="og:image" content="https://pp.vk.me/c630821/v630821072/47bd9/bLXUaRDhR5k.jpg" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch.jsp"%>

<!--This stylesheet should be moved to the head of the document -->
 <div class="container main">
    <div class="row">
        <div class=" col-lg-offset-1 col-lg-10">
            <div class="panel panel-default">
            
                <div class="panel-body" ng-controller="UserController as userCtrl" ng-cloak>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-sm-offset-3 col-sm-6 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
                                    <img class="img-responsive" ng-src="/jobster.by/resources/images/avatar_user/avatar_big/{{userCtrl.user.avatar.path}}.jpg">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="centered-text col-sm-offset-3 col-sm-6 col-md-offset-3 col-md-6 col-lg-offset-3 col-lg-6">
                                    <div itemscope="" itemtype="http://schema.org/Person">
                                        <h2> <span itemprop="name">{{userCtrl.user.nickname}}</span></h2>
                                       
                                        <p>
                                            <i class="fa fa-map-marker"></i> <span itemprop="addressRegion">{{userCtrl.user.city.title}}</span>
                                        </p>
                                       </div>
                                </div>
                            </div>
                        </div>
                       
                    </div>
                    
                    <div class="row" style="text-align:center">
                    
                    <div class="col-md-4 col-md-offset-4">
                    <div style="margin:auto">
                   
                    
<c:if test="${!userGuestBool && idUser != idVisitedUser}">
	<select id="rating">
	  <option value="1">1</option>
	  <option value="2">2</option>
	  <option value="3">3</option>
	  <option selected="selected" value="4">4</option>
	  <option value="5">5</option>
	</select>
	<a id="votes" onclick="hider()" class="btn btn-success btn-sm main-button-style">Оценить!</a>
</c:if>
<p id="thanks" style="display:none; background-color: #33b792; color: white; border-radius: 5px;" >Спасибо! Ваш голос учтён! Вы всегда можете изменить своё решение :)</p>
</div>
<div id="tagscloud">Текущий рейтинг:
<span></span> <i class="fa fa-star" aria-hidden="true" style="color:#edb867"></i>
</div>
</div>

</div>
       
                </div>
                <div class="panel-footer">
                <div>
    <div class="row">
		<div class="well">
        <h1 class="text-center">Работы этого пользователя</h1>
        <div class="list-group" id="list-group" ng-controller="LotsController as lotsCtrl" ng-cloak>
          <a ng-href='/jobster.by/lot?id={{lot.id_lot}}' class="list-group-item" ng-repeat="lot in lotsCtrl.lots">
                <div class="media col-md-3">
                    <figure class="pull-left">
                        <img class="media-object img-rounded img-responsive centered-and-cropped "  ng-src="{{lot.logoImage}}" >
                    </figure>
                </div>
                <div class="col-md-6" style="text-align: center;">
                    <h1 style="font-size: 25px;" class="list-group-item-heading ">{{lot.name}}</h1>
                    <p  class="list-group-item-text result-description ">{{lot.description}}</p>
                </div>
                <div class="col-md-3 text-center">
                     <h2>{{lot.budget}}<small> бел. руб. </small></h2>
                     <button type="button" class="btn btn-default btn-lg btn-block main-button-style"> Помочь! </button>
                    
                </div>
          </a>
          
          
        </div>
        <div style="text-align:center;">
        <a href="#top" class="btn btn-primary load-button"><i class="fa fa-arrow-up" aria-hidden="true"></i> Наверх</a>
										<a class="btn btn-primary load-button"
											onclick='buttonLoader()'><i class="fa fa-repeat" aria-hidden="true"></i> Подгрузить еще </a>
            						</div>
        <div class="load"></div>
        </div>
	</div>
</div>
                    
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
	<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
<script>
var app = angular.module('app', []);
</script>
		<script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"> </script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"> </script> 
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/autoload.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/constant.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery.barrating.min.js" />"></script>
<script>

$(document).ready(function(){
	var idPage=${idUser};
	var url = '/jobster.by/getVoting?idCandidate='+idPage;
      $.get(url,function(data){
    	  $("#tagscloud span").text(data);
        });
    $("#votes").click(function(){
    	var userok = ${idUser};
    	var rate= $('#rating').val();
    	var rateint = parseInt(rate);
    	var data =  {
    	        mark: rateint,
    	        idCandidate: userok,
    	        
    	      };
        $.post("/jobster.by/voting", data);
    });
});

</script>
<script>
function hider(){
	$('#votes').hide();
	$('#thanks').show();
}
</script>
<script>
var q = '*:*';
var fq = ['end_date:[* TO NOW+181DAY]',
          "id_user:${idUser}"];
var sort = 'start_date desc, budget desc';

var jsonData = '${userJson}';

		app.controller('UserController', ['$scope', '$http', userController]);
		
		app.controller('LotsController', ['$scope', '$http', mainLotsController]);

		function userController ($scope) {
			var vm = this;
			var data = JSON.parse(jsonData);
			vm.user = data;
		}

		function mainLotsController ($scope, $http) {
			var vm = this;
			vm.lotsImages = lotsImages;
			vm.lots = [];
			$http({
				method: 'JSONP',
		        url: solrUrl,
		        params:{
		        	'json.wrf': 'JSON_CALLBACK',
		        	'q': q,
		        	'fq': fq,
		        	'sort': sort,
					'start': offsetStart,
					'rows': ajaxLotMaxSize,
					'wt': 'json',
					'indent': 'true'
		        	}
		        }).success(function(data) {
					angular.forEach(data.response.docs, function(lot) {
						lot.logoImage = vm.lotsImages[getRandomInt(0,vm.lotsImages.length-1)];
						vm.lots.push(lot);
					});
				});
			vm.updateCustomRequest = function (scope) {
				vm.lots = scope.lotsCtrl.lots;
			};
		}
		
		function loader(){
			var scope = angular.element(document.getElementById("list-group")).scope();
			// «теневой» запрос к серверу
			$(".load").fadeIn(500, function () {
							$.ajax({
								url: solrUrl,
								type:"GET",
								traditional: true,
		 					    cache: true,
		 					    async: true,
		 					    dataType: 'jsonp',
								data:{
									//передаем параметры
									q: q,
		 							fq: fq,
		 							sort: sort,
		 							start: offset,
		 							rows: ajaxLotMaxSize,
		 							wt: 'json',
		 							indent: 'true'
								},
								success:function(data) {
									if(data.response.docs.length == 0) {
										isEnd = true;
									}
									for(var i=0; i<data.response.docs.length; i++) {
										data.response.docs[i].logoImage = scope.lotsCtrl.lotsImages[getRandomInt(0,scope.lotsCtrl.lotsImages.length-1)];
										scope.lotsCtrl.lots.push(data.response.docs[i]);
									}
									scope.$apply(function () {
										scope.lotsCtrl.updateCustomRequest(scope);
									});
									offset+=ajaxLotMaxSize;
									block = false;
								},
								jsonp: 'json.wrf'
							});
						});
			}
		</script>
		<script type="text/javascript">
   $(function() {
      $('#rating').barrating({
        theme: 'fontawesome-stars'
      });
   });
</script>
<!-- Yandex.Metrika counter -->
<script type="text/javascript">
    (function (d, w, c) {
        (w[c] = w[c] || []).push(function() {
            try {
                w.yaCounter39345665 = new Ya.Metrika({
                    id:39345665,
                    clickmap:true,
                    trackLinks:true,
                    accurateTrackBounce:true,
                    webvisor:true,
                    trackHash:true
                });
            } catch(e) { }
        });

        var n = d.getElementsByTagName("script")[0],
            s = d.createElement("script"),
            f = function () { n.parentNode.insertBefore(s, n); };
        s.type = "text/javascript";
        s.async = true;
        s.src = "https://mc.yandex.ru/metrika/watch.js";

        if (w.opera == "[object Opera]") {
            d.addEventListener("DOMContentLoaded", f, false);
        } else { f(); }
    })(document, window, "yandex_metrika_callbacks");
</script>
<noscript><div><img src="https://mc.yandex.ru/watch/39345665" style="position:absolute; left:-9999px;" alt="" /></div></noscript>
<!-- /Yandex.Metrika counter -->
</body>
</html>
