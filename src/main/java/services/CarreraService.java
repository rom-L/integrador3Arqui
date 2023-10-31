package services;

import DTOs.CarreraDTO;
import models.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CarreraRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;


    public CarreraDTO save(Carrera carrera) {   /**INSERTA UNA CARRERA**/
        Carrera carreraGuardada = this.carreraRepository.save(carrera);

        //retorna un CarreraDTO copiando los atributos de la carrera guardada
        return new CarreraDTO(carreraGuardada.getId(), carreraGuardada.getNombre());
    }
}
