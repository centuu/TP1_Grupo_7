<%@ page import="entidad.Seguro" %>
<%@ page import="dao.SeguroDao" %>
<%@ page import="daoImpl.SeguroImpl" %>
<%@ page import="entidad.TipoSeguro" %>
<%@ page import="daoImpl.TipoSeguroImpl" %>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trabajo Práctico N° 7 - Grupo N° 7</title>
</head>
<body>
<a href="Inicio.jsp">Inicio</a> <a href="AgregarSeguro.jsp">Agregar Seguro</a> <a href="ListarSeguros.jsp">Listar Seguros</a>
<br>
<br>
<form action="ServletSeguro" method="Get">
<b>"Tipos de Seguros de la Base de Datos"</b>
<br>
<br>
Búsqueda por Tipo de Seguros: <select name="tiposeguro">
        <%  
          TipoSeguroImpl imp= new TipoSeguroImpl();
         ArrayList<TipoSeguro> Tiposeguros = imp.list();
         if(Tiposeguros != null && !Tiposeguros.isEmpty())
		  for(TipoSeguro seg  :Tiposeguros) 
		  {
	%>
                <option value="<%=seg.getIdtipo()%>"><%=seg.getDescripcion()%></option>
                <%  } %>
       </select><input type="submit" value="Filtrar" name="btnFiltrar" style="height: 34px; ">
        </form >
</body>
</html>