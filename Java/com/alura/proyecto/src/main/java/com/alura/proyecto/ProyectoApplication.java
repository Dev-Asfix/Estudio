package com.alura.proyecto;

import com.alura.proyecto.pricipal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ProyectoApplication.class, args);
	}

	public void run(String ... args) throws Exception{
		Principal principal = new Principal();
		principal.mostrarMenu();


	}





}
