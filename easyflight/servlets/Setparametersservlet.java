package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class Setparametersservlet
 */
@WebServlet("/Setparametersservlet")
public class Setparametersservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Setparametersservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		response.setContentType("text/html");  
		int auslastung;
		int verkleinert;
		boolean eingabe=false;
		int j = 0;
		try {
			auslastung=Integer.parseInt(request.getParameter("auslastung"));
			verkleinert=Integer.parseInt(request.getParameter("verkleinert"));
		} catch (Exception e) {auslastung=-2; verkleinert=-2;}
		
		if ((auslastung<0) || (auslastung >100) || (verkleinert<0) || (verkleinert>100)) {
			eingabe=true;
		}
		else {
			
			FlugManagement m = new FlugManagement ();
			
			try {
				j=m.setParameters(auslastung, verkleinert);
			} catch (Exception e) {	e.printStackTrace();}
			
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("setparametersresult.jsp");
		rd.include(request, response);
		if (eingabe==true) {
			output.println("<h3>Eingabe falsch!");
		}
		else {
			output.println("Es wurden "+j+" Fluege geändert");
		}
		
		output.println("	 </center>	<br></br><footer> <section id=\"copyright\"><div class=\"wrapper\">&copy; Copyright 2016 by Team easyFlight.All Rights Reserved.</div></section> </footer></body></html>");
		
	}

}
