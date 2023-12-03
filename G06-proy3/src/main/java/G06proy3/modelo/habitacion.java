package G06proy3.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Habitacion")
public class habitacion {

    @Id
    private Integer idHabitacion;

    private Integer idTipo;
    private boolean televisor;
    private boolean minibar;
    private boolean cafetera;

    public habitacion(Integer idHabitacion, Integer idTipo, boolean televisor, boolean minibar, boolean cafetera) {
        this.idHabitacion = idHabitacion;
        this.idTipo = idTipo;
        this.televisor = televisor;
        this.minibar = minibar;
        this.cafetera = cafetera;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public boolean isTelevisor() {
        return televisor;
    }

    public void setTelevisor(boolean televisor) {
        this.televisor = televisor;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isCafetera() {
        return cafetera;
    }

    public void setCafetera(boolean cafetera) {
        this.cafetera = cafetera;
    }
}
