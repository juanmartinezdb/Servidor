<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Fabricante"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Producto" %>
<%@ include file="/WEB-INF/jsp/fragmentos/imports.jspf" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Productos</title>
	<style>
		.clearfix::after {
			content: "";
			display: block;
			clear: both;
		}
	</style>
	<%@ include file="/WEB-INF/jsp/fragmentos/bootstrap.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/jsp/fragmentos/header.jspf" %>
<%@ include file="/WEB-INF/jsp/fragmentos/nav.jspf" %>

<form action="${pageContext.request.contextPath}/tienda/productos" method="get">
	<label for="busqueda">Buscar por:</label>
	<input name="busqueda" id="busqueda" type="text">
	<button type="submit">Buscar</button>
</form>
	<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
		<div class="clearfix">
			<div style="float: left; width: 50%">
				<h1>Productos</h1>
			</div>
			<div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
				
				<div style="position: absolute; left: 39%; top : 39%;">
					
						<form action="${pageContext.request.contextPath}/tienda/productos/crear">
							<input type="submit" value="Crear">
						</form>
					</div>
				
			</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
		<div class="clearfix">
			<div style="float: left;width: 10%">Código</div>
			<div style="float: left;width: 30%">Nombre</div>
			<div style="float: left;width: 20%">Precio</div>
			<div style="float: left;width: 20%;overflow: hidden;">Acción</div>
		</div>
		<div class="clearfix">
			<hr/>
		</div>
	<% 
        if (request.getAttribute("listaProductos") != null) {
            List<Producto> listaProducto= (List<Producto>)request.getAttribute("listaProductos");
            
            for (Producto producto : listaProducto) {
    %>

		<div style="margin-top: 6px;" class="clearfix">
			<div style="float: left;width: 10%"><%= producto.getIdProducto()%></div>
			<div style="float: left;width: 30%"><%= producto.getNombre()%></div>
			<div style="float: left;width: 20%"><%= producto.getPrecio()%></div>
			<div style="float: none;width: auto;overflow: hidden;">
				<form action="${pageContext.request.contextPath}/tienda/productos/<%= producto.getIdProducto()%>" style="display: inline;">
    				<input type="submit" value="Ver Detalle" />
				</form>
				<%	if (session.getAttribute("usuario")!=null) {
					Usuario logged = (Usuario)session.getAttribute(("usuario"));
					if ("administrador".equals(logged.getRol())){
				%>
				<form action="${pageContext.request.contextPath}/tienda/productos/editar/<%= producto.getIdProducto()%>" style="display: inline;">
    				<input type="submit" value="Editar" />
				</form>
				<form action="${pageContext.request.contextPath}/tienda/productos/borrar/" method="post" style="display: inline;">
					<input type="hidden" name="__method__" value="delete"/>
					<input type="hidden" name="codigo" value="<%= producto.getIdProducto()%>"/>
    				<input type="submit" value="Eliminar" />
				</form>
				<%}}%>
			</div>
		</div>
	<% 
            }
        } else { 
    %>
		No hay registros de producto
	<% } %>
	</div>
<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>

</body>
</html>