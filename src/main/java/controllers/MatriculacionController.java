package controllers;

import DTOs.CarreraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
