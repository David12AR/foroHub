CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    contrasena VARCHAR(250) NOT NULL,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL UNIQUE,
    mensaje VARCHAR(300) NOT NULL UNIQUE,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    respuestas VARCHAR(12) NOT NULL,
    autor_id BIGINT NOT NULL,
    CONSTRAINT fk_topicos_usuarios FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);
