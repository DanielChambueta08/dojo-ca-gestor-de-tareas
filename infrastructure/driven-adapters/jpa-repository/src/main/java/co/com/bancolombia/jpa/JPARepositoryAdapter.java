package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.jpa.tarea.TareaDTO;
import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.model.tarea.gateways.TareaRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<Tarea, TareaDTO, String, JPARepository>
implements TareaRepository
{

    public JPARepositoryAdapter(JPARepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Tarea.class));
    }

    //Metodo para obtener todas las tareas
    @Override
    public List<Tarea> listarTareas() {
        return super.findAll();
    }

    //Metodo para buscar una tarea por id
    @Override
    public Tarea buscarTareaPorId(long id) {
        return super.findById(String.valueOf(id));
    }
}
