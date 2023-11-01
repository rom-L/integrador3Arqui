package services;

import DTOs.CarreraDTO;
import models.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.MatriculacionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculacionService {
    @Autowired
    private MatriculacionRepository matriculacionRepository;


    public List<CarreraDTO> findAllCarrerasWithInscriptos() {
        List<Carrera> resultado = this.matriculacionRepository.findAllCarrerasWithInscriptos();   //resultado de la query
        List<CarreraDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Carrera carrera : resultado) {
            CarreraDTO carreraDTO = new CarreraDTO(carrera.getId(), carrera.getNombre());

            listaNueva.add(carreraDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }
}
