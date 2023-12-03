package G06proy3.modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Reserva")
public class reserva {
    
    @Id
    private Integer idReserva;

    private Integer idHabitacion;
    private Integer idCliente;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private ArrayList<Integer> consumo;
    
    public reserva(Integer idReserva, Integer idHabitacion, Integer idCliente, LocalDate fecha_inicio, LocalDate fecha_fin) {
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

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public ArrayList<Integer> getConsumo() {
        return consumo;
    }

    public void setConsumo(ArrayList<Integer> consumo) {
        this.consumo = consumo;
    }

    
}
