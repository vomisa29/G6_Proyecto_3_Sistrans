package G06proy3.modelo;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Cliente")
public class cliente {
    
    @Id
    private Integer idCliente;

    private String nombre;
    private ArrayList<consumo> consumo;

    public cliente(Integer idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<consumo> getConsumo() {
        return consumo;
    }

    public void setConsumo(ArrayList<consumo> consumo) {
        this.consumo = consumo;
    }

}
