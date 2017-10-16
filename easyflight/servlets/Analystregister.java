package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyflight.analyst.Analyst;
import easyflight.analyst.AnalystManagement;
import easyflight.customer.Customer;
import easyflight.customer.CustomerManagement;


@WebServlet("/Analystregister")
public class Analystregister extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		
		if(fname.contains(" ") || lname.contains(" ") || password2.contains(" "))
		{
			RequestDispatcher rd = request.getRequestDispatcher("analystregister.jsp");
			out.println("<font color=blue> <h2>Vorname, Nachname oder Passwort beinhalten ein Leerzeichen</h2></font>");
			rd.include(request, response);
			
		}
		else if(password1.equals("Analyst")){			
			AnalystManagement am = new AnalystManagement();
			int id = 0;
			if(am.getAnalystdao().getAnalystList().isEmpty()){
				Analyst a = new Analyst("b0",password2,fname,lname);
				am.addAnalyst(a);
			}else{
				for(int i = 0; i<am.getAnalystdao().getAnalystList().size(); i++){
					id++;
				}
				Analyst a = new Analyst("b"+id,password2,fname,lname);
				am.addAnalyst(a);
			}			
			RequestDispatcher rd = request.getRequestDispatcher("registered.jsp");
			out.println("<font color=blue> <h2>Ihre Id ist: b"+id+" <br></br>Bitte merken sie sich"
					+ " diese ID für den Login</h2></font>");
			rd.include(request, response);
					
			
			/*for(int i = 0; i<am.getAnalystdao().getAnalystList().size(); i++){
				out.print(am.getAnalystdao().getAnalystList().get(i).toString()+"<br></br>");
			}*/
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("analystregister.jsp");
			out.println("<font color=blue> <h2>Falsches Passwort für Analysten, bitte erneut eingeben</h2></font>");
			rd.include(request, response);
		}
	}
}
