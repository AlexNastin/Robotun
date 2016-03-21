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
	<form:form modelAttribute="updatePersonalLegalForm" method="POST">
		<form:input path="nameEnterprise" placeholder="nameEnterprise" value="${user.legal.nameEnterprise}"/>
		<form:input path="unp" placeholder="unp" value="${user.legal.unp}"/>
		<form:input path="address" placeholder="address" value="${user.legal.address}"/>
		<form:input path="zipCode" placeholder="zipCode" value="${user.legal.zipCode}"/>
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
