<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de clientes</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css" />
</head>
<body>
	<h1>Listado de clientes</h1>
	<table>
		<tr>
			<th class="nombre">Nombre</th>
			<th class="apellido">Apellido</th>
			<th class="email">E-mail</th>
			<th class="acciones" colspan="2">Acciones</th>
		</tr>
		<c:forEach var="cliente" items="${clientes}">
		<c:url var="linkActualizar" value="/cliente/formularioModificacion">
			<c:param name="id" value="${cliente.id}" />
		</c:url>
		<c:url var="linkEliminar" value="/cliente/eliminar">
			<c:param name="id" value="${cliente.id}" />
		</c:url>
		<tr>
			<td class="nombre">${cliente.nombre}</td>
			<td class="apellido">${cliente.apellido}</td>
			<td class="email">${cliente.email}</td>
			<td class="acciones">
				<div class="boton">
					<a href="${linkActualizar}">Modificar</a>
				</div>
			</td>
			<td>
				<div class="boton">
					<a href="${linkEliminar}">Eliminar</a>
				</div>
			</td>
		</tr>
	</c:forEach>
	</table>
	<div class="boton">
		<a href="formularioCreacion">Crear</a>
	</div>
</body>
</html>