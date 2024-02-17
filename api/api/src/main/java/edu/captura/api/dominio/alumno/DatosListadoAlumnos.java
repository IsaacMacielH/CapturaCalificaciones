package edu.captura.api.dominio.alumno;

public record DatosListadoAlumnos(Long id, Long codigo, String nombre, String apellidos, String Grado, String Grupo) {

    public DatosListadoAlumnos(Alumno alumno){
        this(alumno.getId(), alumno.getCodigo(), alumno.getNombre(), alumno.getApellidos(), alumno.getGrado(), alumno.getGrupo());
    }
}
