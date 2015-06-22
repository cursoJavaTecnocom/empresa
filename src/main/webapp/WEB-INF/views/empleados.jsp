<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/empresa.js"></script>
</head>
<body>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>EMPRESA</td>
			<td>NOMBRE</td>
			<td>APELLIDOS</td>
			<td>DIRECCION</td>
			<td>TELEFONO</td>
			<td>EDAD</td>
			<td>DATOS LABORALES</td>
			<td>DATOS PERSONALES</td>
			<td>ACCIONES</td>
		</tr>

		<c:forEach items="${empleados }" var="empleado">
			<tr>

				<td>${empleado.id }</td>
				<td>${ empleado.empresa.nombre}</td>
				<td>${ empleado.nombre}</td>
				<td>${empleado.apellidos }</td>
				<td>${empleado.direccion }</td>
				<td>${empleado.telefono }</td>
				<td>${ empleado.edad}</td>
				<td>${empleado.datoslaborale.cargo.descripcion }-
					${empleado.datoslaborale.salario}</td>
				<td>${empleado.datospersonale.estadoscivile.descripcion }-
					${empleado.datospersonale.hijo.chicos } -
					${empleado.datospersonale.hijo.chicas }</td>
				<td><input type="button" value="Modificar"
					onclick="modificaEmpleado(${empleado.id})"> <input
					type="button" value="Borrar"
					onclick="borraEmpleado(${empleado.id })"></td>
			</tr>
		</c:forEach>

	</table>

	<a href="modificaEmpleado.gin?id=0">Alta de Empleado</a>


</body>
</html>