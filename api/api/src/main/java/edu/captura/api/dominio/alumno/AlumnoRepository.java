package edu.captura.api.dominio.alumno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    //List<Alumno> findByGradoAndGrupo(String grado, String grupo);
    Page<Alumno> findByGradoAndGrupo(Pageable paginacion, String grado, String grupo);
}
