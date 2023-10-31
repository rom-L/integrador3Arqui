package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Table(name = "matriculaciones")
public class Matriculacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @Column(name = "anio_inscripcion")
    private Integer anioInscripcion;

    @Column(name = "anio_graduacion", nullable = true)
    private Integer anioGraduacion;

    @Column(name = "antiguedad") @Setter
    private Integer antiguedad;

    public Matriculacion(Estudiante estudiante, Carrera carrera, Integer anioInscripcion, Integer anioGraduacion, Integer antiguedad) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.anioInscripcion = anioInscripcion;
        this.anioGraduacion = anioGraduacion;
        this.antiguedad = antiguedad;
    }

}




