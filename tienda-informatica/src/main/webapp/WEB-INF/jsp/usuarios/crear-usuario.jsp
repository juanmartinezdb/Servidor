<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 25/11/2024
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="org.iesbelen.model.Usuario"%>
<%@page import="java.util.Optional"%>
<%@ include file="/WEB-INF/jsp/fragmentos/imports.jspf" %>
<html>
<head>
    <title>Crear Usuario</title>
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
    <form action="${pageContext.request.contextPath}/tienda/usuarios/crear/" method="post">
        <div class="clearfix">
            <div style="float: left; width: 50%">
                <h1>Crear Usuario</h1>
            </div>
            <div style="float: none;width: auto;overflow: hidden;min-height: 80px;position: relative;">

                <div style="position: absolute; left: 39%; top : 39%;">
                    <input type="submit" value="Crear"/>
                </div>

            </div>
        </div>

        <div class="clearfix">
            <hr/>
        </div>

        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Nombre
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="nombre" />
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                Password
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="password" />
            </div>
        </div>
        <div style="margin-top: 6px;" class="clearfix">
            <div style="float: left;width: 50%">
                rol
            </div>
            <div style="float: none;width: auto;overflow: hidden;">
                <input name="rol" />
            </div>
        </div>

    </form>
</div>
<%@ include file ="/WEB-INF/jsp/fragmentos/footer.jspf"%>
</body>
</html>
