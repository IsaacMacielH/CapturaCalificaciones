package edu.captura.api.profesor;

public record DatosListadoProfesor(Long id, String nombre, String apellidos, Integer codigo) {

    public DatosListadoProfesor(Profesor profesor){
        this(profesor.getId(), profesor.getNombre(), profesor.getApellidos(), profesor.getCodigo());
    }
}
