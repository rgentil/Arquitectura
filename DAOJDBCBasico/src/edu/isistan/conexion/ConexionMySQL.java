package edu.isistan.conexion;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import edu.isistan.interfaces.IConexion;

public class ConexionMySQL implements IConexion {

	// FIELDS

	// Conexión
	protected Connection conn;
	private String database;

	// MySQL
	private String host;
	private String puerto;
	private String usuario;
	private String contraseña;

	// CONSTRUCTOR

	public ConexionMySQL(/* String database */) {
		this.host = "localhost";
		this.puerto = "3336";
		this.usuario = "mag";
		this.contraseña = "123";

		this.database = "exampleDB";
		// this.database = database;
	}

	// REGISTRAR EL DRIVER
	private void registrarDriver() {

		// Registro el Driver
		String driver = "com.mysql.cj.jdbc.Driver";

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
	public void conectar() throws SQLException {

		// REGISTRO EL DRIVER
		this.registrarDriver();

		// Defino URI: protocolo:tipoDB:path
		// String uri = "jdbc:mysql://localhost:3306/exampleDB";
		String uri = "jdbc:mysql://" + this.host + ":" + this.puerto + "/" + this.database;

		try {
			// Registro Driver con el uso de DriverManager
			this.conn = DriverManager.getConnection(uri, this.usuario, this.contraseña);
			this.conn.setAutoCommit(false);

		} catch (SQLException e) {
			// Ataja fallos de conexión
			e.printStackTrace();
		}

	}

	// CERRAR CONEXIÓN A LA BD
	@Override
	public void cerrar() throws SQLException {

		if (this.conn != null && !this.conn.isClosed()) {
			this.conn.close();
		}
	}

}
