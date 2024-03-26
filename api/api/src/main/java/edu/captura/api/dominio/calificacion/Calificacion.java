package edu.captura.api.dominio.calificacion;

import edu.captura.api.dominio.alumno.Alumno;
import edu.captura.api.dominio.materia.Materia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "calificaciones")
@Entity(name = "Calificacion")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno_id;

    @OneToOne
    @JoinColumn(name = "id_materia")
    private Materia materia_id;

    private Long calif;
}
