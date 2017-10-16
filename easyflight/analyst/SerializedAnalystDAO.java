package easyflight.analyst;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class SerializedAnalystDAO implements Serializable, AnalystDAO{
	
	private String analystfile;
	ArrayList<Analyst> analystlist = null;
	ObjectInputStream is;
	ObjectOutputStream os;
	
	public SerializedAnalystDAO (String analystfile) {
		this.analystfile = analystfile;		
		try{
			is = new ObjectInputStream(new FileInputStream(analystfile));
			analystlist = (ArrayList<Analyst>) is.readObject();
			is.close();
		}catch(Exception fx){
				analystlist = new ArrayList<Analyst>();
				try{
				os = new ObjectOutputStream(new FileOutputStream(analystfile));
				os.writeObject(analystlist);
				os.close();
				}catch(Exception ex){
					ex.printStackTrace();
				}
				
		}
	}
	
	

	@Override
	public ArrayList<Analyst> getAnalystList() {
		try {
			is = new ObjectInputStream(new FileInputStream(this.analystfile));
			ArrayList<Analyst> analystlist = (ArrayList<Analyst>) is.readObject();
			is.close();
			return analystlist;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Datei nicht gefunden - Programm beendet");
			return null;
		}
	}

	@Override
	public Analyst getAnalystbyID(String id) {
		Analyst a = null;
		for(int i = 0; i < analystlist.size(); i++){
			if(id.equals(analystlist.get(i).getId())) {
				a = analystlist.get(i);
				return a;
			}
		}
		return null;
	}

	@Override
	public void deleteAnalyst(Analyst a) {
		for(int i = 0; i < analystlist.size(); i++){
			if(a.getId() == analystlist.get(i).getId()){
				analystlist.remove(i);
				break;
			}
		}
			try{
				os = new ObjectOutputStream(new FileOutputStream(analystfile));
				os.writeObject(analystlist);
				os.close();
			}catch(IOException iox){			
				iox.printStackTrace();
			}
		
	}

	@Override
	public void addAnalyst(Analyst a) {
		if(a.getId()== null || a.getVorname() == null || a.getNachname() == null ){
			throw new IllegalArgumentException("Es müssen alle Instanzvariablen belegt sein");
		}
		for(int i = 0; i < analystlist.size(); i++){
			if(a.getId() == analystlist.get(i).getId()) throw new IllegalArgumentException("ID bereits vergeben");
		}
		
		try{
			os = new ObjectOutputStream(new FileOutputStream(analystfile));
			analystlist.add(a);
			os.writeObject(analystlist);
			os.close();
		}catch(IOException iox){
			iox.printStackTrace();
		}
		
	}
	
	

}
