package edu.captura.api.dominio.materia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {
    Page<Materia> findByActivaTrue(Pageable paginacion);
}