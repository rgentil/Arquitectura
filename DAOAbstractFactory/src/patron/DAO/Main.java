package patron.DAO;

import patron.DAO.abstractfactory.DAOFactory;
import patron.DAO.databaseObjects.Customer;
import patron.DAO.interfaces.CustomerDAO;

public class Main {

	public static void main(String[] args) {
		// create the required DAO Factory
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory. MYSQL_JDBC);
		CustomerDAO custDAO = mysqlFactory.getCustomerDAO();
		// create a new customer
		//int newCustNo = custDAO.insertCustomer(...);
		// Find a customer object.
		//Customer cust = custDAO.findCustomer(...);
		// modify the values in the Transfer Object and update it using the DAO
		//cust.setAddress(...);
		//cust.setEmail(...);
		//custDAO.updateCustomer(cust);
		// select all customers in the same city
		//CustomerCriteria criteria=new CustomerCriteria();
		//criteria.setCity("New York");
		//Collection customersList = custDAO.selectCustomers(criteria);

	}

}
