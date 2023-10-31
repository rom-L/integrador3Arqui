package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carreras")
@Getter
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre") @Setter
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private Set<Matriculacion> matriculaciones;

    public Carrera(String nombre) {
        this.nombre = nombre;
        this.matriculaciones = new HashSet<Matriculacion>();
    }

    public void addMatriculacion(Matriculacion m){
        this.matriculaciones.add(m);
    }
}
