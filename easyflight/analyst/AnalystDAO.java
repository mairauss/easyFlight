package easyflight.analyst;

import java.util.ArrayList;

public interface AnalystDAO {
	
	/**
	 * @return gibt eine Liste aller Analysten im System zurück
	 */
	public ArrayList<Analyst> getAnalystList();
	/**
	 * @param id ID für das Suchen des Objekts
	 * @return gibt ein bestimmtes Objekt Analyst mit Hilfe der ID zurück
	 */
	public Analyst getAnalystbyID(String id);
	/**
	 * @param a Löscht das Objekt Analyst a aus der Liste, falls es vorhanden ist
	 */
	public void deleteAnalyst(Analyst a);
	/**
	 * @param a Fügt den Analysten a in die Liste dazu
	 */
	public void addAnalyst (Analyst a);
	
	
}
