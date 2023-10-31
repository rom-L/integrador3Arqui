package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@RequiredArgsConstructor @Getter
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @Column(name = "dni")
    private static Long dni;

    @Column(name = "nombres")
    private static String nombres;

    @Column(name = "apellido")
    private static String apellido;

    @Column(name = "edad")
    private static int edad;

    @Column(name = "genero")
    private static String genero;

    @Column(name = "ciudad_residencia")
    private static String ciudadResidencia;

    @Column(name = "numero_libreta")
    private static String numeroLibreta;

    @OneToMany(mappedBy = "estudiante")
    private Set<Matriculacion> matriculaciones;


    public void addMatriculacion(Matriculacion matriculacion) {
        this.matriculaciones.add(matriculacion);
    }

    public void removeMatriculacion(Matriculacion matriculacion) {
        this.matriculaciones.remove(matriculacion);
    }
}
