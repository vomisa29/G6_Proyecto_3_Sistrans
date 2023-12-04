package G06proy3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import G06proy3.modelo.cliente;
import G06proy3.modelo.consumo;
import G06proy3.modelo.habitacion;
import G06proy3.modelo.producto;
import G06proy3.modelo.reserva;
import G06proy3.modelo.servicios;
import G06proy3.modelo.tipoHabitacion;
import G06proy3.repositorio.clienteRepository;
import G06proy3.repositorio.habitacionRepository;
import G06proy3.repositorio.reservasRepository;
import G06proy3.repositorio.serviciosRepository;
import G06proy3.repositorio.tipoHabitacionRepository;

@SpringBootApplication
@EnableMongoRepositories
public class G06Proy3Application implements CommandLineRunner{

	@Autowired
	serviciosRepository repoServicios;

	@Autowired
	tipoHabitacionRepository repoTipoHabitacion;

	@Autowired
	habitacionRepository repoHabitacion;

	@Autowired
	clienteRepository repoClientes;

	@Autowired
	reservasRepository repoReservas;

	Scanner scanner;
	public static void main(String[] args) {
		SpringApplication.run(G06Proy3Application.class, args);
	}

	@Override
	public void run(String... args) {
		this.scanner = new Scanner(System.in);
		System.out.println("Que desea hacer:" +
		"\n1 CRUD Servicios" + 
		"\n2 CRUD Tipo Habitacion" +
		"\n3 CRUD Habitacion" +
		"\n4 CRUD Cliente" +
		"\n5 CRUD Reserva");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		switch(rta){
			case(1):
				interfazServicios();
				break;
			case(2):
				interfazTipoHabitacion();
				break;
			case(3):
				interfazHabitacion();
				break;
			case(4):
				interfazClientes();
				break;
			case(5):
				interfazReserva();
				break;
		}
		System.out.println("\nFin programa");
		this.scanner.close();
	};
	


////Servicios---------------------------------------------------------------------------------------------------------------------------------------

