package repositories;

import models.Matriculacion;
import models.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculacionRepository extends JpaRepository<Matriculacion, Integer> {
    @Query("SELECT c FROM Carrera c JOIN c.matriculaciones m GROUP BY c.id, c.nombre")
    List<Carrera> findAllCarrerasWithInscriptos();

    @Query("SELECT DISTINCT m.anioInscripcion FROM Matriculacion m ORDER BY m.anioInscripcion ASC")
    List<Integer> getAniosDeInscripcionesAsc();

    @Query("SELECT DISTINCT m.anioGraduacion FROM Matriculacion m ORDER BY m.anioGraduacion ASC")
    List<Integer> getAniosDeGraduacionesAsc();


}
