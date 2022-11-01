package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Direccion {

	@Id
	private Long id;
	@Column
	private String calle;
	@Column
	private int numero;	
	
}
