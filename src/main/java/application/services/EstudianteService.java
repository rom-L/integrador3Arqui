package application.services;

import application.DTOs.EstudianteDTO;
import application.models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.EstudianteRepository;

import java.util.ArrayList;
import java.util.List;

@Service("EstudianteService")
public class EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;



    /**BUSCA A TODOS ORDENADO POR DNI DESC | (2.C)**/
    public List<EstudianteDTO> findAllByOrderByDniDesc() {
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


    /**BUSCA POR NUMERO LIBRETA | (2.D)**/
    public EstudianteDTO findByNumeroLibreta(String numeroLibreta) {
        Estudiante estudianteResultado = this.estudianteRepository.findByNumeroLibreta(numeroLibreta).get();   //se usa el .get() para conseguir el Estudiante del Optional

        //retorna un EstudianteDTO copiando los atributos del estudiante resultado
        return new EstudianteDTO(estudianteResultado.getDni(), estudianteResultado.getNombres(),
                estudianteResultado.getApellido(), estudianteResultado.getEdad(), estudianteResultado.getGenero(),
                estudianteResultado.getCiudadResidencia(), estudianteResultado.getNumeroLibreta());
    }


    /**BUSCA POR GENERO | (2.E)**/
    public List<EstudianteDTO> findByGenero(String genero) {
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


    /**INSERTA UN ESTUDIANTE | (2.A)**/
    public EstudianteDTO save(Estudiante estudiante) {
        Estudiante estudianteGuardado = this.estudianteRepository.save(estudiante);

        //retorna un EstudianteDTO copiando los atributos del estudiante guardado
        return new EstudianteDTO(estudianteGuardado.getDni(), estudianteGuardado.getNombres(),
                estudianteGuardado.getApellido(), estudianteGuardado.getEdad(), estudianteGuardado.getGenero(),
                estudianteGuardado.getCiudadResidencia(), estudianteGuardado.getNumeroLibreta());
    }
}
