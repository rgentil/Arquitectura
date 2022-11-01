package com.example.demo.utils;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDataBase {

	@Bean
	CommandLineRunner initDataBase(@Qualifier("personaRepository") PersonaRepository repository) {
		return args -> {
			log.info("Preloading" + repository.save(new Persona((long)1234, "Pedro", "Pascal")));
			log.info("Preloading" + repository.save(new Persona((long)4321, "Juan", "Tormo")));
		};
	}
	
}
