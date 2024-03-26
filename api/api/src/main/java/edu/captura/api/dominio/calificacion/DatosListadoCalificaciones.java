package edu.captura.api.dominio.calificacion;

import edu.captura.api.dominio.alumno.Alumno;
import edu.captura.api.dominio.materia.Materia;

public record DatosListadoCalificaciones(Alumno idAlumno, Materia idMateria, Long calificacion) {

    public DatosListadoCalificaciones(Calificacion calificacion){
        this(calificacion.getAlumno_id(), calificacion.getMateria_id(), calificacion.getCalif());
    }
}
