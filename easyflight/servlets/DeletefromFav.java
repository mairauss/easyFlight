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
import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class DeletefromFav
 */
@WebServlet("/DeletefromFav")
public class DeletefromFav extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletefromFav() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
	    response.setContentType("text/html");  
	    CustomerManagement cm=new CustomerManagement ();
	     HttpSession session=request.getSession(true);
	     Customer c = (Customer) request.getSession().getAttribute("currentSessionCustomer");
	     Customer help=cm.getCustomerbyId(c.getId());
	     String delid="";
	     for (int i=0;i<help.getFav().size();i++) {
	    	 if (request.getParameter(help.getFav().get(i).getId())!=null) {
	    		 delid=request.getParameter(help.getFav().get(i).getId());
	    	 }
	     }
	     
	     String[] adelid=delid.split("\\s+");
	     help.deletefromFav(adelid[1]);
	     try {
		     cm.deletebyId(help.getId());
		     cm.addCustomer(help);
	     } catch (Exception e) {}
	     
	     RequestDispatcher rd = request.getRequestDispatcher("ShowFav");
	     rd.forward(request, response);
	     
	     
	}

}
