<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
    	<a class="navbar-brand" href="inicio.jsp">Home</a>
    	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      		<span class="navbar-toggler-icon"></span>
    	</button>
    	<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
				<% if(session.getAttribute("user") == null)
		 	    {%>
					<li class="nav-item">
						<a class="nav-link mx-4" aria-current="page" href="login.jsp">Login</a>
	        		</li>
		        <%}
				else if(session.getAttribute("rol").toString().equals("1"))
		        {%>
        		<li class="nav-item">
          			<a class="nav-link" href="ServletAlumno">Alta Alumnos</a>
				</li>	
				<li class="nav-item">
          			<a class="nav-link" href="ServletAltaCurso">Alta Curso</a>
				</li>
        		<li class="nav-item">
          			<a class="nav-link" href="CargarNotas.jsp">Cargar notas</a>
				</li>
				<li class="nav-item">
          			<a class="nav-link" href="ServletAltaDocente">Alta Docentes</a>
				</li>
				<li class="nav-item">
          			<a class="nav-link" href="Docentes.jsp">Listar Docentes</a>
				</li>
				<li class="nav-item">
          			<a class="nav-link" href="ServletListarAlumnos">Listar Alumnos</a>
				</li>
				<%}
				else
				{%>
				<li class="nav-item">
          			<a class="nav-link" href="ServletListarAlumnos">Listar Alumnos</a>
				</li>
				<li class="nav-item">
          			<a class="nav-link" href="CargarNotas.jsp">Cargar notas</a>
				</li>
				<%}%>
			</ul>
			<ul class="navbar-nav justify-content-end">
		 	    <li class="nav-item">
		 	    	<% if(session.getAttribute("user") != null)
		 	    	{%>
		          		<label class="nav-link" style="display: inline;"><%= session.getAttribute("name") %></label>
		          		<a class="nav-link" href="ServletLogin" style="display: inline;">Logout</a>
		          	<%}
		 	    	else 
		 	    	{ %> 
		          		<label class="nav-link">Invitado</label>
		          <%} %>
		        </li>	
			</ul>
		</div>
	</div>
</nav>