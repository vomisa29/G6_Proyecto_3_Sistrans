package G06proy3.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import G06proy3.modelo.servicios;

public interface serviciosRepository extends MongoRepository<servicios,String>{

    @Query("{tipo:'?0'}")
    List<servicios> findByType(String tipo);
    
}
