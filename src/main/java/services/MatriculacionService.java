package services;

import DTOs.CarreraConInscriptosYEgresadosDTO;
import DTOs.CarreraDTO;
import DTOs.EstudianteDTO;
import DTOs.ReporteDTO;
import models.Carrera;
import models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CarreraRepository;
import repositories.EstudianteRepository;
import repositories.MatriculacionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculacionService {
    @Autowired
    private MatriculacionRepository matriculacionRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;


    public List<CarreraDTO> findAllCarrerasWithInscriptos() {
        List<Carrera> resultado = this.matriculacionRepository.findAllCarrerasWithInscriptos();   //resultado de la query
        List<CarreraDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Carrera carrera : resultado) {
            CarreraDTO carreraDTO = new CarreraDTO(carrera.getId(), carrera.getNombre());

            listaNueva.add(carreraDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }

    public ReporteDTO getReporte() {
        //obtenemos todos los años en donde hubieron graduaciones
        List<Integer> aniosDeGraduaciones = matriculacionRepository.getAniosDeGraduacionesAsc();
        //obtenemos todos los años en donde hubieron inscripciones
        List<Integer> aniosDeInscripciones = matriculacionRepository.getAniosDeInscripcionesAsc();

        List<Carrera> allCarreras = carreraRepository.findAllByOrderByNombreAsc();
        ReporteDTO reporte = new ReporteDTO();

        //por cada carrera persistida
        for (Carrera c: allCarreras) {
            //CarreraDTO que tendrá dentro todos los estudiantes que se inscribieron y egresaron en ella
            CarreraConInscriptosYEgresadosDTO carreraConInscriptosYEgresadosDTO = new CarreraConInscriptosYEgresadosDTO(c.getNombre());
            //por cada año se obtienen los estudiantes que se graduaron en la carrera 'x'
            for (Integer anio : aniosDeGraduaciones) {
                List<EstudianteDTO> estudianteGraduadosDTOs = new ArrayList<>();
                for (Estudiante e : estudianteRepository.findAllGraduatedByCarreraAndYear(c, anio)) {
                    estudianteGraduadosDTOs.add(new EstudianteDTO(e.getDni(), e.getNombres(), e.getApellido(), e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumeroLibreta()));
                }
                carreraConInscriptosYEgresadosDTO.agregarGraduadosEnAnio(estudianteGraduadosDTOs, anio);
            }
            //por cada año se obtienen los estudiantes que se inscribieron en la carrera 'x'
            for (Integer anio : aniosDeInscripciones) {
                List<EstudianteDTO> estudianteInscriptosDTOs = new ArrayList<>();
                for (Estudiante e : estudianteRepository.findAllInscribedByCarreraAndYear(c, anio)) {
                    estudianteInscriptosDTOs.add(new EstudianteDTO(e.getDni(), e.getNombres(), e.getApellido(), e.getEdad(), e.getGenero(), e.getCiudadResidencia(), e.getNumeroLibreta()));
                }
                carreraConInscriptosYEgresadosDTO.agregarInscriptosEnAnio(estudianteInscriptosDTOs, anio);
            }
            //agregamos la carrera al reporte
            reporte.agregarCarrerasConInscriptosEnAnio(carreraConInscriptosYEgresadosDTO);
        }
        return reporte;
    }
}
