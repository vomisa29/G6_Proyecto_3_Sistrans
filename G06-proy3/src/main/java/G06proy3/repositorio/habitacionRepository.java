package G06proy3.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import G06proy3.modelo.habitacion;

public interface habitacionRepository extends MongoRepository<habitacion,Integer>{

    @Query(value="{televisor:'?0'}", fields="{'tipo':1,'costo':1}")
    List<habitacion> findHabitacionesWithTelevisor(boolean televisor);
}
