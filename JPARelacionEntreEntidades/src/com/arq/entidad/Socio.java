package com.arq.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Socio {
	
    @Id
    @Column(name = "persona_id")
    private int persona_id;

	@Column
	private String tipo;
	
//  1-que sea bidireccional
//	@OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "persona_id", referencedColumnName = "id")
//  private Persona persona;
		
	// 2-que tengan el mismo id.
//	@OneToOne(cascade = CascadeType.ALL)
//    @MapsId
//    @JoinColumn(name = "id")
//    private Persona persona;
	
	//Es una relación 1 a 1 con Persona.
	//Se indica que utilice el mapeo sobre la id.
	//Termina siendo PK y FK a la vez.
	@OneToOne(cascade = CascadeType.ALL)
	@MapsId
	private Persona persona;
		
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Socio(String tipo, Persona persona) {
		super();
		this.tipo = tipo;
		this.persona = persona;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
