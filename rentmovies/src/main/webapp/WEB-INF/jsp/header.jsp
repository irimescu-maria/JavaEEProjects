<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rent a Movie</title>

<script
	src="<c:url value='https://maxcdn.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js' />"></script>
<script
	src="<c:url value='https://code.jquery.com/jquery-1.11.1.min.js' />"></script>
<script src="<c:url value='/resources/jquery/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
<script
	src="<c:url value='/resources/bootstrap/js/bootstrap-datepicker.js'/>"></script>


<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/3.0.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/bootstrap/css/bootstrap-datepicker3.standalone.css'/>">
<script src="<c:url value='/resources/jquery/js/jquery.min.js'/>"></script>
<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js'/>"></script>
<script
	src="<c:url value='/resources/bootstrap/js/bootstrap-datepicker.js'/>"></script>
</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Rent a Movie</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty user.email}">
							<li><a href="<c:url value = "/signup"/>">Register</a></li>
							<li><a href="<c:url value="/login" />">Login</a></li>
						</c:when>
						<c:otherwise>
							<li>Hello ${user.email}</li>
							<li><a href="<c:url value="/logout" />">Log out</a></li>
				
						</c:otherwise>
					</c:choose>

				</ul>
			</div>



		</div>
	</div>
	<div class="container">