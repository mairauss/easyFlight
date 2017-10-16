package easyflight.buchung;

import java.util.ArrayList;

import easyflight.flug.Flug;

/**
 * @author Team2
 *
 */
public interface BuchungsDAO {
	
	/**
	 * @return retouniert die Buchungsliste
	 */
	public ArrayList<Buchung> getBuchungList();
	/**
	 * @param Id einer Buchung
	 * @return retouniert eine Buchung mit der Id die als Paramet eingegeben wird
	 */
	public Buchung getBuchungbyId(int Id);
	/**
	 * @param b Buchung wird gespeichert
	 */
	public void addBuchung(Buchung b);
	/**
	 * @param b Buchung wird gelöscht
	 */
	public void deleteBuchung(Buchung b);
}
