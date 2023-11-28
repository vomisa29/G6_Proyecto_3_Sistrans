package G06proy3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import G06proy3.modelo.servicios;
import G06proy3.repositorio.serviciosRepository;

@SpringBootApplication
@EnableMongoRepositories
public class G06Proy3Application implements CommandLineRunner{

	@Autowired
	serviciosRepository repoServicios;

	public static void main(String[] args) {
		SpringApplication.run(G06Proy3Application.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("---- Creation of Items ----");
		createServicios();
		System.out.println("\n----- Todos los servicios ----");
		showAllServices();
		System.out.println("\n-----Servicios por tipo-----\n");
		getServiciosByTipo("piscina");
	};
	

	void createServicios(){
		System.out.println("Data creation Started...");
		repoServicios.save(new servicios(12, 1000, "bar"));
		repoServicios.save(new servicios(23, 1500, "piscina"));
		System.out.println("Data creation Completed...");
	}

	public void showAllServices(){
		repoServicios.findAll().forEach(servicios->System.out.println(getServiciosDetails(servicios)));
	}

	public String getServiciosDetails(servicios servicioActual){
		return "\nid: " + String.valueOf(servicioActual.getId()) +
		"\ncosto: " + String.valueOf(servicioActual.getCosto()) +
		"\ntipo: " + servicioActual.getTipo(); 
	}

	public void getServiciosByTipo(String tipo){
		System.out.println("Mostrando Servicios por el tipo: " + tipo);
		List<servicios> lista = repoServicios.findByType(tipo);
		lista.forEach(servicios -> System.out.println(

		"\nid: " + String.valueOf(servicios.getId()) +
		"\ncosto: " + String.valueOf(servicios.getCosto()) +
		"\ntipo: " + servicios.getTipo()

		));
	}

}
