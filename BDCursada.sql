create schema Cursada;

use Cursada;

CREATE TABLE nacionalidad
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nacionalidad VARCHAR(50)
);

CREATE TABLE provincia
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    provincia VARCHAR(50)
);

CREATE TABLE localidad
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    localidad VARCHAR(50)
);

CREATE TABLE usuarios
(
	usuario VARCHAR(25) NOT NULL PRIMARY KEY,
	clave VARCHAR(25),
    legajo INT,
	rol INT
);

CREATE TABLE alumnos
(
	legajo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni VARCHAR(10),
    nombre VARCHAR(25),
    apellido VARCHAR(25),
    fechaNacimiento DATE,
    domicilio VARCHAR(50),
    idProvincia INT,
    idNacionalidad INT,
    email VARCHAR(50),
    telefono VARCHAR(25),
    estado BOOLEAN,
	FOREIGN KEY(idNacionalidad) REFERENCES nacionalidad(id),
    FOREIGN KEY(idProvincia) REFERENCES provincia(id)
);

CREATE TABLE docentes
(
	legajo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni VARCHAR(10),
    nombre VARCHAR(25),
    apellido VARCHAR(25),
    fechaNacimiento DATE,
    domicilio VARCHAR(50),
    idLocalidad INT,
    idNacionalidad INT, 
    email VARCHAR(50),
    telefono VARCHAR(25),
    estado BOOLEAN,
    FOREIGN KEY(idNacionalidad) REFERENCES Nacionalidad(id),
    FOREIGN KEY(idLocalidad) REFERENCES localidad(id)
);

CREATE TABLE cursos
(
	idCurso INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idMateria INT,
    semestre VARCHAR(25),
    ciclo INT,
    idDocente INT
);

CREATE TABLE cursada
(
	idCursada INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idCurso INT,
    legajoAlumno INT,
    nota_pri DECIMAL,
    nota_seg DECIMAL,
    rec_pri decimal,
    rec_seg decimal,
    estado BOOLEAN
);

CREATE TABLE materias
(
	idMateria INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(100),
    anio INT,
    idCarrera INT
);

CREATE TABLE carreras
(
	idCarrera INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(100)
);

CREATE PROCEDURE insert_Alumno 
(
	dni INT,
	nombre VARCHAR(10), 
	apellido VARCHAR(25),
	fechaNacimiento DATE,
	domicilio VARCHAR(50),
	idprovincia INT,
	idnacionalidad INT,
	email VARCHAR(50),
	telefono VARCHAR(25),
	estado BOOLEAN
)
BEGIN INSERT INTO Alumnos (dni,nombre,apellido,fechaNac,domicilio,idprovincia,idnacionalidad,email,telefono,estado) 
VALUES 
(
	dni,
	nombre,
	apellido,
	fechaNacimiento,
	domicilio,
	idprovincia,
	idnacionalidad,
	email,
	telefono,
	estado
)

INSERT INTO provincia (provincia) VALUES ( 'Buenos Aires' );
INSERT INTO provincia (provincia) VALUES ( 'Entre Rios' );
INSERT INTO provincia (provincia) VALUES ( 'Santa Fe' );
INSERT INTO provincia (provincia) VALUES ( 'Catamarca' );
INSERT INTO provincia (provincia) VALUES ( 'Chubut' );
INSERT INTO provincia (provincia) VALUES ( 'Jujuy' );
INSERT INTO provincia (provincia) VALUES ( 'Otra' );

INSERT INTO localidad (localidad) VALUES ( 'Pacheco' );
INSERT INTO localidad (localidad) VALUES ( 'Talar' );
INSERT INTO localidad (localidad) VALUES ( 'Quilmes' );
INSERT INTO localidad (localidad) VALUES ( 'Otra' );

INSERT INTO nacionalidad (nacionalidad) VALUES ('Argentina' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Boliviana' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Brasileña' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Chilena' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Colombiana' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Ecuatoriana' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Paraguaya' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Peruana' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Uruguaya' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Venezolana' );
INSERT INTO nacionalidad (nacionalidad) VALUES ('Otra' );


INSERT INTO alumnos (legajo, dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('1', '38914204', 'Pedro', 'Torres', '1995/05/04', 'Azucena 1234', 1, 1, 'ptorres@utn.com', '03327485986', true);
INSERT INTO alumnos (legajo, dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('2', '39168909', 'Marcos', 'Ledesma', '1995/05/06', 'Palosanto 456', 1, 1, 'mledesma@utn.com', '47411451', true);
INSERT INTO alumnos (legajo, dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('3', '12345678', 'Fernando', 'Gordillo', '1995/10/08', 'Oscar 1234', 1, 1, 'fgordillo@utn.com', '47896512', true);

INSERT INTO docentes (legajo, dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, estado) VALUES ('0001', '44555888', 'Tomas', 'Scutti', '2000/08/12', 'Caracas 1234', 3, 1, 'tscutti@utn.com', '47478989', true);
INSERT INTO docentes (legajo, dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, estado) VALUES ('0002', '46888999', 'Jose', 'Fabiani', '2002/06/03', 'Florida 486', 2, 1, 'jfabiani@utn.com', '12123636', true);

INSERT INTO usuarios (usuario, clave, legajo, rol) VALUES ('admin', 'admin', 0, 1);
INSERT INTO usuarios (usuario, clave, legajo, rol) VALUES ('0001', '1234', 0, 2);
INSERT INTO usuarios (usuario, clave, legajo, rol) VALUES ('0002', 'lab4', 0, 2);


INSERT INTO carreras (descripcion) VALUES ('Tecnico Universitario en Programacion');

INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Programacion I', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Sistemas de Proc. de Datos', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Matematica', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Ingles I', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Laboratorio de Computacion I', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Programacion II', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Arquitectura y Sistemas Operativos', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Estadistica', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Ingles II', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Laboratorio de Computacion II', 1, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Metodologia de la Investigacion', 1, 1);

INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Programacion III', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Organizacion Contable de la Empresa', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Organizacion Empresarial', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Elementos de la Investigacion Operativa', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Laboratorio de Computacion III', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Metodologia de Sistemas I', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Diseno y Administracion de Base de Datos', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Legislacion', 2, 1);
INSERT INTO materias (descripcion, anio, idCarrera) VALUES ('Laboratorio de Computacion IV', 2, 1);