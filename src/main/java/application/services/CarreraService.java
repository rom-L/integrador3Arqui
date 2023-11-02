package application.services;

import application.DTOs.CarreraDTO;
import application.models.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.CarreraRepository;

import java.util.ArrayList;
import java.util.List;

@Service("CarreraService")
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;


    public CarreraDTO save(Carrera carrera) {   /**INSERTA UNA CARRERA**/
        Carrera carreraGuardada = this.carreraRepository.save(carrera);

        //retorna un CarreraDTO copiando los atributos de la carrera guardada
        return new CarreraDTO(carreraGuardada.getId(), carreraGuardada.getNombre());
    }
}
