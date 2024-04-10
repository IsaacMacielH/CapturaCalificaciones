package edu.captura.api.dominio.calificacion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRespository extends JpaRepository <Calificacion, Long> {

    //Page <Calificacion> findByMateriaCrn(Long crn, Pageable paginacion);
    //Page<Calificacion> findByMateriaId(Long id, Pageable pageable);
    Page<Calificacion> findByMateria_Crn(Long id, Pageable pageable);
}