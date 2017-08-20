<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>		
	</head> 
	<body>
	<div id="mainWrapper">
		<img src=<c:url value="/static/img/flussi_bancari.png" /> />
		
		<div class="form-group col-md-12">
			<s:url value="/MAVManager" var="mav" htmlEscape="true">
			</s:url>
				<a href="${mav}">
				MAVManager
				</a>
		</div>
		<div class="form-group col-md-12">
			<s:url value="/autoRegistration" var="autoReg" htmlEscape="true">
			</s:url>
			<a href="${autoReg}">
				Registration
			</a>
		</div>
		
	</div>
	</body>
</html>
