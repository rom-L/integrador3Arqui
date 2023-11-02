package application.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "estudiantes")
public class Estudiante implements Serializable {
    @Id
    @Column(name = "dni")
    private Long dni;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @Column(name = "numero_libreta")
    private String numeroLibreta;

    @OneToMany(mappedBy = "estudiante")
    private Set<Matriculacion> matriculaciones;

    public Estudiante(Long dni, String nombres, String apellido, int edad, String genero, String ciudadResidencia, String numeroLibreta) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibreta = numeroLibreta;
        this.matriculaciones = new HashSet<Matriculacion>();
    }

    public Estudiante() {

    }

    public void addMatriculacion(Matriculacion matriculacion) {
        this.matriculaciones.add(matriculacion);
    }

    public void removeMatriculacion(Matriculacion matriculacion) {
        this.matriculaciones.remove(matriculacion);
    }
}
