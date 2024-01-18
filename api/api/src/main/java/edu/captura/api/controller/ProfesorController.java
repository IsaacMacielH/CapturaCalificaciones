package edu.captura.api.controller;

import edu.captura.api.profesor.DatosRegistroProfesor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    //@RequestBody le avisa que eso es el body que esta llegando del request
    @PostMapping
    public void registrarProfesor(@RequestBody DatosRegistroProfesor datosRegistroProfesor){
        System.out.println("El request llega correctamente");
        System.out.println(datosRegistroProfesor);
    }
}
