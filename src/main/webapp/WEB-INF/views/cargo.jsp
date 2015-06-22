<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/empresa.js"></script>
</head>
<body>

	<table border="1">
		<tr>
			<td>ID</td>
			<td>DESCRIPCION</td>
			<td>ACCIONES</td>
		</tr>


		<c:forEach items="${cargos }" var="cargo">

			<tr>
				<td>${cargo.id }</td>
				<td>${cargo.descripcion }</td>
				<td><input type="button" value="Modificar"
					onclick="modificaCargo(${cargo.id})"> <input type="button"
					value="Borrar" onclick="borraCargo(${cargo.id},${cargo.datoslaborales.size() })"></td>
			</tr>

		</c:forEach>


	</table>

<a href="modificaCargo.gin?id=0">Alta Cargo</a>

</body>
</html>