package G06proy3.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import G06proy3.modelo.tipoHabitacion;

public interface tipoHabitacionRepository extends MongoRepository<tipoHabitacion,Integer>{

    @Query(value="{capacidad:'?0'}", fields="{'nombreTipo':1,'costo':1}")
    List<tipoHabitacion> findByCapacidad(Integer capacidad);
    
}
