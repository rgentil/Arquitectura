package com.arq.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Persona {

	// No lo genero automatico porque puede ser el dni, libreta, etc.
	@Id
	private int id;

	@Column(name = "anios", nullable = true)
	private int edad;

	@Column(nullable = false)
	private String nombre;

	// Muchas personas pueden vivir en un mismo domicilio
	@ManyToOne
	private Direccion domicilio;

	/*
	 * Para que la persona tenga el mapeo en la realcion ManyToMany. El fetch es
	 * Lazy por defecto. Indica que la relacion ya esta mapeada por el atributo
	 * jugadores de la clase Turno. Se de cuenta que esta entidad, tabla o clase
	 * porque la coleccion de este atributo es de ese tipo
	 */
	@ManyToMany(mappedBy = "jugadores")
	private List<Turno> turnos;

	/*
	 * Para la relacion one to one de person con socio puede haber dos casos:
	 * 1-que sea bidireccional
	 * 2-que tengan el mismo id.
	 * 3-Como explicaron, solo agregando la relacion en socio
	 */
	
	//1-que sea bidireccional
    //@OneToOne(mappedBy = "persona")
    //private Socio socio;

	//2-que tengan el mismo id.
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    private Socio socio;
	
	//3 Solo en socio
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(int id, int edad, String nombre, Direccion domicilio) {
		super();
		this.id = id;
		this.edad = edad;
		this.nombre = nombre;
		this.domicilio = domicilio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Direccion domicilio) {
		this.domicilio = domicilio;
	}

	public int getId() {
		return id;
	}

}
