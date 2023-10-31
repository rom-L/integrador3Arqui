package DTOs;

import lombok.Getter;

@Getter
public class CarreraDTO {
    private Long id;
    private String nombre;

    public CarreraDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ID: " + id + "| Nombre: " + nombre;
    }
}
