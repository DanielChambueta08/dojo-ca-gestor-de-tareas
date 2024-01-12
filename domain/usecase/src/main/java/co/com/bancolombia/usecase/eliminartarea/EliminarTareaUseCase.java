package co.com.bancolombia.usecase.eliminartarea;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class EliminarTareaUseCase {
    private final TareaRepository tareaRepository;

    public boolean eliminarTarea(long id) {
        Tarea tarea = tareaRepository.buscarTareaPorId(id);
        if (tarea != null) {
            tareaRepository.eliminarTarea(id);
            return true; // Tarea eliminada con éxito
        } else {
            return false; // Tarea no encontrada
        }
    }
}
