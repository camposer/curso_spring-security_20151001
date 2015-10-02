CREATE TABLE articulo(
	id INTEGER NOT NULL 
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	titulo VARCHAR(250) NOT NULL,
	contenido VARCHAR(500) NOT NULL,
	fecha DATE NOT NULL,
	status CHAR(10),
	PRIMARY KEY(id)
);

INSERT INTO articulo(titulo, contenido, fecha, status)
VALUES('titulo 1', 'contenido 1', current_date, 'ACTIVO');
INSERT INTO articulo(titulo, contenido, fecha, status)
VALUES('titulo 2', 'contenido 2', current_date, 'ACTIVO');

-- select nombre_usuario as username, clave as password, true from usuario where nombre_usuario = ? and estatus = 'ACTIVO'
CREATE TABLE usuario(
	id INTEGER NOT NULL 
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre_usuario VARCHAR(50) NOT NULL,
	clave VARCHAR(100) NOT NULL,
	estatus CHAR(10),
	PRIMARY KEY(id)
);
-- Contraseñas con sha-1 de 123456
INSERT INTO usuario(nombre_usuario, clave, estatus)
VALUES('user', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'ACTIVO');
INSERT INTO usuario(nombre_usuario, clave, estatus)
VALUES('admin', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'ACTIVO');
INSERT INTO usuario(nombre_usuario, clave, estatus)
VALUES('root', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'ACTIVO');

-- select nombre_usuario as u.username, r.nombre as authority from rol r inner join usuario u on r.usuario_id = u.id where u.nombre_usuario = ?
select nombre_usuario as username, r.nombre as authority from rol r inner join usuario u on r.usuario_id = u.id where u.nombre_usuario = 'admin'
CREATE TABLE rol(
	id INTEGER NOT NULL 
		GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	usuario_id INTEGER NOT NULL,
	nombre VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
INSERT INTO rol(usuario_id, nombre) VALUES(1, 'ROLE_USER');
INSERT INTO rol(usuario_id, nombre) VALUES(2, 'ROLE_USER');
INSERT INTO rol(usuario_id, nombre) VALUES(2, 'ROLE_ADMIN');
INSERT INTO rol(usuario_id, nombre) VALUES(3, 'ROLE_USER');
INSERT INTO rol(usuario_id, nombre) VALUES(3, 'ROLE_ADMIN');
INSERT INTO rol(usuario_id, nombre) VALUES(3, 'ROLE_INFO');
