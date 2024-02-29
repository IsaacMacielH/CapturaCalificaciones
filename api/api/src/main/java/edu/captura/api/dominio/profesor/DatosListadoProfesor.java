package edu.captura.api.dominio.profesor;

import edu.captura.api.dominio.materia.Materia;

import java.util.Set;

public record DatosListadoProfesor(Long id, String nombre, String apellidos, Integer codigo) {

    public DatosListadoProfesor(Profesor profesor){
        this(profesor.getId(), profesor.getNombre(), profesor.getApellidos(), profesor.getCodigo());
    }
}
