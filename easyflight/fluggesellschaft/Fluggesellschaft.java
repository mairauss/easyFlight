package easyflight.fluggesellschaft;

import java.io.Serializable;

import easyflight.User;

public class Fluggesellschaft extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Name der Fluggesellschaft
	 */
	private String Name; 
	
	
	/**
	 * Überladener Konstruktor
	 * @param id Id der Airline
	 * @param password Passwort der Airline
	 * @param Name Bezeichnung der Airline
	 */
	public Fluggesellschaft(String id,String password, String Name){
		super(id, password);
		this.Name=Name;
		
	}
	/*public Fluggesellschaft(Fluggesellschaft fg){
		super(fg.getId(),fg.getPassword());
		this.Name=fg.getName();
		
	}*/	
	/**
	 * @return retouniert den Namen der Fluggesellschaft
	 */
	public String getName() {
		return Name;	
	}
	
}


