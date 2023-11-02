package application.repositories;

import application.models.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CarreraRepository")
public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    List<Carrera> findAllByOrderByNombreAsc();
}
