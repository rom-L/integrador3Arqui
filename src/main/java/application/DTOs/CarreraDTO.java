package application.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonIgnoreProperties( ignoreUnknown = true )
public class CarreraDTO implements Serializable {

    private String nombre;

    public CarreraDTO(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre;
    }
}
