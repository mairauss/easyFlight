package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;
import easyflight.fluggesellschaft.Fluggesellschaft;

/**
 * Servlet implementation class ChangeTicketPrice
 */
@WebServlet("/ChangeTicketPrice")
public class ChangeTicketPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Konstruktor von servlet ChangeTicketPrice
     */
    public ChangeTicketPrice() {
        super();
    }

    /**
     * Die Fluggesellschaft kann Ticketpreis aendern
     * Wenn ein Wert fehlt und ID schon vergeben ist,
     * dann erhlt FG eine Fehlermeldung "'WERT' field is required!"
     * oder "Id is already taken!"
     * Bei erfolgreicher aenderung, wechselt FG auf die Seite des Ergebnisses
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     **/
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
	double TicketPrice =0;
    String ID = request.getParameter("ID");
    if(!request.getParameter("TicketPrice").isEmpty()){
    	 TicketPrice = Double.parseDouble(request.getParameter("TicketPrice"));
    }
            
    Fluggesellschaft fg = (Fluggesellschaft) request.getSession().getAttribute("currentSessionFG");
    String airline = fg.getName();
    
    PrintWriter out = response.getWriter();
    FlugManagement fm = new FlugManagement();
    boolean noid = false;

    	try {
			for(int i=0;i<fm.getFlugList().size();i++)
			{
				if(ID.equals(fm.getFlugList().get(i).getId()) && fm.getFlugList().get(i).getAirline().equals(airline))
				{
						try {
							fm.changeTicketPrice(ID, TicketPrice);
							noid = true;
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						}
						RequestDispatcher rd=request.getRequestDispatcher("cfResult.jsp");

						
						request.setAttribute("Flug", "Changed!");
						rd.include(request, response);
				    } 
				}
			if(ID.isEmpty()||TicketPrice==0)
	    	{
				if(ID.isEmpty())
		    	{out.println("<font color=red>'ID' field is required!</font>");}
				if(TicketPrice==0)
				{out.println("<font color=red>'New Ticket Price' field is required!</font>");}
		    	  RequestDispatcher rd=request.getRequestDispatcher("ChangeTicketPrice.jsp");
		      	  rd.include(request, response);
		    }else if(noid == false)
			{
			out.print("<font color=red> 'ID' does not exist!</font>");
			 RequestDispatcher rd=request.getRequestDispatcher("ChangeTicketPrice.jsp");
	      	 rd.include(request, response);
			}
			
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
    	out.close();
}
}