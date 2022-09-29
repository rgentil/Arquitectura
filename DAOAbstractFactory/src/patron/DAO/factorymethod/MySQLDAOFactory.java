package patron.DAO.factorymethod;
//MySQL concrete DAO Factory implementation
import java.sql.*;

import patron.DAO.abstractfactory.DAOFactory;
import patron.DAO.impl.MySQL.MySQLCustomerDAO;
import patron.DAO.interfaces.CustomerDAO;
public class MySQLDAOFactory extends DAOFactory{
	
	//FIELDS
	
	//public static final String DRIVER= ...
	//public static final String DBURL= ...
	
	// method to create DB connection
	public static Connection createConnection() {
		return null;
		// Use DRIVER and DBURL to create a connection
	}
	public CustomerDAO getCustomerDAO() {
		// MySQLCustomerDAO implements CustomerDAO
		return new MySQLCustomerDAO();
	}
	// Other DAOs
	//...
}
