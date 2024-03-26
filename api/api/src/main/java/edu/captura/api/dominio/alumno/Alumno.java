package edu.captura.api.dominio.alumno;

import edu.captura.api.dominio.calificacion.Calificacion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Table(name="alumnos")
@Entity(name="Alumno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codigo;
    private String nombre;
    private String apellidos;
    private String grado;
    private String grupo;

    @OneToMany(mappedBy = "alumno_id")
    private Set<Calificacion> calificaciones;
}