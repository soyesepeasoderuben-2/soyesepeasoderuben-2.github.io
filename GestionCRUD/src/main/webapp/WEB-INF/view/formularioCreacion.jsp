<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:choose>
<c:when test="${accion eq 'crear'}">
<title>Creación de cliente</title>
</c:when>
<c:otherwise>
<title>Modificación de cliente</title>
</c:otherwise>
</c:choose>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css" />
</head>
<body>
<c:choose>
<c:when test="${accion eq 'crear'}">
<h2>Creación de cliente</h2>
</c:when>
<c:otherwise>
<h2>Modificación de cliente</h2>
</c:otherwise>
</c:choose>
<form:form action="${accion}" modelAttribute="cliente">
	<form:hidden path="id"/>
	<div>
		<div class="label">
			<form:label path="nombre">Nombre: </form:label>
		</div>
		<div class="field">
			<form:input path="nombre"/>
		</div>
	</div>
	<div>
		<div class="label">
			<form:label path="apellido">Apellidos: </form:label>
		</div>
		<div class="field">
			<form:input path="apellido"/>
		</div>
	</div>
	<div>
		<div class="label">
			<form:label path="email">E-mail: </form:label>
		</div>
		<div class="field">
			<form:input path="email"/>
		</div>
	</div>
	<div>
		<div class="boton">
			<a href="javascript:document.forms[0].submit();">${accion}</a>
		</div>
		<div class="boton">
			<a href="lista">Cancelar</a>
		</div>
	</div>
</form:form>
</body>
</html>