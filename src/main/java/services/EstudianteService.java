package services;

import DTOs.EstudianteDTO;
import models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.EstudianteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;


    public List<EstudianteDTO> findAllByOrderByDniDesc() {      /**BUSCA A TODOS ORDENADO POR DNI DESC**/
        List<Estudiante> resultado = this.estudianteRepository.findAllByOrderByDniDesc();   //resultado de la query
        List<EstudianteDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Estudiante estudiante : resultado) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
                    estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
                    estudiante.getCiudadResidencia(), estudiante.getNumeroLibreta());


            listaNueva.add(estudianteDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }

    public EstudianteDTO findByNumeroLibreta(String numeroLibreta) {    /**BUSCA POR NUMERO LIBRETA**/
        Estudiante estudianteResultado = this.estudianteRepository.findByNumeroLibreta(numeroLibreta);   //se usa el .get() para conseguir el Estudiante del Optional

        //retorna un EstudianteDTO copiando los atributos del estudiante resultado
        return new EstudianteDTO(estudianteResultado.getDni(), estudianteResultado.getNombres(),
                estudianteResultado.getApellido(), estudianteResultado.getEdad(), estudianteResultado.getGenero(),
                estudianteResultado.getCiudadResidencia(), estudianteResultado.getNumeroLibreta());
    }

    public List<EstudianteDTO> findByGenero(String genero) {      /**BUSCA POR GENERO**/
        List<Estudiante> resultado = this.estudianteRepository.findByGenero(genero);   //resultado de la query
        List<EstudianteDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Estudiante estudiante : resultado) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
                    estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
                    estudiante.getCiudadResidencia(), estudiante.getNumeroLibreta());


            listaNueva.add(estudianteDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }

    public EstudianteDTO save(Estudiante estudiante) {   /**INSERTA UN ESTUDIANTE**/
        Estudiante estudianteGuardado = this.estudianteRepository.save(estudiante);

        //retorna un EstudianteDTO copiando los atributos del estudiante guardado
        return new EstudianteDTO(estudianteGuardado.getDni(), estudianteGuardado.getNombres(),
                estudianteGuardado.getApellido(), estudianteGuardado.getEdad(), estudianteGuardado.getGenero(),
                estudianteGuardado.getCiudadResidencia(), estudianteGuardado.getNumeroLibreta());
    }
}
