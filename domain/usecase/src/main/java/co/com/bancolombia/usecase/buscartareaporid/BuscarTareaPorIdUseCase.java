package co.com.bancolombia.usecase.buscartareaporid;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class BuscarTareaPorIdUseCase {
    private final TareaRepository tareaRepository;

    public Tarea buscarTareaPorId(long id) {
        return tareaRepository.buscarTareaPorId(id);
    }
}
