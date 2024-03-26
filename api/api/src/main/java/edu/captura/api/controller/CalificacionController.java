package edu.captura.api.controller;

import edu.captura.api.dominio.calificacion.CalificacionRespository;
import edu.captura.api.dominio.calificacion.DatosListadoCalificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionRespository calificacionRespository;

    @GetMapping("/{crn}")
    public ResponseEntity<Page<DatosListadoCalificaciones>> retornaCalificacionesCrn(@PathVariable Long crn, Pageable paginacion){
        return ResponseEntity.ok(calificacionRespository.findByMateria_idCrn(crn, paginacion).map(DatosListadoCalificaciones::new));
    }
}
