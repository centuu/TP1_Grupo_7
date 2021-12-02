<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Curso" %>
<%@ page import = "entidad.Alumno" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TP Integrador - Grupo N° 7</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/CargarNotas.css">
</head>
<body>
	<jsp:include page="/partials/navbar.jsp" />
	<jsp:include page="/partials/Confirmation.jsp" />
	<form id="form" action="notas" method="POST">
	<div class="row">
		<div class="col-2"></div>
		<div class="col-8 w-100">
			<div class="container text-center my-5 "> 
				<div id="card" class="col border border-secondary rounded p-4">
					<h1>Cargar notas</h1>
					<br>
					<div class="form-group row">	
					<label class="col-1 col-form-label">Curso: </label>
					<div class="col-2">
					<label class="col-2 col-form-label" style="width: 358px; "><b><%= request.getParameter("cursodes").toString() %></b></label>
					<input type="text" name="idCurso" value= "<%= request.getParameter("IdCurso").toString()%>" hidden ></input>
					</div>
					<div class="row">
						<div class="col-12">
							<table class="table">
							  <thead>
							    <tr>
							      <th scope="col">Legajo</th>
							      <th scope="col">Nombre</th>
							      <th scope="col">Apellido</th>
							      <th scope="col">Nota 1</th>
							      <th scope="col">Nota 2</th>
							      <th scope="col">Rec. 1</th>
							      <th scope="col">Rec. 2</th>
							      <th scope="col">Condición</th>
							    </tr>
							  </thead>
							  <tbody>
							    <tr>
							<%  if(request.getAttribute("listaCursada")!=null)
                               {
					              ArrayList<Alumno> listcursada = (ArrayList<Alumno>)request.getAttribute("listaCursada");
				
								for(int i = 0 ; i<listcursada.size(); i++ )
								{
								%>
								    <td name="legajo"><%= listcursada.get(i).getLegajo()  %></td> 
					              	<td name="nombre"><%= listcursada.get(i).getNombre() %></td>
					               	<td name="apellido"><%= listcursada.get(i).getApellido() %></td>
					               	<td>
									<input type="text" name="nota1_<%=i %>" class="form-control" value="<%= listcursada.get(i).getNota_pri() %>">
								    </td>
				    			  <td>
						           	<input type="text" name="nota2_<%=i %>" class="form-control" value="<%= listcursada.get(i).getNota_seg() %>">
							      </td>
							      <td>
									<input type="text" name="rec1_<%=i %>" class="form-control" value="<%= listcursada.get(i).getRec_pri() %>">
								 </td>
								 <td>
									<input type="text" name="rec2_<%=i %>" class="form-control" value="<%= listcursada.get(i).getRec_seg() %>">
								 </td>
							      <td>
									<input type="text" name="condicion_<%=i %>" class="form-control" value="<%= listcursada.get(i).getCondicion() %>" placeholder="Regular/Libre">
							      </td>
							    </tr>
							    
							    <%}
							    } %>
							    
							    
							  </tbody>
							</table>
						</div>
					</div>
					<div class="col-md-12 school-options-dropdown text-center">
						<button name="btnconfirmar" class="btn btn-primary text-center" type="button" data-toggle="modal" data-target="#modalpopup">
							Confirmar
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="col-2"></div>
	</div>
	</div>
	</form>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
 	<script>	
	 	document.getElementById("alert").addEventListener('click', function (event)
	 	{
	 		$(".alert").alert('close');
	 	})
 	</script>
</body>
</html>