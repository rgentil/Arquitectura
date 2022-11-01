package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("persona")
public class PersonaControllerJpa {

	@Qualifier("personaRepository")
	@Autowired
	private final PersonaRepository repository;

	public PersonaControllerJpa(@Qualifier("personaRepository") PersonaRepository repository) {
		this.repository = repository;
	}

	@GetMapping()
	public Iterable<Persona> getPersona() {
		return repository.findAll();
	}

	@GetMapping("{id}")
	public Optional<Persona> getPersonaById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@GetMapping("personaByName/{name}")
	public Iterable<Persona> getPersonaByName(@PathVariable String name) {
		return repository.findAllByName(name);
	}

	@GetMapping("personaBySurname/{surname}")
	public Iterable<Persona> getPersonaBySurname(@PathVariable String surname) {
		return repository.findAllBySurname(surname);
	}

	@PostMapping()
	public Persona addPersona(@RequestBody Persona persona) {
		return repository.save(persona);
	}

	@PutMapping("{id}")
	public Persona updatePersona(@RequestBody Persona persona, @PathVariable Long id) {
		Optional<Persona> aux = repository.findById(id);
		if (aux != null) {
			Persona p = aux.get();
			p.setName(persona.getName());
			p.setSurname(persona.getSurname());
			return repository.save(p);
		}
		persona.setDni(id);
		return repository.save(persona);
	}
	
	@DeleteMapping("{id}")
	public void deletePersona(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
