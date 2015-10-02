<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Artículos</title>
	<style type="text/css">
		.articulo {
			boder: 1x solid black;
		}
	</style>
</head>
<body>
	<h1>Artículos</h1>
	<div>
		<c:forEach var="a" items="${articulos}">
			<div class="articulo">
				<div class="titulo">${a.titulo}</div>
				<div class="contenido">${a.contenido}</div>
			</div>
			<br>
		</c:forEach>
		
	</div>
	<c:url var="adminUrl" value="/articulos/admin.do"/>
	<a href="${adminUrl}">Admin</a>
	<c:url var="logoutUrl" value="/logout.do"/>
	<a href="${logoutUrl}">Salir</a>	
	
</body>
</html>