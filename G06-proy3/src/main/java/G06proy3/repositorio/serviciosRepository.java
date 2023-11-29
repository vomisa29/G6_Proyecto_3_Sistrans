package G06proy3.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import G06proy3.modelo.servicios;

public interface serviciosRepository extends MongoRepository<servicios,Integer>{

    @Query(value="{tipo:'?0'}", fields="{'tipo':1,'costo':1}")
    List<servicios> findByType(String tipo);
}
