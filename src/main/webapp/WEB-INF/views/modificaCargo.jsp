<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>GESTION CARGO</h1>
	<form action="grabaCargo.gin">
	<input type="hidden" name="id" value="${cargo.id }">
		<table>
			<tr>
				<td>DESCRIPCION:</td>
				<td><input type="text" name="descripcion" value="${cargo.descripcion }"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar"></td>
				
			</tr>
		</table>

	</form>

</body>
</html>