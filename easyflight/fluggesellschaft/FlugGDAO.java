package easyflight.fluggesellschaft;

import java.io.IOException;
import java.util.ArrayList;

import easyflight.buchung.Buchung;

public interface FlugGDAO {
	/**
	 * @return retouniert die FlugGListe
	 */
	public ArrayList<Fluggesellschaft> getFlugGList();
	/**
	 * @param Name der Airline
	 * @return retouniert eine Fluggesellschaft
	 */
	public Fluggesellschaft getFlugGbyname(String Name);
	/**
	 * @param fg Fluggesellschaft wird gespeichert
	 */
	public void addFlugG(Fluggesellschaft fg);
	/**
	 * @param fg Fluggesellschaft wird gelöscht
	 */
	public void deleteFlugG(Fluggesellschaft fg);
}
//fertig