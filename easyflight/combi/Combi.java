package easyflight.combi;

import java.io.Serializable;

/**
 * @author Team2
 *
 */
public class Combi implements Serializable{
	
	/**
	 * jede Combi hat eine eindeutige ID
	 */
	private int ID;
	/**
	 * Beschreibung der Combi
	 */
	private String beschreibung;
	/**
	 * Link wird verwendet um zu dem Angebot zu führen
	 */
	private String link;
	
	private String airline;
	
	/**
	 * Überladener Konstruktor
	 * @param id der Combi
	 * @param beschreibung der Combi
	 * @param link der Combi
	 */
	public Combi(int id, String beschreibung, String link, String airline){
		this.ID = id;
		this.beschreibung = beschreibung;
		this.link = link;
		this.airline = airline;
	}
	
	/**
	 * @return Id wird retouniert
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD set-Methode
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return Beschreibung wird retouniert
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * @param beschreibung set-Methode
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * @return Link wird retouniert
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link set-Methode
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * return airline retouniert die Fluggesellschaft welche die Combi erstellt hat
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * @param airline Methode zum setzen der Fluggsellschaft
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

}
