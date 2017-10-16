package easyflight.buchung;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import easyflight.flug.Flug;

/**
 * @author Team2
 *
 */
public class SerializedBuchungsDAO implements BuchungsDAO, Serializable{
	/**
	 * PFad der Datei
	 */
	private String buchungsfile;
	/**
	 * Liste in der Buchungen gespeichert werden
	 */
	ArrayList<Buchung> buchungsliste = null;
	FileInputStream fis; 
	ObjectInputStream is;
	FileOutputStream fos;
	ObjectOutputStream os;
	
	public SerializedBuchungsDAO(String file){
		this.buchungsfile = file;		
		try{
			fis = new FileInputStream(this.buchungsfile);
			is = new ObjectInputStream(fis);
			buchungsliste = (ArrayList<Buchung>) is.readObject();
			is.close();
			fis.close();
		}catch(Exception fx){
			 buchungsliste = new ArrayList<Buchung>();
				try{
				fos = new FileOutputStream(file);
				os = new ObjectOutputStream(fos);
				os.writeObject(buchungsliste);
				os.close();
				fos.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
		}
	}
	
	public ArrayList<Buchung> getBuchungList(){
		try {
			fis = new FileInputStream(this.buchungsfile);
			is = new ObjectInputStream(fis);
			ArrayList<Buchung> flist = (ArrayList<Buchung>) is.readObject();
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
	public Buchung getBuchungbyId(int id){
		Buchung c = null;
			for(int i = 0; i < buchungsliste.size(); i++){
				if(id == buchungsliste.get(i).getID()){
					c = buchungsliste.get(i);
					return c;
				}
			}
			return null;
	}
	
	public void addBuchung(Buchung c){		
		/*if(c.getId() == 0 || c.getCustomerId() == 0 || c.getFlightId() == 0 ){
			throw new IllegalArgumentException("Falsche Parametereingabe");
		}
		for(int i = 0; i < buchungsliste.size(); i++){
			if(c.getId() == buchungsliste.get(i).getID())throw new IllegalArgumentException("ID bereits vergeben");
		}*/
		
		try{
			fos = new FileOutputStream(buchungsfile);
			os = new ObjectOutputStream(fos);
			buchungsliste.add(c);
			os.writeObject(buchungsliste);
			os.close();
			fos.close();
		}catch(IOException iox){
			iox.printStackTrace();
		}
	}
	
	public void deleteBuchung(Buchung c){		
		for(int i = 0; i < buchungsliste.size(); i++){
			if(c.getID() == buchungsliste.get(i).getID()){
				buchungsliste.remove(i);
				break;
			}
		}
			try{
				fos = new FileOutputStream(buchungsfile);
				os = new ObjectOutputStream(fos);
				os.writeObject(buchungsliste);
				os.close();
				fos.close();
			}catch(IOException iox){			
				iox.printStackTrace();
			}
	}
}
