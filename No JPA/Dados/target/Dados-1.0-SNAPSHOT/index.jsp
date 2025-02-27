<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int cantidad = (int) (Math.random()*6)+2;
    String [] dados = new String[] {
            "1.svg","2.svg","3.svg","4.svg","5.svg","6.svg"
    };
    List<Integer> tirada = new LinkedList<Integer>();

    for (int i=0; i<cantidad; i++){
        tirada.add((int) (Math.random()*6));
    }
    String salida = tirada.stream().map(t-> "<img src=\"images/"+(t+1)+".svg\" />").collect(Collectors.joining("\n"));
    tirada.sort(null);
    String salidaOrdenada = tirada.stream().map(t-> "<img src=\"images/"+(t+1)+".svg\" />").collect(Collectors.joining("\n"));
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> Ordenar dados</h1>
<p>Actualice la página para una nueva tirada</p>
<h2>Tirada de dados</h2>
<div>
    <%=salida%> //es mejor meter el for aqui que hacer un stream arriba.
</div>
<h2>Ordenada</h2>
<div>
    <%=salidaOrdenada%>
</div>
<br/>
</body>
</html>