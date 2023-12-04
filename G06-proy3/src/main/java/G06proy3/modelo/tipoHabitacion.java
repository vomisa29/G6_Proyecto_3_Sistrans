package G06proy3.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TipoHabitacion")
public class tipoHabitacion {

    @Id
    private Integer idTipo;
    
    private String nombreTipo;
    private Integer capacidad;
    private Integer costo;

    public tipoHabitacion(Integer idTipo, String nombreTipo, Integer capacidad, Integer costo) {
        this.idTipo = idTipo;
        this.nombreTipo = nombreTipo;
        this.capacidad = capacidad;
        this.costo = costo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
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
