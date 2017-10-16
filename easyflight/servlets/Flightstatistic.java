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
 * Servlet implementation class Flightstatistic
 */
@WebServlet("/Flightstatistic")
public class Flightstatistic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Flightstatistic() {
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
	    try {
	    	HttpSession session = request.getSession(true); 
	        session.setAttribute("currentSessionFm",m); 
	        response.sendRedirect("seeflightstatistics.jsp"); 
		} catch (Exception e) {		}
	    
	    RequestDispatcher rd=request.getRequestDispatcher("seeflightstatistics.jsp");
		    rd.include(request, response);
	    
	}

}
