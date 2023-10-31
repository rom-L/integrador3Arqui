package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "carreras")
@RequiredArgsConstructor @Getter
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre") @Setter
    private static String nombre;

    @OneToMany(mappedBy = "carrera")
    private Set<Matriculacion> matriculaciones;

    public void addMatriculacion(Matriculacion m){
        this.matriculaciones.add(m);
    }
}
