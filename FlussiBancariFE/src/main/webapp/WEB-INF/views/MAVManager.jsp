<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Caricamento File Excel MAV</title>
<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<!-- 	<form method="POST" action="MAVManagerExcelLoad?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
		File Excel MAV: <input type="file" name="file" >
 		<input type="submit" value="Carica"> Premi qui per caricare il file Excel per la conversione in formato CBI!
	
	</form>	
 -->	
 <div id="mainWrapper">
	<form action="${pageContext.request.contextPath}/MAVManagerExcelLoad" 
   			enctype="multipart/form-data"  method="POST" 
   			class="form-horizontal" role="form">
   			File Excel MAV: <input type="file" name="file" >
   			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
 			<input type="submit" value="Carica"> Premi qui per caricare il file Excel per la conversione in formato CBI!
	</form>
</div>
</body>
</html>