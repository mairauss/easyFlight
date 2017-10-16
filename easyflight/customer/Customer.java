
package easyflight.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import easyflight.User;
import easyflight.buchung.Buchung;
import easyflight.flug.Flug;


public class Customer extends User implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String vorname;
	private String nachname;
	private String gebdatum;
    private String adresse;
    private int gebjahr;
    private ArrayList<Flug> favourites=null;
    private double miles;
    
    
    
    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Konstruktor von class Customer
     * @param id
     * @param password
     * @param vorname
     * @param nachname
     * @param gebdatum
     * @param adresse
     */
   	public Customer(String id,String password,String vorname, String nachname,
			String gebdatum, String adresse) {
		super(id,password);
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebdatum = gebdatum;
		this.adresse = adresse;		
		favourites=new ArrayList<Flug> ();
		}

   	/**
   	 * @return vorname;
   	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return nachname;
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @param gebdatum
	 * @return cal;
	 */
	public Calendar getCalendar(String gebdatum) {
       	String[] parts = gebdatum.split("-");
       	Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));    		
        // SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Calendar cal = java.util.Calendar.getInstance();
           int gebjahr = calendar.get(Calendar.YEAR);
           //String s =calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"+calendar.get(Calendar.DAY_OF_MONTH);
           setGebjahr(gebjahr);
           return cal;
       }
	
	/**
	 * @return gebdatum;
	 */
	public String getGebdatum() {
		return gebdatum;
	}

	/**
	 * @param gebdatum
	 * @throws IllegalArgumentException - wenn datum groesser als heutige Datum ist; 
	 */
	public void setGebdatum(String gebdatum) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
	    int Datum = cal.get(java.util.Calendar.YEAR);
	    getCalendar(gebdatum);
	    if(getGebjahr()>Datum)
	    {
	    	throw new IllegalArgumentException("Datum ist groesser als heutige Datum!");
	    }
	    else this.gebdatum = gebdatum;
	}

	/**
	 * @return adresse;
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return gebjahr;
	 */
	public int getGebjahr() {
		return gebjahr;
	}

	/**
	 * @param gebjahr
	 */
	public void setGebjahr(int gebjahr) {
		this.gebjahr = gebjahr;
	}
	
	/**
	 * @return gebjahr;
	 */
	public double getmiles() {
		return miles;
	}

	/**
	 * @param m
	 */
	public void setmiles(double m) {
		this.miles = m;
	}
		
	/**
	 * Speichert die Favourites Fluege 
	 * @param f
	 */
	public void addtoFav(Flug f) {
		favourites.add(f);
		System.out.println(f.getId()+" ist angekommen");
	}
	
	/***
	 * Liste mit Favourites Fluege
	 * @return favourites
	 */
	public ArrayList<Flug> getFav () {
		return favourites;
	}
	
	/**
	 * Loescht den Flug aus SavetoFav
	 * @param id
	 */
	public void deletefromFav (String id) {
		for (int i=0;i<favourites.size();i++) {
			if (id.equals(favourites.get(i).getId())) {
				favourites.remove(i);
			}
		}
	}
}