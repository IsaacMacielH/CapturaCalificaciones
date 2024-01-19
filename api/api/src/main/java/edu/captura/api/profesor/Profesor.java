package edu.captura.api.profesor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "profesores")
@Entity(name = "Profesor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private Integer codigo;
    private String contra;

    public Profesor(DatosRegistroProfesor datosRegistroProfesor) {
        this.nombre = datosRegistroProfesor.nombre();
        this.apellidos = datosRegistroProfesor.apellidos();
        this.codigo = datosRegistroProfesor.codigo();
        this.contra = datosRegistroProfesor.contra();
    }
}
