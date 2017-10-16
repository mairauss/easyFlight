package easyflight;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * Passwort das jeder User hat
	 */
	private String password;
	/**
	 * Jeder User hat eine ID
	 */
	private String ID;

	
	/**
	 * Konstruktor für die erstellung eines Users, wird nicht verwendet weil nur abgeleitet
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param password id Konstruktor mit Passwort  und ID als Parameter
	 */
	public User (String ID,String password) {
		this.ID = ID;
		this.password=password;

	}
	
	/**
	 * @return gibt das Password des Benutzers zurück
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param id Methode um die Id zu setzen
	 */
	public void setId(String id) {
		this.ID = id;
	}
	/**
	 * @return retouniert die ID des Users
	 */
	public String getId() {
		return ID;
	}
	/**
	 * @param password setzt das Passwort des Benutzers neu
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

	

}
