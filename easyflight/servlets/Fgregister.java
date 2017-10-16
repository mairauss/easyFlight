package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyflight.customer.Customer;
import easyflight.customer.CustomerManagement;
import easyflight.fluggesellschaft.FGesellschaftManagement;
import easyflight.fluggesellschaft.Fluggesellschaft;

@WebServlet("/Fgregister")
public class Fgregister extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fgname");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		FGesellschaftManagement fgm = null;
		boolean namevergeben = false;
		fgm = new FGesellschaftManagement();
		for(int i = 0; i < fgm.listGesellschaften().size(); i++){
			if(name.equals(fgm.listGesellschaften().get(i).getName()))
				namevergeben = true;
		}
		
		if(name.isEmpty()|| name.contains(" ") || password2.contains(" ") || password1.isEmpty() || namevergeben == true)
		{
			RequestDispatcher rd = request.getRequestDispatcher("fgregister.jsp");
			out.println("<font color=blue> <h2>Name bereits vergeben, Name beinhaltet ein Leerzeichen oder Passwort beinhaltet ein Leerzeichen</h2></font>");
			rd.include(request, response);
			
		}else if(password1.equals("Fluggesellschaft")){
			try {
				
				int id = 0;
				if(fgm.listGesellschaften().isEmpty()){
					Fluggesellschaft fg = new Fluggesellschaft("c0",password2,name);
					fgm.addGesellschaft(fg);
				}else{
					for(int i = 0; i<fgm.listGesellschaften().size(); i++){
						id++;
					}
					Fluggesellschaft fg = new Fluggesellschaft("c"+id,password2,name);
					fgm.addGesellschaft(fg);
				}
			
								
				RequestDispatcher rd = request.getRequestDispatcher("registeredFG.jsp");
				out.println("<font color=blue> <h2>Ihre Id ist: c"+id+" <br></br>Bitte merken sie sich"
						+ " diese ID fuer den Login</h2></font>");
				rd.include(request, response);
				
				/*for(int i = 0; i<fgm.listGesellschaften().size(); i++){
					out.print(fgm.listGesellschaften().get(i).toString()+"<br></br>");
				}*/
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("fgregister.jsp");
			out.println("<font color=blue> <h2>Falsches Passwort für Fluggesellschaften, bitte erneut eingeben</h2></font>");
			rd.include(request, response);
		}
	}
}
