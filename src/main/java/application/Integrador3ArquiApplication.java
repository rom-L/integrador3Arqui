package application;

import application.util.CargaDeDatos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Integrador3ArquiApplication {
    @Autowired
    private CargaDeDatos cargaDeDatos;


    public static void main(String[] args) {
        SpringApplication.run(Integrador3ArquiApplication.class, args);
    }

    @PostConstruct
    public void init() throws IOException, Exception {
        cargaDeDatos.cargarDatos();
    }

}