	void interfazServicios(){
		System.out.println("Que desea hacer:" +
		"\n1 Crear un servicio" + 
		"\n2 Encontrar un servicio" +
		"\n3 Actualizar el costo de un servicio" +
		"\n4 Borrar un servicio" +
		"\n5 Ver todos los servicios");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		Integer id;
		Integer costo;
		switch(rta){
			case(1):
				System.out.println("---- Creation of Items ----");
				createServicios();
				break;
			case(2):
				System.out.println("Digite el id del servicio que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				getServiciosById(id);
				break;
			case(3):
				System.out.println("Digite el id del servicio que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite valor del costo: ");
				costo = Integer.parseInt(this.scanner.nextLine());
				updateServicioCosto(id, costo);
				break;
			case(4):
				System.out.println("Digite el id del servicio que desea borrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				deleteServiciosById(id);
				break;
			case(5):
				showAllServices();
				break;
		}
		

	}

    void createServicios(){
		Integer id;
		Integer costo;
		String nom_utencilio;
		String tipo_prenda;
		Integer num_prenda;
		Integer capacidad;
		Integer num_maquinas;
		String horario_servicio;
		Integer profundidad;
		String descripcion;
		String nombre;
		String estilo;
		Integer id_subServicio;
		String tipo_tienda;
		Integer id_salon;
		LocalDateTime fecha_horaReserva;
		Integer duracion;



		System.out.println("Que servicio desea crear:" + 
							"\n1. Prestamo Utencilios" + 
							"\n2. Lavado" + 
							"\n3. Gimnasio" + 
							"\n4 Internet" +
							"\n5 Piscina" +
							"\n6 Restaurante" +
							"\n7 Supermercado" +
							"\n8 Bar" +
							"\n9 Tienda" +
							"\n10 Reserva Salon Conferencia" +
							"\n11 Reserva Salon Reuniones");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		switch(rta){
			case(1):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el nombre del utencilio");
				nom_utencilio = this.scanner.nextLine();
				createServicioPrestamo_Utencilios(id,costo,nom_utencilio);
				break;
			case(2):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el tipo de prenda");
				tipo_prenda = this.scanner.nextLine();
				System.out.println("Digite el numero del prendas");
				num_prenda = Integer.parseInt(this.scanner.nextLine());
				createServicioLavado(id, costo, tipo_prenda, num_prenda);
				break;
			case(3):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del gimnasio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el numero de maquinas del gimnasio");
				num_maquinas = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el horario de servicio");
				horario_servicio = this.scanner.nextLine();
				createServicioGimnasio(id, costo, capacidad, num_maquinas, horario_servicio);
				break;
			case(4):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del servicio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				createServicioInternet(id, costo, capacidad);
				break;
			case(5):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del servicio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la profundidad de la piscina");
				profundidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el horario de servicio");
				horario_servicio = this.scanner.nextLine();
				System.out.println("Digite la descripcion del servicio");
				descripcion = this.scanner.nextLine();
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				createServicioPiscina(id, costo, capacidad, profundidad, horario_servicio, descripcion, nombre);
				break;
			case(6):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del servicio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el estilo del restaurante");
				estilo = this.scanner.nextLine();
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el id del restaurante");
				id_subServicio = Integer.parseInt(this.scanner.nextLine());
				createServicioRestaurante(id, costo, capacidad, estilo, id_subServicio, nombre, null);
				break;
			case(7):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el id del supermercado");
				id_subServicio = Integer.parseInt(this.scanner.nextLine());
				createServicioSupermercado(id, costo, id_subServicio, nombre, null);
				break;
			case(8):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del servicio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el estilo del bar");
				estilo = this.scanner.nextLine();
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el id del bar");
				id_subServicio = Integer.parseInt(this.scanner.nextLine());
				createServicioBar(id, costo, capacidad, estilo, id_subServicio, nombre, null);
				break;
			case(9):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el id del tienda");
				id_subServicio = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el tipo de la tienda");
				tipo_tienda = this.scanner.nextLine();
				createServicioTienda(id, costo, id_subServicio, nombre, tipo_tienda, null);
				break;
			case(10):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del servicio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el estilo del restaurante");
				estilo = this.scanner.nextLine();
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el id del restaurante");
				id_salon = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la fecha de la reserva");
				fecha_horaReserva = LocalDateTime.parse(this.scanner.nextLine());
				System.out.println("Digite la duracion de la reserva");
				duracion = Integer.parseInt(this.scanner.nextLine());
				createServicioReserva(id, costo, "salon_conferencias", id_salon, capacidad, fecha_horaReserva, duracion);
				break;
			case(11):
				System.out.println("Digite el id del servicio:");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el costo del servicio");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad del servicio");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el estilo del restaurante");
				estilo = this.scanner.nextLine();
				System.out.println("Digite el nombre del servicio");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el id del restaurante");
				id_salon = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la fecha de la reserva");
				fecha_horaReserva = LocalDateTime.parse(this.scanner.nextLine());
				System.out.println("Digite la duracion de la reserva");
				duracion = Integer.parseInt(this.scanner.nextLine());
				createServicioReserva(id, costo, "salon_reuniones", id_salon, capacidad, fecha_horaReserva, duracion);
				break;
		}
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

	void createServicioReserva(Integer id, Integer costo, String tipo,Integer id_salon, Integer capacidad,LocalDateTime fecha_horaReserva, double duracion){
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

	void interfazTipoHabitacion(){
		System.out.println("Que desea hacer:" +
		"\n1 Crear un tipo de habitacion" + 
		"\n2 Encontrar un tipo de habitacion" +
		"\n3 Actualizar el costo de un tipo de habitacion" +
		"\n4 Borrar un tipo de habitacion");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		Integer id;
		String nombre;
		Integer capacidad;
		Integer costo;
		switch(rta){
			case(1):
				System.out.println("---- Creation of Items ----");
				System.out.println("Digite el id");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el nombre");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el costo");
				costo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la capacidad");
				capacidad = Integer.parseInt(this.scanner.nextLine());
				crearTipoHabitacion(id, nombre, capacidad, costo);
				break;
			case(2):
				System.out.println("Digite el id del tipo de habitacion que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				getTipoHabitacion(id);
				break;
			case(3):
				System.out.println("Digite el id del tipo habitacion que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite valor del costo: ");
				costo = Integer.parseInt(this.scanner.nextLine());
				updateTipoHabitacionCosto(id, costo);
				break;
			case(4):
				System.out.println("Digite el id del tipo habitacion que desea borrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				deleteTipoHabitacionById(id);
				break;
		}
		
	}

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

	public void getTipoHabitacionByCapacidad(Integer capacidad){
		System.out.println("Mostrando Servicios por el capacidad: " + capacidad);
		List<tipoHabitacion> lista = repoTipoHabitacion.findByCapacidad(capacidad);
		lista.forEach(tipoHabitacion -> System.out.println(getTipoHabitacionDetails(tipoHabitacion)));
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
		"\nnombreTipo: " + tipohabitacionActual.getNombreTipo() +
		"\ncapacidad: " + tipohabitacionActual.getCapacidad() +
		"\ncosto: " + tipohabitacionActual.getCosto();
	}

////Habitacion---------------------------------------------------------------------------------------------------------------------------

	void interfazHabitacion(){
		System.out.println("Que desea hacer:" +
		"\n1 Crear un habitacion" + 
		"\n2 Encontrar un habitacion" +
		"\n3 Actualizar el costo de un habitacion" +
		"\n4 Borrar un habitacion");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		Integer id;
		Integer idTipo;
		boolean televisor;
		boolean minibar;
		boolean cafetera;
		switch(rta){
			case(1):
				System.out.println("---- Creation of Items ----");
				System.out.println("Digite el id");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id del tipo de habitacion");
				idTipo = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite si hay televisor: ");
				televisor = Boolean.valueOf(this.scanner.nextLine());
				System.out.println("Digite si hay minibar: ");
				minibar = Boolean.valueOf(this.scanner.nextLine());
				System.out.println("Digite si hay cafetera: ");
				cafetera = Boolean.valueOf(this.scanner.nextLine());
				crearHabitacion(id, idTipo, televisor,minibar,cafetera);
				break;
			case(2):
				System.out.println("Digite el id de la habitacion que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				getHabitacion(id);
				break;
			case(3):
				System.out.println("Digite el id de la habitacion que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite si hay televisor: ");
				televisor = Boolean.valueOf(this.scanner.nextLine());
				updateHabitacionTelevisor(id, televisor);
				break;
			case(4):
				System.out.println("Digite el id del tipo habitacion que desea borrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				deleteHabitacionById(id);
				break;
		}
	}

	public void crearHabitacion(Integer idHabitacion, Integer idTipo, boolean televisor, boolean minibar, boolean cafetera){
		habitacion habitacion = new habitacion(idHabitacion, idTipo, televisor, minibar, cafetera);
		repoHabitacion.save(habitacion);
	}

	public void getHabitacion(Integer id){
		Optional<habitacion> habitacionID = repoHabitacion.findById(id);
		if(habitacionID.isPresent()){
			System.out.println(gethabitacionDetails(habitacionID.get()));
		}else {
			System.out.println("No existe una habitacion con ese ID");
		}
	}
	
	public void updateHabitacionTelevisor(Integer id, boolean televisor){
		Optional<habitacion> habitacionID = repoHabitacion.findById(id);
		if(habitacionID.isPresent()){
			habitacionID.get().setTelevisor(televisor);
			repoHabitacion.save(habitacionID.get());
			System.out.println("Se actualizo correctamente");
		}else {
			System.out.println("No existe una habitacion con ese ID");
		}
	}

	public void deleteHabitacionById(Integer id){
		repoHabitacion.deleteById(id);
		System.out.println("Se borro la habitacion con el id: " + id);
	}

	String gethabitacionDetails(habitacion habitacionActual){
		return "\nid: " + habitacionActual.getIdHabitacion() +
		"\ntelevisor: " + habitacionActual.isTelevisor() +
		"\nminibar: " + habitacionActual.isMinibar() +
		"\ncafetera: " + habitacionActual.isCafetera();
	}

////Cliente---------------------------------------------------------------------------------------------------------------------------

	void interfazClientes(){
		System.out.println("Que desea hacer:" +
		"\n1 Crear un cliente" + 
		"\n2 Encontrar un cliente" +
		"\n3 Actualizar el costo de un cliente" +
		"\n4 Borrar un cliente" +
		"\n5 get Llegada Cliente" +
		"\n6 set Llegada Cliente" +
		"\n7 get Salida Cliente" +
		"\n8 set Salida Cliente");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		Integer id;
		String nombre;
		Integer idCliente;
		Integer idReserva;
		LocalDateTime fecha_inicio;
		switch(rta){
			case(1):
				System.out.println("---- Creation of Items ----");
				System.out.println("Digite el id");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el nombre");
				nombre = this.scanner.nextLine();
				System.out.println("Digite el costo");
				crearCliente(id, nombre, null);
				break;
			case(2):
				System.out.println("Digite el id del cliente que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				getCliente(id);
				break;
			case(3):
				System.out.println("Digite el id del cliente que desea encontrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite valor del costo: ");
				nombre = this.scanner.nextLine();
				updateClienteNombre(id, nombre);
				break;
			case(4):
				System.out.println("Digite el id del cliente que desea borrar: ");
				id = Integer.parseInt(this.scanner.nextLine());
				deleteClienteById(id);
				break;
			case(5):
				System.out.println("Digite el id del cliente: ");
				idCliente = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id de la reserva: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				getLLegadaCliente(idCliente,idReserva);
			case(6):
				System.out.println("Digite el id del cliente: ");
				idCliente = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id de la reserva: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la fecha de la reserva");
				fecha_inicio = LocalDateTime.parse(this.scanner.nextLine());
				updateLLegadaCliente(idCliente, idReserva, fecha_inicio);
			case(7):
				System.out.println("Digite el id del cliente: ");
				idCliente = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id de la reserva: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				getSalidaCliente(idCliente,idReserva);
			case(8):
				System.out.println("Digite el id del cliente: ");
				idCliente = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id de la reserva: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la fecha de la reserva");
				fecha_inicio = LocalDateTime.parse(this.scanner.nextLine());
				updateSalidaCliente(idCliente, idReserva, fecha_inicio);

		}
	}

	public void crearCliente(Integer idCliente, String nombre, ArrayList<consumo> consumo){
		cliente cliente = new cliente(idCliente, nombre);
		if(consumo != null){
			cliente.setConsumo(consumo);
		}
		repoClientes.save(cliente);
	}

	public void getCliente(Integer id){
		Optional<cliente> clienteID = repoClientes.findById(id);
		if(clienteID.isPresent()){
			System.out.println(getClienteDetails(clienteID.get()));
		}else {
			System.out.println("No existe un cliente con ese ID");
		}
	}

	public void updateClienteNombre(Integer id, String nombre){
		Optional<cliente> clienteID = repoClientes.findById(id);
		if(clienteID.isPresent()){
			clienteID.get().setNombre(nombre);
			repoClientes.save(clienteID.get());
			System.out.println("Se actualizo correctamente");
		}else {
			System.out.println("No existe un cliente con ese ID");
		}
	}

	public void deleteClienteById(Integer id){
		repoClientes.deleteById(id);
		System.out.println("Se borro el cliente con el id: " + id);
	}

	String getClienteDetails(cliente clienteActual){
		return "\nid: " + clienteActual.getIdCliente() +
		"\nnombre: " + clienteActual.getNombre();
	}

////Reserva---------------------------------------------------------------------------------------------------------------------------

	void interfazReserva(){
		System.out.println("Que desea hacer:" +
		"\n1 Crear un reserva" + 
		"\n2 Encontrar un reserva" +
		"\n3 Actualizar el costo de un reserva" +
		"\n4 Borrar un reserva");
		Integer rta = Integer.parseInt(this.scanner.nextLine());
		Integer idReserva;
		Integer idHabitacion;
		Integer idCliente;
		LocalDateTime fecha_inicio;
		LocalDateTime fecha_fin;
		
		switch(rta){
			case(1):
				System.out.println("---- Creation of Items ----");
				System.out.println("Digite el id de la reserva ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id de la habitacion");
				idHabitacion = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id del cliente");
				idCliente = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite la fecha de inicio de la reserva");
				fecha_inicio = LocalDateTime.parse(this.scanner.nextLine());
				System.out.println("Digite la fecha de finalizacion de la reserva");
				fecha_fin = LocalDateTime.parse(this.scanner.nextLine());
				crearReserva(idReserva, idHabitacion, idCliente, fecha_inicio, fecha_fin, null);
				break;
			case(2):
				System.out.println("Digite el id de la reserva que desea encontrar: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				getReserva(idReserva);
				break;
			case(3):
				System.out.println("Digite el id de la reserva que desea encontrar: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				System.out.println("Digite el id de la habitacion: ");
				idHabitacion = Integer.parseInt(this.scanner.nextLine());
				updateReservaIdHabitacion(idReserva, idHabitacion);
				break;
			case(4):
				System.out.println("Digite el id del tipo reserva que desea borrar: ");
				idReserva = Integer.parseInt(this.scanner.nextLine());
				deleteReserva(idReserva);
				break;
		}
	}

	//Crea una reserva si es posible: es decir si la habitacion no tiene una reserva ya para esa fecha
	public void crearReserva(Integer idReserva, Integer idHabitacion, Integer idCliente, LocalDateTime fecha_inicio, LocalDateTime fecha_fin, ArrayList<Integer> consumo){
		List<reserva> lista = getReservasIntervalo(fecha_inicio, fecha_fin,idHabitacion);
		System.out.println(lista.isEmpty());
		if(lista.isEmpty()){
			reserva reserva = new reserva(idReserva, idHabitacion, idCliente, fecha_inicio, fecha_fin);
			if(consumo != null){
				reserva.setConsumo(consumo);
			}
			repoReservas.save(reserva);
			System.out.println("Se creo la reserva correctamente.");

		}else{
			System.out.println("No se puede: La habitacion ya tiene una reserva para esa fecha.");
		}

	}

	public void getReserva(Integer idReserva){
		Optional<reserva> reservaID = repoReservas.findById(idReserva);
		if(reservaID.isPresent()){
			System.out.println(getReservaDetails(reservaID.get()));
		}else {
			System.out.println("No existe un reserva con ese ID");
		}
	}

	public void updateReservaIdHabitacion(Integer idReserva, Integer idHabitacion){
		Optional<reserva> reservaID = repoReservas.findById(idHabitacion);
		reserva reservaActual = reservaID.get();
		if(reservaID.isPresent() && (getReservasIntervalo(reservaActual.getFecha_inicio(), reservaActual.getFecha_fin(), idHabitacion).isEmpty())){
			reservaActual.setIdHabitacion(idHabitacion);
			repoReservas.save(reservaActual);
			System.out.println("Se actualizo la reserva correctamente");
		}else{
			System.out.println("No se puede actualizar la reserva");
		}
	}

	public void deleteReserva(Integer idReserva){
		repoReservas.deleteById(idReserva);
		System.out.println("Se borro la reserva con el id: " + idReserva);
	}

	String getReservaDetails(reserva reservaActual){
		return "\nidReserva: " + reservaActual.getIdReserva() +
		"\nidHabitacion: " + reservaActual.getIdHabitacion() +
		"\nidCliente: " + reservaActual.getIdCliente() + 
		"\nfecha_inicio: " + reservaActual.getFecha_inicio().toString() +
		"\nfecha_fin: " + reservaActual.getFecha_fin().toString();
	}

	public List<reserva> getReservasIntervalo(LocalDateTime fecha_inicio, LocalDateTime fecha_fin,Integer idHabitacion){
		fecha_inicio = fecha_inicio.plus(-1,ChronoUnit.DAYS);
		fecha_fin = fecha_fin.plus(1, ChronoUnit.DAYS);
		List<reserva> lista = repoReservas.findByRange(fecha_inicio, fecha_fin,idHabitacion);
		return lista;
	}

////LLegada o salida de un Cliente---------------------------------------------------------------------------------------------------------------------------


	void getLLegadaCliente(Integer idCliente, Integer idReserva){
		reserva llegadaCliente = repoReservas.findByIdCliente_AND_IdReserva(idCliente, idReserva);
		if(llegadaCliente != null){
			System.out.println("La fecha de llegada del cliente para la reserva dada es: " + llegadaCliente.getFecha_inicio());
		}else{
			System.out.println("No existe una reserva para el cliente dado.");
		}
	}

	void getSalidaCliente(Integer idCliente, Integer idReserva){
		reserva llegadaCliente = repoReservas.findByIdCliente_AND_IdReserva(idCliente, idReserva);
		if(llegadaCliente != null){
			System.out.println("La fecha de salida del cliente para la reserva dada es: " + llegadaCliente.getFecha_fin());
		}else{
			System.out.println("No existe una reserva para el cliente dado.");
		}
	}

	void updateLLegadaCliente(Integer idCliente, Integer idReserva, LocalDateTime fecha_inicio){
		Optional<reserva> lista = repoReservas.findById(idReserva);
		String salida = "No se puede realizar la actualización.";
		if(lista.isPresent()){
			LocalDateTime fecha_fin = lista.get().getFecha_fin();
			Integer idHabitacion = lista.get().getIdHabitacion();
			List<reserva> listaIntervalo = getReservasIntervalo(fecha_inicio, fecha_fin,idHabitacion);
			if(listaIntervalo.isEmpty()){
				lista.get().setFecha_inicio(fecha_inicio);
				salida = "Se realizo el cambio correctamente.";
			}
		}
		System.out.println(salida);
	}

	void updateSalidaCliente(Integer idCliente, Integer idReserva, LocalDateTime fecha_fin){
		Optional<reserva> lista = repoReservas.findById(idReserva);
		String salida = "No se puede realizar la actualización.";
		if(lista.isPresent()){
			LocalDateTime fecha_inicio = lista.get().getFecha_inicio();
			Integer idHabitacion = lista.get().getIdHabitacion();
			List<reserva> listaIntervalo = getReservasIntervalo(fecha_inicio, fecha_fin,idHabitacion);
			if(listaIntervalo.isEmpty()){
				lista.get().setFecha_fin(fecha_fin);
				salida = "Se realizo el cambio correctamente.";
			}
		}
		System.out.println(salida);
	}
}
