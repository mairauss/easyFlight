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

import easyflight.buchung.Buchung;
import easyflight.buchung.BuchungsManagement;
import easyflight.customer.Customer;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class meineMeilen
 */
@WebServlet("/meineMeilen")
public class meineMeilen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public meineMeilen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd=request.getRequestDispatcher("meineMeilen.jsp");
        rd.include(request, response); 
        
        response.setContentType("text/html");  
         
         
        PrintWriter output = response.getWriter();
        Customer c = (Customer) request.getSession().getAttribute("currentSessionCustomer");
         
         BuchungsManagement bm = new BuchungsManagement();
         ArrayList<Buchung> blist = new ArrayList<Buchung>();
         FlugManagement fg = new FlugManagement();
         output.println("<center><h1>Ihre derzeitigen Meilen betragen: </h1>");
         output.println("<h2>"+c.getmiles()+"</h2> </center>");
         
         
         
         
      }
}
