package edu.captura.api.dominio.calificacion;

import jakarta.validation.constraints.NotNull;

public record DatosRegistroCalificacion(@NotNull Long id_alumno,
                                        @NotNull Long id_materia,
                                        @NotNull Long calif) {
}
