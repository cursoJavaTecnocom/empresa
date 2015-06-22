<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
	<%@taglib prefix="sp"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ empresa.id gt 0 }">
	<h1>MODIFICA EMPRESA</h1>
</c:if>
<c:if test="${empty empresa.id}">
	<h1>ALTA EMPRESA</h1>
</c:if>


	<sp:form action="grabaEmpresa.gin" modelAttribute="empresa"> 
		<sp:hidden path="id"/>		

		<table border="1">
			<tr>
				<td>Nombre</td>
				<td><sp:input path="nombre"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar"></td>
			</tr>

		</table>
		
		
	</sp:form>
</body>
</html>





