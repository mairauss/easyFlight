package easyflight.fluggesellschaft;

import java.io.IOException;
import java.util.ArrayList;

public class FGesellschaftManagement{
	
	private SerializedFlugGDAO fgDAO;
	
	
	public FGesellschaftManagement(){
		
		
		fgDAO=new SerializedFlugGDAO("fgfile.ser");
	
	}
	
	public void addGesellschaft(Fluggesellschaft fg){
		getFGDAO().addFlugG(fg);
	}
	
	public void deleteFlightG(Fluggesellschaft fg) throws IOException{
		getFGDAO().deleteFlugG(fg);
	}
	
	public ArrayList<Fluggesellschaft> listGesellschaften(){
		return getFGDAO().getFlugGList();
	}
	
	
	public void setFGManList(SerializedFlugGDAO list){
		this.fgDAO=list;
	}
	
	public SerializedFlugGDAO getFGDAO(){
		return fgDAO;
	}
}
