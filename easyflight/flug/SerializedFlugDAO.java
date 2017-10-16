package easyflight.flug;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class SerializedFlugDAO implements FlugDAO {
	private String pfad;
	private File file;
	ArrayList<Flug> flug;
	
	/**
	 * Konstruktor von class SerializedFlugDAO
     * @param pfad String
	 */
	public SerializedFlugDAO (String pfad)
	{
	this.pfad = pfad;
	flug = new ArrayList<Flug>();
	file = new File(pfad);
	if(file.exists()){
		try {
			FileInputStream fileIn=new FileInputStream(pfad+".ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			flug= new ArrayList<Flug>((ArrayList<Flug>) in.readObject());
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

	/**
	 * getFlugList zeigt alle Fluege, die gespeichert wurden
	 * @return flug;
	 */	
	public ArrayList<Flug> getFlugList() throws ClassNotFoundException, Exception
	{
		try{
			FileInputStream fileIn=new FileInputStream(pfad+".ser");
			ObjectInputStream in=new ObjectInputStream(fileIn);
			flug= new ArrayList<Flug>((ArrayList<Flug>) in.readObject());
			in.close();
			} catch(IOException ex)
			{
				System.out.println(ex);
			}
		return flug;
	}
	
	/**
	 * getFlugbyId zeigt einen bestimten Flug, der gespeichert wurde
	 * @param Id int
	 */
	public Flug getFlugbyId(String Id) throws ClassNotFoundException, Exception
	{
		getFlugList();
		for(int i=0; i < flug.size(); i++)
		{
			if( flug.get(i).getId().equals(Id))
			{
				return flug.get(i);
			}
		}
		return null;
	}

	/**
	 * addFlug speichert einen Flug in file 
	 * @param save Flug
	 * @throws IllegalArgumentException wenn ein Wert fehlt und wenn Id schon besetzt ist
	 */
	public void addFlug(Flug save) throws ClassNotFoundException, Exception {
		/*for (int i = 0; i < flug.size(); i++) {
			if (flug.get(i).getAddInfo().isEmpty() || flug.get(i).getArrivalTime().isEmpty()
			|| flug.get(i).getDestination().isEmpty()|| flug.get(i).getDestinationCountry().isEmpty()
			|| flug.get(i).getStartAirport().isEmpty()|| flug.get(i).getStartCountry().isEmpty()
			|| flug.get(i).getStartTime().isEmpty() || flug.get(i).getStartAirport().isEmpty()) {
				throw new IllegalArgumentException("A value is missing!");
			}
			if (flug.get(i).getCapacity() == 0 
				|| flug.get(i).getReservedSeats() == 0 || flug.get(i).getTicketPrice() == 0) {
				throw new IllegalArgumentException("A value is missing!");
			}
			}*/
		try {
			getFlugList();
			for (int i = 0; i < flug.size(); i++) {
			if( save.getId().equals(flug.get(i).getId()))
			{
	    		throw new IllegalArgumentException("Id is already taken!");
	    	}
			}
			flug.add(save);
		    ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(pfad+".ser")));
			oos.writeObject(flug);
			oos.close();
			System.out.println("Saved :) ");
		} catch (IOException i) {
			i.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * deleteFlug loescht einen Flug aus file 
	 * @param delete Flug
	 * @throws IllegalArgumentException
	 */
	public void deleteFlug(Flug delete) {
		try {
			 ObjectInputStream ois= new ObjectInputStream( new FileInputStream(pfad+".ser"));
			  boolean gibt = false;
			 for(int i=0;i<flug.size();i++)
			{
				if(delete.getId()==flug.get(i).getId())
				{
					gibt = true;
					break;
		    	}
			}
			if(gibt == true)
			{
				flug.remove(delete);
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
		  oos.writeObject(flug);
		  oos.close();
		  } catch (IOException i) {
		    i.printStackTrace();
		    System.exit(1);
		    }
		  }
	
	/**
	 * Ticketprice wird geaendert
	 * @param id
	 * @param price
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public void changeTicketPrice(String id, double price) throws ClassNotFoundException, Exception
	{
		getFlugList();
		for (int i = 0; i < flug.size(); i++) {
			if( id.equals(flug.get(i).getId()))
			{
	    		flug.get(i).setTicketPrice(price);
	    		saveList();
	    		System.out.println("Changed!");
	    	}
	   }
	}
}
