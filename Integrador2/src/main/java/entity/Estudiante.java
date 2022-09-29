package main.java.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estudiante {
	/*
	 * Considere el diseño de un registro de estudiantes, con la siguiente
	 * información: nombres,apellido, edad, género, número de documento, ciudad de
	 * residencia, número de libreta universitaria
	 */
	@Id
	private Long DNI;// numero de documento lo tomo como id de la tabla

	@Column(nullable = false)
	private String nombre;

	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private int edad;

	@Column(nullable = false)
	private String genero;

	@Column(nullable = false)
	private String ciudad;

	@Column(unique = true)
	private long LU;// numero de libreta

	@OneToMany(mappedBy = "estudiante")
	private List<CarreraEstudiante> carreras;

}
