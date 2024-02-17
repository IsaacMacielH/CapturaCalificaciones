package edu.captura.api.controller;

import edu.captura.api.dominio.alumno.AlumnoRepository;
import edu.captura.api.dominio.alumno.DatosListadoAlumnos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping("/{grado}/{grupo}")
    public ResponseEntity<Page<DatosListadoAlumnos>> retornaDatosAlumnos(Pageable paginacion, @PathVariable String grado, @PathVariable String grupo){
        //List<Alumno> alumno = alumnoRepository.findByGradoAndGrupo(grado,grupo);
        //var datosRespuestaAlumno = new DatosRespuestaAlumno( alumno.getId(), alumno.getCodigo(), alumno.getNombre(), alumno.getApellidos(), alumno.getGrado(), alumno.getGrupo());
        return ResponseEntity.ok(alumnoRepository.findByGradoAndGrupo(paginacion, grado, grupo).map(DatosListadoAlumnos::new));
    }
}
