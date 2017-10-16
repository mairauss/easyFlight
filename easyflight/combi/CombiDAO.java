package easyflight.combi;

import java.util.ArrayList;



/**
 * @author Team2
 *
 */
public interface CombiDAO {

	/**
	 * @return Liste mit Combis wird retouniert
	 */
	public ArrayList<Combi> getCombiList();
	/**
	 * @param Id als Parameter
	 * @return Combi objekt anhand der ID
	 */
	public Combi getCombibyId(int Id);
	/**
	 * @param c Combi wird gespeichert
	 */
	public void addCombi(Combi c);
	/**
	 * @param c Combi wird gelöscht
	 */
	public void deleteCombi(Combi c);
	
}
