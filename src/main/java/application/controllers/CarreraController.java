package application.controllers;

import application.DTOs.CarreraDTO;
import application.models.Carrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import application.services.CarreraService;

@RestController("CarreraController")
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;

    @PostMapping("")
    public CarreraDTO post(@RequestBody Carrera carrera) {
        return this.carreraService.save(carrera);
    }
}
