
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Curso" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Vista Docente</title>

      <link rel="stylesheet" type="text/css" href="resources/css/VistaDocente.css?1.0" media="all"/>

  </head>
  <body>
  	<jsp:include page="/partials/navbar.jsp" />

       <div class="container text-center" style="margin-top:100px;">
         <div class="row">
           <div class=" colum col col-lg-4 col-md-3 col-sm-12  ">
                <div class="">
                  <img src="resources/img/profe.png" height=300" alt="" />  
                </div>
           </div>
           <div class="col col-lg-8 col-md-9 col-sm  ">
            <div class="mb-3 ">
                 <h1>Mis Cursos</h1>
                 
 
                 <div class="col-12 modal-content">
		                <table class="table table-hover table-striped">
		                    <tr class="alert-primary">
		                        <th scope="col">curso</th>
		                        <th scope="col">materia</th>
		                        <th scope="col">semestre</th>
		                        <th scope="col">año</th>
		             
		                        <th scope="col"> </th>   
		                        <th scope="col"> </th>                   
		                  </tr>
		                  
            <%  if((ArrayList<Curso>)request.getAttribute("listaCurso")!=null)
                  {
					ArrayList<Curso> cursos = (ArrayList<Curso>)request.getAttribute("listaCurso");
                  
                 
									
								for(Curso curso : cursos)
								{
								%>
									<tr>
										<form action="alumno" method="GET">
											<td><%= curso.getIdCurso()  %></td> 
					                       	<td><%= curso.getdesMateria() %></td>
					                       	<td><%= curso.getSemestre() %></td>
					                       	<td><%= curso.getAnio() %></td>			                   
					                        <td>			                        
					                         	<button name="btninfo" type="submit" class="btn btn-info mx-0">Alumnos</button>
					                      
					                        </td>
			                     		</form>
					               	</tr>
								<%
								}
                  
                  }		%>
                 
            </div>
          </div>

         </div>

       </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
 
  </body>
</html>