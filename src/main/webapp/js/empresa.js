function borraEmpresa(id, destino, cantidad) {

	if (cantidad > 0) {
		alert("La empresa tiene empleados");
		return;
	}

	document.location = destino + "?id=" + id;

}


function borraEmpleado(id) {

	

	document.location = "borraEmpleado.gin?id=" + id;

}

function borraDatoLaboral(id, cantidad) {

	if (cantidad > 0) {
		alert("El Dato laboral tiene empleados");
		return;
	}

	document.location = "borraDatoLaboral.gin?id=" + id;

}

function borraDatoPersonal(id, cantidad) {

	if (cantidad > 0) {
		alert("El Dato laboral tiene empleados");
		return;
	}

	document.location = "borraDatoPersonal.gin?id=" + id;

}

function borraCargo(id,cantidad)
{
	if(cantidad>0)
		{
		alert("Existen datos Laborales con este cargo asociado");
		return;
		}
	document.location="borraCargo.gin?id="+id;

}


function modificaEmpresa(id)
{
	document.location = "modificaEmpresa.gin?id=" + id;
}
function modificaEmpleado(id)
{
	document.location = "modificaEmpleado.gin?id=" + id;
}
function modificaDatoLaboral(id)
{
	document.location = "modificaDatoLaboral.gin?id=" + id;
}
function modificaDatoPersonal(id)
{
	document.location = "modificaDatoPersonal.gin?id=" + id;
}

function modificaCargo(id)
{
	document.location="modificaCargo.gin?id="+id;
}



