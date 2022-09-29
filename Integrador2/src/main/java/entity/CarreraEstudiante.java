package main.java.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class CarreraEstudiante {
	
	@EmbeddedId
	private CarreraEstudianteId id;
	
	@ManyToOne
    @MapsId("studentId")
	@JoinColumn(name = "student_id")
    private Estudiante estudiante;
    
	@ManyToOne
    @MapsId("careerId")
    @JoinColumn(name = "career_id")
    private Carrera carrera;
    
	@Column 
    private int antiguedad;
	
	@Column
    private Boolean graduado;
    


}
