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
<b>Agregar Seguros</b>
<br>
<br>
Id Seguro: 
<br>
Descripción: &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&nbsp;<input type="text" name="txtDesc"/>
<br>
Tipo de Seguro: &emsp;&emsp;&emsp;&emsp;&emsp;&ensp;<select name="tipoSeguro" style="width: 153px; ">  </select>
<br>
Costo Contratación: &emsp;&emsp;&emsp;&ensp;&nbsp; <input type="text" name="txtCostCon"/>
<br>
Costo Máximo Asegurado: &emsp;&nbsp;<input type="text" name="txtCostMax"/>
<br>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;&nbsp;<input type="submit" value ="Aceptar" name="btnAceptar" style="width: 76px; "/>
</body>
</html>