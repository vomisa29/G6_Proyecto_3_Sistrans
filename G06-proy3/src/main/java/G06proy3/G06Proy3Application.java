package G06proy3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import G06proy3.modelo.producto;
import G06proy3.modelo.servicios;
import G06proy3.modelo.tipoHabitacion;
import G06proy3.repositorio.serviciosRepository;
import G06proy3.repositorio.tipoHabitacionRepository;

@SpringBootApplication
@EnableMongoRepositories
public class G06Proy3Application implements CommandLineRunner{

	@Autowired
	serviciosRepository repoServicios;
	tipoHabitacionRepository repoTipoHabitacion;

	Scanner scanner;
	public static void main(String[] args) {
		SpringApplication.run(G06Proy3Application.class, args);
	}

	@Override
	public void run(String... args) {
		this.scanner = new Scanner(System.in);
		//System.out.println("---- Creation of Items ----");
		//createServicios();
		System.out.println("\n----- Todos los servicios ----");
		showAllServices();
		System.out.println("Digite un tipo de servicio(ej:piscina)");
		String tipo = this.scanner.nextLine();
		System.out.println("\n----- Todos los servicios de " +tipo+ " ----");
		getServiciosByTipo(tipo);;
		System.out.println("Digite id de un servicio(ej:12)");
		Integer id = Integer.parseInt(this.scanner.nextLine());
		System.out.println("\n-----Servicios con el id: " +id+" -----");
		getServiciosById(id);
		this.scanner.close();
	};
	


////Servicios---------------------------------------------------------------------------------------------------------------------------------------

	void interfazServicios(){

	}

    void createServicios(){
		
	}

	void createServicioPrestamo_Utencilios(Integer id, Integer costo, String nom_utencilio){
		servicios prestamo = new servicios(id, costo, "prestamo_utencilios");
		prestamo.setNom_utencilios(nom_utencilio);
		repoServicios.save(prestamo);
	}

	void createServicioLavado(Integer id, Integer costo, String tipo_prenda, Integer num_prenda){
		servicios lavado = new servicios(id, costo, "lavado");
		lavado.setTipo_prenda(tipo_prenda);
		lavado.setNum_prenda(num_prenda);
		repoServicios.save(lavado);
	}

	void createServicioGimnasio(Integer id, Integer costo, Integer capacidad, Integer num_maquinas, String horario_servicios){
		servicios gimnasio = new servicios(id, costo, "gimnasio");
		gimnasio.setCapacidad(capacidad);
		gimnasio.setNum_maquinas(num_maquinas);
		gimnasio.setHorario_servicio(horario_servicios);
		repoServicios.save(gimnasio);
	}

	void createServicioInternet(Integer id, Integer costo, Integer capacidad){
		servicios internet = new servicios(id, costo, "internet");
		internet.setCapacidad(capacidad);
		repoServicios.save(internet);
	}

	void createServicioPiscina(Integer id, Integer costo, Integer capacidad, Integer profundidad, String horario_servicio, String descripcion, String nombre){
		servicios piscina = new servicios(id, costo, "piscina");
		piscina.setCapacidad(capacidad);
		piscina.setProfundidad(profundidad);
		piscina.setHorario_servicio(horario_servicio);
		piscina.setDescripcion(descripcion);
		piscina.setNombre(nombre);
		repoServicios.save(piscina);
	}

	void createServicioRestaurante(Integer id, Integer costo, Integer capacidad, String estilo, Integer id_subServicio, String nombre, ArrayList<producto> productos){
		servicios restaurante = new servicios(id, costo, "restaurante");
		restaurante.setCapacidad(capacidad);
		restaurante.setEstilo(estilo);
		restaurante.setId_subServicio(id_subServicio);
		restaurante.setNombre(nombre);
		restaurante.setProductos(productos);
		repoServicios.save(restaurante);
	}

	void createServicioSupermercado(Integer id, Integer costo, Integer id_subServicio, String nombre, ArrayList<producto> productos){
		servicios supermercado = new servicios(id, costo, "supermercado");
		supermercado.setId_subServicio(id_subServicio);
		supermercado.setNombre(nombre);
		supermercado.setProductos(productos);
		repoServicios.save(supermercado);
	}

	void createServicioBar(Integer id, Integer costo, Integer capacidad, String estilo, Integer id_subServicio, String nombre, ArrayList<producto> productos){
		servicios bar = new servicios(id, costo, "bar");
		bar.setCapacidad(capacidad);
		bar.setEstilo(estilo);
		bar.setId_subServicio(id_subServicio);
		bar.setNombre(nombre);
		bar.setProductos(productos);
		repoServicios.save(bar);
	}

