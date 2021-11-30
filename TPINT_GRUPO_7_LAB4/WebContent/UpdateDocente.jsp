<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Nacionalidad" %>
<%@ page import = "entidad.Docente" %>
<%@ page import = "daoImpl.NacionalidadDaoImpl" %>
<%@ page import = "daoImpl.AlumnoImpl" %>
<%@ page import = "entidad.Localidad" %>
<%@ page import = "daoImpl.LocalidadDaoImpl" %>
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
	<jsp:include page="/partials/Confirmation.jsp" />	
	<main>     
		<% Docente docente = (Docente)request.getAttribute("docente"); %>
       	
       	<form action="altadocente" method="post" class="needs-validation" novalidate id="form">
		 <div class="container text-center my-5 "> 
		  <div class="row ">
		     <div class="col-lg-4"></div> 
			     <div class="col-lg-4 border border-primary rounded p-4 bg-light">  
			     	<h1>Detalle Docente </h1>           
			     	<br>
			        <div class="row mb-3 text-center">
			          	<label  class="from-group">Legajo</label>
			           	<input type="text" readonly name="txtLegajo" class="form-control" value=<%= docente.getLegajo() %>>
				        </div>
				        <div class="row mb-3 text-center">
				          	<label  class="from-group">DNI</label>
				           	<input type="text" value="<%=docente.getDni() %>" name="txtdni" class="form-control" pattern="[0-9]{7,8}" maxlength="8" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" required <%= request.getAttribute("readOnly")  %> >
				           	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>
				        </div>
				        <div class="row mb-3 text-center">
				         	<label  class="from-group">Nombre</label>
				           	<input type="text" value="<%=docente.getNombre() %>" name="txtnombre" class="form-control" <%= request.getAttribute("readOnly")  %> pattern="^(?=.{3,30}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$" required>
				           	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>
				        </div>
				        <div class="row mb-3 text-center">
				          	<label  class="from-group">Apellido</label>
				           	<input type="text" value="<%=docente.getApellido() %>" name="txtapellido" class="form-control" <%= request.getAttribute("readOnly")  %> pattern="^(?=.{3,30}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$" required >
				         	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>
				        </div>
				        <div class="row mb-3 text-center">
				          	<label  class="from-group">Fecha Nacimiento</label>
				           	<input type="text"value="<%=docente.getFechaNac() %>" name="txtfechanac" class="form-control" <%= request.getAttribute("readOnly")  %> placeholder="yyyy/mm/dd" pattern="[0-9]{4}[\/|-](0[1-9]|1[0-2])[\/|-]([0-2][0-9]|3[0-1])" required >
				         	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>				           	
				        </div>
				        <div class="row mb-3 text-center">
				          	<label class="from-group">Direccion</label>
				           	<input type="text"value="<%=docente.getDireccion() %>" name="txtdireccion" class="form-control" <%= request.getAttribute("readOnly")  %> required>
				         	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>				           	
				        </div>
				          <div class="row mb-3 text-center">
				          	<label hidden id="docenteLocalidad" value=<%= request.getAttribute("localidad") %>></label>
				           	<label  class="from-group">Localidad</label>
				          	<select name="localidad" id="localidades" <%= request.getAttribute("readOnly") != "" ? "disabled=true" : "" %>>
									<%
									     LocalidadDaoImpl locDao= new LocalidadDaoImpl(); 
								  		ArrayList<Localidad> localidades =locDao.list();	
										
								  		if (localidades!=null)
								  		{
										  for(Localidad localidad : localidades)
										  {
									  %>
											<option value="<%= localidad.getId() %>"><%= localidad.getNombre() %></option>
									  <%
										  }
								  		}
									%>
							</select>
				        </div>
				        <div class="row mb-3 text-center"> 
				        	<label hidden id="docenteNacionalidad" value=<%= request.getAttribute("nacionalidad") %>></label>				        	
				        	<label  class="from-group">Nacionalidad</label>
					       <select name="nacionalidad" id="nacionalidades" <%= request.getAttribute("readOnly") != "" ? "disabled=true" : "" %>>
				                  <%  NacionalidadDaoImpl nacionDao =new  NacionalidadDaoImpl ();
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
				           	<input type="email" value="<%=docente.getMail() %>" name="txtmail" class="form-control" id="inputPassword3" <%= request.getAttribute("readOnly")  %> required>
				         	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>				           	
				        </div>
				         <div class="row mb-3 text-center">
				          	<label  class="from-group">Telefono</label>
				           	<input type="text" value="<%=docente.getTelefono() %>" name="txttelefono" class="form-control" id="inputPassword3" <%= request.getAttribute("readOnly")  %> pattern="[0-9]+" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" required>
				         	<div class="valid-feedback"></div>
		           			<div class="invalid-feedback">Campo Obligatorio</div>				           	
				        </div>
				      	<div class="row mb-3 text-center">
				       		<button name="btnregistrar" id="btnregistrar" type="button" class="btn btn-primary mb-1" <%= request.getAttribute("readOnly") != "" ? "hidden=true" : "" %> data-toggle="modal" data-target="#modalpopup">Guardar cambios</button>
				       		<button name="btnVolver" type="button" onclick="window.location.href='listardocentes?page=1'" class="btn btn-danger">Volver</button>
				     	</div>
						<div class="col-lg-4"></div>
					</div>  
				</div>
			</div>
		</form>	    
	</main> 
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	<script>
		for(var i = 0; i < document.getElementById("nacionalidades").length ; i++) 
		{
		    if(document.getElementById("nacionalidades")[i].getAttribute("value") == document.getElementById("docenteNacionalidad").getAttribute("value"))
		       document.getElementById("nacionalidades").selectedIndex = i;
		}
	
		for(var i = 0; i < document.getElementById("localidades").length ; i++) 
		{
		    if(document.getElementById("localidades")[i].getAttribute("value") == document.getElementById("docenteProvincia").getAttribute("value"))
		       document.getElementById("localidades").selectedIndex = i;
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