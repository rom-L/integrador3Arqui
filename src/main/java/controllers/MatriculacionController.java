package controllers;

import DTOs.CarreraDTO;
import DTOs.EstudianteDTO;
import DTOs.MatriculacionDTO;
import DTOs.ReporteDTO;
import models.Matriculacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.MatriculacionService;

import java.util.List;

@RestController
@RequestMapping("/matriculaciones")
public class MatriculacionController {
    @Autowired
    private MatriculacionService matriculacionService;

    @GetMapping("/carrerasConInscriptos")
    public List<CarreraDTO> getCarrerasConInscriptos() {
        return this.matriculacionService.findAllCarrerasWithInscriptos();
    }

    @GetMapping("/getEstudiantesByCarrera/{idCarrera}/filterByCiudad/{ciudad}")
    public List<EstudianteDTO> getEstudiantesByCarreraByCiudad(@PathVariable("idCarrera") Long idCarrera, @PathVariable("ciudad") String ciudad) {
        return this.matriculacionService.findAllEstudiantesInCarreraByCiudad(idCarrera, ciudad);
    }

    @PostMapping("")
    public MatriculacionDTO post(@RequestBody Matriculacion matriculacion) {
        return this.matriculacionService.save(matriculacion);
    }

    @GetMapping("/reporte")
    public ReporteDTO getReporte(){
        return matriculacionService.getReporte();
    }
}
