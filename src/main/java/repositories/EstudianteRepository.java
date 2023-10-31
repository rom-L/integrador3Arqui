package repositories;

import models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findAllByOrderByDniDesc();
    Optional<Estudiante> findByNumeroLibreta(String numeroLibreta);
    List<Estudiante> findByGenero(String genero);
}
