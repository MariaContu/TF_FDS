package com.example.sistemaVendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class SistemaVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaVendasApplication.class, args);
	}
}