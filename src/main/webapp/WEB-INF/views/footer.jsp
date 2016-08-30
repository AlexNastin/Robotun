<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<footer class="footer-distributed">

			<div class="footer-right">

				<a href="#"><i class="fa fa-facebook"></i></a>
				<a href="#"><i class="fa fa-vk"></i></a>
				

			</div>

			<div class="footer-left">

				<p class="footer-links">
					
					<a href="<c:url value="/about" />">О проекте</a>
					·
					<a href="<c:url value="/agreement" />">Публичный договор</a>
					·
					<a href="<c:url value="/policy" />">Политика конфендециальности </a>
					·
					<a href="<c:url value="/faq" />">FAQ</a>
					·
					<a href="<c:url value="/contacts" />">Контакты</a>
					
				</p>

				<p>Jobster &copy; 2016</p>
			</div>

		</footer>