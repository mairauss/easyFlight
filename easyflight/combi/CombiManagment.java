package easyflight.combi;

/**
 * @author Team2
 *
 */
public class CombiManagment {
	
	/**
	 * Referenz vom Typ CombiDAO
	 */
	private CombiDAO combiDAO;
	
	/**
	 * Kontruktor indem die Referenz initalisiert wird
	 */
	public CombiManagment(){
		combiDAO = new SerializedCombiDAO("combifile.ser");
	}
	
	/**
	 * @param c Combi wird gespeichert
	 */
	public void addCombi(Combi c){
		getCombiDAO().addCombi(c);
	}
	
	/**
	 * @param c Combi wird gelöscht
	 */
	public void deleteCombi(Combi c){
		getCombiDAO().deleteCombi(c);
	}
	
	/**
	 * Überladene Methode
	 * @param id Mittels ID wird die Combi gesucht
	 * @return Alle Attribute werden ausgegeben
	 */
	public String listCombis(int id){
		String a = "Beschreibung: ";
		a += getCombiDAO().getCombibyId(id).getBeschreibung(); 
		a += "\nLink : ";
		a += getCombiDAO().getCombibyId(id).getLink();
		return a;
	}
	
	/**
	 * @return Alle Combis werden ausgegeben
	 */
	public String listCombis(){
		String a = "Alle Combis \n";
		for(int i = 0; i< getCombiDAO().getCombiList().size(); i++){
			a += "Id: "+getCombiDAO().getCombiList().get(i).getID()+"\n";
			a += "Beschreibung: "+getCombiDAO().getCombiList().get(i).getBeschreibung()+"\n";
			a += "Link: "+getCombiDAO().getCombiList().get(i).getLink()+"\n";
		}
		return a;
	}
	
	
	/**
	 * @return CombiDAO wird retouniert
	 */
	public CombiDAO getCombiDAO() {
		return combiDAO;
	}

	/**
	 * @param combiDAO set-Methode trivial
	 */
	public void setCombiDAO(CombiDAO combiDAO) {
		this.combiDAO = combiDAO;
	}

	
	
}
