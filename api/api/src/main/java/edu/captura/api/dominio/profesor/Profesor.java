package edu.captura.api.dominio.profesor;

import edu.captura.api.dominio.materia.Materia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
    private boolean activo;

    @OneToMany(mappedBy = "profesor")
    private List<Materia> materias;



    public Profesor(DatosRegistroProfesor datosRegistroProfesor) {
        this.nombre = datosRegistroProfesor.nombre();
        this.apellidos = datosRegistroProfesor.apellidos();
        this.codigo = datosRegistroProfesor.codigo();
        this.contra = datosRegistroProfesor.contra();
        this.activo = true;
    }

    public void actualizarDatos(DatosActualizarProfesor datosActualizarProfesor) {
        if(datosActualizarProfesor.nombre() != null){
            this.nombre = datosActualizarProfesor.nombre();
        }
        if(datosActualizarProfesor.apellidos() != null){
            this.apellidos = datosActualizarProfesor.apellidos();
        }
        if(datosActualizarProfesor.contra() != null){
            this.contra = datosActualizarProfesor.contra();
        }
    }

    public void desactivarProfesor() {
        this.activo = false;
    }
}
