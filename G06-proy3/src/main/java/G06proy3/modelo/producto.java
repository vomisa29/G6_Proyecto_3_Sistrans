package G06proy3.modelo;

public class producto {
    private Integer id;
    private String nom_producto;
    private Integer costo;

    public producto(Integer id, String nom_producto, Integer costo) {
        this.id = id;
        this.nom_producto = nom_producto;
        this.costo = costo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
    

    
}
