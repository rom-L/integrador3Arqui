package application.repositories;

import application.models.Estudiante;
import application.models.Matriculacion;
import application.models.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MatriculacionRepository")
public interface MatriculacionRepository extends JpaRepository<Matriculacion, Long> {
    @Query("SELECT c FROM Carrera c JOIN c.matriculaciones m GROUP BY c.id, c.nombre")
    List<Carrera> findAllCarrerasWithInscriptos();

    @Query("SELECT e FROM Estudiante e WHERE e.ciudadResidencia = :ciudad AND e IN (SELECT m.estudiante FROM Matriculacion m WHERE m.carrera = :carrera)")
    List<Estudiante> findAllEstudiantesInCarreraByCiudad(@Param("ciudad") String ciudad, @Param("carrera") Long id);

    @Query("SELECT DISTINCT m.anioInscripcion FROM Matriculacion m ORDER BY m.anioInscripcion ASC")
    List<Integer> getAniosDeInscripcionesAsc();

    @Query("SELECT DISTINCT m.anioGraduacion FROM Matriculacion m ORDER BY m.anioGraduacion ASC")
    List<Integer> getAniosDeGraduacionesAsc();


}
