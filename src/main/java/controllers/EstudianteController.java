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
        return this.estudianteService.findAllByOrderBydniDesc();
    }

    @GetMapping("/nroLibreta/{nroLibreta}")
    public EstudianteDTO getBynumeroLibreta(@PathVariable String nroLibreta) {
        return this.estudianteService.findBynumeroLibreta(nroLibreta);
    }

    @PostMapping("")
    public EstudianteDTO post(@RequestBody Estudiante estudiante) {
        return this.estudianteService.save(estudiante);
    }
}

