package edu.captura.api.controller;

import edu.captura.api.profesor.DatosListadoProfesor;
import edu.captura.api.profesor.DatosRegistroProfesor;
import edu.captura.api.profesor.Profesor;
import edu.captura.api.profesor.ProfesorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    //@Autowired no es recomendable para testing
    @Autowired
    private ProfesorRepository profesorRepository;

    //@RequestBody le avisa que eso es el body que esta llegando del request
    @PostMapping
    public void registrarProfesor(@RequestBody @Valid DatosRegistroProfesor datosRegistroProfesor){
        System.out.println("El request llega correctamente");
        profesorRepository.save(new Profesor(datosRegistroProfesor));
    }

    //Con DatosListadoProfesor obtenemos solo los valores que nos interesan
    //Page y pageable se usa para acomodar los resultados por paginas para no mostrar todo en una sola
    @GetMapping
    public Page<DatosListadoProfesor> listadoProfesores(Pageable paginacion){
        return profesorRepository.findAll(paginacion).map(DatosListadoProfesor::new);
    }
}
