package edu.captura.api.controller;

import edu.captura.api.dominio.alumno.Alumno;
import edu.captura.api.dominio.alumno.AlumnoRepository;
import edu.captura.api.dominio.alumno.DatosRespuestaAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping("/{id}/{grado}/{grupo}")
    public ResponseEntity<DatosRespuestaAlumno> retornaDatosAlumnos(@PathVariable Long id, @PathVariable String grado, @PathVariable String grupo){
        Alumno alumno = alumnoRepository.getReferenceById(id);
    }
}
