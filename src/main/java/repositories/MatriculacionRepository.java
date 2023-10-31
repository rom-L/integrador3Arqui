package repositories;

import models.Matriculacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculacionRepository extends JpaRepository<Matriculacion, Integer> {
    
}
