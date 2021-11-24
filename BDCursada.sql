create schema Cursada;

use Cursada;

create table nacionalidad
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombreNacionalidad varchar(50)
);

create table provincia
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombreProvincia varchar(50)
);

create table localidad
(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombreLocalidad varchar(50)
);


create table usuarios
(
	usuario VARCHAR(25) NOT NULL PRIMARY KEY,
	clave VARCHAR(25),
    nroLegajo int,
	rol int
);

create table alumnos
(
	nroLegajo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni varchar(10),
    nombre VARCHAR(25),
    apellido VARCHAR(25),
    fechaNac VARCHAR(25),
    domicilio VARCHAR(50),
    idprovincia int,
    idnacionalidad int,
    email VARCHAR(50),
    telefono VARCHAR(25),
    estado boolean,
	foreign key( idnacionalidad) references nacionalidad(id),
    foreign key( idprovincia) references provincia(id)
);

create table docentes
(
	nroLegajo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    dni varchar(10),
    nombre VARCHAR(25),
    apellido VARCHAR(25),
    fechaNac DATE,
    domicilio VARCHAR(50),
    idlocalidad int,
    idnacionalidad int, 
    email VARCHAR(50),
    telefono VARCHAR(25),
    estado boolean,
    foreign key( idnacionalidad) references Nacionalidad(id),
    foreign key( idlocalidad) references localidad(id)
);
create table cursos
(
	idCurso INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idMateria int,
    semestre varchar(25),
    ciclo int,
    idDocente int
);

create table cursada
(
	idCursada INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idCurso int,
    idAlumno int,
    nota_pri DECIMAL,
    nota_seg DECIMAL,
    rec_pri decimal,
    rec_seg decimal,
    estado boolean
);

create table materias
(
	idMateria INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion varchar(100),
    anio int,
    idCarrera int
);

create table carreras
(
	idCarrera INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion varchar(100)
);


INSERT INTO provincia (nombreProvincia) VALUES ( 'Buenos Aires' );
INSERT INTO provincia (nombreProvincia) VALUES ( 'Entre Rios' );
INSERT INTO provincia (nombreProvincia) VALUES ( 'Santa Fe' );
INSERT INTO provincia (nombreProvincia) VALUES ( 'Catamarca' );
INSERT INTO provincia (nombreProvincia) VALUES ( 'Chubut' );
INSERT INTO provincia (nombreProvincia) VALUES ( 'Jujuy' );
INSERT INTO provincia (nombreProvincia) VALUES ( 'Otros' );

INSERT INTO localidad (nombreLocalidad) VALUES ( 'Pacheco' );
INSERT INTO localidad (nombreLocalidad) VALUES ( 'Talar' );
INSERT INTO localidad (nombreLocalidad) VALUES ( 'Quilmes' );
INSERT INTO localidad (nombreLocalidad) VALUES ( 'Otra' );

INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Argentina' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Boliviana' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Brasileña' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Chilena' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Colombiana' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Ecuatoriana' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Paraguaya' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Peruana' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Uruguaya' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Venezolana' );
INSERT INTO nacionalidad (nombreNacionalidad) VALUES ('Otra' );


INSERT INTO alumnos (nroLegajo, dni, nombre, apellido, fechaNac, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('1', '38914204', 'Pedro', 'Torres', '1995/05/04', 'Azucena 1234', 1, 1, 'ptorres@utn.com', '03327485986', true);
INSERT INTO alumnos (nroLegajo, dni, nombre, apellido, fechaNac, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('2', '39168909', 'Marcos', 'Ledesma', '1995/05/06', 'Palosanto 456', 1, 1, 'mledesma@utn.com', '47411451', true);
INSERT INTO alumnos (nroLegajo, dni, nombre, apellido, fechaNac, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('3', '12345678', 'Fernando', 'Gordillo', '1995/10/08', 'Oscar 1234', 1, 1, 'fgordillo@utn.com', '47896512', true);

INSERT INTO docentes (nroLegajo, dni, nombre, apellido, fechaNac, domicilio, idlocalidad, idnacionalidad, email, telefono, estado) VALUES ('0001', '44555888', 'Tomas', 'Scutti', '2000/08/12', 'Caracas 1234', 3, 1, 'tscutti@utn.com', '47478989', true);
INSERT INTO docentes (nroLegajo, dni, nombre, apellido, fechaNac, domicilio, idlocalidad, idnacionalidad, email, telefono, estado) VALUES ('0002', '46888999', 'Jose', 'Fabiani', '2002/06/03', 'Florida 486', 2, 1, 'jfabiani@utn.com', '12123636', true);

INSERT INTO usuarios (usuario, clave, nroLegajo, rol) VALUES ('admin', 'admin', 0, 1);
INSERT INTO usuarios (usuario, clave, nroLegajo, rol) VALUES ('0001', '1234', 0, 2);
INSERT INTO usuarios (usuario, clave, nroLegajo, rol) VALUES ('0002', 'lab4', 0, 2);


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