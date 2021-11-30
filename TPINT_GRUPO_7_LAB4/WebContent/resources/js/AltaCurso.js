$("#btnRight").on("click", (event) => 
{
	$("#alumnosSeleccionados").append($("#alumnosASeleccionar")[0][$("#alumnosASeleccionar")[0].selectedIndex]);
	document.getElementById("alumnos").value += "|" + ($("#alumnosSeleccionados")[0][$("#alumnosSeleccionados")[0].selectedIndex].value);
});

$("#btnLeft").on("click", (event) =>
{
	$("#alumnosASeleccionar").append($("#alumnosSeleccionados")[0][$("#alumnosSeleccionados")[0].selectedIndex]);
	var alumno = "|" + ($("#alumnosASeleccionar")[0][$("#alumnosASeleccionar")[0].selectedIndex].value);
	document.getElementById("alumnos").value = document.getElementById("alumnos").value.replace(alumno, "");
});
