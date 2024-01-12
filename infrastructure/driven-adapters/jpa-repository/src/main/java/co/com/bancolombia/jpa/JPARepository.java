package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.tarea.TareaDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepository extends CrudRepository<TareaDTO, String>, QueryByExampleExecutor<TareaDTO> {
}
