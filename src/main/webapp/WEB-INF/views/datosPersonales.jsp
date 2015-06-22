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
			<td>ESTADO CIVIL</td>
			<td>CHICOS</td>
			<td>CHICAS</td>
			<td>ACCIONES</td>
		</tr>

		<c:forEach items="${datosPersonales }" var="datopersonal">

			<tr>
				<td>${datopersonal.id }</td>
				<td>${datopersonal.estadoscivile.descripcion }</td>
				<td>${datopersonal.hijo.chicos }</td>
				<td>${datopersonal.hijo.chicas }</td>
				<td><input type="button" value="Modificar"
					onclick="modificaDatoPersonal(${datopersonal.id})"> <input
					type="button" value="Borrar"
					onclick="borraDatoPersonal(${datopersonal.id},${datopersonal.empleados.size() })">
				</td>
			</tr>
		</c:forEach>

	</table>
	<a href="modificaDatoPersonal.gin?id=0">nuevo Dato Personal</a>
</body>
</html>