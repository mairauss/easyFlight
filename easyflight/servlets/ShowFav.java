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

import easyflight.customer.Customer;
import easyflight.customer.CustomerManagement;
import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class ShowFav
 */
@WebServlet("/ShowFav")
public class ShowFav extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFav() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("myfavourites.jsp");
	    rd.include(request, response); 
	    
	    response.setContentType("text/html");  
	     
	     
	    PrintWriter output = response.getWriter();
	    Customer r = (Customer) request.getSession().getAttribute("currentSessionCustomer");
	     
	     ArrayList<Flug> flist = new ArrayList<Flug>();
	     FlugManagement fg = new FlugManagement();
	     CustomerManagement cm = new CustomerManagement ();
	     Customer c = cm.getCustomerbyId(r.getId());
	     
	    
	     
	     for(int i = 0; i< c.getFav().size(); i++){
	    	 try {
				if (fg.getFlugbyId(c.getFav().get(i).getId())!=null) {
					 flist.add(fg.getFlugbyId(c.getFav().get(i).getId()));
				 }
			} catch (Exception e) {		}
	     }
	     output.println("<br><br>");
	        if (flist.size()==0) {
	          output.println("<h1>Keine Favouriten gefunden! </h1>");
	        }
	        else {
	          output.println("<form action=\"DeletefromFav\" method=\"POST\">");
	          for (int i=0;i<flist.size();i++) {
	        output.println("<table><thead><tr><th>BuchungsID</th><th>Ihre ID</th><th>FlugID</th><th>StartAirport</th><th>Destination</th><th>Starttime</th>" );
	        try {
	          output.println("<tr><td>"+flist.get(i).getId() +"</td>"+"<td>"+c.getId()+"</td>"+"<td>"+flist.get(i).getId()+"</td>"+"<td>"+fg.getFlugbyId(flist.get(i).getId()).getStartAirport()+"</td>"+"<td>"+fg.getFlugbyId(flist.get(i).getId()).getDestination()+"</td>"+"<td>"+fg.getFlugbyId(flist.get(i).getId()).getStartTime()+"</td>");
	        } catch (ClassNotFoundException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        } catch (Exception e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	          //String flugid=fluglist.get(i).getId();
	          //request.getSession().setAttribute("Flugliste", fluglist);
	            output.println("<td><input type=\"submit\" value=\"Favourite "+flist.get(i).getId()+" Löschen!\" name=\""+flist.get(i).getId()+"\"></td>");
	            
	          request.getSession().setAttribute("flist", flist);
	          }
	          output.println("</tr>");
	          }
	          output.println("</form>");
	        
	        
	        output.println("</body></html>");
	}
	

}
