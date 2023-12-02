package G06proy3.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TipoHabitacion")
public class tipoHabitacion {

    @Id
    private Integer idTipo;
    
    private String nombre;
    private Integer capacidad;
    private Integer costo;

    public tipoHabitacion(Integer idTipo, String nombre, Integer capacidad, Integer costo) {
        this.idTipo = idTipo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
}
