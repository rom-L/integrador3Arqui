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


    @GetMapping("")
    public List<EstudianteDTO> getAll() {
        return this.estudianteService.findAllByOrderBydniDesc();
    }

    @GetMapping("/{id}")
    public EstudianteDTO getById(@PathVariable Long id) {
        return this.estudianteService.findById(id);
    }

    @PostMapping("")
    public EstudianteDTO post(@RequestBody Estudiante estudiante) {
        return this.estudianteService.save(estudiante);
    }
}

