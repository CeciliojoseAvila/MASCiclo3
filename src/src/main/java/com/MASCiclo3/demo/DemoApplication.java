package com.MASCiclo3.demo;

import com.MASCiclo3.demo.Modelos.Empresa;
import org.hibernate.annotations.GeneratorType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController//LO QUITÉ PARA PROBAR OTRO CONTROLADOR(Controllers)
@SpringBootApplication(exclude ={SecurityAutoConfiguration.class})

public class DemoApplication {
@GetMapping(value = "/hello")
public String hello(){
	return "ESTO SI ES PROGRAMAR EN CICLO 3 DE MISION TIC 2022";
}
	@GetMapping(value = "/test")
	public String test(){
		Empresa emp = new Empresa("EL COLIBRÍ FINAL", "CALLE LA AVENIDA", "3215642","8314592-6");

		emp.setNombre("EL COLIBRÍ LTDA ");
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
