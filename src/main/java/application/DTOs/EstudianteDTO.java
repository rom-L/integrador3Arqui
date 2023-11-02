package application.DTOs;

import lombok.Getter;

@Getter
public class EstudianteDTO {
    private Long dni;
    private String nombres;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private String numeroLibreta;

    public EstudianteDTO(Long dni, String nombres, String apellido, int edad, String genero, String ciudadResidencia, String numeroLibreta) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibreta = numeroLibreta;
    }


    @Override
    public String toString() {
        return "DNI: " + this.dni + " - " + this.nombres + " " + this.apellido + " | Edad: " + this.edad + " | Genero: " + this.genero + " | Ciudad: " + this.ciudadResidencia + " | Nro Libreta: " + this.numeroLibreta;
    }
}