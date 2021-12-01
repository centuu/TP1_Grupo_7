<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Alumno" %>
<%@ page import = "entidad.Docente" %>
<%@ page import = "entidad.Materia" %>
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
	<jsp:include page="/partials/navbar.jsp" />
	<div class="row">
		<div class="col-2"></div>
		<div class="col-8">
			<div class="container text-center my-5 "> 
				<div id="card" class="col border border-secondary rounded p-4">
					<h1>Alta Curso</h1>
					<br>
					<%
						if(request.getAttribute("messageSuccess") != null)
						{
			     	%>
			     			<div class="alert alert-success alert-dismissible fade show" role="alert" id="alert">
							  <div class="row justify-content-end mb-1">
							  <div class="col-11"></div>
							  	<div type="button" class="close col-1" data-dismiss="alert" aria-label="Close"></div>
							  </div>
							  <%= request.getAttribute("messageSuccess") %>
							</div>
					<%
						}
			   			if(request.getAttribute("messageError") != null)
			   			{
			   		%>
			   				<div class="alert alert-danger alert-dismissible fade show" role="alert" id="alert">
							  <div class="row justify-content-end mb-1">
							  <div class="col-11"></div>
							  	<div type="button" class="close col-1" data-dismiss="alert" aria-label="Close"></div>
							  </div>
							  <%= request.getAttribute("messageError") %>
							</div>
			   		<%
			   			}
					%>
					<form action="altacurso" method="POST">
						<div class="row mb-3 justify-content-center">
							<label for="btn-Profesor">Seleccione un profesor</label>
							<select name="docente" class="btn btn-secondary form-control form-control-sm" style="width: auto;">
								<%
							  		ArrayList<Docente> docentes = (ArrayList<Docente>)request.getAttribute("docentes");	
									
									for(Docente docente : docentes)
									{
								%>
										<option value=<%= docente.getLegajo() %>><%= docente.getNombre() + " " + docente.getApellido() %></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="row mb-3 justify-content-center">
							<label for="btn-Profesor">Seleccione una materia</label>
							<select name="materia" class="btn btn-secondary form-control form-control-sm" style="width: auto;">
								<%
							  		ArrayList<Materia> materias = (ArrayList<Materia>)request.getAttribute("materias");	
									
									for(Materia materia : materias)
									{
								%>
										<option value=<%= materia.getId() %>><%= materia.getDescripcion() %></option>
								<%
									}
								%>
							</select>
						</div>
						<div class="row mb-3 justify-content-center">
							<label for="btn-Año">Seleccione Turno</label>
								<select name="turno" id="turno-dropdown" class="btn btn-secondary form-control form-control-sm" style="width: auto;">
								</select>
						</div>
						<div class="row mb-3 justify-content-center">
							<label for="btn-Año">Seleccione Año</label>
								<select name="año" id="date-dropdown" class="btn btn-secondary form-control form-control-sm" style="width: auto;">
								</select>
						</div>								
						<div class="row">
							<div class="col-5">
								<label>Alumnos a seleccionar</label>
								<select class="form-select" id="alumnosASeleccionar" size="10" aria-label="size 3 select example">
								  	<%
								  		ArrayList<Alumno> alumnos = (ArrayList<Alumno>)request.getAttribute("alumnos");	
										
										for(Alumno alumno : alumnos)
										{
									%>
											<option value=<%= alumno.getLegajo() %>> <%= alumno.getNombre() + " " + alumno.getApellido() %> </option>
									<%
										}
									%>
								</select>
							</div>
							<div class="col-2 align-items-center pt-5">
								<button id="btnRight" type="button" class="btn btn-warning mb-2">></button>
								<br>
								<button id="btnLeft" type="button" class="btn btn-warning"><</button>
							</div>
							<div class="col-5">
								<input type="text" class="form-control" name="alumnos" hidden id="alumnos" value="">
								<label>Alumnos a seleccionados</label>
								<select class="form-select" id="alumnosSeleccionados" size="10" aria-label="size 3 select example"></select>
							</div>
						</div>					
						<button type="submit" class="btn btn-primary">Confirmar</button>
					</form>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
	</div>
	<script src="./resources/js/AltaCurso.js"></script>
	<script>
		  let dateDropdown = document.getElementById('date-dropdown');    
		  let currentYear = new Date().getFullYear();    
		  let nextYear = currentYear + 1;         
		    let dateOption = document.createElement('option');          
		    dateOption.text = currentYear;      
		    dateOption.value = currentYear;        
		    dateDropdown.add(dateOption);
		    dateOption = document.createElement('option');          
		    dateOption.text = nextYear;      
		    dateOption.value = nextYear;        
		    dateDropdown.add(dateOption); 
	</script>
	<script>
	let turnoDropdown = document.getElementById('turno-dropdown');
	let turnoOption = document.createElement('option');
	turnoOption.text="1C-TM";
	turnoOption.value="1C-TM";
	turnoDropdown.add(turnoOption);
	turnoOption = document.createElement('option');
	turnoOption.text="2C-TM";
	turnoOption.value="2C-TM";
	turnoDropdown.add(turnoOption);
	turnoOption = document.createElement('option');
	turnoOption.text="1C-TT";
	turnoOption.value="1C-TT";
	turnoDropdown.add(turnoOption);
	turnoOption = document.createElement('option');
	turnoOption.text="2C-TT";
	turnoOption.value="2C-TT";
	turnoDropdown.add(turnoOption);
	</script>
</body>
</html>