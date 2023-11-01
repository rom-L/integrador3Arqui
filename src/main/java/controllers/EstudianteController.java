package controllers;

import DTOs.EstudianteDTO;
import models.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.EstudianteService;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;


    @GetMapping("/OrderByDNI")
    public List<EstudianteDTO> getAllOrderByDni() {
        return this.estudianteService.findAllByOrderByDniDesc();
    }

    @GetMapping("/getByLibreta/{nroLibreta}")
    public EstudianteDTO getByNumeroLibreta(@PathVariable String nroLibreta) {
        return this.estudianteService.findByNumeroLibreta(nroLibreta);
    }

    @GetMapping("/getByGenero/{genero}")
    public List<EstudianteDTO> getByGenero(@PathVariable String genero) {
        return this.estudianteService.findByGenero(genero);
    }

    @PostMapping("")
    public EstudianteDTO post(@RequestBody Estudiante estudiante) {
        return this.estudianteService.save(estudiante);
    }
}

