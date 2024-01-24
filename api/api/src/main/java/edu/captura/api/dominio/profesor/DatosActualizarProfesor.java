package edu.captura.api.dominio.profesor;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarProfesor(@NotNull Long id, String nombre, String apellidos, String contra) {
}
