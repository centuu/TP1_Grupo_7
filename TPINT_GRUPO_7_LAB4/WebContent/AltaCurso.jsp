<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TP Integrador - Grupo N° 7</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/AltaCurso.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
	    	<a class="navbar-brand" href="inicio.jsp">Home</a>
	    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      		<span class="navbar-toggler-icon"></span>
	    	</button>
	    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
	        		<li class="nav-item">
	          			<a class="nav-link" href="AltaAlumno.jsp">Alta Alumnos</a>
					</li>	
					<li class="nav-item">
	          			<a class="nav-link" href="BajaAlumno.jsp">Baja Alumnos</a>
					</li>	
	        		<li class="nav-item">
	          			<a class="nav-link active" href="AltaCurso.jsp">Alta Curso</a>
					</li>
	        		<li class="nav-item">
	          			<a class="nav-link" href="CargarNotas.jsp">Cargar notas</a>
					</li>
					<li class="nav-item">
	          			<a class="nav-link" href="AltaDocente.jsp">Alta Docentes</a>
					</li>
					<li class="nav-item">
	          			<a class="nav-link" href="BajaDocente.jsp">Baja Docentes</a>
					</li>
				</ul>
				<ul class="navbar-nav justify-content-end">
			 	    <li class="nav-item">
			          <label class="nav-link"> Usuario</label>
			        </li>	
				</ul>
			</div>
		</div>
	</nav>
	<div class="row" align="center">
		<h3>Alta Curso</h3>
	</div>
	<div class="row">
		<div class="col-2"></div>
		<div class="col-8">
			<div class="container text-center my-5 "> 
				<div id="card" class="col border border-secondary rounded p-4">
					<div class="row mb-3">
						<label for="btn-Profesor">Seleccione un profesor</label>
						<div class="btn-group" id="btn-Profesor">
						  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Profesor
						  </button>
						  <div class="dropdown-menu">
						    ...
						  </div>
						</div>
					</div>
					<div class="row mb-3 text-center">
						<label for="btn-Materia">Seleccione una materia</label>
						<div class="btn-group" id="btn-Materia">
						  <button class="btn btn-secondary btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    Materia
						  </button>
						  <div class="dropdown-menu">
						    ...
						  </div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-5">
							<label>Alumnos a seleccionar</label>
							<select class="form-select" size="10" aria-label="size 3 select example">
							  <option selected>Open this select menu</option>
							  <option value="1">One</option>
							  <option value="2">Two</option>
							  <option value="3">Three</option>
							</select>
						</div>
						<div class="col-2 align-items-center pt-5">
							<button class="btn btn-warning mb-2">></button>
							<br>
							<button class="btn btn-warning"><</button>
						</div>
						<div class="col-5">
							<label>Alumnos a seleccionados</label>
							<select class="form-select" size="10" aria-label="size 3 select example">
							  <option selected>Open this select menu</option>
							  <option value="1">One</option>
							  <option value="2">Two</option>
							  <option value="3">Three</option>
							</select>
						</div>
					</div>

					
					<button type="submit" class="btn btn-primary">Confirmar</button>
				</div>
		</div>
		</div>
		<div class="col-2"></div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>