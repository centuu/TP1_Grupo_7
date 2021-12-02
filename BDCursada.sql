drop schema cursada;
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

ALTER TABLE alumnos ADD CONSTRAINT unq_DNI UNIQUE(dni);

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
    clave varchar(50),    
    estado BOOLEAN,
    FOREIGN KEY(idNacionalidad) REFERENCES Nacionalidad(id),
    FOREIGN KEY(idLocalidad) REFERENCES localidad(id)
);

ALTER TABLE docentes ADD CONSTRAINT unq_docenteDNI UNIQUE(dni);

CREATE TABLE usuarios
(
	usuario VARCHAR(25) NOT NULL PRIMARY KEY,
	clave VARCHAR(25),
    legajo INT,
	rol INT
);

ALTER TABLE usuarios ADD CONSTRAINT unq_usuariolegajo UNIQUE(legajo);

CREATE TABLE cursos
(
	idCurso INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idMateria INT,
    idDocente INT,
    semestre VARCHAR(20),
    anio INT,
    descripcion varchar(100)
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
    condicion VARCHAR(20)
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

/*PROCEDIMIENTOS ALMACENADOS*/

DELIMITER //
CREATE PROCEDURE insert_AlumnoPorCurso(idCurso INT, legajoAlumno INT)
BEGIN 
	INSERT INTO alumnosPorCurso (idCurso,legajoAlumno) 
	VALUES (idCurso,legajoAlumno);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE insert_Cursada(idCurso INT, legajoAlumno INT)
BEGIN 
	INSERT INTO cursada (idCurso, legajoAlumno, condicion) 
	VALUES (idCurso, legajoAlumno,'');
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE count_Alumnos()
BEGIN 
	SELECT COUNT(*) FROM Alumnos INNER JOIN nacionalidad ON Alumnos.idNacionalidad = nacionalidad.id INNER JOIN provincia ON Alumnos.idProvincia = provincia.id WHERE alumnos.estado = 1;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE count_Docentes()
BEGIN 
	SELECT COUNT(*) FROM docentes INNER JOIN nacionalidad ON docentes.idNacionalidad = nacionalidad.id INNER JOIN localidad ON docentes.idLocalidad = localidad.id WHERE docentes.estado = 1;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE insert_Alumno (dni INT,nombre VARCHAR(10),apellido VARCHAR(25),fechaNacimiento DATE,domicilio VARCHAR(50),idprovincia INT,idnacionalidad INT,email VARCHAR(50),telefono VARCHAR(25))
BEGIN 
	INSERT INTO Alumnos (dni,nombre,apellido,fechaNacimiento,domicilio,idprovincia,idnacionalidad,email,telefono,estado) 
	VALUES (dni,nombre,apellido,fechaNacimiento,domicilio,idprovincia,idnacionalidad,email,telefono,true);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_Alumno (legajo INT)
BEGIN 
	UPDATE Alumnos SET estado = 0 WHERE legajo = legajo;
END //
DELIMITER ;

DELIMITER //

DELIMITER //
CREATE PROCEDURE list_Alumnos()
BEGIN 
	SELECT * FROM Alumnos INNER JOIN nacionalidad ON Alumnos.idNacionalidad = nacionalidad.id INNER JOIN provincia ON Alumnos.idProvincia = provincia.id WHERE alumnos.estado = 1;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE find_Alumno(legajo INT)
BEGIN 
	SELECT * FROM Alumnos INNER JOIN nacionalidad ON Alumnos.idNacionalidad = nacionalidad.id INNER JOIN provincia ON Alumnos.idProvincia = provincia.id WHERE alumnos.estado = 1 AND alumnos.legajo = legajo;
END //
DELIMITER ;

/*TRIGGERS*/

DELIMITER $$
CREATE TRIGGER insert_Usuario
AFTER INSERT ON docentes
FOR EACH ROW
BEGIN
    INSERT INTO usuarios(usuario, clave, legajo, rol) VALUES (NEW.dni, NEW.clave, NEW.legajo, 2);
END$$
DELIMITER ;

DELIMITER $$
DROP TRIGGER IF EXISTS `update_cursos`$$
CREATE TRIGGER `update_cursos` BEFORE INSERT ON `cursos` 
FOR EACH ROW BEGIN
    DECLARE descMateria varchar(100);
    SELECT descripcion INTO descMateria FROM materias WHERE idMateria = NEW.idMateria;
    SET NEW.descripcion = CONCAT(descMateria,' ', NEW.anio,' ', NEW.semestre);
END$$
DELIMITER ;

/*CARGA DE DATOS*/

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

-- *****************************************************************************
--                      insert  registros Alumnos

INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('38914202', 'Pedro', 'Torres', '1995/05/04', 'Azucena 1234', 1, 1, 'ptorres@utn.com', '03327485986', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('39168909', 'Marcos', 'Ledesma', '1995/05/06', 'Palosanto 456', 2, 3, 'mledesma@utn.com', '47411451', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('12345678', 'Fernando', 'Gordillo', '1995/10/08', 'Oscar 1234', 4, 5, 'fgordillo@utn.com', '47896512', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('38914211', 'Josefina', 'Galarza', '1999/12/12', 'Gandolfo 1334', 1, 1, 'jGalarza@utn.com', '27415986', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('38454201', 'Juan', 'Villar', '1997/09/04', 'quintana 3244', 1, 1, 'juanV@utn.com', '332748596', true);

INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('39148933', 'Nicolas', 'Ferrrari', '1990/05/06', 'Italia 4546', 5, 3, 'NicoF@utn.com', '47422451', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('13345278', 'Andres', 'Diaz', '1999/12/12', 'Cordero 1244', 4, 5, 'Diaz@utn.com', '17846513', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('13365678', 'Agustina', 'Lhez', '1998/11/08', 'Revignani 4322', 4, 5, 'aLhez@utn.com', '31890012', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('38224202', 'Mathias', 'Beltser', '1998/09/10', 'Uruguay 1534', 1, 6, 'mBeltser@utn.com', '27485486', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('36164409', 'alejandro', 'Blanco', '1995/01/06', 'Maipu 3010', 4, 1, 'aBlanco@utn.com', '22411351', true);

INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('39138409', 'Sol', 'Roccia', '1990/02/01', 'Piran 3456', 2, 3, 'sRoccia@utn.com', '66410451', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('38913332', 'Sofia', 'Varela', '1991/05/04', 'Cordero 1934', 1, 1, 'sVarela@utn.com', '27405906', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('39264649', 'German', 'Martinez', '1995/09/03', 'Gandolfo 4256', 2, 3, 'gMartinez@utn.com', '30119451', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('13345778', 'Santiago', 'Nuñez', '1998/10/02', 'Junin 2331', 4, 5, 'sNuñez@utn.com', '66896502', true);
INSERT INTO alumnos (dni, nombre, apellido, fechaNacimiento, domicilio, idprovincia, idnacionalidad, email, telefono, estado) VALUES ('11343868', 'Maria', 'Casmuz', '1991/10/01', 'Rolon 3100', 2, 3, 'mCasmuz@utn.com', '43678512', true);

-- *****************************************************************************
--                      insert  registros Docentes

INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('44555888', 'Tomas', 'Scutti', '2000/08/12', 'Caracas 1234', 3, 1, 'tscutti@utn.com', '47478989','123465', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('46888999', 'Jose', 'Fabiani', '2002/06/03', 'Florida 486', 2, 1, 'jfabiani@utn.com', '12123636','ASD123', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('32456789', 'Pablo', 'Laciobu', '2000/09/12', 'Caracas 1224', 1, 1, 'tscutti@utn.com', '47478989','123465', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('44325831', 'Damian', 'Natale', '1989/08/12', 'España 1134', 3, 1, 'dNatale@utn.com', '45458989','1234', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('46327199', 'Angel', 'Simon', '1988/09/02', 'Fleming 4822', 3, 4, 'aSimon@utn.com', '12123622','AB123', true);

INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('30056719', '	Tamara', 'Herrera', '1990/01/11', 'Caracas 1624', 1, 1, 'tHerrera@utn.com', '22747189','AC123', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('10555828', 'Innes', 'Casanova', '1980/01/01', 'Centenario 2204', 1, 2, 'iCasanova@utn.com', '23475589','1234B', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('36808909', 'Rodrigo', 'Pacheco', '1988/01/03', 'Moyano 1286', 3, 2, 'rPacheco@utn.com', '22120636','ABC123', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('35404781', 'Florencia', 'Suarez', '1991/12/12', 'Polonia 1224', 2, 1, 'fSuarez@utn.com', '42078989','BC465', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('40505868', 'Cecilia', 'Lupani', '1995/08/05', 'Irigoyen 1234', 3, 1, 'cLupani@utn.com', '33008989','12A34', true);

INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('32881909', 'Jorge', 'Peña', '2000/05/05', 'Portugal 4816', 2, 1, 'jPeña@utn.com', '55202336','AC123', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('54456709', 'Victoria', 'Marez', '1988/09/01', 'Sobremonte 3224', 3, 2, 'vMarez@utn.com', '76008989','12CC', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('49505811', 'Ignacio', 'Mendoza', '1998/12/12', 'Lima 2231', 3, 1, 'iMendoza@utn.com', '22478089','BC345', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('1084959', 'Rafael', 'Farias', '2001/01/03', 'Ricardo Rojas 1266', 2, 1, 'rFarias@utn.com', '12100636','AD4321', true);
INSERT INTO docentes (dni, nombre, apellido, fechaNacimiento, domicilio, idlocalidad, idnacionalidad, email, telefono, clave, estado) VALUES ('21456001', 'Alejandra', 'Romero', '2000/01/05', 'Suipacha 3055', 3, 3, 'aRomero@utn.com', '45458009','4321B', true);



INSERT INTO usuarios (usuario, clave, legajo, rol) VALUES ('admin', 'admin', 0, 1);

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


-- *****************************************************************************
--                      insert  registros Crusos

insert into cursos(idMateria,idDocente,semestre,anio)values(7,3,'2C-TM',2022);
insert into cursos(idMateria,idDocente,semestre,anio)values(3,1,'1C-TN',2021);
insert into cursos(idMateria,idDocente,semestre,anio)values(6,2,'2C-TM',2020);
insert into cursos(idMateria,idDocente,semestre,anio)values(4,3,'2C-TN',2021);

insert into cursos(idMateria,idDocente,semestre,anio)values(1,4,'2C-TM',2021);
insert into cursos(idMateria,idDocente,semestre,anio)values(2,5,'1C-TN',2020);
insert into cursos(idMateria,idDocente,semestre,anio)values(5,6,'2C-TM',2020);
insert into cursos(idMateria,idDocente,semestre,anio)values(8,7,'2C-TN',2022);


-- *****************************************************************************
--                      insert  registros Cursada
/*select*from cursada
insert into cursada (idCurso,legajoAlumno)values(1,1);
insert into cursada (idCurso,legajoAlumno)values(3,1);
insert into cursada (idCurso,legajoAlumno)values(2,3);
insert into cursada (idCurso,legajoAlumno)values(6,2);
insert into cursada (idCurso,legajoAlumno)values(4,2);
insert into cursada (idCurso,legajoAlumno)values(3,1);
insert into cursada (idCurso,legajoAlumno)values(2,5);
insert into cursada (idCurso,legajoAlumno)values(2,4);
insert into cursada (idCurso,legajoAlumno)values(1,12);
insert into cursada (idCurso,legajoAlumno)values(1,9);
*/


