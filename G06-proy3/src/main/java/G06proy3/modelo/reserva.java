package G06proy3.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Reserva")
public class reserva {
    
    @Id
    private Integer idReserva;

    private Integer idHabitacion;
    private Integer idCliente;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;
    private ArrayList<Integer> consumo;
    
    public reserva(Integer idReserva, Integer idHabitacion, Integer idCliente, LocalDateTime fecha_inicio, LocalDateTime fecha_fin) {
        this.idReserva = idReserva;
        this.idHabitacion = idHabitacion;
        this.idCliente = idCliente;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public ArrayList<Integer> getConsumo() {
        return consumo;
    }

    public void setConsumo(ArrayList<Integer> consumo) {
        this.consumo = consumo;
    }

    
}
