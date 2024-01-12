package co.com.bancolombia.jpa.tarea;

import co.com.bancolombia.model.tarea.Tarea;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tarea")
public class TareaDTO {
    @Id
    private Long id;
    private String titulo;
    private String descripcion;
    private String estado;

    public static Tarea newTarea(Long id, String titulo, String descripcion, String estado) {
        return new Tarea(id, titulo, descripcion, estado);
    }
}

