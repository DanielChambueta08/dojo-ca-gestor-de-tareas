package co.com.bancolombia.usecase.agregartarea;

import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class AgregarTareaUseCase {
    private final TareaRepository tareaRepository;

    public Tarea agregarTarea(Tarea tarea) {
        Tarea tareaById = tareaRepository.buscarTareaPorId(tarea.getId());
        if (tareaById == null) {
            tareaRepository.agregarTarea(tarea);
            return tarea;
        } else {
            return null;
        }
    }
}
