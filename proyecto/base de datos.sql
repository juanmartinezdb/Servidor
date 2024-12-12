Drop database if exists tiendadigital;
CREATE DATABASE tiendadigital;
USE tiendadigital;

DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
    idCategoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
    idProducto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(600),
    precio DECIMAL(10,2) NOT NULL,
    imagen VARCHAR(255),
    idCategoria INT NOT NULL,
    FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria)
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
    idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    password VARCHAR(128) NOT NULL,
    rol ENUM('cliente', 'admin') NOT NULL
);

DROP TABLE IF EXISTS pedido;
CREATE TABLE pedido (
    idPedido INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idCliente INT NOT NULL,
    fecha DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES usuario(idUsuario)
);

DROP TABLE IF EXISTS articulos_pedido;
CREATE TABLE  articulos_pedido (
    idPedido INT NOT NULL,
    idProducto INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (idPedido, idProducto),
    FOREIGN KEY (idPedido) REFERENCES pedido(idPedido),
    FOREIGN KEY (idProducto) REFERENCES producto(idProducto)
);
