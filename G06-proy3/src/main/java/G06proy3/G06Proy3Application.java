package G06proy3;

import java.time.LocalDate;
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
		//System.out.println("---- Creation of Items ----");
		//createServicios();
		//System.out.println("\n----- Todos los servicios ----");
		//showAllServices();
		//System.out.println("\nDigite un tipo de servicio(ej:piscina)");
		//String tipo = this.scanner.nextLine();
		//System.out.println("\n----- Todos los servicios de " +tipo+ " ----");
		//getServiciosByTipo(tipo);;
		//System.out.println("\nDigite id de un servicio(ej:12)");
		//Integer id = Integer.parseInt(this.scanner.nextLine());
		//System.out.println("\n-----Servicios con el id: " +id+" -----");
		//getServiciosById(id);
		System.out.println("prueba getReservasIntervalo()  -  Funciona correctamente");
		LocalDate fecha_inicio = LocalDate.parse("2018-05-05");
		LocalDate fecha_fin = LocalDate.parse("2020-05-05");
		Integer idHabitacion = 12;
		getReservasIntervalo(fecha_inicio, fecha_fin,idHabitacion);
		this.scanner.close();
	};
	


////Servicios---------------------------------------------------------------------------------------------------------------------------------------

	void interfazServicios(){

	}

    void createServicios(){
		//aqui debe estar la logica para escoger un servicio en especifico
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

	void interfazTipoHabitacion(){
		
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
		"\nnombre: " + tipohabitacionActual.getNombre() +
		"\ncapacidad: " + tipohabitacionActual.getCapacidad() +
		"\ncosto: " + tipohabitacionActual.getCosto();
	}

////Habitacion---------------------------------------------------------------------------------------------------------------------------

	void interfazHabitacion(){

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
	
	public void updateHabitacionCosto(Integer id, boolean televisor){
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

	}

	//Crea una reserva si es posible: es decir si la habitacion no tiene una reserva ya para esa fecha
	public void crearReserva(Integer idReserva, Integer idHabitacion, Integer idCliente, LocalDate fecha_inicio, LocalDate fecha_fin, ArrayList<Integer> consumo){
		List<reserva> lista = getReservasIntervalo(fecha_inicio, fecha_fin,idHabitacion);
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

	public List<reserva> getReservasIntervalo(LocalDate fecha_inicio, LocalDate fecha_fin,Integer idHabitacion){
		List<reserva> lista = repoReservas.findByRange(fecha_inicio, fecha_fin,idHabitacion);
		return lista;
	}

////LLegada o salida de un Cliente---------------------------------------------------------------------------------------------------------------------------

	void interfaz_LLegada_Salida(){

	}

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

	void updateLLegadaCliente(Integer idCliente, Integer idReserva, LocalDate fecha_inicio){
		Optional<reserva> lista = repoReservas.findById(idReserva);
		String salida = "No se puede realizar la actualización.";
		if(lista.isPresent()){
			LocalDate fecha_fin = lista.get().getFecha_fin();
			Integer idHabitacion = lista.get().getIdHabitacion();
			List<reserva> listaIntervalo = getReservasIntervalo(fecha_inicio, fecha_fin,idHabitacion);
			if(listaIntervalo.isEmpty()){
				lista.get().setFecha_inicio(fecha_inicio);
				salida = "Se realizo el cambio correctamente.";
			}
		}
		System.out.println(salida);
	}

	void updateSalidaCliente(Integer idCliente, Integer idReserva, LocalDate fecha_fin){
		Optional<reserva> lista = repoReservas.findById(idReserva);
		String salida = "No se puede realizar la actualización.";
		if(lista.isPresent()){
			LocalDate fecha_inicio = lista.get().getFecha_inicio();
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
