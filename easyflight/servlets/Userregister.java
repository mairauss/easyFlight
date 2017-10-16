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


import easyflight.customer.Customer;
import easyflight.customer.CustomerManagement;

/**
 * @author Team2
 *
 */
@WebServlet(name="Userregister",urlPatterns={"/Userregister"})
public class Userregister extends HttpServlet {
	/**
	 * Konstruktor
	 */
	public Userregister() {
        super();
        // TODO Auto-generated constructor stub
        
       
        
    }
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gdatum = request.getParameter("gdatum");
		String ort = request.getParameter("ort");
		String password = request.getParameter("password");
		
		if(fname.isEmpty()||lname.isEmpty()||gdatum.isEmpty()||ort.isEmpty()||password.isEmpty() || fname.contains(" ") || lname.contains(" ") || gdatum.contains(" ") || ort.contains(" ") || password.contains(" ")) 
		{
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			out.println("<font color=blue> <h2>Eine oder mehrere Ihrer eingegeben Daten beinhalten ein Leerzeichen</h2></font>");
			rd.include(request, response);
			
		}
		else
		{
			try {
				CustomerManagement cm = new CustomerManagement();
				int id = 0;
				if(cm.getCustomerList().isEmpty()){
					Customer c = new Customer("a0",password,fname,lname,gdatum, ort);
					cm.addCustomer(c);
				}else{
					for(int i = 0; i<cm.getCustomerList().size(); i++){
						id++;
					}
					Customer c = new Customer("a"+id,password,fname,lname,gdatum, ort);
					cm.addCustomer(c);
				}
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("registered.jsp");
				out.println("<font color=blue> <h2>Ihre Id ist: a"+id+" <br></br>Bitte merken sie sich"
						+ " diese ID für den Login</h2></font>");
				rd.include(request, response);
				
				/*for(int i = 0; i<cm.getCustomerList().size(); i++){
					out.print(cm.getCustomerList().get(i).toString()+"<br></br>");
				}*/
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

