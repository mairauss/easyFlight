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

import easyflight.flug.FlugManagement;
import easyflight.fluggesellschaft.Fluggesellschaft;

/**
 * Servlet implementation class CancelFlight
 */
@WebServlet("/CancelFlight")
public class CancelFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Konstruktor von servlet CancelFlight
     */
    public CancelFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Die Fluggesellschaft kann den Flug stornieren
     * Wenn ein Wert fehlt und ID schon vergeben ist,
     * dann erhlt FG eine Fehlermeldung "'WERT' field is required!"
     * oder "Id is already taken!"
     * Bei erfolgreicher aenderung, wechselt FG auf die Seite des Ergebnisses
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    String ID = request.getParameter("ID");
	    Fluggesellschaft fg = (Fluggesellschaft) request.getSession().getAttribute("currentSessionFG");
	    String airline = fg.getName();
	    PrintWriter out = response.getWriter();
	    FlugManagement fm = new FlugManagement();
	     	
			try {
				for(int i=0;i<fm.getFlugList().size();i++)
				{
					if(ID.equals(fm.getFlugList().get(i).getId()) && fm.getFlugList().get(i).getAirline().equals(airline))
					{
							try {
								fm.deletebyId(ID);
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							RequestDispatcher rd=request.getRequestDispatcher("cfResult.jsp");
							request.setAttribute("Flug", "Deleted");
							rd.include(request, response);
					    }  
					}
					
				    if(ID.isEmpty())
			    	{
				    	out.println("<font color=red>'ID' field is required!</font>");
				    	  RequestDispatcher rd=request.getRequestDispatcher("CancelFlight.jsp");
				      	  rd.include(request, response);
				    }
					
				    else
						{
						out.print("<font color=red> 'ID' does not exist!</font>");
						 RequestDispatcher rd=request.getRequestDispatcher("CancelFlight.jsp");
				      	 rd.include(request, response);
						}
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    		    
    	out.close();
	}
}
