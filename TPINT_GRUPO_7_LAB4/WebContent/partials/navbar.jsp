<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
   <link rel="stylesheet" type="text/css" href="resources/css/partial.css?1.0" media="all"/>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
    	<a class="navbar-brand ms-5" href="inicio">Home</a>
    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mx-auto mb-2 mb-lg-0 ">
				<%	if(session.getAttribute("user") == null)
		 	    	{
		 	    %>
						<li class="nav-item">
							<label class="navbar-brand">Invitado</label>
		        		</li>
		        <%
		        	}
					else if(session.getAttribute("rol").toString().equals("1"))
		        	{
		        %>
		        		<li class="nav-item">
		          			<a class="nav-link" href="alumno">Alta Alumnos</a>
						</li>	
						<li class="nav-item">
		          			<a class="nav-link" href="altacurso">Alta Curso</a>
						</li>
						<li class="nav-item">
		          			<a class="nav-link" href="altadocente">Alta Docentes</a>
						</li>
						<li class="nav-item">
		          			<a class="nav-link" href="listardocentes?page=1">Listar Docentes</a>
						</li>
						<li class="nav-item">
		          			<a class="nav-link" href="listaralumnos?page=1">Listar Alumnos</a>
						</li>
				<%
					}
				    else if(session.getAttribute("rol").toString().equals("2"))
				    {
				%>
		        		<li class="nav-item">
		          			<a class="nav-link" href="vistaDocente">Mis cursos</a>
						</li>
						<li class="nav-item">
		          			<a class="nav-link" href="CargarNotas">Cargar Notas</a>
						</li>
						<li class="nav-item">
		          			<a class="nav-link" href="listaralumnos?page=1">Alumnos</a>
						</li>
				<% 
				 	}				
				%>
			</ul>	
		 	    <% 
		 	    	if(session.getAttribute("user") != null)
		 	    	{
		 	    %>
		          		<label class="navbar-brand" "><%= session.getAttribute("name") %></label>
		          		<a class="nav-link me-5 " href="login" style="display: inline;">Logout</a>
		        <%
		        	}
		 	    	else 
		 	    	{
		 	    %> 
		          		<a class="nav-link me-5 " href="login" style="display: inline;">LogIn</a>
		        <%
		        	}
		 	   	%>
		</div>
	</div>
</nav>