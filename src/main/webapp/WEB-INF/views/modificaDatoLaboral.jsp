<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
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
			var opciones=document.forms[0].selectCargo;
			var dato=${datoLaboral.cargo.id};
			   for (i = 0; i < opciones.length; i++) {
			   if(opciones[i].value==${datoLaboral.cargo.id})
				   {
				   opciones[i].selected=true;
			   }
		}
		}
		);

</script>
</head>
<body>
	<sp:form action="grabaDatoLaboral.gin" modelAttribute="datoLaboral">
		<sp:hidden  path="id"/>
		<table border="1">
			<tr>
				<td>Salario</td>
				<td><sp:input path="salario"/></td>
			</tr>

			<tr>
				<td>Cargo</td>
				<td>
			
				<sp:select path="cargo"  id="selectCargo">
				<sp:option value="0">Selecciona Cargo...</sp:option>
				<sp:options  items="${ cargos}" itemValue="id" itemLabel="descripcion" />
				</sp:select>
	
				</td>
			</tr>
		</table>
		<input type="submit" value="Grabar">
	</sp:form>
</body>
</html>