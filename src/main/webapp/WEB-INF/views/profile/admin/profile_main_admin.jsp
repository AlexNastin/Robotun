<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<title>Личный кабинет администратора</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
<link href="<c:url value="/resources/css/main/main.css"  />" rel="stylesheet" />
<link href="<c:url value="/resources/css/profiles/admin.css"  />" rel="stylesheet" />
</head>
<body>
<%@include file="/WEB-INF/views/headerwithsearch2.jsp"%>
<div class="container" style="width:100%; padding-left:0px; padding-right:0px;">
<div class="min-height-admin-page">
<div class="col-md-2 nopadiing-left">
<img src="<c:url value="/resources/images/fabian-perez.jpg"/>" class="img-responsive img-thumbnail" alt="Image">
<a href='<c:url value="/admin/profile" />' class="list-group-item background-color-menu-profile active-menu">Профиль</a>
<a href='<c:url value="/admin/addModerator" />' class="list-group-item background-color-menu-profile">Добавить модератора</a>
</div>
<div class="col-md-10">
<div class="text-admin-page-main col-md-12">Модераторы: </div>

<c:forEach items="${listUsers}" var="user">
<p> ${user.login} <a type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${user.idUser}">Удалить этого урода</a></p>
<div class="modal fade" id="myModal${user.idUser}" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Подтверждение удаления</h4>
        </div>
        <div class="modal-body">
          <p>Разжаловать ублюдка?</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Не удалять</button>
          <a class="btn btn-danger" href='<c:url value="/admin/deleteModerator?id=${user.idUser}" />'>Удалить</a>
        </div>
      </div>
      
    </div>
  </div>
</c:forEach>
</div>
</div>
</div>
<a type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</a>


  

<%@include file="/WEB-INF/views/footer.jsp"%>
<script	src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script	src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>
