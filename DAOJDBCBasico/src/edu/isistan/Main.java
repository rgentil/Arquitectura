package edu.isistan;

import java.sql.SQLException;
import edu.isistan.dao.PersonaDAOImpl;
import edu.isistan.db.Persona;
import edu.isistan.interfaces.PersonaDAO;

public class Main {

	public static void main(String[] args) {
		
		//CREACI�N INSTANCIA PERSONA
		//Persona persona = new Persona(8, "Sasha", 31);
		
		//CREACI�N INSTANCIA L�GICA DE UNA PERSONA
		PersonaDAO dao = new PersonaDAOImpl();
		
		try {
			//CREACI�N de Tabla Persona
			//dao.createTable();
			
			//ALTA de Persona
			//dao.registrar(persona);
			
			//SELECT de Persona
			//Recorre los resultados que retorn� la sentencia con un cursor
			for(Persona p : dao.read()) {
				System.out.println(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
