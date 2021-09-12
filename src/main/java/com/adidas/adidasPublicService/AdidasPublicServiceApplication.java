package com.adidas.adidasPublicService;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the application
 */
@SpringBootApplication
public class AdidasPublicServiceApplication {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(AdidasPublicServiceApplication.class, args);
	}
	//TODO
	//getManySubsciptions
	//test
	//seguridad
	//linkeHashMap
}
