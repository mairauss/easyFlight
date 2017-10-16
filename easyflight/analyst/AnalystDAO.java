package easyflight.analyst;

import java.util.ArrayList;

public interface AnalystDAO {
	
	/**
	 * @return gibt eine Liste aller Analysten im System zur�ck
	 */
	public ArrayList<Analyst> getAnalystList();
	/**
	 * @param id ID f�r das Suchen des Objekts
	 * @return gibt ein bestimmtes Objekt Analyst mit Hilfe der ID zur�ck
	 */
	public Analyst getAnalystbyID(String id);
	/**
	 * @param a L�scht das Objekt Analyst a aus der Liste, falls es vorhanden ist
	 */
	public void deleteAnalyst(Analyst a);
	/**
	 * @param a F�gt den Analysten a in die Liste dazu
	 */
	public void addAnalyst (Analyst a);
	
	
}
