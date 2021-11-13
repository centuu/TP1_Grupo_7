<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>TP Integrador - Grupo N° 7</title>
	<link rel="stylesheet" href="./resources/css/login.css">
</head>
<body>
	<jsp:include page="/partials/navbar.jsp" />
	
	<form action="ServletLogin" method="post">
		<div class="container text-center my-5 "> 
			<div class="row ">
				<div class="col-lg-4"></div>
				<div id="card" class="col-lg-4 border border-secondary rounded p-4">
					<img src="resources/img/user.png" width="200" alt="" />    
					<div class="row mb-3">
						<label for="inputEmail3" class="from-group">Usuario</label>
						<input type="text" class="form-control" id="inputEmail3" name="usuario">
					</div>
					<div class="row mb-3 text-center">
						<label for="inputPassword3" class="from-group">Contraseña</label>
						<input type="password" class="form-control" id="inputPassword3" name="password">
					</div>
					<button type="submit" class="btn btn-secondary">Ingresar</button>
				</div>
				<div class="col-lg-4"></div>
	 		</div>
		</div>  
	</form>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>