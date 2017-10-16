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

import easyflight.buchung.Buchung;
import easyflight.buchung.BuchungsManagement;
import easyflight.customer.Customer;
import easyflight.customer.CustomerManagement;
import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class SavetoFav
 */
@WebServlet("/SavetoFav")
public class SavetoFav extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavetoFav() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		HttpSession session=request.getSession(true);  
		 Customer c = (Customer) request.getSession().getAttribute("currentSessionCustomer");
		 String favid = "";
		 FlugManagement fm=new FlugManagement();
		 CustomerManagement cm= new CustomerManagement ();
		 
		 try {
			for (int i=0;i<fm.getFlugList().size();i++) {
				 if (request.getParameter(fm.getFlugList().get(i).getId())!=null) {
					 favid=request.getParameter(fm.getFlugList().get(i).getId());
				 }
			 }
		
		} catch (Exception e) {e.printStackTrace();}
		 
		 String afavid [] = favid.split("\\s+");
		 Flug f=null;
		 try {
			f=fm.getFlugbyId(afavid[1]);
		 } catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("Flug leer");
		 }
		 		 
		 Customer testcust=cm.getCustomerbyId(c.getId());
		 testcust.addtoFav(f);
		 try {
			 cm.deletebyId(c.getId());
			 cm.addCustomer(testcust);
		 } catch (Exception e) {System.out.println("delete oder add nicht funktionert");}
		 
		request.getRequestDispatcher("indexcustomer.jsp").include(request, response);; 
		 
		 
	}

}
