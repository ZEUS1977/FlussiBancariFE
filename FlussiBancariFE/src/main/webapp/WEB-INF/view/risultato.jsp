<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page import="online.flussibancari.cbi.mav.consts.Constants" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato Conversione</title>
</head>
<body>
<h2>Risultato conversione Excel</h2>
   <table>
    <tr>
        <td>Contenuto File Excel</td>
        <td>${out.type}</td>
    </tr>
    <tr>
        <td>Scarica qui il file CBI:</td>
        <td>
        	<s:url value="/downloadTxt/{file_name}" var="txt_file_url" htmlEscape="true">
				<s:param name="file_name" value="${out.fileName}"></s:param>
			</s:url>
			<a href="${txt_file_url}">${out.type}</a>
        </td>
    </tr>
</table> 
</body>
</html>