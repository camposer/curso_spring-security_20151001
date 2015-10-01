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