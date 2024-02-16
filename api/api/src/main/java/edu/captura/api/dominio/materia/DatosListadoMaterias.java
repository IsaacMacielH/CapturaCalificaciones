package edu.captura.api.dominio.materia;

public record DatosListadoMaterias (Long id, Long crn, String nombre, String grado, Boolean activa) {

    public DatosListadoMaterias(Materia materia){
        this(materia.getId(), materia.getCrn(), materia.getNombre(), materia.getGrado(), materia.isActiva());
    }
}
