package easyflight.customer;

import java.util.ArrayList;
import java.util.Collection;

import easyflight.buchung.BuchungsDAO;
import easyflight.flug.*;

public class CustomerManagement {
private CustomerDAO customerDAO;
private FlugDAO flugDAO;
private ArrayList<String> savetofav = new ArrayList<String>();



/**
 *Konstruktor von class CustomerManagement
 */
public CustomerManagement() {
	 this.customerDAO = new SerializedCustomerDAO("customerfile.ser");
}

/**
 * @return customerDAO;
 */
public CustomerDAO getCustomerDAO() {
	return customerDAO;
}

/**
 * @param customerDAO
 */
public void setCustomerDAO(CustomerDAO customerDAO) {
	this.customerDAO = customerDAO;
}

/**
 * @return customerDAO.getCustomerList();
 */
public ArrayList<Customer> getCustomerList()
{
  	try {
		return customerDAO.getCustomerList();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
}

/**
 * @param Id int
 * @return customerDAO.getCustomerbyId(Id);
 */
public Customer getCustomerbyId(String Id) 
{
	try{
	if(customerDAO.getCustomerbyId(Id).equals(null))
	{
		return null;
	}
	else return customerDAO.getCustomerbyId(Id);
	}catch(Exception x){
		System.out.println("Es ist ein Fehler aufgetreten");
		return null;
	}
}

/**
 * @param save Customer
 * @throws ClassNotFoundException
 * @throws Exception
 */
public void addCustomer(Customer save) throws ClassNotFoundException, Exception
{
   customerDAO.addCustomer(save);
}

/**
 * @param Id int
 * @throws ClassNotFoundException
 * @throws Exception
 */
public void deletebyId(String Id) throws ClassNotFoundException, Exception
{
  customerDAO.deleteCustomer(customerDAO.getCustomerbyId(Id));
}

/**
 * Save Favourites Flights to SaveFavourite
 * @param Id
 * @throws ClassNotFoundException
 * @throws Exception
 */
public void SaveToFavourites(String Id) throws ClassNotFoundException, Exception 
{
	ArrayList<Flug> favflug =flugDAO.getFlugList();

	for(int i =0; i> favflug.size(); i++)
	{
		if(Id.equals(favflug.get(i).getId())){
		savetofav.addAll((Collection<? extends String>) favflug.get(i));
		}
	}
}

/**
 * Zeigt die List von "Favourites Flights"
 * @return savetofav;
 */
public ArrayList<String> ShowFavourites()
{
	return savetofav;
}


/**
 * Die Flugmeilen sammeln
 * @param id
 * @param n
 * @throws ClassNotFoundException
 * @throws Exception
 */
/*public void addMiles(String id) throws ClassNotFoundException, Exception
{
	ArrayList<Flug> favflug =flugDAO.getFlugList();
	for(int i =0; i> favflug.size(); i++)
	{
		if(id.equals(favflug.get(i).getId()))
		{
		+= favflug.get(i).getMiles();
	    }
	}
}
*/
}

