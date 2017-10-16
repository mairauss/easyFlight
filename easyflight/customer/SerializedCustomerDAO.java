package easyflight.customer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SerializedCustomerDAO implements CustomerDAO {
private String pfad;
private File file;
ArrayList<Customer> customerlist;

@SuppressWarnings("unchecked")
/**
 * Konstruktor von class SerializedCustomerDAO
 * @param pfad String
 */
public SerializedCustomerDAO (String pfad)
{
this.pfad = pfad;
customerlist = new ArrayList<Customer>();
file = new File(pfad);
if(file.exists()){
	try {
		FileInputStream fileIn=new FileInputStream(pfad+".ser");
		ObjectInputStream in=new ObjectInputStream(fileIn);
		customerlist= new ArrayList<Customer>((ArrayList<Customer>) in.readObject());
		in.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		System.exit(1);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.exit(1);
	} catch (IOException e) {
		e.printStackTrace();
		System.exit(1);
	}
  }
}

@SuppressWarnings("unchecked")
/**
 * getCustomerList zeigt alle Customers, die gespeichert wurden
 * @return customerlist;
 */
public ArrayList<Customer> getCustomerList() throws ClassNotFoundException, Exception
{
	try{
		FileInputStream fileIn=new FileInputStream(pfad+".ser");
		ObjectInputStream in=new ObjectInputStream(fileIn);
		customerlist= new ArrayList<Customer>((ArrayList<Customer>) in.readObject());
		in.close();
		} catch(IOException ex)
		{
			System.out.println(ex);
		}
	return customerlist;
}

/**
 * getCustomerbyId zeigt  einen bestimmten Kunden, der gespeichert wurde
 * @param Id int
 */
public Customer getCustomerbyId(String Id) throws ClassNotFoundException, Exception
{
	getCustomerList();
	for(int i=0; i < customerlist.size(); i++)
	{
		if( customerlist.get(i).getId().equals(Id))
		{
			return customerlist.get(i);
		}
	}
	return null;
}


/**
 * addCustomer speichert einen Client in file 
 * @param save Customer
 * @throws IllegalArgumentException wenn ein Wert fehlt und wenn Id schon besetzt ist
 */
public void addCustomer(Customer save) throws ClassNotFoundException, Exception {
	/*for (int i = 0; i < customerlist.size(); i++) {
		if (customerlist.get(i).getPassword().isEmpty() || customerlist.get(i).getVorname().isEmpty()
		|| customerlist.get(i).getNachname().isEmpty()|| customerlist.get(i).getGebdatum().isEmpty()
		|| customerlist.get(i).getAdresse().isEmpty()) {
			throw new IllegalArgumentException("A value is missing!");
		}
		if (customerlist.get(i).getId() == 0) {
			throw new IllegalArgumentException("A value is missing!");
		}
		}*/
	try {
		getCustomerList();
		for (int i = 0; i < customerlist.size(); i++) {
		if( save.getId()==customerlist.get(i).getId())
		{
    		throw new IllegalArgumentException("Id is already taken!");
    	}
		}
		customerlist.add(save);
	    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pfad+".ser")));
		oos.writeObject(customerlist);
		oos.close();
		System.out.println("Saved :) ");
	} catch (IOException i) {
		i.printStackTrace();
		System.exit(1);
	}
}

@SuppressWarnings("resource")
/**
 * deleteCustomer loescht einen Client aus file 
 * @param delete Customer
 * @throws IllegalArgumentException, wenn Customer mit diesem Id nicht existiert
 */
public void deleteCustomer(Customer delete) { 
  try {
	 ObjectInputStream ois= new ObjectInputStream( new FileInputStream(pfad+".ser"));
	  boolean gibt = false;
	 for(int i=0;i<customerlist.size();i++)
	{
		if(delete.getId().equals(customerlist.get(i).getId()))
		{
			gibt = true;
			break;
    	}
	}
	if(gibt == true)
	{
		customerlist.remove(delete);
		  saveList();
		  System.out.println("Deleted :) ");
		  ois.close();
	}
	else throw new IllegalArgumentException("Id does not exist!");
    }
  catch (Exception i) {
   System.out.println("Id does not exist!");
   System.exit(1);
   }
}
/**
 * saveList() Speichert File nach deleteCustomer nochmal
 */
public void saveList() {
  try {
  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pfad+".ser"));
  oos.writeObject(customerlist);
  oos.close();
  } catch (IOException i) {
    i.printStackTrace();
    System.exit(1);
    }
  }
}
