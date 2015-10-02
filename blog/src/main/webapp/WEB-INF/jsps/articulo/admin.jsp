<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin de Artículos</title>
</head>
<body>
	<h1>Admin de Artículos</h1>
	<div>
		<p>Adminitración de artículos...</p>
	</div>

	<c:url var="inicioUrl" value="/articulos.do"/>
	<a href="${inicioUrl}">Inicio</a>
	
	<sec:authorize access="hasRole('INFO')">
		<div>Sólo lo puede ver ROLE_INFO</div>
	</sec:authorize>
</body>
</html>