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
					<label>Listado Alumnos</label>
					<div class="form-group row">	
						<label for="inputFilter" class="col-2 col-form-label">Filtro</label>
						<div class="col-10"> 
							<input type="text" class="form-control" id="inputFilter">
						</div>
					</div>
					<select class="form-select" size="20" aria-label="size 3 select example">
					  <option selected>Open this select menu</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
					</select>
					<br>
					<button class="btn btn-primary">Listar</button>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>