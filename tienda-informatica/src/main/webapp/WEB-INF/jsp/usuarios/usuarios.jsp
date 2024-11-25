<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 25/11/2024
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Fabricante"%>
<%@page import="java.util.List"%>
<%@ page import="org.iesbelen.model.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Usuarios</title>
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


<div id="contenedora" style="float:none; margin: 0 auto;width: 900px;" >
    <div class="clearfix">
        <div style="float: left; width: 50%">
            <h1>Usuarios</h1>
        </div>
        <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">
            <div style="position: absolute; left: 39%; top : 39%;">

                <form action="${pageContext.request.contextPath}/tienda/usuarios/crear">
                    <input type="submit" value="Crear">
                </form>
            </div>

        </div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <div class="clearfix">
        <div style="float: left;width: 20%">ID</div>
        <div style="float: left;width: 20%">Nombre</div>
        <div style="float: left;width: 20%">Password</div>
        <div style="float: left;width: 20%">Rol</div>
        <div style="float: none;width: auto;overflow: hidden;">Acción</div>
    </div>
    <div class="clearfix">
        <hr/>
    </div>
    <%
        if (request.getAttribute("usuarios") != null) {
            List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("usuarios");

            for (Usuario user : listaUsuarios) {
    %>

    <div style="margin-top: 6px;" class="clearfix">
        <div style="float: left;width: 20%"><%= user.getIdUsuario()%></div>
        <div style="float: left;width: 20%"><%= user.getNombre()%></div>
        <div style="float: left;width: 20%"><%= user.getPassword().substring(0,4)%></div>
        <div style="float: left;width: 20%"><%= user.getRol()%></div>
        <div style="float: none;width: auto;overflow: hidden;">
            <form action="${pageContext.request.contextPath}/tienda/usuarios/<%= user.getIdUsuario()%>" style="display: inline;">
                <input type="submit" value="Ver Detalle" />
            </form>
            <form action="${pageContext.request.contextPath}/tienda/usuarios/editar/<%= user.getIdUsuario()%>" style="display: inline;">
                <input type="submit" value="Editar" />
            </form>
            <form action="${pageContext.request.contextPath}/tienda/usuarios/borrar/" method="post" style="display: inline;">
                <input type="hidden" name="__method__" value="delete"/>
                <input type="hidden" name="codigo" value="<%= user.getIdUsuario()%>"/>
                <input type="submit" value="Eliminar" />
            </form>
        </div>
    </div>

    <%
        }
    } else {
    %>
    No hay registros de Usuarios
    <% } %>
</div>

<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>
</body>
</html>