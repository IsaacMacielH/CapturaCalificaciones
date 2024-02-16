package edu.captura.api.controller;

import edu.captura.api.dominio.materia.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping
    public ResponseEntity<Page<DatosListadoMaterias>> listadoMaterias(Pageable paginacion){
        return ResponseEntity.ok(materiaRepository.findByActivaTrue(paginacion).map(DatosListadoMaterias::new));
    }
}
