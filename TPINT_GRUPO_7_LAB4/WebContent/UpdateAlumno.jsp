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
<title>Insert title here</title>}

 	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="./resources/css/AltaAlumno.css">
</head>
<body>
     <jsp:include page="/partials/navbar.jsp" />

	<main>  
	   <% 
	     if (request.getAttribute("alumno")!=null)
	     {
	    	 Alumno alu=new Alumno();
	    	 alu=(Alumno)request.getAttribute("alumno");    	 
	   %>
	   
	        <div class="container text-center my-5 "> 
		  <div class="row ">
		     <div class="col-lg-4"></div> 
		     <div class="col-lg-4 border border-primary rounded p-4 bg-light">  
		     	<h1>Datos Personales</h1>           
		     	<br>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Legajo</label>
					<label><%=alu.getLegajo() %></label>
		          	
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">DNI</label>
		           	<label><%=alu.getDni() %></label>
		        </div>
		        <div class="row mb-3 text-center">
		         	<label  class="from-group">Nombre</label>
		         	<label><%=alu.getNombre() %></label>

		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Apellido  : <%=alu.getApellido() %></label>
		          	<label><%=alu.getApellido() %></label>
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Fecha Nacimiento</label>
		          	<label><%=alu.getFechaNac() %></label>
		        </div>
		        <div class="row mb-3 text-center">
		          	<label class="from-group">Direccion</label>
		          	<label><%=alu.getDireccion() %></label>
		        </div>
		          <div class="row mb-3 text-center">
		          	<label  class="from-group">Provincia</label>
		             <label><%=alu.getProvincia().getNombre() %></label>
		        </div>
		        <div class="row mb-3 text-center"> 
		        	<label  class="from-group">Nacionalidad</label>
                      <label><%=alu.getNacionalidad().getNombre()  %></label>
		        </div>
		         <div class="row mb-3 text-center">
		          	<label  class="from-group">Email</label>
		           	<label><%=alu.getMail() %></label>
		        </div>
		         <div class="row mb-3 text-center">
		          	<label  class="from-group">Telefono</label>
		           	<label><%=alu.getTelefono() %></label>
		        </div>
		      	<div class="row mb-3 text-center">
		       		<button name="btnregistrar" type="submit" class="btn btn-primary">Editar</button>
		     	</div>
				<div class="col-lg-4"></div>
			</div>  
	    
	    <%} %>
	    
	     <% 
	     if (request.getAttribute("alumnoeditar")!=null)
	     {
	    	 Alumno alu=new Alumno();
	    	 alu=(Alumno)request.getAttribute("alumnoeditar");    	 
	     %>
	     
	     
	     
       <form action="ServletAlumno" method="post">
		 <div class="container text-center my-5 "> 
		  <div class="row ">
		     <div class="col-lg-4"></div> 
		     <div class="col-lg-4 border border-primary rounded p-4 bg-light">  
		     	<h1>Registro Alumnos </h1>           
		     	<br>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Legajo</label>
					<% 
						String legajo =String.valueOf(alu.getLegajo());
		          	%>
		           	<input type="text" readonly name="txtLegajo" class="form-control" value=<%= legajo %>>
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">DNI</label>
		           	<input type="text" value="<%=alu.getDni() %>" name="txtdni" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		         	<label  class="from-group">Nombre</label>
		           	<input type="text" value="<%=alu.getNombre() %>" name="txtnombre" class="form-control">
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Apellido</label>
		           	<input type="text" value="<%=alu.getApellido() %>" name="txtapellido" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		          	<label  class="from-group">Fecha Nacimiento</label>
		           	<input type="text"value="<%=alu.getFechaNac() %>" name="txtfechanac" class="form-control" >
		        </div>
		        <div class="row mb-3 text-center">
		          	<label class="from-group">Direccion</label>
		           	<input type="text"value="<%=alu.getDireccion() %>" name="txtdireccion" class="form-control" >
		        </div>
		          <div class="row mb-3 text-center">
		          	<label  class="from-group">Provincia</label>
		           	<select name="provincia">
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
		        	<label  class="from-group">Nacionalidad</label>
			       <select name="nacionalidad">
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
		           	<input type="text" value="<%=alu.getMail() %>" name="txtmail" class="form-control" id="inputPassword3">
		        </div>
		         <div class="row mb-3 text-center">
		          	<label  class="from-group">Telefono</label>
		           	<input type="text" value="<%=alu.getTelefono() %>" name="txttelefono" class="form-control" id="inputPassword3">
		        </div>
		      	<div class="row mb-3 text-center">
		       		<button name="btnguardar" type="submit" class="btn btn-primary">Guardar cambios</button>
		     	</div>
				<div class="col-lg-4"></div>
			</div>  
		</form>
	     
	    <%} %>
	   
	    
	    
	    
	    
	    
	         
	</main> 
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
</body>
</html>