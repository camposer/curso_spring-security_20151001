<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceso a Blog</title>
</head>
<body>
	<h1>Acceso a Blog</h1>
	<c:url value="/autenticar" var="loginUrl" />
	<form action="${loginUrl}" method="post">
		<c:if test="${param.error != null}">        
		<p>Usuario o contraseña inválido</p>
		</c:if>
		<c:if test="${param.logout != null}">       
		<p>Te has salido del sistema</p>
		</c:if>
		<p>
			<label for="username">Usuario</label>
			<input type="text" name="usuario" />
		</p>
		<p>
			<label for="password">Contraseña</label>
			<input type="password" name="clave" />
		</p>
		<p>
			<input type="checkbox" name="remember-me" />
			Recuérdame
		</p>
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button type="submit" class="btn">Entrar</button>
	</form>
</body>
</html>