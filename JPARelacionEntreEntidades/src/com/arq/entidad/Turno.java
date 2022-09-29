package com.arq.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Turno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private Date fecha;
	
	/*
	 * Relacion ManyToManu con persona.
	 * El fetch en este tipo de realcion es Lazy por defecto
	 */
	@ManyToMany
	List<Persona> jugadores;

}
