package co.com.bancolombia.usecase.listartareas;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListarTareasUseCase {
    private final TareaRepository tareaRepository;
    public List<Tarea> listarTareas() {
        return tareaRepository.listarTareas();
    }
}
