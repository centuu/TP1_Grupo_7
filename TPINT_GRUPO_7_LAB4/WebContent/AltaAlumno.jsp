<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TP Integrados </title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/AltaAlumno.css">
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
						<a class="nav-link mx-4" aria-current="page" href="login.jsp">Login</a>
	        		</li>
	        		<li class="nav-item">
	          			<a class="nav-link active" href="AltaAlumno.jsp">Alta alumno</a>
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
	
	<main>  
	 	<h1>Registro docentes </h1>           
		<form method="post">
		 <div class="container text-center my-5 "> 
		  <div class="row ">
		     <div class="col-lg-4"></div> 
		     <div class="col-lg-4 border border-primary rounded p-4 bg-light">  
		       	<div class="row mb-3">
		         	<label class="from-group">Legajo</label>
		           	<input type="text" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">DNI</label>
		           	<input type="text" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		         	<label  class="from-group">Nombre</label>
		           	<input type="text" class="form-control">
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Apellido</label>
		           	<input type="text" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">fecha Nacimiento</label>
		           	<input type="text" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		          	<label class="from-group">Direccion</label>
		           	<input type="text" class="form-control" >
		        </div>
		          <div class="row mb-3 text-center">
		          	<label  class="from-group">Localidad</label>
		           	<input type="text" class="form-control" id="inputPassword3">
		        </div>
		         <div class="row mb-3 text-center">
		          	<label  class="from-group">Nacionalidad</label>
		           	<input type="text" class="form-control" id="inputPassword3">
		        </div>
		         <div class="row mb-3 text-center">
		          	<label  class="from-group">email</label>
		           	<input type="text" class="form-control" id="inputPassword3">
		        </div>
		         <div class="row mb-3 text-center">
		          	<label  class="from-group">Telefono</label>
		           	<input type="text" class="form-control" id="inputPassword3">
		        </div>
		      	<div class="row mb-3 text-center">
		       		<button type="submit" class="btn btn-primary">Registrar</button>
		     	</div>
				<div class="col-lg-4"></div>
			</div>  
		</form>
	</main> 
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>