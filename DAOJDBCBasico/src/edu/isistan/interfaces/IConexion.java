package edu.isistan.interfaces;

import java.sql.SQLException;

public interface IConexion {

	public void conectar() throws SQLException;

	public void cerrar() throws SQLException;

}
