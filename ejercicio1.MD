#Ejercicio 1

1.- Incluir un método de validación por formulario que permita autenticar a los usuarios configurados.

Ver: http://docs.spring.io/spring-security/site/docs/4.0.3.CI-SNAPSHOT/reference/htmlsingle/#authorize-requests

3.- Deshabilitar el filtro de CSRF y cambiar la configuración por defecto de: 
- Nombres de username y password
- URL destino

4.- Cambiar el método de autenticación a JDBC

Ver: http://docs.spring.io/spring-security/site/docs/4.0.3.CI-SNAPSHOT/reference/htmlsingle/#user-schema

5.- Cambiar enlace de cerrar sesión por logout (probar que funciona)

Ver: http://docs.spring.io/spring-security/site/docs/4.0.0.M2/reference/htmlsingle/#csrf-logout

6.- Agregar opción de remember-me 

7.- Securizar el método ArticuloService.obtenerArticulos()

8.- Agregar un enlace de "info" a articulo/index.html que sólo puedan ver los usuarios con el rol ROLE_INFO (además deben tener el ROLE_USER).
