package application.util;

import application.models.Carrera;
import application.models.Estudiante;
import application.models.Matriculacion;
import application.repositories.CarreraRepository;
import application.repositories.EstudianteRepository;
import application.services.MatriculacionService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CargaDeDatos {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private MatriculacionService matriculacionService;



    public void cargarDatos() throws IOException, Exception {
        cargarDatosEstudiante();
        cargarDatosCarrera();
        cargarDatosMatriculacion();
    }


    public void cargarDatosEstudiante() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/application/csv/estudiantes.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Estudiante estudiante = new Estudiante();

                estudiante.setDni(Long.parseLong(csvRecord.get("dni")));
                estudiante.setNombres(csvRecord.get("nombres"));
                estudiante.setApellido(csvRecord.get("apellido"));
                estudiante.setEdad(Integer.parseInt(csvRecord.get("edad")));
                estudiante.setGenero(csvRecord.get("genero"));
                estudiante.setCiudadResidencia(csvRecord.get("ciudad_residencia"));
                estudiante.setNumeroLibreta(csvRecord.get("numero_libreta"));


                this.estudianteRepository.save(estudiante); //guarda al estudiante en la base de datos
            }
        }
    }

    public void cargarDatosCarrera() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/application/csv/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera carrera = new Carrera();

                carrera.setNombre(csvRecord.get("nombre"));


                this.carreraRepository.save(carrera); //guarda a la carrera en la base de datos
            }
        }
    }

    public void cargarDatosMatriculacion() throws IOException, Exception {
        File archivoCSV = ResourceUtils.getFile("src/main/java/application/csv/matriculaciones.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Matriculacion matriculacion = new Matriculacion();

                Estudiante e = this.estudianteRepository.findById(Long.parseLong(csvRecord.get("estudiante_id"))).get();
                Carrera c = this.carreraRepository.findById(Long.parseLong(csvRecord.get("carrera_id"))).get();
                matriculacion.setEstudiante(e);
                matriculacion.setCarrera(c);
                matriculacion.setAnioInscripcion(Integer.parseInt(csvRecord.get("anio_inscripcion")));
                matriculacion.setAnioGraduacion(Integer.parseInt(csvRecord.get("anio_graduacion")));
                matriculacion.setAntiguedad(Integer.parseInt(csvRecord.get("antiguedad")));


                this.matriculacionService.save(matriculacion); //guarda a la matriculacion en la base de datos
            }
        }
    }
}
