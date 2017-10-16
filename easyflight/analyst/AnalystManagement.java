package easyflight.analyst;

public class AnalystManagement {

	private AnalystDAO analystdao;
	
	/**
	 * Konstruktor für das Management, dabei wird die Klasse SerializedAnalystDAO referenziert und die File zum speichern wird übergeben
	 */
	public AnalystManagement () {
		analystdao=new SerializedAnalystDAO("analystfile.ser");
	}
	
	/**
	 * @return gibt das Interface zurück
	 */
	public AnalystDAO getAnalystdao() {
		return analystdao;
	}



	/**
	 * @param analystdao setzt das Interface neu
	 */
	public void setAnalystdao(AnalystDAO analystdao) {
		this.analystdao = analystdao;
	}
	
	
	/**
	 * @param a Fügt einen Analysten A in die Liste
	 */
	public void addAnalyst (Analyst a) {
		getAnalystdao().addAnalyst(a);
	}
	
	/**
	 * @param a Löscht einen Analsyst a aus der Liste
	 */
	public void deleteAnalyst (Analyst a) {
		getAnalystdao().deleteAnalyst(a);
	}
	
	/**
	 * @param id Zeigt für einen bestimmten Analysten die Attribute 
	 * @return retouniert id
	 */
	public String showAnalyst (String id) {
		String s="";
		s+="ID"+getAnalystdao().getAnalystbyID(id).getId()+'\n';
		s+="Vorname"+getAnalystdao().getAnalystbyID(id).getVorname()+'\n';
		s+="Nachname"+getAnalystdao().getAnalystbyID(id).getNachname()+'\n';
		s+="Passwort"+getAnalystdao().getAnalystbyID(id).getPassword()+'\n'+'\n';
		
		return s;
	}
	
	



	
	
	
	
}
