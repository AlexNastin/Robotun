<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Изменение личных данных</title>
</head>
<body>
	<form:form modelAttribute="updatePersonalPhysicalForm" method="POST">
		<form:input path="name" placeholder="name" value="${user.physical.name}"/>
		<form:input path="surname" placeholder="surname" value="${user.physical.surname}"/>
		<form:input path="middleName" placeholder="middleName" value="${user.physical.middleName}"/>
		<form:select class="form-control" path="idCity">
			<c:set var="idSelectCity" value="${user.idCity}"/>
			<c:forEach items="${listCities}" var="city">
				<c:if test="${city.idCity == idSelectCity}">
					<c:set var="selected" value="true"/>
				</c:if>
				<form:option value="${city.idCity}" selected="${selected}">${city.title}</form:option>
				<c:set var="selected" value=""/>
			</c:forEach>
		</form:select>
		<c:forEach items="${user.phones}" var="phone">
				<form:input path="phones" placeholder="phone" value="${phone.phone}"/>
		</c:forEach>
		<input type="submit" class="button-on-add-lot" value="Добавить" />
	</form:form>
</body>
</html>