	void createServicioTienda(Integer id, Integer costo, Integer id_subServicio, String nombre,String tipo_tienda, ArrayList<producto> productos){
		servicios tienda = new servicios(id, costo, "tienda");
		tienda.setId_subServicio(id_subServicio);
		tienda.setNombre(nombre);
		tienda.setTipo_tienda(tipo_tienda);
		tienda.setProductos(productos);
		repoServicios.save(tienda);
	}

	void createServicioReserva(Integer id, Integer costo, String tipo,Integer id_salon, Integer capacidad,Date fecha_horaReserva, double duracion){
		servicios reservaSalon = new servicios(id, costo, tipo);
		reservaSalon.setId_salon(id_salon);
		reservaSalon.setCapacidad(capacidad);
		reservaSalon.setFecha_horaReserva(fecha_horaReserva);
		reservaSalon.setDuracion(duracion);
		repoServicios.save(reservaSalon);
	}
	
	producto crearProducto(Integer id, String nom_producto, Integer costo){
		producto producto = new producto(id, nom_producto, costo);
		return producto;
	}
	
	public void showAllServices(){
		repoServicios.findAll().forEach(servicios->System.out.println(getServiciosDetails(servicios)));
	}

	public void getServiciosByTipo(String tipo){
		System.out.println("Mostrando Servicios por el tipo: " + tipo);
		List<servicios> lista = repoServicios.findByType(tipo);
		lista.forEach(servicios -> System.out.println(getServiciosDetails(servicios)));
	}

	public void getServiciosById(Integer id){
		Optional<servicios> serviciosID = repoServicios.findById(id);
		if(serviciosID.isPresent()){
			System.out.println(getServiciosDetails(serviciosID.get()));
		}else {
			System.out.println("No existe un servicio con ese ID");
		}
		
	}

	public void updateServicioCosto(Integer id, Integer costo){
		Optional<servicios> serviciosID = repoServicios.findById(id);
		if(serviciosID.isPresent()){
			serviciosID.get().setCosto(costo);
			repoServicios.save(serviciosID.get());
			System.out.println("Se actualizo el costo correctamente");
		}else {
			System.out.println("No existe un servicio con ese ID");
		}
	}

	public void deleteServiciosById(Integer id){
		repoServicios.deleteById(id);
		System.out.println("Se borro el servicio con el id: " + id);
	}

	
	public String getServiciosDetails(servicios servicioActual){
		return "\nid: " + String.valueOf(servicioActual.getId()) +
		"\ncosto: " + String.valueOf(servicioActual.getCosto()) +
		"\ntipo: " + servicioActual.getTipo(); 
	}


////TipoHabitacion---------------------------------------------------------------------------------------------------------------------------

	public void crearTipoHabitacion(Integer idTipo, String nombre, Integer capacidad, Integer costo){
		tipoHabitacion tipoHabitacion = new tipoHabitacion(idTipo, nombre, capacidad, costo);
		repoTipoHabitacion.save(tipoHabitacion);
	}

	public void getTipoHabitacion(Integer id){
		Optional<tipoHabitacion> tipoHabitacionID = repoTipoHabitacion.findById(id);
		if(tipoHabitacionID.isPresent()){
			System.out.println(getTipoHabitacionDetails(tipoHabitacionID.get()));
		}else {
			System.out.println("No existe un tipo de habitacion con ese ID");
		}
	}

	public void updateTipoHabitacionCosto(Integer id, Integer costo){
		Optional<tipoHabitacion> tipoHabitacionID = repoTipoHabitacion.findById(id);
		if(tipoHabitacionID.isPresent()){
			tipoHabitacionID.get().setCosto(costo);
			repoTipoHabitacion.save(tipoHabitacionID.get());
			System.out.println("Se actualizo el costo correctamente");
		}else {
			System.out.println("No existe un tipo de habitacion con ese ID");
		}
	}

	public void deleteTipoHabitacionById(Integer id){
		repoTipoHabitacion.deleteById(id);
		System.out.println("Se borro el tipo de habitacion con el id: " + id);
	}

	String getTipoHabitacionDetails(tipoHabitacion tipohabitacionActual){
		return "\nid: " + tipohabitacionActual.getIdTipo() +
		"\nnombre: " + tipohabitacionActual.getNombre() +
		"\ncapacidad: " + tipohabitacionActual.getCapacidad() +
		"\ncosto: " + tipohabitacionActual.getCosto();
	}
}
