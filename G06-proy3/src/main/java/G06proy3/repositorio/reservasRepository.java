package G06proy3.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import G06proy3.modelo.reserva;

public interface reservasRepository extends MongoRepository<reserva,Integer>{
    
    @Query("{$and:[" +
    "{fecha_inicio:{$gte: '?0'}}," +
    "{fecha_fin:{$lte: '?1'}}" +
    "]}")
    List<reserva> findByRange(Date fecha_inicio, Date fecha_fin);

    @Query("idHabitacion:'?0")
    List<reserva> findByIdHabitacion(Integer idHabitacion);
}
