package edu.isistan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.isistan.conexion.ConexionDerby;
import edu.isistan.conexion.ConexionMySQL;
import edu.isistan.db.Persona;
import edu.isistan.interfaces.PersonaDAO;

public class PersonaDAOImpl extends ConexionMySQL implements PersonaDAO {

	@Override
	public void registrar(Persona persona) throws SQLException {
		// Abro conexión a la BD
		this.conectar();
		// Define la sentencia
		String insert = "INSERT INTO persona (id, nombre, edad) VALUES (?, ?, ?)";
		// Prepara la sentencia de inserción
		PreparedStatement ps = this.conn.prepareStatement(insert);
		// Setea valores de los placeholders
		ps.setInt(1, persona.getId());
		ps.setString(2, persona.getNombre());
		ps.setInt(3, persona.getEdad());
		// Ejecutamos el insert
		ps.executeUpdate();
		// Cerramos la preparación de la sentencia (No es necesario)
		ps.close();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexión
		this.cerrar();

	}

	@Override
	public void update(Persona persona) throws SQLException {
		// Abro conexión a la BD
		this.conectar();
		// Define la sentencia de actualización de registro
		String update = "UPDATE persona WHERE id = ?";
		// Prepara la sentencia
		PreparedStatement ps = this.conn.prepareStatement(update);
		// Setea valores del placeholder
		ps.setInt(1, persona.getId());
		// Ejecutamos el update
		ps.executeUpdate();
		// Cerramos la preparación de la sentencia (No es necesario)
		ps.close();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexión a la BD
		this.cerrar();

	}

	@Override
	public void delete(Persona persona) throws SQLException {
		// Abro conexión a la BD
		this.conectar();
		// Define la sentencia de actualización de registro
		String delete = "DELETE FROM persona WHERE id = ?";
		// Prepara la sentencia
		PreparedStatement ps = this.conn.prepareStatement(delete);
		// Setea valores del placeholder
		ps.setInt(1, persona.getId());
		// Ejecutamos el delete
		ps.executeUpdate();
		// Cerramos la preparación de la sentencia (No es necesario)
		ps.close();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexión a la BD
		this.cerrar();

	}

	// HACER UN SELECT

	@Override
	public ArrayList<Persona> read() throws SQLException {
		ArrayList<Persona> lista = new ArrayList<Persona>();
		// Abro conexión a la BD
		this.conectar();
		// Define la sentencia de selección
		String select = "SELECT * FROM persona";
		// Prepara la sentencia de selección
		PreparedStatement ps = this.conn.prepareStatement(select);
		// Ejecuta la sentencia y almacena en una variable
		// el conjunto de resultados obtenidos
		ResultSet rs = ps.executeQuery();
		// SELECT de Persona
		// Recorre los resultados que retornó la sentencia con un cursor
		while (rs.next()) {
			// Creo una persona
			// Nro de columna con el tipo de ese atributo.
			// Persona.id-col1 //Persona.nombre-col2 //Persona.edad-col3
			Persona persona = new Persona(rs.getInt(1), rs.getString(2), rs.getInt(3));
			// Persona persona = new Persona(rs.getInt("id"), rs.getString("nombre"),
			// rs.getInt("edad"));
			lista.add(persona);
		}
		// Cerramos la query del ResultSet
		rs.close();
		// Cerramos la query de preparación
		ps.close();
		// Cerramos la conexión a la BD
		this.cerrar();

		return lista;
	}

	@Override
	public void createTable() throws SQLException {
		// Abro conexión a la BD
		this.conectar();
		// Creo la tabla
		String table = "CREATE TABLE persona(" + "id INT," + "nombre VARCHAR(500)," + "edad INT," + "PRIMARY KEY(id))";
		// Prepara la sentencia de creación y la ejecuta
		PreparedStatement ps = this.conn.prepareStatement(table);
		ps.execute();
		// this.conn.prepareStatement(table).execute();
		// Commitea la sentencia
		this.conn.commit();
		// Cerramos la conexión a la BD
		this.cerrar();

	}

}
