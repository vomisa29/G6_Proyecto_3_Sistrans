package G06proy3.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Servicios")
public class servicios {

    @Id
    private Integer id;

    private Integer costo;
    private String tipo;
    private Integer capacidad;
    private String nom_utencilios;
    private String tipo_prenda;
    private Integer num_prenda;
    private Integer num_maquinas;
    private String horario_servicio;
    private Integer profundidad;
    private String descripcion;
    private String nombre;//para restaurante, supermercado, bar, tienda y spa
    private String estilo;
    private Integer id_subServicio;//para restaurante, supermercado, bar, tienda y spa
    private String tipo_tienda;
    private ArrayList<producto> productos;
    private LocalDateTime fecha_horaReserva;
    private double duracion;
    private Integer id_salon;
    
    //crear servicio generico
    public servicios(Integer id, Integer costo, String tipo) {
        this.id = id;
        this.costo = costo;
        this.tipo = tipo;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getNom_utencilios() {
        return nom_utencilios;
    }

    public void setNom_utencilios(String nom_utencilios) {
        this.nom_utencilios = nom_utencilios;
    }

    public String getTipo_prenda() {
        return tipo_prenda;
    }

    public void setTipo_prenda(String tipo_prenda) {
        this.tipo_prenda = tipo_prenda;
    }

    public Integer getNum_prenda() {
        return num_prenda;
    }

    public void setNum_prenda(Integer num_prenda) {
        this.num_prenda = num_prenda;
    }

    public Integer getNum_maquinas() {
        return num_maquinas;
    }

    public void setNum_maquinas(Integer num_maquinas) {
        this.num_maquinas = num_maquinas;
    }

    public String getHorario_servicio() {
        return horario_servicio;
    }

    public void setHorario_servicio(String horario_servicio) {
        this.horario_servicio = horario_servicio;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public ArrayList<producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<producto> productos) {
        this.productos = productos;
    }

    public Integer getId_subServicio() {
        return id_subServicio;
    }

    public void setId_subServicio(Integer id_subServicio) {
        this.id_subServicio = id_subServicio;
    }

    public String getTipo_tienda() {
        return tipo_tienda;
    }

    public void setTipo_tienda(String tipo_tienda) {
        this.tipo_tienda = tipo_tienda;
    }


    public LocalDateTime isFecha_horaReserva() {
        return fecha_horaReserva;
    }


    public void setFecha_horaReserva(LocalDateTime fecha_horaReserva) {
        this.fecha_horaReserva = fecha_horaReserva;
    }


    public double getDuracion() {
        return duracion;
    }


    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }


    public Integer getId_salon() {
        return id_salon;
    }


    public void setId_salon(Integer id_salon) {
        this.id_salon = id_salon;
    }  

}
