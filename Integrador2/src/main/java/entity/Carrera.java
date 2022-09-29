package main.java.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Carrera {
	/*
	 * carrera(s) en la que está inscripto, antigüedad en cada una de esas carreras,
	 * y si se graduó o no
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "carrera")
	private List<CarreraEstudiante> estudiantes;

}
