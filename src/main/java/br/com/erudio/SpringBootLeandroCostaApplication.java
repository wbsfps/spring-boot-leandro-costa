package br.com.erudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLeandroCostaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLeandroCostaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Teste");
	}
}
