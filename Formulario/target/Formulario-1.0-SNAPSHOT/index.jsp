<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
</html>
<head>
    <title>Formulario</title>
</head>
<body>
<form action="formulario" method="post">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" placeholder="Nombre">
<br>
    <label for="apellidos">Apellidos:</label>
    <input type="text" id="apellidos" name="apellidos" placeholder="Apellidos">
    <br>
    <label for="edad">Edad:</label>
    <select id="edad" name="edad">
        <option value="vacia">Selecciona...</option>
        <option value="18">-18</option>
        <option value="18-25">18-25</option>
        <option value="26-35">26-35</option>
        <option value="36-45">36-45</option>
        <option value="46">46+</option>
    </select>
    <br>
    <label for="peso">Peso:</label>
    <input type="number" id="peso" name="peso" placeholder="Peso"> kg
    <br>
    <label>Sexo:</label>
    <input type="radio" name="sexo" id="hombre" value="hombre">
    <label for="hombre">Hombre</label>
    <input type="radio" name="sexo" id="mujer" value="mujer">
    <label for="mujer">Mujer</label>
    <input type="radio" name="sexo" id="otro" value="otro">
    <label for="otro">Otro</label>
    <br>
    <label>Estado Civil:</label>
    <input type="radio" name="estadoCivil" id="soltero" value="soltero">
    <label for="soltero">Soltero</label>
    <input type="radio" name="estadoCivil" id="casado" value="casado">
    <label for="casado">Casado</label>
    <input type="radio" name="estadoCivil" id="otroG" value="otro">
    <label for="otroG">Otro</label>
    <br>
    <label>Aficiones:</label>
    <input type="checkbox" id="cine" name="cine" value="cine">
    <label for="cine">Cine</label>
    <input type="checkbox" id="literatura" name="literatura" value="literatura">
    <label for="literatura">Literatura</label>
    <input type="checkbox" id="tebeos" name="tebeos" value="tebeos">
    <label for="tebeos">Tebeos</label>
    <input type="checkbox" id="deporte" name="deporte" value="deporte">
    <label for="deporte">Deporte</label>
    <input type="checkbox" id="musica" name="musica" value="musica">
    <label for="musica">Música</label>
    <input type="checkbox" id="television" name="television" value="television">
    <label for="television">Televisión</label>
    <br>
    <button type="submit">Enviar</button>
    <button type="reset">Borrar</button>
</form>

<a href="formulario">Contenido Formulario</a>

</body>
</html>
