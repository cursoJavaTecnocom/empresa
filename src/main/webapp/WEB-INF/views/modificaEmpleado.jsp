<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			var opciones=document.forms[0].datospersonale;
			
			   for (i = 0; i < opciones.length; i++) {
			   if(opciones[i].value==${empleado.datospersonale.id})
				   {
				   opciones[i].selected=true;
			   }
		}
			   
			   
			   var opciones1=document.forms[0].datoslaborale
				
			   for (i = 0; i < opciones1.length; i++) {
			   if(opciones1[i].value==${empleado.datoslaborale.id})
				   {
				   opciones1[i].selected=true;
			   }
		}
			   
			   var opciones2=document.forms[0].empresa
				
			   for (i = 0; i < opciones2.length; i++) {
			   if(opciones2[i].value==${empleado.empresa.id})
				   {
				   opciones2[i].selected=true;
			   }
		}
			   
			   
		}
		);

</script>
</head>
<body>

	<sp:form action="grabaEmpleado.gin" modelAttribute="empleado">
		<table border="1">
			<tr>
				<td>NOMBRE</td>
				<td><sp:input path="nombre" /></td>
			</tr>
			<tr>
				<td>APELLIDOS</td>
				<td><sp:input path="apellidos" /></td>
			</tr>
			<tr>
				<td>DIRECCION</td>
				<td><sp:input path="direccion" /></td>
			</tr>
			<tr>
				<td>TELEFONO</td>
				<td><sp:input path="telefono" /></td>
			</tr>
			<tr>
				<td>EDAD</td>
				<td><sp:input path="edad" /></td>
			</tr>
			<tr>
				<td>DATOS LABORALES</td>
				<td><sp:select path="datoslaborale" >
						<sp:option value="0">Selecciona Dato Laboral....</sp:option>
						<sp:options items="${datosLaborales }" itemLabel="texto"
							itemValue="id" />
					</sp:select></td>
			</tr>
			<tr>
				<td>DATOS PERSONALES</td>
				<td><sp:select path="datospersonale" >
					<sp:option value="0">Selecciona Dato Personal....</sp:option>
					<sp:options items="${datosPersonales }" itemLabel="texto"
						itemValue="id" />
				</sp:select>
				</td>
			</tr>
			<tr>
				<td>EMPRESA</td>
				<td><sp:select path="empresa">
						<sp:option value="0">Selecciona Empresa....</sp:option>
						<sp:options items="${empresas }" itemLabel="nombre" itemValue="id" />
					</sp:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Grabar"> </td>
			</tr>
		</table>


	</sp:form>



</body>
</html>