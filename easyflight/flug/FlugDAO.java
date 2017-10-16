package easyflight.flug;

import java.util.ArrayList;

public interface FlugDAO {
	public ArrayList<Flug> getFlugList() throws ClassNotFoundException, Exception;
	 public Flug getFlugbyId(String id) throws ClassNotFoundException, Exception;
	 public void addFlug(Flug save) throws ClassNotFoundException, Exception;
	 public void deleteFlug(Flug delete);
	 public void changeTicketPrice(String id, double price) throws ClassNotFoundException, Exception;
}
