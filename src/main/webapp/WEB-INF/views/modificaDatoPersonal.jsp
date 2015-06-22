<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
$("document").ready(
		function()
		{
			var opciones=document.forms[0].selectEstadosCiviles;
			
			   for (i = 0; i < opciones.length; i++) {
			   if(opciones[i].value==${datoPersonal.estadoscivile.id})
				   {
				   opciones[i].selected=true;
			   }
		}
			   
			   
			   var opciones1=document.forms[0].selectHijos;
				
			   for (i = 0; i < opciones1.length; i++) {
			   if(opciones1[i].value==${datoPersonal.hijo.id})
				   {
				   opciones1[i].selected=true;
			   }
		}
			   
			   
			   
		}
		);

</script>




</head>
<body>
	<c:if test="${empty datoPersonal }">
		<h1>Alta de Dato Personal</h1>
	</c:if>
	<c:if test="${not empty datoPersonal }">
		<h1>Modificacion de Dato Personal</h1>
	</c:if>

	<sp:form action="grabaDatoPersonal.gin" modelAttribute="datoPersonal">
		<sp:hidden path="id"/>
		<table border="1">
			<tr>
				<td>Estado Civil:</td>
				<td>
				<sp:select path="estadoscivile"  id="selectEstadosCiviles">
				<sp:option value="0" >Selecciona Estado Civil...</sp:option>
				<sp:options items="${estadosCiviles }" itemLabel="descripcion" itemValue="id"/>
				</sp:select>
				</td>
			</tr>
			<tr>
				<td>Hijos:</td>
				<td><sp:select path="hijo" id="selectHijos">
				<sp:option value="0" >Selecciona Hijos...</sp:option>
				<sp:options items="${hijos }" itemLabel="texto" itemValue="id"/>
				</sp:select></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="Grabar">
				</td>
				
			</tr>
		</table>


	</sp:form>


</body>
</html>