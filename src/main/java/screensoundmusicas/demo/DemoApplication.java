package screensoundmusicas.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import screensoundmusicas.demo.principal.Principal;
import screensoundmusicas.demo.repository.ArtistaRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private ArtistaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.exibeMenu();
	}
}
