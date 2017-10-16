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
import easyflight.fluggesellschaft.Fluggesellschaft;

/**
 * Servlet implementation class BuchungsServlet
 */
@WebServlet("/BuchungsServlet")
public class BuchungsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuchungsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }  
  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher rd=request.getRequestDispatcher("meinebuchungen.jsp");
    rd.include(request, response); 
    
    response.setContentType("text/html");  
     
     
    PrintWriter output = response.getWriter();
    Customer c = (Customer) request.getSession().getAttribute("currentSessionCustomer");
     
     BuchungsManagement bm = new BuchungsManagement();
     ArrayList<Buchung> blist = new ArrayList<Buchung>();
     FlugManagement fg = new FlugManagement();
     
     
     for(int i = 0; i< bm.getBuchungDAO().getBuchungList().size(); i++){
       if(bm.getBuchungDAO().getBuchungList().get(i).getCustomerId().equals(c.getId())){
         blist.add(bm.getBuchungDAO().getBuchungList().get(i));
       }
     }
     output.println("<br><br>");
        if (blist.size()==0) {
          output.println("<h1>Keine Buchungen gefunden! </h1>");
        }
        else {
          output.println("<form action=\"Buchungloeschen\" method=\"POST\">");
          for (int i=0;i<blist.size();i++) {
        output.println("<table><thead><tr><th>BuchungsID</th><th>Ihre ID</th><th>FlugID</th><th>StartAirport</th><th>Destination</th><th>Starttime</th><th>Preis</th>" );
        try {
          output.println("<tr><td>"+blist.get(i).getID() +"</td>"+"<td>"+blist.get(i).getCustomerId()+"</td>"+"<td>"+blist.get(i).getFlightId()+"</td>"+"<td>"+fg.getFlugbyId(blist.get(i).getFlightId()).getStartAirport()+"</td>"+"<td>"+fg.getFlugbyId(blist.get(i).getFlightId()).getDestination()+"</td>"+"<td>"+fg.getFlugbyId(blist.get(i).getFlightId()).getStartTime()+"</td>"+"<td>"+blist.get(i).getPreis()+"</td>");
        } catch (ClassNotFoundException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
          //String flugid=fluglist.get(i).getId();
          //request.getSession().setAttribute("Flugliste", fluglist);
            output.println("<td><input type=\"submit\" value=\"Buchung "+blist.get(i).getID()+" Löschen!\" name=\""+blist.get(i).getID()+"\"></td>");
            
          request.getSession().setAttribute("blist", blist);
          }
          output.println("</tr>");
          }
          output.println("</form>");
        
        
        output.println("</body></html>");
     
     
     
  }

}