package com.arq.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Direccion {

	// Id se genera automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String calle;

	@Column
	private String ciudad;

	// Una direccion puede tener muchas personas
	// Se mapea con el atributo domicilio en Persona
	// Fetch Lazy en relaciones oneToMany es por defecto
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "domicilio")
	List<Persona> personas;

	public Direccion() {
		super();
		this.personas = new ArrayList<Persona>();
	}

	public Direccion(String calle, String ciudad) {
		super();
		this.calle = calle;
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", ciudad=" + ciudad + "]";
	}

}
