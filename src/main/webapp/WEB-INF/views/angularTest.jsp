<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html ng-app="app">
<head>
<script type="text/javascript" src="<c:url value="/resources/js/angular/angular.min.js" />"></script>
	<title>AngularTest</title>
</head>
<body ng-controller="CompaniesController">
  <h1>Companies List!</h1>
  <ul>
    <li ng-repeat="company in companies">{{company}}</li>
  </ul>
  <hr>
  <h1>Technologies List!</h1>
  <ul>
    <li ng-repeat="tech in technologies">{{tech}}</li>
  </ul>

</body>
<script type="text/javascript">
//Code goes here

var app = angular.module('app', []);

app.controller('CompaniesController', ['$scope', '$http',
  function($scope, $http) {
    $http.get('/webapp/resources/js/angular/companies.json').success(function(data) {
      $scope.companies = [];
      $scope.technologies = [];
      angular.forEach(data, function(company) {
        $scope.companies.push(company.title);
        angular.forEach(company.technologies, function(tech) {
          if ($scope.technologies.indexOf(tech) == -1) {
            $scope.technologies.push(tech);
          }
        });
      });
    });

  }
]);
</script>
</html>
