<%@ page import = "java.util.ArrayList" %>
<%@ page import = "entidad.Nacionalidad" %>
<%@ page import = "daoImpl.NacionalidadDaoImpl" %>
<%@ page import = "entidad.Docente" %>
<%@ page import = "entidad.Localidad" %>
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
	<jsp:include page="/partials/navbar.jsp" />
	<jsp:include page="/partials/Confirmation.jsp" />
	<main>  
		<form action="altadocente" method="post" class="needs-validation" novalidate id="form">
		 <div class="container text-center my-5 "> 
			<div class="row ">
			    <div class="col-lg-4"></div> 
			    <div class="col-lg-4 border border-primary rounded p-4 bg-light">  
			    	<h1>Registro Docentes</h1>           
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
		          	<% 
						String legajo = (String)request.getAttribute("nextLegajo");
		          	%>
		           	<input type="text" readonly name="txtLegajo" class="form-control" value=<%= legajo %>>
	        		</div>
			       <div class="row mb-3 text-center">
			         	<label  class="from-group">DNI</label>
			          	<input type="text" pattern="[0-9]{7,8}" maxlength="8" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" name="txtdni" class="form-control" required>
		           		<div class="valid-feedback"></div>
		           		<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			       <div class="row mb-3 text-center">
			        	<label  class="from-group">Nombre</label>
			          	<input type="text" name="txtnombre" class="form-control" pattern="^(?=.{3,30}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$" required>
		           		<div class="valid-feedback"></div>
		           		<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			       <div class="row mb-3 text-center">
			         	<label  class="from-group">Apellido</label>
			          	<input name="txtapellido" type="text" class="form-control" pattern="^(?=.{3,30}$)[A-ZÁÉÍÓÚ][a-zñáéíóú]+(?: [A-ZÁÉÍÓÚ][a-zñáéíóú]+)?$" required>
			          	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			       <div class="row mb-3 text-center">
			         	<label  class="from-group">Fecha Nacimiento</label>
			          	<input name="txtfechanac" type="text" class="form-control" placeholder="yyyy/mm/dd" pattern="[0-9]{4}[\/](0[1-9]|1[0-2])[\/]([0-2][0-9]|3[0-1])" required>
			        	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			       <div class="row mb-3 text-center">
			         	<label class="from-group">Direccion</label>
			          	<input name="txtdireccion" type="text" class="form-control" required>
			          	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
    		          <div class="row mb-3 text-center">
		          	<label  class="from-group">Localidad</label>
		           	<select name="Localidad">
							<%
						  		ArrayList<Localidad> localidades = (ArrayList<Localidad>)request.getAttribute("localidades");	
								
								for(Localidad localidad : localidades)
								{
							%>
									<option value=<%= localidad.getId() %>><%= localidad.getNombre() %></option>
							<%
								}
							%>
					</select>
		        	</div>
				   <div class="row mb-3 text-center"> 
			        	<label  class="from-group">Nacionalidad</label>
				        <select name="nacionalidad">
								<%
							  		ArrayList<Nacionalidad> nacionalidades = (ArrayList<Nacionalidad>)request.getAttribute("nacionalidades");	
									
									for(Nacionalidad nacionalidad : nacionalidades)
									{
								%>
										<option value=<%= nacionalidad.getId() %>><%= nacionalidad.getNombre() %></option>
								<%
									}
								%>
						</select>
			        </div>
			        <div class="row mb-3 text-center">
			         	<label  class="from-group">Email</label>
			          	<input name="txtmail" type="email" class="form-control" id="inputPassword3" required>
			          	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			        <div class="row mb-3 text-center">
			         	<label  class="from-group">Telefono</label>
			          	<input type="text" name="txttelefono" class="form-control" id="inputPassword3" pattern="[0-9]+" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" required>
			         	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			 		     <div class="row mb-3 text-center">
			         	<label  class="from-group">Contraseña</label>
			          	<input type="password" class="form-control" id="inputPassword4" name="txtclave" required>
			          	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			 		     <div class="row mb-3 text-center">
			         	<label  class="from-group">Repetir contraseña</label>
			          	<input type="password" class="form-control" id="inputPassword5" name="txtconfclave" required>
			          	<div class="valid-feedback"></div>
			           	<div class="invalid-feedback">Campo Obligatorio</div>
			       </div>
			     	<div class="row mb-3 text-center">
			      		<button name="btnregistrar" id="btnregistrar" type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalpopup">Registrar</button>
			    	</div>
				<div class="col-lg-4"></div>
				</div>
			</div>
		</div> 
		</form>
	</main> 
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
 		 	
 	var password, password2;

 	password = document.getElementById('inputPassword4');
 	password2 = document.getElementById('inputPassword5');

 	password.onchange = inputPassword5.onkeyup = passwordMatch;

 	function passwordMatch() {
 	    if(inputPassword4.value !== inputPassword5.value)
 	    	inputPassword5.setCustomValidity('Las contraseñas no coinciden.');
 	    else
 	    	inputPassword5.setCustomValidity('');
 	}
 	
 	document.getElementById("alert").addEventListener('click', function (event)
 	{
 		$(".alert").alert('close');
 	})
 	</script>
</body>
</html>