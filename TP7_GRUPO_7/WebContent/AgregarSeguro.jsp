<%@ page import="entidad.Seguro" %>
<%@ page import="dao.SeguroDao" %>
<%@ page import="daoImpl.SeguroImpl" %>
<%@ page import="entidad.TipoSeguro" %>
<%@ page import="daoImpl.TipoSeguroImpl" %>
<%@ page import ="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Trabajo Pr�ctico N� 7 - Grupo N� 7</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a> 
	<a href="AgregarSeguro.jsp">Agregar Seguro</a> 
	<a href="ListarSeguros.jsp">Listar Seguros</a>
	<br>
	<form action="ServletSeguro" method="Get">
		<br>
		<b>Agregar Seguros</b>
		<br>
		<br>
		<label>	Id Seguro: </label>
		<% 
			SeguroImpl seguro = new SeguroImpl();
		%>
		<label name="lblID"><%= seguro.GetNextId() %></label>
		<br>
		<label>Descripci�n: </label> 
		<input type="text" name="txtDesc"/>
		<br>
		<label>Tipo de Seguro:</label>
		<select name="tiposeguro">
        <% 
			TipoSeguroImpl imp = new TipoSeguroImpl();
			ArrayList<TipoSeguro> Tiposeguros = imp.list();
			if(Tiposeguros != null && !Tiposeguros.isEmpty())
			{
		  		for(TipoSeguro seg  :Tiposeguros) 
		  		{
		%>
        		<option value="<%=seg.getIdtipo()%>"><%=seg.getDescripcion()%></option>
        <% 		}
		  	} 
		%>
		  	
		</select>
		<br>
		<label>Costo Contrataci�n: </label>
		<input type="text" name="txtCostCon"/>
		<br>
		<label>Costo M�ximo Asegurado: </label>
		<input type="text" name="txtCostMax"/>
		<br>
		<br>
 		<input type="submit" value ="Aceptar" name="btnAceptar" style="width: 76px; "/>
 	</form >
</body>
</html>