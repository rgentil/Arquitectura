package edu.isistan.conexion;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.isistan.interfaces.IConexion;

public class ConexionDerby implements IConexion {

	protected Connection conn;

	// REGISTRAR EL DRIVER
	private void registrarDriver() {

		// Registro el Driver
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";

		try {
			// Creo una instancia del Driver usando mecanismo de reflexión
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			// Falla al agregar el Driver sale del programa
			e.printStackTrace();
			System.exit(1);
		}

	}

	// GENERAR CONEXIÓN A LA BD
	@Override
	public void conectar() {

		// REGISTRO EL DRIVER
		this.registrarDriver();

		// Defino URI: protocolo:tipoDB:path:paramCreación
		String uri = "jdbc:derby:MyDerbyDb;create=true";

		try {
			// Registro Driver con el uso de DriverManager
			this.conn = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			// Ataja fallos de conexión
			e.printStackTrace();
		}
	}

	// CERRAR CONEXIÓN A LA BD
	@Override
	public void cerrar() throws SQLException {

		if (conn != null && !conn.isClosed()) {
			conn.close();
		}
	}
}
