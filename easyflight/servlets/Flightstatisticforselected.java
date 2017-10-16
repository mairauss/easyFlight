package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class Flightstatisticforselected
 */
@WebServlet("/Flightstatisticforselected")
public class Flightstatisticforselected extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flightstatisticforselected() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FlugManagement m=new FlugManagement();
		PrintWriter output = response.getWriter();	
	    response.setContentType("text/html"); 
	    
	    String flugid=request.getParameter("idstat");
	    RequestDispatcher rd = null;
	    try {
			if (m.seeFStatistics(flugid)!=null) {
				
			    	HttpSession session = request.getSession(true); 
			        session.setAttribute("currentSessionFm",m); 
			        session.setAttribute("flugid", flugid);
			        response.sendRedirect("seeflightstatisticsexplicit.jsp"); 
			        rd=request.getRequestDispatcher("seeflightstatistics.jsp");
				
			}
			else {
				rd=request.getRequestDispatcher("seestatistic.jsp");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			output.println("<h1>FlugID nicht vorhanden! </h1>");
			rd=request.getRequestDispatcher("seestatistic.jsp");
		}
	    	
	    	
	    	
	    
	    
	    
	   
		    rd.include(request, response);
	}

}
