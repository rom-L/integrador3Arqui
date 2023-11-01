package DTOs;

import lombok.Getter;

@Getter
public class MatriculacionDTO {
    private int id;
    private Long estudianteId;
    private Long carreraId;
    private Integer anioInscripcion;
    private Integer anioGraduacion;
    private Integer antiguedad;

    public MatriculacionDTO(int id, Long estudianteId, Long carreraId, Integer anioInscripcion, Integer anioGraduacion, Integer antiguedad) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.carreraId = carreraId;
        this.anioInscripcion = anioInscripcion;
        this.anioGraduacion = anioGraduacion;
        this.antiguedad = antiguedad;
    }


    @Override
    public String toString() {
        return "MatriculacionDTO{" +
                "id=" + id +
                ", estudianteId=" + estudianteId +
                ", carreraId=" + carreraId +
                ", anioInscripcion=" + anioInscripcion +
                ", anioGraduacion=" + anioGraduacion +
                ", antiguedad=" + antiguedad +
                '}';
    }
}
