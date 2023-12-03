package G06proy3.modelo;

import java.util.ArrayList;

public class consumo {

    private Integer idServicio;
    private String tipoServicio;
    private Integer costo;
    private ArrayList<producto> productos;

    public consumo(Integer idServicio, String tipoServicio, Integer costo, ArrayList<producto> productos) {
        this.idServicio = idServicio;
        this.tipoServicio = tipoServicio;
        this.costo = costo;
        this.productos = productos;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public ArrayList<producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<producto> productos) {
        this.productos = productos;
    }

    
    
}
