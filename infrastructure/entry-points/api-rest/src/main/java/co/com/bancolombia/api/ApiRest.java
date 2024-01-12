package co.com.bancolombia.api;
import co.com.bancolombia.model.tarea.Tarea;
import co.com.bancolombia.usecase.agregartarea.AgregarTareaUseCase;
import co.com.bancolombia.usecase.buscartareaporid.BuscarTareaPorIdUseCase;
import co.com.bancolombia.usecase.listartareas.ListarTareasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final ListarTareasUseCase listarTareasUseCase;
    private final BuscarTareaPorIdUseCase buscarTareaPorIdUseCase;
    private final AgregarTareaUseCase agregarTarea;

    @GetMapping(path = "/path")
    public String commandName() {
        return "Hello World";
    }

    //Metodo para listar todas las tareas
    @GetMapping(path = "/ListarTareas")
    public ResponseEntity<List<Tarea>> getTareas() {
        return new ResponseEntity<List<Tarea>>(
                listarTareasUseCase.listarTareas(), new HttpHeaders(), HttpStatus.OK);
    }

    //Metodo para buscar una tarea por id
    @GetMapping(path = "/BuscarTareaPorId/{id}")
    public ResponseEntity<Tarea> getTareaById(@PathVariable("id") long id) {
        Tarea tarea = buscarTareaPorIdUseCase.buscarTareaPorId(id);
        if (tarea != null) {
            System.out.println("Tarea encontrada con éxito");
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            System.out.println("Tarea no encontrada");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Metodo para agregar una tarea
    @PostMapping(path = "/AgregarTarea")
    public ResponseEntity<Tarea> addTarea(@RequestBody Tarea newTarea) {
        Tarea tareaAgregada = agregarTarea.agregarTarea(newTarea);
        if (tareaAgregada == null) {
            System.out.println("Tarea ya existe");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            System.out.println("Tarea agregada con éxito");
            return new ResponseEntity<Tarea>(tareaAgregada, new HttpHeaders(), HttpStatus.CREATED);
        }
    }


}
