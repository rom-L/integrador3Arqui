package application.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carreras")
@Getter @Setter
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private Set<Matriculacion> matriculaciones;

    public Carrera(String nombre) {
        this.nombre = nombre;
        this.matriculaciones = new HashSet<Matriculacion>();
    }

    public Carrera() {

    }

    public void addMatriculacion(Matriculacion m){
        this.matriculaciones.add(m);
    }
}
