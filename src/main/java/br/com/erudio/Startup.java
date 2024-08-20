package br.com.erudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Startup implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Startup.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Teste");
	}
}
