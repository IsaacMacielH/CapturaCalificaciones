package edu.captura.api.controller;

import edu.captura.api.dominio.profesor.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    //@Autowired no es recomendable para testing
    @Autowired
    private ProfesorRepository profesorRepository;

    //@RequestBody le avisa que eso es el body que esta llegando del request
    @PostMapping
    public ResponseEntity<DatosRespuestaProfesor> registrarProfesor(@RequestBody @Valid DatosRegistroProfesor datosRegistroProfesor, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("El request llega correctamente");
        Profesor profesor = profesorRepository.save(new Profesor(datosRegistroProfesor));
        DatosRespuestaProfesor datosRespuestaProfesor = new DatosRespuestaProfesor(profesor.getId(), profesor.getNombre(), profesor.getApellidos(), profesor.getCodigo());
        URI url = uriComponentsBuilder.path("/profesor/{id}").buildAndExpand(profesor.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaProfesor);
    }

    //Con DatosListadoProfesor obtenemos solo los valores que nos interesan
    //Page y pageable se usa para acomodar los resultados por paginas para no mostrar todo en una sola
    @GetMapping
    public ResponseEntity<Page<DatosListadoProfesor>> listadoProfesores(Pageable paginacion){
        //Con la siguiente linea regresa TODOS los profesores
        //return profesorRepository.findAll(paginacion).map(DatosListadoProfesor::new);

        //En la siguiente linea regresa a los profesores activos
        //Se creó "findByActivoTrue"
        return ResponseEntity.ok(profesorRepository.findByActivoTrue(paginacion).map(DatosListadoProfesor::new));
    }

    //Transactional se usa para terminar la transaccion y que se actualicen los datos en la base de datos
    //Es como hacer un commit a la base de datos al termionar la transaccion
    //Si no se pone, hace un roll back y no pasa nada en la base de datos
    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaProfesor> actualizarProfesor(@RequestBody @Valid DatosActualizarProfesor datosActualizarProfesor){
        Profesor profesor = profesorRepository.getReferenceById(datosActualizarProfesor.id());
        profesor.actualizarDatos(datosActualizarProfesor);
        return ResponseEntity.ok(new DatosRespuestaProfesor(profesor.getId(), profesor.getNombre(), profesor.getApellidos(), profesor.getCodigo()));
    }
// DELETE EN BASE DE DATOS
    //En el deleteMapping se obtiene una vairable, para elegir el id a eliminar, para obtener esa variable en el código
    //Se usa PathVariable, lo que le dice que esa variable viene de la dirección
//    @DeleteMapping("/{id}")
//    @Transactional
//    public void eliminarProfesor(@PathVariable Long id){
//        Profesor profesor = profesorRepository.getReferenceById(id);
//        profesorRepository.delete(profesor);
//    }

    //DELETE LOGICO
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarProfesor(@PathVariable Long id){
        Profesor profesor = profesorRepository.getReferenceById(id);
        profesor.desactivarProfesor();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaProfesor> retornaDatosProfesor(@PathVariable Long id){
        Profesor profesor = profesorRepository.getReferenceById(id);
        var datosRespuestaProfesor = new DatosRespuestaProfesor(profesor.getId(), profesor.getNombre(), profesor.getApellidos(), profesor.getCodigo());
        return ResponseEntity.ok(datosRespuestaProfesor);
    }
}
