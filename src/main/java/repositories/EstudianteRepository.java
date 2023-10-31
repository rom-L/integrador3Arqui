package repositories;

import models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findAllByOrderByDniDesc();
    Estudiante findByNumeroLibreta(String numeroLibreta);
    List<Estudiante> findByGenero(String genero);
}
