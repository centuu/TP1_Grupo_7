<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Alumno" %>
<%@ page import = "entidad.Curso" %>
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
						<div class="col-2">
							<select class="btn btn-secondary form-control form-control-sm">
								<option value="" selected disabled hidden>Seleccione</option>
								<%
									ArrayList<Curso> cursos = (ArrayList<Curso>)request.getAttribute("cursos");
							
									for(Curso curso : cursos)
									{
								%>
									<option value=<%= curso.getIdCurso() %>><%= curso.getIdCurso() %></option>
									
								<%
									}
								%>
							</select>
						</div>
						<button name="btnlistar" type="submit" class="btn btn-primary col-1">Listar</button>
					</div>
					<div class="col-12 modal-content">
		                <table id="table_id" class="w3-table w3-striped" cellpadding="5" cellspacing="5">
		                    <tr class="alert-primary">
		                        <th scope="col">Legajo</th>
		                        <th scope="col">Nombre</th>
		                        <th scope="col">Apellido</th>
		                        <th scope="col">Fecha Nac.</th>
		             
		                        <th scope="col"> </th>   
		                        <th scope="col"> </th>                   
		                    </tr>
		                    
		                    	<%
								  	ArrayList<Alumno> alumnos = (ArrayList<Alumno>)request.getAttribute("alumnos");	
										
									for(Alumno alumno : alumnos)
									{
								%>
										<tr>
											<form action="alumno" method="GET">
												<td><%= alumno.getLegajo()  %></td> 
												<input name="legajo" type="hidden" value="<%=alumno.getLegajo()%>" >
						                       	<td><%= alumno.getNombre() %></td>
						                       	<td><%= alumno.getApellido() %></td>
						                       	<td><%= alumno.getFechaNac() %></td>			                   
						                        <td>			                        
						                         	<button name="btninfo" type="submit" class="btn btn-info mx-0">Detalle</button>
						                            <button name="btneditar"type="submit" class="btn btn-success mx-0">Editar</button>              
						                            <button name="btneliminar" type="submit" class="btn btn-danger" onclick="return confirm('Desea eliminar este alumno?')">Eliminar</button>
						                        </td>
				                     		</form>
						               	</tr>
								<%
									}
								%>
						</table>						
					    <a href="listaralumnos?page=${currentPage - 1}"><</a> Página ${currentPage} de ${noOfPages} <a href="listaralumnos?page=${currentPage + 1}">></a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html> 
