CREATE TABLE profesores(
    id bigint NOT NULL AUTO_INCREMENT,
    nombre varchar(100) NOT NULL,
    apellidos varchar(100) NOT NULL,
    codigo bigint NOT NULL,
    contra varchar(100),

    PRIMARY KEY(id)
);