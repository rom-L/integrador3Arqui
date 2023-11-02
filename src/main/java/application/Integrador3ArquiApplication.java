package application;

import application.util.CargaDeDatos;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Integrador3ArquiApplication {

    public static void main(String[] args) {

        SpringApplication.run(Integrador3ArquiApplication.class, args);

        @PostConstruct
        CargaDeDatos.run;
    }

}
