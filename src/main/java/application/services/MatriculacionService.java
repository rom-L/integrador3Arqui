package application.services;

import application.DTOs.*;
import application.models.Carrera;
import application.models.Estudiante;
import application.models.Matriculacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.CarreraRepository;
import application.repositories.EstudianteRepository;
import application.repositories.MatriculacionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("MatriculacionService")
public class MatriculacionService {
    @Autowired
    private MatriculacionRepository matriculacionRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;



    /**INSERTA UNA MATRICULACION  | (2.A)**/
    public MatriculacionDTO save(Matriculacion matriculacion) throws Exception {

        Optional<Estudiante> e = estudianteRepository.findById(matriculacion.getEstudiante().getDni());
        Optional<Carrera> c = carreraRepository.findById(matriculacion.getCarrera().getId());

        if (!e.isPresent() || !c.isPresent()){
            throw new Exception("El estudiante o la carrera no existen en el sistema");
        }

        Matriculacion matriculacionGuardada = this.matriculacionRepository.save(matriculacion);

        return new MatriculacionDTO(matriculacionGuardada.getId(), matriculacionGuardada.getEstudiante().getDni(),
                matriculacionGuardada.getCarrera().getId(), matriculacionGuardada.getAnioInscripcion(),
                matriculacionGuardada.getAnioGraduacion(), matriculacionGuardada.getAntiguedad());
    }


    /**BUSCA CARRERAS CON INSCRIPTOS ORDENADO POR CANT. INSCRIPTOS  | (2.F)**/
    public List<CarreraDTO> findAllCarrerasWithInscriptos() {
        List<Carrera> resultado = this.matriculacionRepository.findAllCarrerasWithInscriptos();   //resultado de la query
        List<CarreraDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Carrera carrera : resultado) {
            CarreraDTO carreraDTO = new CarreraDTO(carrera.getNombre());

            listaNueva.add(carreraDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }


    /**BUSCA ESTUDIANTES EN UNA CARRERA ESPECIFICADA FILTRADO POR CIUDAD  | (2.G)**/
    public List<EstudianteDTO> findAllEstudiantesInCarreraByCiudad(Long idCarrera, String ciudad) {
        List<Estudiante> resultado = this.matriculacionRepository.findAllEstudiantesInCarreraByCiudad(ciudad, idCarrera);   //resultado de la query
        List<EstudianteDTO> listaNueva = new ArrayList<>(); //lista vacia para poner los DTOs

        for (Estudiante estudiante : resultado) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
                    estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
                    estudiante.getCiudadResidencia(), estudiante.getNumeroLibreta());


            listaNueva.add(estudianteDTO);
        }

        return listaNueva;  //retorna la lista de DTOs
    }


    /**GENERA REPORTE | (2.H)**/
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
