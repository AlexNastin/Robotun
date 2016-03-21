<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-default header-background-color">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed burger-button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar" style="background-color: white"></span>
                <span class="icon-bar" style="background-color: white"></span>
                <span class="icon-bar" style="background-color: white"></span>
            </button>
            <a class="navbar-brand text-color" href="<c:url value="/"/>">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value="/test"/>" class="text-color active-block">Test<span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="/signup"/>" class="text-color">Sign Up</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="text-color">Link</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>