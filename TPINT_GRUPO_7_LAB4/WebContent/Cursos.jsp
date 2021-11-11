<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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
	  <nav class="navbar sticky-top bg-light">
        <div class=" mx-auto">
                <form class="d-flex">
                   <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Buscar</button>
               </form>
         </div>
      </nav>

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
                    <li class="list-group-item"> <a href="AltaCurso.jsp">cursos </a></li>
                </ul>
            </div>
        </div>
        <div class="col col-8">
            <div class="container text-center fs-3" style="font-family:Algerian;">
                 <p> Lista Curso</p>
              </div>
            <div class="col-12 modal-content me-5">
                <table class="table table-hover table-striped">
                    <tr class="alert-primary">
                        <th scope="col">codigo</th>
                        <th scope="col"> Nombre</th>
                        <th scope="col">año</th>
                        <th scope="col"> </th>           

                    </tr>
                     <tr>
                         <td>001</td>
                         <td>Programacion</td>
                         <td> 2021</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                       
                     </tr>
                     <tr>
                         <td>002</td>
                         <td>Metodologia de sistemas</td>
                         <td> 2020</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                     </tr>
                      <tr>
                         <td>003</td>
                         <td>Lavoratorio 4</td>
                         <td> 2021</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>               
                     </tr>
                      <tr>
                         <td>004</td>
                         <td>Matematica 1</td>
                         <td> 2019</td>
                         <td><button type="submit" class="btn btn-info mx-0">info</button>
                       
                     </tr>

                  </table>
               </div>

        </div>
    </div>
	
</body>
</html>