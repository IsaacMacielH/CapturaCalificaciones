package edu.captura.api.profesor;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}
