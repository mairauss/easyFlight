package easyflight.customer;

import java.util.ArrayList;

public interface CustomerDAO {
	 public ArrayList<Customer> getCustomerList() throws ClassNotFoundException, Exception;
	 public Customer getCustomerbyId(String id) throws ClassNotFoundException, Exception;
	 public void addCustomer(Customer save) throws ClassNotFoundException, Exception;
	 public void deleteCustomer(Customer delete);
}
