package main.java.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // Se indica que la clase puede ser embebida por otra(? saco pk compuesto
public class CarreraEstudianteId {

	@Column(name = "estudiante_id")
	private Long estudianteId;

	@Column(name = "carrear_id")
	private Long carreraId;

	public CarreraEstudianteId(Long estudianteId, Long carreraId) {
		super();
		this.estudianteId = estudianteId;
		this.carreraId = carreraId;
	}

	public CarreraEstudianteId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getEstudianteId() {
		return estudianteId;
	}

	public Long getCarreraId() {
		return carreraId;
	}

}
