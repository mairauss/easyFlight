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

import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class SearchServletforRegistered
 */
@WebServlet("/SearchServletforRegistered")
public class SearchServletforRegistered extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServletforRegistered() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter output = response.getWriter();
    
    
    RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
    rd.include(request, response);
    
      response.setContentType("text/html");  
      ArrayList<Flug> fluglist;
      String startland=request.getParameter("start");
      String zielland=request.getParameter("ziel");
      String flugdatum=request.getParameter("date");
      FlugManagement f1 = new FlugManagement();    
      fluglist=f1.getFlugbyDestination(startland, zielland, flugdatum);
      output.println("<br><br>");
      if (fluglist.size()==0) {
        output.println("<h1>Keine Flüge gefunden! </h1>");
      }
      else {
        for (int i=0;i<fluglist.size();i++) {
      output.println("<form action=\"SavetoFav\" method=\"POST\">");
      output.println("<table><thead><tr><th>FlugID</th><th>StartAirport</th><th>Destination</th><th>Starttime</th><th>ArrivalTime</th><th>Ticketprice</th><th>FreeSeats</th> <th>Additional Info</th>  " );
      output.println("<tr><td>"+fluglist.get(i).getId() +"</td>"+"<td>"+fluglist.get(i).getStartAirport()+"</td>"+"<td>"+fluglist.get(i).getDestination()+"</td>"+"<td>"+fluglist.get(i).getStartTime()+"</td>"+"<td>"+fluglist.get(i).getArrivalTime()+"</td>"+"<td>"+fluglist.get(i).getTicketPrice()+"</td>"+"<td>"+(fluglist.get(i).getCapacity()-fluglist.get(i).getReservedSeats())+"</td>"+"<td>"+(fluglist.get(i).getAddInfo())+"</td>");
      output.println("<td><input type=\"submit\" value=\"Flug "+fluglist.get(i).getId()+" speichern!\" name=\""+fluglist.get(i).getId()+"\"></td>");
      output.println("</form>");
      if (fluglist.get(i).getCapacity()-fluglist.get(i).getReservedSeats()==0) output.println("<td>Flug voll!</td>"); 
      else {
          output.println("<form action=\"ReserveServlet\" method=\"POST\">");
          
          output.println("<td><input type=\"submit\" value=\"Flug "+fluglist.get(i).getId()+" Buchen!\" name=\""+fluglist.get(i).getId()+"\"></td>");
          
          output.println("</form>");
        request.getSession().setAttribute("fluglist", fluglist);
      }
        output.println("</tr>");
        }
        
      }
      
      output.println("</body></html>");
  }

}