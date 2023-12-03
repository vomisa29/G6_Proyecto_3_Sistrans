package G06proy3.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import G06proy3.modelo.cliente;

public interface clienteRepository extends MongoRepository<cliente,Integer> {
    
}
