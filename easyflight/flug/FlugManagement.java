package easyflight.flug;

import java.util.ArrayList;

public class FlugManagement {
	public FlugDAO flugDAO;
	private String pfad;

	/**
	 *Konstruktor von class FlugManagement
	 */
	public FlugManagement() {
		 this.flugDAO = new SerializedFlugDAO(pfad+".ser");
	}

	/**
	 * @return flugDAO;
	 */
	public FlugDAO getFlugDAO() {
		return flugDAO;
	}

	/**
	 * @param flugDAO
	 */
	public void setFlugDAO(FlugDAO flugDAO) {
		this.flugDAO = flugDAO;
	}

	/**
	 * @param flugdatum 
	 * @return flugDAO.getFlugList();
	 */
	
	public ArrayList<Flug> getFlugbyDestination (String start, String destination, String flugdatum) {
		ArrayList<Flug> fluglist = new ArrayList<Flug> ();
		ArrayList<Flug> allflights = null;
		try {
			allflights=getFlugList();
		}  catch (Exception e) {
		}
		
		if (!flugdatum.isEmpty()) {
			for (int i=0;i<allflights.size();i++) {
				if ((allflights.get(i).getStartAirport().equals(start)) && (allflights.get(i).getDestination().equals(destination))  && (allflights.get(i).getDatum().equals(flugdatum))) {
					fluglist.add(allflights.get(i));
				}
			}
			System.out.println ("Flugdatum="+flugdatum);
		}
		else {
			for (int i=0;i<allflights.size();i++) {
				if ((allflights.get(i).getStartAirport().equals(start)) && (allflights.get(i).getDestination().equals(destination))) {
					fluglist.add(allflights.get(i));
				}
			}
		}
		
		return fluglist;
	}
	
	/**
	 * 
	 * @return FlugList;
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public ArrayList<Flug> getFlugList() throws ClassNotFoundException, Exception
	{
	  	return flugDAO.getFlugList();
	}

	/**
	 * @param Id int
	 * @return flugDAO.getFlugbyId(Id);
	 * @throws ClassNotFoundException
	 * @throws Exception
	 * @throws IllegalArgumentException - wenn Id nicht existiert 
	 */
	public Flug getFlugbyId(String Id) throws ClassNotFoundException, Exception
	{
		if(flugDAO.getFlugbyId(Id).equals(null))
		{
			throw new IllegalArgumentException("Id does not exist! ");
		}
		else return flugDAO.getFlugbyId(Id);
	}

	/**
	 * @param save Flug
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public void addFlug(Flug save) throws ClassNotFoundException, Exception
	{
		flugDAO.addFlug(save);
	}

	/**
	 * @param Id int
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public void deletebyId(String Id) throws ClassNotFoundException, Exception
	{
		flugDAO.deleteFlug(flugDAO.getFlugbyId(Id));
	}
	
	/**
	 * Durchschnittspreis aller Fluege
	 * @return Preis/i;
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public double meanPrice() throws ClassNotFoundException, Exception
	{
		double Preis=0;
		ArrayList<Flug> fluglist =flugDAO.getFlugList();
		  int i=0;
		  for(; i < fluglist.size();i++)
		  {
			  if(fluglist.get(i) instanceof Flug)
			  {
			Preis += fluglist.get(i).getTicketPrice();
			  }
		  }
		  return Preis/i;
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
		flugDAO.changeTicketPrice(id, price);
	}
	
	/**
	 * 
	 * @return auslastung;
	 */
	public double meanutilization () {
		double auslastung=0;
 		ArrayList<Flug> fluglist;
 		try {
 			fluglist = flugDAO.getFlugList();
 			int i=0;
 			  for(; i < fluglist.size();i++)
 			  {
 				  auslastung += fluglist.get(i).getReservedSeats()/fluglist.get(i).getCapacity();
 			  }
 			  auslastung = auslastung/i;
 			  auslastung = auslastung * 10000;
 			  auslastung = (int)auslastung;
 			  auslastung = (double) auslastung/100;
 			  return auslastung;
 		} catch (Exception e) {
 			// TODO Auto-generated catch block
 			return 0;
		}
	}
	
	/**
	 * @return gibt einen String mit den durchschnittlichen Kartenpreis, Anzahl Fl�ge im System, Auslastung der Fl�ge
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public String seeFStatistics () throws ClassNotFoundException, Exception {
		String s="";
		s+="<br>Durchschnittlicher Kartenpreis: "+meanPrice()+"</br>"+'\n';
		s+="<br> Es sind "+getFlugList().size()+" Fluege im System </br>";
		s+="Auslastung der Fluege: "+ meanutilization()+'\n';
		return s;
	}
	
	/**
	 * @param id Id des jeweiligen Fluges
	 * @return gibt den Kartenpreis und die Auslastung des Fluges zur�ck
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public String seeFStatistics (String  id) throws ClassNotFoundException, Exception {
		Flug f=getFlugbyId(id);
		String s="";
		s+="<br>Kartenpreis fuer den Flug "+id+": "+f.getTicketPrice()+"</br>"+"\n";
		s+="<br>Auslastung des Fluges "+id+": "+(f.getReservedSeats()/f.getCapacity())+"</br>"+'\n';
		return s;
	}
	
	
	/**
	 * @param auslastung gibt als Parameter an unter welcher Auslastungsgrenze in Prozent ein Flug verbilligt werden soll
	 * @param verkleinert gibt an um wie viel Prozent ein Flug verbilligt werden soll
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	public int setParameters (int auslastung, int verkleinert) throws ClassNotFoundException, Exception {
		int j=0;
		for (int i=0;i<getFlugDAO().getFlugList().size();i++) {
			if (getFlugDAO().getFlugList().get(i).getReservedSeats()/getFlugDAO().getFlugList().get(i).getCapacity()<auslastung) {
				double oldprice=getFlugDAO().getFlugList().get(i).getTicketPrice();
				getFlugDAO().getFlugList().get(i).setTicketPrice(oldprice*(100-verkleinert));
				j++;
			}
		}
		return j;
		
	}
}

