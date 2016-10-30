<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="templatemo_header">
	<div id="site_title">
		<h1>
			<a href="<c:url value="/" />">Best prices</a>
		</h1>
	</div>

	<div id="header_right">
		<div class="cleaner"></div>
		<div id="templatemo_search">
			<form action="#" method="get">
				<input type="text" value="Search" name="keyword" id="keyword"
					title="keyword" onfocus="clearText(this)" onblur="clearText(this)"
					class="txt_field" /> <input type="submit" name="Search" value=""
					alt="Search" id="searchbutton" title="Search" class="sub_btn" />
			</form>
		</div>
	</div>
	<!-- END -->
</div>
<!-- END of header -->