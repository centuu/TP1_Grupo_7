$("#btnRight").on("click", (event) => {
	$("#alumnosSeleccionados").append($("#alumnosASeleccionar")[0][$("#alumnosASeleccionar")[0].selectedIndex]);
});

$("#btnLeft").on("click", (event) => {
	$("#alumnosASeleccionar").append($("#alumnosSeleccionados")[0][$("#alumnosSeleccionados")[0].selectedIndex]);
});
