<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	</head> 
	<body>
	<div id="mainWrapper">
		<img src=<c:url value="/static/img/flussi_bancari.png" /> />
		<s:url value="/MAVManager" var="mav" htmlEscape="true">
		</s:url>
			<a href="${mav}">MAVManager</a>
	</div>
	</body>
</html>
