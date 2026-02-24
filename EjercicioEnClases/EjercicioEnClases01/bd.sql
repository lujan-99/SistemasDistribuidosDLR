-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

-- Tabla Bibliotecas
CREATE TABLE bibliotecas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    tamano_m2 DOUBLE
);

-- Tabla Armarios
CREATE TABLE armarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50),
    material VARCHAR(20),
    biblioteca_id INT,
    FOREIGN KEY (biblioteca_id) REFERENCES bibliotecas(id)
);

-- Tabla Publicaciones (Base)
CREATE TABLE publicaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(200),
    tipo_publicacion VARCHAR(50),
    armario_id INT,
    FOREIGN KEY (armario_id) REFERENCES armarios(id)
);

-- Tabla Libros (Específica)
CREATE TABLE libros (
    publicacion_id INT PRIMARY KEY,
    autor VARCHAR(100),
    editorial VARCHAR(100),
    ano INT,
    FOREIGN KEY (publicacion_id) REFERENCES publicaciones(id)
);