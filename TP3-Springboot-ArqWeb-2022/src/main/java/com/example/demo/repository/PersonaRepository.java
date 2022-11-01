package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Persona;

/**
 * 
 * @author Gentil Ricardo
 * Es una interface en donde se declaran los metodos de busqueda que luego se van a usar. 
 * Extiende de JpaRepository porque este me da los métodos más comunes para las búsquedas, por 
 * ejemplo
 * List<T> findAll(); 
 * void flush();
 * List<T> findAllById(Iterable<ID> ids);
 */
public interface PersonaRepository extends JpaRepository<Persona,Long> {
	
	@Query("SELECT p FROM Persona p WHERE p.surname = :surname")
	public List<Persona> findAllBySurname(String surname);
	
	@Query("SELECT  p FROM Persona p WHERE p.name = :name")
	public List<Persona> findAllByName(String name);
	
}
