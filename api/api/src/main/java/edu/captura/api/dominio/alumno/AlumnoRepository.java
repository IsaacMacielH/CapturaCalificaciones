package edu.captura.api.dominio.alumno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    Page<Alumno> findByGradoAndGrupo(Pageable paginacion);
}
