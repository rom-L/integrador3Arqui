package application.repositories;

import application.models.Carrera;
import application.models.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("EstudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    List<Estudiante> findAllByOrderByDniDesc();
    Optional<Estudiante> findByNumeroLibreta(String numeroLibreta);
    List<Estudiante> findByGenero(String genero);

    @Query("SELECT e FROM Estudiante e JOIN e.matriculaciones m WHERE m.carrera = :c AND m.anioInscripcion = :year")
    List<Estudiante> findAllInscribedByCarreraAndYear(@Param("c") Carrera c, @Param("year") Integer year);

    @Query("SELECT e FROM Estudiante e JOIN e.matriculaciones m WHERE m.carrera = :c AND m.anioGraduacion = :year")
    List<Estudiante> findAllGraduatedByCarreraAndYear(@Param("c") Carrera c, @Param("year") Integer year);

}
