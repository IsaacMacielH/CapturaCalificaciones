package edu.captura.api.controller;

import edu.captura.api.dominio.calificacion.Calificacion;
import edu.captura.api.dominio.calificacion.CalificacionRespository;
import edu.captura.api.dominio.calificacion.DatosListadoCalificaciones;
import edu.captura.api.dominio.calificacion.DatosRegistroCalificacion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private CalificacionRespository calificacionRespository;

    @GetMapping("/{crn}")
    public ResponseEntity<Page<DatosListadoCalificaciones>> retornaCalificacionesCrn(@PathVariable Long crn, Pageable paginacion){
        return ResponseEntity.ok(calificacionRespository.findByMateria_Crn(crn, paginacion).map(DatosListadoCalificaciones::new));
    }

    @PostMapping("")
    public ResponseEntity<DatosListadoCalificaciones> capturarCalificacion(@RequestBody @Valid DatosRegistroCalificacion datosRegistroCalificacion, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("Si entró al Registro");
        Calificacion calificacion = calificacionRespository.save(new Calificacion(datosRegistroCalificacion));
    }
}
