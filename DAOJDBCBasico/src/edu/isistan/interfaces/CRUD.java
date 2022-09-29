package edu.isistan.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CRUD<T> {

	public void registrar(T generic) throws SQLException;

	public void update(T generic) throws SQLException;

	public void delete(T generic) throws SQLException;

	public ArrayList<T> read() throws SQLException;

	public void createTable() throws SQLException;
}
