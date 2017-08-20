<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page import="online.flussibancari.cbi.mav.consts.Constants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato Conversione</title>
</head>
<body>
<div id="mainWrapper">
<div class="well lead">Risultato conversione Excel</div>
<form:form method="POST" modelAttribute="user" class="form-horizontal">
      <div class="form-group col-md-12"> 
        <label class="col-md-3 control-lable" for="firstName">Contenuto File Excel</label> 
        <div class="col-md-7">${out.type}
        </div>
        <label class="col-md-3 control-lable" for="firstName">Scarica qui il file CBI:</label>
        <div class="col-md-7">
	        	<s:url value="/downloadTxt/{file_name}" var="txt_file_url" htmlEscape="true">
					<s:param name="file_name" value="${out.fileName}"></s:param>
				</s:url>
				<a href="${txt_file_url}">${out.type}</a>
		</div>
	</div>
</form:form>
</div>
</body>
</html>