package co.com.bancolombia.model.tarea;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Tarea {
    private Long id;
    private String titulo;
    private String descripcion;
    private String estado;

    public static Tarea newTarea(Long id, String titulo, String descripcion, String estado) {
        return new Tarea(id, titulo, descripcion, estado);
    }
}
