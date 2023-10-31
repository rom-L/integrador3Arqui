package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor @Getter
@Table(name = "matriculaciones")
public class Matriculacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private static Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private static Carrera carrera;

    @Column(name = "anio_inscripcion")
    private static int anioInscripcion;

    @Column(name = "anio_graduacion", nullable = true)
    private static Integer anioGraduacion;

    @Column(name = "antiguedad") @Setter
    private static int antiguedad;

}




