package br.com.alura.screensound;

import br.com.alura.screensound.principal.Principal;
import br.com.alura.screensound.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.SpringCglibInfo;

@SpringBootApplication
public class ScreensoundApplication implements CommandLineRunner {

	//@Autowired
	//private ArtistaRepository repositorio;

	@Autowired // <--- ESSA INJEÇÃO É A CHAVE!
	private Principal principal;

    public ScreensoundApplication(Principal principal) {
        this.principal = principal;
    }

    public static void main(String[] args) {
		SpringApplication.run(ScreensoundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Principal principal = new Principal(repositorio);
		principal.exibeMenu();

	}
}
