package edu.captura.api.profesor;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarProfesor(@NotNull Long id, String nombre, String apellidos, String contra) {
}
