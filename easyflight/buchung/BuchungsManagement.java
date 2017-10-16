package easyflight.buchung;

import java.io.Serializable;

/**
 * @author Team2
 *
 */
public class BuchungsManagement implements Serializable {

	/**
	 * Referenz vom typ BuchungsDAO
	 */
	private BuchungsDAO buchungDAO;
	
	/**
	 * Konstruktor
	 */
	public BuchungsManagement(){
		buchungDAO = new SerializedBuchungsDAO("buchungsfile.ser");
	}
	
	/**
	 * @param c Buchung wird gespeichert
	 */
	public void addBuchung(Buchung c){
		getBuchungDAO().addBuchung(c);
	}
	
	/**
	 * @param c Buchung wird gelöscht
	 */
	public void deleteBuchung(Buchung c){
		getBuchungDAO().deleteBuchung(c);
	}
	
	/**
	 * @return Listet alle Buchungen auf
	 */
	public String listBuchungen(){
		String a = "Alle Buchungen \n";
		for(int i = 0; i< getBuchungDAO().getBuchungList().size(); i++)
		{
			a += "BuchungsID: "+getBuchungDAO().getBuchungList().get(i).getID()+"\n";
			a += "CustomerID: "+getBuchungDAO().getBuchungList().get(i).getCustomerId()+"\n";
			a += "FlightID: "+getBuchungDAO().getBuchungList().get(i).getFlightId()+"\n";
		}
		return a;
	}
		
	/**
	 * @return retouniert das DAO
	 */
	public BuchungsDAO getBuchungDAO() {
		return buchungDAO;
	}

	/**
	 * @param BuchungDAO set Methode
	 */
	public void setBuchungDAO(BuchungsDAO BuchungDAO) {
		this.buchungDAO = BuchungDAO;
	}
	
}
