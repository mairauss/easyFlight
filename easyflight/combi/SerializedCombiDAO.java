package easyflight.combi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



/**
 * @author Team2
 *
 */
public class SerializedCombiDAO implements CombiDAO, Serializable{
	/**
	 * Pfad der Datei
	 */
	private String combifile;
	/**
	 * Liste in der die Combis gespeichert werden
	 */
	ArrayList<Combi> combiListe = null;
	/**
	 * Inputstream zum lesen
	 */
	FileInputStream fis; 
	/**
	 * Outputstream zum speichern
	 */
	ObjectInputStream is;
	FileOutputStream fos;
	ObjectOutputStream os;
	
	/**
	 * Konstruktor
	 * @param file Pfad wird übergeben wo die Datei gespeichert wird
	 */
	public SerializedCombiDAO(String file){
		this.combifile = file;		
		try{
			fis = new FileInputStream(this.combifile);
			is = new ObjectInputStream(fis);
			combiListe = (ArrayList<Combi>) is.readObject();
			is.close();
			fis.close();
		}catch(Exception fx){
				combiListe = new ArrayList<Combi>();
				try{
				fos = new FileOutputStream(file);
				os = new ObjectOutputStream(fos);
				os.writeObject(combiListe);
				os.close();
				fos.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
		}
	}
	
	public ArrayList<Combi> getCombiList(){
		try {
			fis = new FileInputStream(this.combifile);
			is = new ObjectInputStream(fis);
			ArrayList<Combi> flist = (ArrayList<Combi>) is.readObject();
			is.close();
			fis.close();
			return flist;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Datei nicht gefunden - Programm beendet");
			return null;
		}
	}
	public Combi getCombibyId(int id){
		Combi c = null;
			for(int i = 0; i < combiListe.size(); i++){
				if(id ==(combiListe.get(i).getID())){
					c = combiListe.get(i);
					return c;
				}
			}
			return null;
	}
	
	public void addCombi(Combi c){		
		if(c.getID()==0 || c.getBeschreibung() == null || c.getLink() == null ){
			throw new IllegalArgumentException("Falsche Parametereingabe");
		}
		for(int i = 0; i < combiListe.size(); i++){
			if(c.getID() == combiListe.get(i).getID())throw new IllegalArgumentException("ID bereits vergeben");
		}
		try{
			fos = new FileOutputStream(combifile);
			os = new ObjectOutputStream(fos);
			combiListe.add(c);
			os.writeObject(combiListe);
			os.close();
			fos.close();
		}catch(IOException iox){
			iox.printStackTrace();
		}
	}
	public void deleteCombi(Combi c){		
		for(int i = 0; i < combiListe.size(); i++){
			if(c.getID() == combiListe.get(i).getID()){
				combiListe.remove(i);
				break;
			}
		}
			try{
				fos = new FileOutputStream(combifile);
				os = new ObjectOutputStream(fos);
				os.writeObject(combiListe);
				os.close();
				fos.close();
			}catch(IOException iox){			
				iox.printStackTrace();
			}
	}
	
}
