<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autores</title>
</head>
<body>

	<h1>Autores:</h1>
	<ul>
		<c:forEach var="autor" items="${autores}">
			<li>${autor}</li>
		</c:forEach>
	</ul>
	<a href="/Ejemplo_WebApp3/">Volver</a>

</body>
</html>