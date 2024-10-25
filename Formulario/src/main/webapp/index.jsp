<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
</html>
<head>
    <title>Formulario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
    <form action="formulario" method="get">
        <div class="row mb-3">
            <div class="col">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre">
            </div>
            <div class="col">
                <label for="apellidos" class="form-label">Apellidos:</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Apellidos">
            </div>
            <div class="col">
                <label for="edad" class="form-label">Edad:</label>
                <select class="form-select" id="edad" name="edad">
                    <option selected value="vacia">Selecciona...</option>
                    <option value="18">-18</option>
                    <option value="18-25">18-25</option>
                    <option value="26-35">26-35</option>
                    <option value="36-45">36-45</option>
                    <option value="46">46+</option>
                </select>
            </div>
        </div>

        <div class="row mb-3">
            <div class="col">
                <label for="peso" class="form-label">Peso:</label>
                <div class="input-group">
                    <input type="number" class="form-control" id="peso" name="peso" placeholder="Peso">
                    <span class="input-group-text">kg</span>
                </div>
            </div>
            <div class="col">
                <label class="form-label">Sexo:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="sexo" id="hombre" value="hombre">
                    <label class="form-check-label" for="hombre">Hombre</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="sexo" id="mujer" value="mujer">
                    <label class="form-check-label" for="mujer">Mujer</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="sexo" id="otro" value="otro">
                    <label class="form-check-label" for="otro">Otro</label>
                </div>
            </div>
            <div class="col">
                <label class="form-label">Estado Civil:</label>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estadoCivil" id="soltero" value="soltero">
                    <label class="form-check-label" for="soltero">Soltero</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estadoCivil" id="casado" value="casado">
                    <label class="form-check-label" for="casado">Casado</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="estadoCivil" id="otroG" value="otro">
                    <label class="form-check-label" for="otroG">Otro</label>
                </div>
            </div>
        </div>

        <div class="row mb-3">
            <label class="form-label">Aficiones:</label>
            <div class="col">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="cine" name="cine" value="cine">
                    <label class="form-check-label" for="cine">Cine</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="literatura" name="literatura" value="literatura">
                    <label class="form-check-label" for="literatura">Literatura</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="tebeos" name="tebeos" value="tebeos">
                    <label class="form-check-label" for="tebeos">Tebeos</label>
                </div>
            </div>
            <div class="col">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="deporte" name="deporte" value="deporte">
                    <label class="form-check-label" for="deporte">Deporte</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="musica" name="musica" value="musica">
                    <label class="form-check-label" for="musica">Música</label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="television" name="television" value="television">
                    <label class="form-check-label" for="television">Televisión</label>
                </div>
            </div>
        </div>

        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <button class="btn btn-primary me-md-2" type="submit">Enviar</button>
            <button class="btn btn-secondary" type="reset">Borrar</button>
        </div>
    </form>
</div>
<a href="formulario">Contenido Formulario</a>


</body>
</html>
