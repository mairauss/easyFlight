package easyflight.analyst;

import easyflight.User;

/**
 * @author Stefan
 *
 */
public class Analyst extends User {
	private String vorname;
	private String nachname;


	/**
	 * Konstruktor für den Analysten
	 * @param id Gibt die ID des Analysten an
	 * @param password Gibt das Passwort des Benutzers an
	 * @param vorname Gibt den Vornamen des Benutzers an
	 * @param nachname Gibt den Nachnamen des Benutzers an
	 */
	public Analyst(String id,String password, String vorname, String nachname) {
		super(id,password);
		this.vorname=vorname;
		this.nachname=nachname;
	}

	/**
	 * @return gibt den Vornamen zurück
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname setzt den Vornamen
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return gibt den Nachnamen zurück
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname setzt den Nachnamen 
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}	

}
