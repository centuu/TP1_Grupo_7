<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TP Integrador - Grupo N° 7</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/AltaAlumno.css">
</head>
<body>
<<<<<<< HEAD:TPINT_GRUPO_7_LAB4/WebContent/Docentes.jsp
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
	          			<a class="nav-link" href="Alumnos.jsp">lista Alumnos</a>
					</li>	
					<li class="nav-item">
	          			<a class="nav-link" href="AltaCurso.jsp">Alta Curso</a>
					</li>
	        		<li class="nav-item">
	          			<a class="nav-link" href="CargarNotas.jsp">Cargar notas</a>
					</li>
					<li class="nav-item">
	          			<a class="nav-link" href="AltaDocente.jsp">Alta Docentes</a>
					</li>
					<li class="nav-item">
	          			<a class="nav-link" href="Docentes.jsp">lista Docentes</a>
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
	
=======
	<jsp:include page="/partials/navbar.jsp" />	
>>>>>>> b811194c1481688e73c1dadbf6728d5bf4c730be:TPINT_GRUPO_7_LAB4/WebContent/BajaDocente.jsp
	<main>  
	 	<div class="row p-4">
        <div class="col col-4">
            <div class=" text-center">
                    <img src="resources/img/user2.png" width="200"alt="" />    
            </div>
            <div class="bg-secondary mt-5">
            
                   <h1>Bienvenido Admin</h1> 
            </div>
           <div class="text-center">
                <ul class="list-group">
                    <li class="list-group-item"> <a href="Docentes.jsp">Docentes</a> </li>
                    <li class="list-group-item"><a href="Alumnos.jsp">alumnos</a></li>
                    <li class="list-group-item"> <a href="Cursos.jsp">cursos </a></li>
                </ul>
            </div>
        </div>
        <div class="col col-8">
            <div class="container text-center fs-3" style="font-family:Algerian;">
                 <p> Lista Docentes</p>
              </div>
            <div class="col-12 modal-content me-5">
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
                         <td> Herrera</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                            <button type="submit" class="btn btn-success">editar</button>                         
                            <button type="submit" class="btn btn-danger">eliminar</button></td>
                       
                     </tr>
                     <tr>
                         <td>1235</td>
                         <td>Carlos</td>
                         <td>Rodriguez</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                            <button type="submit" class="btn btn-success">editar</button>                         
                            <button type="submit" class="btn btn-danger">eliminar</button></td>
                       
                     </tr>
                      <tr>
                         <td>1236</td>
                         <td>Lorena</td>
                         <td>Palermo</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                            <button type="submit" class="btn btn-success">editar</button>                         
                            <button type="submit" class="btn btn-danger">eliminar</button></td>                    
                     </tr>
                      <tr>
                         <td>1237</td>
                         <td>Angel </td>
                         <td>Simon</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                            <button type="submit" class="btn btn-success">editar</button>                         
                            <button type="submit" class="btn btn-danger">eliminar</button></td>
                       
                     </tr>
                             <tr>
                         <td>1238</td>
                         <td>Maxi</td>
                         <td> Fernandez</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                            <button type="submit" class="btn btn-success">editar</button>                         
                            <button type="submit" class="btn btn-danger">eliminar</button></td>
                       
                     </tr>
                     

                  </table>
               </div>

        </div>
    </div>
	
	</main> 
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>