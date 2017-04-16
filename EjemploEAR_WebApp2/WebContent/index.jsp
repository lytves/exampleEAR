<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mostrar autores</title>
</head>
<body>
	<h1>Hola ${nombre}!</h1>
	<form action="./GetUserName" method="post">
		Dime tu nombre: <input type="text" id="nombre" name="nombre"></input>
		<input type="submit" value="Tu nombre"></input>
	</form>
	
	<h1><a href="/EjemploEAR_WebApp2/Autores">Mostrar autores</a></h1>
</body>
</html>