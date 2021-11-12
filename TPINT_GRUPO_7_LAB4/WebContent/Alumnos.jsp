<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TP Integrador - Grupo N° 7</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/ListarAlumnos.css">
</head>
<body>
	<jsp:include page="/partials/navbar.jsp" />

	<div class="row">
		<div class="col-2"></div>
		<div class="col-8">
			<div class="container text-center my-5 "> 
				<div id="card" class="col border border-secondary rounded p-4">
					<h1>Listado Alumnos</h1>
					<br>
					<div class="form-group row">	
						<label for="inputFilter" class="col-2 col-form-label">Filtro</label>
						<div class="col-4"> 
							<input type="text" class="form-control" id="inputFilter">
						</div>
						<label class="col-1 col-form-label">Curso</label>
						<div class="col-3 school-options-dropdown text-center">
							<div class="dropdown">
							  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    Seleccionar curso
							  </button>
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <a class="dropdown-item" href="#">Action</a>
							    <a class="dropdown-item" href="#">Another action</a>
							    <a class="dropdown-item" href="#">Something else here</a>
							  </div>
							</div>
						</div>
						<button class="btn btn-primary col-1">Listar</button>
					</div>
					<div class="col-12 modal-content">
		                <table class="table table-hover table-striped">
		                    <tr class="alert-primary">
		                        <th scope="col">Legajo</th>
		                        <th scope="col"> Nombre</th>
		                        <th scope="col">Apellido</th>
		                        <th scope="col"> </th>           
		                    </tr>
		                    <tr>
		                         <td>1234</td>
		                         <td>Tamara </td>
		                         <td>Herrera</td>
		                         <td class="row justify-content-end">
		                         	<div class="col-6"></div>	
		                         	<div class="col-6">
			                         	<button type="submit" class="btn btn-info mx-0">Info</button>
			                            <button type="submit" class="btn btn-success">Editar</button>                         
			                            <button type="submit" class="btn btn-danger">Eliminar</button>
		                         	</div>
		                         </td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html> 
