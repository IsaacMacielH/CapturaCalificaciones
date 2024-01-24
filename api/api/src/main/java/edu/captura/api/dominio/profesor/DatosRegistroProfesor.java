package edu.captura.api.dominio.profesor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO Data Transfer Object
//Los saltos de linea son solo con fines visuales
public record DatosRegistroProfesor(@NotBlank String nombre,
                                    @NotBlank
                                    String apellidos,
                                    @NotNull
                                    Integer codigo,
                                    @NotBlank
                                    String contra) {
}
