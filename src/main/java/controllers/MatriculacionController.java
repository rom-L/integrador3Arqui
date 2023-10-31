package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.MatriculacionService;

@RestController
@RequestMapping("/matriculaciones")
public class MatriculacionController {
    @Autowired
    private MatriculacionService matriculacionService;



}
