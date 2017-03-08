<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Caricamento File Excel MAV</title>
</head>
<body>
	<form method="POST" action="MAVManager" enctype="multipart/form-data">
		File Excel MAV: <input type="file" name="file">
 
		<input type="submit" value="Carica"> Premi qui per caricare il file Excel per la conversione in formato CBI!
	</form>	
</body>
</html>