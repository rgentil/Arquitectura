package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Persona {

	@Id
	private Long dni;
	@Column
	private String name;
	@Column
	private String surname;
	
	public Persona() {}
	
	public Persona(Long dni, String name, String surname) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
	}

	public void setDni(Long id) {
		this.dni = id;		
	}
	
}
