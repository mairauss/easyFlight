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
import javax.servlet.http.HttpSession;

import easyflight.combi.Combi;
import easyflight.combi.CombiManagment;
import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

@WebServlet("/SeeCombi")
public class SeeCombi extends HttpServlet {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
		
		PrintWriter output = response.getWriter();
		
		
		RequestDispatcher rd=request.getRequestDispatcher("seecombi.jsp");
		rd.include(request, response);
		
		
	    response.setContentType("text/html");  
	    ArrayList<Combi> combilist;
	    CombiManagment cm = new CombiManagment();
	    combilist = cm.getCombiDAO().getCombiList();
	    output.println("<br><br>");
	    if (combilist.size()==0) {
	    	output.println("<h1>Keine Combis gefunden! </h1>");
	    }
	    else {
	    	
	    	for (int i=0;i<combilist.size();i++) {
	    	
			output.println("<table><thead><tr><th>Fluglinie&nbsp;&nbsp;&nbsp;&nbsp;</th><th>CombiID&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Link&nbsp;&nbsp;&nbsp;&nbsp;</th><th>Beschreibung&nbsp;&nbsp;&nbsp;&nbsp;</th>  " );
			output.println("<tr><td>"+combilist.get(i).getAirline() +"&nbsp;&nbsp;&nbsp;&nbsp;</td>"+"<td>"+combilist.get(i).getID()+"&nbsp;&nbsp;&nbsp;&nbsp;</td>"+"<td>"+combilist.get(i).getLink()+"&nbsp;&nbsp;&nbsp;&nbsp;</td>"+"<td>"+combilist.get(i).getBeschreibung()+"</td> <br> </br><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"http://"+combilist.get(i).getLink()+"\">Zum Link </a> </td>");
			output.println("</tr>");
			output.println(" ");
	    	}
	    	//output.println("</form>");
	    }
	    
	    output.println("</body></html>");
	    //RequestDispatcher rd2=request.getRequestDispatcher("ReserveServlet");
		//rd2.include(request, response);
	    
	    
	   // request.setAttribute("Flug", fluglist);
	    
		

	
	
	}  
}