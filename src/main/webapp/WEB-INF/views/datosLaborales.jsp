<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/empresa.js">
</script>

</head>
<body>

	<table border="1" id="miTabla">
		<tr>
			<td>ID</td>
			<td>SALARIO</td>
			<td>CARGO</td>
			<td>ACCIONES</td>
		</tr>
		<c:forEach items="${datosLaborales }" var="datoLaboral">

			<tr>
				<td>${datoLaboral.id }</td>
				<td>${datoLaboral.salario}</td>
				<td>
				${datoLaboral.cargo.descripcion} - ${datoLaboral.cargo.id }
				</td>
				<td>
				<input type="button" value="Modificar" onclick="modificaDatoLaboral(${datoLaboral.id})">
				<input type="button" value="Borrar" onclick="borraDatoLaboral(${datoLaboral.id},${datoLaboral.empleados.size() })">
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="modificaDatoLaboral.gin?id=0">Alta de Datos Laborales</a>

</body>
</html>