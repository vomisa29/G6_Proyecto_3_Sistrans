package G06proy3.repositorio;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import G06proy3.modelo.reserva;

public interface reservasRepository extends MongoRepository<reserva,Integer>{
    
    @Query("{$and:[" +
    "{fecha_inicio:{$gte: '?0'}}," +
    "{fecha_fin:{$lte: '?1'}}," +
    "{idHabitacion:{$eq:'?2'}}" +
    "]}")
    List<reserva> findByRange(LocalDateTime fecha_inicio, LocalDateTime fecha_fin, Integer idHabitacion);

    @Query("{$and:[{idCliente:'?0'},{_id:'?1'}]}")
    reserva findByIdCliente_AND_IdReserva(Integer idCliente, Integer idReserva);
}
