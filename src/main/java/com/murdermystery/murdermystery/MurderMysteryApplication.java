package com.murdermystery.murdermystery;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MurderMysteryApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MurderMysteryApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "3456"));
		app.run(args);
	}

}
