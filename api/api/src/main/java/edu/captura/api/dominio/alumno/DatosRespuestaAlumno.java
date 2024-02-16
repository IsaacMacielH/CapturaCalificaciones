package edu.captura.api.dominio.alumno;

public record DatosRespuestaAlumno(Long id, Long codigo, String nombre, String apellidos, String Grado, String Grupo) {

    public DatosRespuestaAlumno(Alumno alumno){
        this(alumno.getId(), alumno.getCodigo(), alumno.getNombre(), alumno.getApellidos(), alumno.getGrado(), alumno.getGrupo());
    }
}
