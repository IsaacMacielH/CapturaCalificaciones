package edu.captura.api.profesor;

public record DatosListadoProfesor(String nombre, String apellidos, Integer codigo) {

    public DatosListadoProfesor(Profesor profesor){
        this(profesor.getNombre(), profesor.getApellidos(), profesor.getCodigo());
    }
}
