<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Nacionalidad" %>
<%@ page import = "entidad.Alumno" %>
<%@ page import = "daoImpl.NacionalidadDaoImpl" %>
<%@ page import = "daoImpl.AlumnoImpl" %>
<%@ page import = "entidad.Provincia" %>
<%@ page import = "daoImpl.ProvinciaDaoImpl" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>TP Integrador - Grupo N° 7</title>
 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/AltaAlumno.css">
</head>
<body>
	<jsp:include page="/partials/navbar.jsp" />
	<main>     
		<% Alumno alumno = (Alumno)request.getAttribute("alumno"); %>
       	<form action="alumno" method="post" class="needs-validation" novalidate id="form">
		 <div class="container text-center my-5 "> 
		  <div class="row ">
		     <div class="col-lg-4"></div> 
			     <div class="col-lg-4 border border-primary rounded p-4 bg-light">  
			     	<h1>Registro Alumnos </h1>           
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
			        <div class="row mb-3 text-center">
			          	<label  class="from-group">Legajo</label>
			           	<input type="text" readonly name="txtLegajo" class="form-control" value=<%= alumno.getLegajo() %>>
				        </div>
				        <div class="row mb-3 text-center">
				          	<label  class="from-group">DNI</label>
				           	<input type="text" value="<%=alumno.getDni() %>" name="txtdni" class="form-control" <%= request.getAttribute("readOnly")  %> >
				        </div>
				        <div class="row mb-3 text-center">
				         	<label  class="from-group">Nombre</label>
				           	<input type="text" value="<%=alumno.getNombre() %>" name="txtnombre" class="form-control" <%= request.getAttribute("readOnly")  %>>
				        </div>
				        <div class="row mb-3 text-center">
				          	<label  class="from-group">Apellido</label>
				           	<input type="text" value="<%=alumno.getApellido() %>" name="txtapellido" class="form-control" <%= request.getAttribute("readOnly")  %> >
				        </div>
				        <div class="row mb-3 text-center">
				          	<label  class="from-group">Fecha Nacimiento</label>
				           	<input type="text"value="<%=alumno.getFechaNac() %>" name="txtfechanac" class="form-control" <%= request.getAttribute("readOnly")  %> >
				        </div>
				        <div class="row mb-3 text-center">
				          	<label class="from-group">Direccion</label>
				           	<input type="text"value="<%=alumno.getDireccion() %>" name="txtdireccion" class="form-control" <%= request.getAttribute("readOnly")  %> >
				        </div>
				          <div class="row mb-3 text-center">
				          	<label hidden id="alumnoProvincia" value=<%= request.getAttribute("provincia") %>></label>		
				          	<label  class="from-group">Provincia</label>
				           	<select name="provincia" id="provincias" <%= request.getAttribute("readOnly") != "" ? "disabled=true" : "" %>>
									<%
									    ProvinciaDaoImpl proviDao= new ProvinciaDaoImpl(); 
								  		ArrayList<Provincia> provincias =proviDao.list();	
										
								  		if (provincias!=null)
								  		{
										  for(Provincia provincia : provincias)
										  {
									  %>
											<option value="<%= provincia.getId() %>"><%= provincia.getNombre() %></option>
									  <%
										  }
								  		}
									%>
							</select>
				        </div>
				        <div class="row mb-3 text-center"> 
				        	<label hidden id="alumnoNacionalidad" value=<%= request.getAttribute("nacionalidad") %>></label>				        	
				        	<label  class="from-group">Nacionalidad</label>
					       <select name="nacionalidad" id="nacionalidades" <%= request.getAttribute("readOnly") != "" ? "disabled=true" : "" %>>
				                  <%  
				                  		NacionalidadDaoImpl nacionDao =new  NacionalidadDaoImpl ();
				                       	ArrayList<Nacionalidad> lista=nacionDao.list();
		         
		                          if (lista!=null)
		                          {
		                            for(Nacionalidad na:lista) 
		                            {
		                          	%>
		                          	  <option value="<%=na.getId() %>"><%=na.getNombre() %></option>
		
		                          <%}
		                          }%>
		                         </select>
				        </div>
				         <div class="row mb-3 text-center">
				          	<label  class="from-group">Email</label>
				           	<input type="text" value="<%=alumno.getMail() %>" name="txtmail" class="form-control" id="inputPassword3" <%= request.getAttribute("readOnly")  %>>
				        </div>
				         <div class="row mb-3 text-center">
				          	<label  class="from-group">Telefono</label>
				           	<input type="text" value="<%=alumno.getTelefono() %>" name="txttelefono" class="form-control" id="inputPassword3" <%= request.getAttribute("readOnly")  %>>
				        </div>
				      	<div class="row mb-3 text-center">
				       		<button name="btnguardar" id="btnguardar" type="submit" class="btn btn-primary mb-1" data-toggle="modal" data-target="#modalpopup" <%= request.getAttribute("readOnly") != "" ? "hidden=true" : "" %>>Guardar cambios</button>
				       		
				       		<button name="btnVolver" type="button" onclick="window.location.href='listaralumnos?page=1'" class="btn btn-danger">Volver</button>
				     	</div>
						<div class="col-lg-4"></div>
					</div>  
				</div>
			</div>
		</form>	    
	</main> 
	<script>
		for(var i = 0; i < document.getElementById("nacionalidades").length ; i++) 
		{
		    if(document.getElementById("nacionalidades")[i].getAttribute("value") == document.getElementById("alumnoNacionalidad").getAttribute("value"))
		       document.getElementById("nacionalidades").selectedIndex = i;
		}
	
		for(var i = 0; i < document.getElementById("provincias").length ; i++) 
		{
		    if(document.getElementById("provincias")[i].getAttribute("value") == document.getElementById("alumnoProvincia").getAttribute("value"))
		       document.getElementById("provincias").selectedIndex = i;
		}
	</script>
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script> 		
 	(function()
 	{
 		var forms = $(".needs-validation");
 		
		Array.prototype.slice.call(forms).forEach(function (form) 
		{
		    form.addEventListener('click', function (event) 
		    {
		      if (!form.checkValidity()) 
		      {
		        event.preventDefault()
		        event.stopPropagation()
		      }
		      form.classList.add('was-validated')
		    }, false)
		})
 	})()

 	document.getElementById("alert").addEventListener('click', function (event)
 	{
 		$(".alert").alert('close');
 	})
 	</script>
</body>
</html>