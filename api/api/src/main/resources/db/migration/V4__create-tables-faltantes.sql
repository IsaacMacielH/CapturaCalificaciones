CREATE TABLE materias(
                         id bigint NOT NULL AUTO_INCREMENT,
                         crn bigint NOT NULL,
                         nombre varchar(100) NOT NULL,
                         grado varchar(100) NOT NULL,

                         PRIMARY KEY(id)
);

CREATE TABLE alumnos(
                         id bigint NOT NULL AUTO_INCREMENT,
                         codigo bigint NOT NULL,
                         nombre varchar(100) NOT NULL,
                         apellios varchar(100) NOT NULL,
                         grado varchar(100) NOT NULL,
                         grupo varchar(100) NOT NULL,

                             PRIMARY KEY(id)
);

CREATE TABLE matricula(
                         id_alumno bigint NOT NULL,
                         id_materia bigint NOT NULL,

                         FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
                         FOREIGN KEY (id_materia) REFERENCES materias(id)
);

CREATE TABLE calificaciones(
                         id bigint NOT NULL AUTO_INCREMENT,
                         id_alumno bigint NOT NULL,
                         id_materia bigint NOT NULL,
                         calificaion bigint NOT NULL,

                            PRIMARY KEY(id),
                            FOREIGN KEY (id_alumno) REFERENCES alumnos(id),
                            FOREIGN KEY (id_materia) REFERENCES materias(id)

);

CREATE TABLE imparte(
                        id_profesor bigint NOT NULL,
                        id_materia bigint NOT NULL,

                            FOREIGN KEY (id_profesor) REFERENCES profesores(id),
                            FOREIGN KEY (id_materia) REFERENCES materias(id)
);