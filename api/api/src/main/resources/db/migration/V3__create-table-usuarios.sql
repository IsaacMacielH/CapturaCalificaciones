CREATE TABLE usuarios(
    id bigint NOT NULL AUTO_INCREMENT,
    login varchar(100) NOT NULL,
    clave varchar(100) NOT NULL,

    PRIMARY KEY(id)
);