package easyflight.fluggesellschaft;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import easyflight.analyst.Analyst;
import easyflight.buchung.Buchung;

public class SerializedFlugGDAO implements FlugGDAO, Serializable {

	/**
	 * PFad der Datei
	 */
	private String fgfile;
	/**
	 * Liste in der Buchungen gespeichert werden
	 */
	ArrayList<Fluggesellschaft> fgliste = null;
	FileInputStream fis; 
	ObjectInputStream is;
	FileOutputStream fos;
	ObjectOutputStream os;
	
	public SerializedFlugGDAO(String file){
		this.fgfile = file;		
		try{
			fis = new FileInputStream(this.fgfile);
			is = new ObjectInputStream(fis);
			fgliste = (ArrayList<Fluggesellschaft>) is.readObject();
			is.close();
			fis.close();
		}catch(Exception fx){
			fgliste = new ArrayList<Fluggesellschaft>();
				try{
				fos = new FileOutputStream(file);
				os = new ObjectOutputStream(fos);
				os.writeObject(fgliste);
				os.close();
				fos.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
		}
	}
	
	public ArrayList<Fluggesellschaft> getFlugGList(){
		try {
			fis = new FileInputStream(this.fgfile);
			is = new ObjectInputStream(fis);
			ArrayList<Fluggesellschaft> fgliste = (ArrayList<Fluggesellschaft>) is.readObject();
			is.close();
			fis.close();
			return fgliste;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Datei nicht gefunden - Programm beendet");
			return null;
		}
	}
	public Fluggesellschaft getFlugGbyname(String name){
		Fluggesellschaft fg = null;
			for(int i = 0; i < fgliste.size(); i++){
				if(name.equals(fgliste.get(i).getName())){
					fg = fgliste.get(i);
					return fg;
				}
			}
			return null;
	}
	
	public void addFlugG(Fluggesellschaft fg){		
		/*if(c.getId() == 0 || c.getCustomerId() == 0 || c.getFlightId() == 0 ){
			throw new IllegalArgumentException("Falsche Parametereingabe");
		}
		for(int i = 0; i < buchungsliste.size(); i++){
			if(c.getId() == buchungsliste.get(i).getID())throw new IllegalArgumentException("ID bereits vergeben");
		}*/
		
		try{
			fos = new FileOutputStream(fgfile);
			os = new ObjectOutputStream(fos);
			fgliste.add(fg);
			os.writeObject(fgliste);
			os.close();
			fos.close();
		}catch(IOException iox){
			iox.printStackTrace();
		}
	}
	
	public void deleteFlugG(Fluggesellschaft fg){		
		for(int i = 0; i < fgliste.size(); i++){
			if(fg.getId().equals(fgliste.get(i).getId())){
				fgliste.remove(i);
				break;
			}
		}
			try{
				fos = new FileOutputStream(fgfile);
				os = new ObjectOutputStream(fos);
				os.writeObject(fgliste);
				os.close();
				fos.close();
			}catch(IOException iox){			
				iox.printStackTrace();
			}
	}
	
}
