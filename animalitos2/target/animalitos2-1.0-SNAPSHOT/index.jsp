<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String[] fotos = new String[] {
            "ballena.svg",
            "caballito-mar.svg",
            "camello.svg",
            "cebra.svg",
            "elefante.svg",
            "hipopotamo.svg",
            "jirafa.svg",
            "leon.svg",
            "leopardo.svg",
            "medusa.svg",
            "mono.svg",
            "oso.svg",
            "oso-blanco.svg",
            "pajaro.svg",
            "pinguino.svg",
            "rinoceronte.svg",
            "serpiente.svg",
            "tigre.svg",
            "tortuga.svg",
            "tortuga-marina.svg"
    };

    String [] nombres = new String[]{
            "ballena",
            "caballito-mar",
            "camello",
            "cebra",
            "elefante",
            "hipopotamo",
            "jirafa",
            "leon",
            "leopardo",
            "medusa",
            "mono",
            "oso",
            "oso-blanco",
            "pajaro",
            "pinguino",
            "rinoceronte",
            "serpiente",
            "tigre",
            "tortuga",
            "tortuga-marina"
    };
    int rando = (int) (Math.random()*fotos.length);



%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Animalitos" %>
</h1>
<h2> <%=nombres[rando]%></h2>
<img src="./imagenes/<%=fotos[rando]%>">
<br/>

</body>
</html>