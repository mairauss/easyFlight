package easyflight.buchung;

import java.io.Serializable;

/**
 * @author Team2
 *
 */
public class Buchung implements Serializable {
	/**
	 * Id der Buchung
	 */
	private int ID;
	/**
	 * Id des Buchers
	 */
	private String CustomerId;
	/**
	 * Id des Fluges
	 */
	private String FlightId;
	private double preis;
	
	

	/**
	 * Konstrukto
	 * @param id Id der Buchung
	 * @param cid des Customer
	 * @param fid des Fluges
	 */
	public Buchung(int id, String cid, String fid, double preis){
		this.ID = id;
		this.CustomerId = cid;
		this.FlightId = fid;
		this.preis = preis;
	}
	
	/**
	 * @return retouniert die CustomerID
	 */
	public String getCustomerId() {
		return CustomerId;
	}
	/**
	 * @param customerId set Methode
	 */
	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}
	/**
	 * @return retouniert die Flugid
	 */
	public String getFlightId() {
		return FlightId;
	}
	/**
	 * @param flightId set Methode
	 */
	public void setFlightId(String flightId) {
		FlightId = flightId;
	}
	
	/**
	 * @return retouniert die Id der Buchung
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD set Methode
	 */
	public void setID(int iD) {
		ID = iD;
	}
	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
}