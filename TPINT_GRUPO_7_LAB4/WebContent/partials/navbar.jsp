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
			        else
			        {%>
	        		<li class="nav-item">
	          			<a class="nav-link" href="AltaAlumno.jsp">Alta Alumnos</a>
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
	          			<a class="nav-link" href="Docentes.jsp">Listar Docentes</a>
					</li>
					<li class="nav-item">
	          			<a class="nav-link" href="Alumnos.jsp">Listar Alumnos</a>
					</li>
					<%} %>
				</ul>
				<ul class="navbar-nav justify-content-end">
			 	    <li class="nav-item">
			 	    	<% if(session.getAttribute("user") != null)
			 	    	{%>
			          		<label class="nav-link" style="display: inline;"><%= session.getAttribute("name") %></label>
			          		<a class="nav-link" href="ServletLogin" style="display: inline;">logout</a>
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