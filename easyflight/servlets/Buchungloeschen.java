package easyflight.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easyflight.buchung.Buchung;
import easyflight.buchung.BuchungsManagement;
import easyflight.customer.Customer;
import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class Buchungloeschen
 */
@WebServlet("/Buchungloeschen")
public class Buchungloeschen extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buchungloeschen() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.setContentType("text/html");
    //PrintWriter out=response.getWriter();
    HttpSession session=request.getSession(true);  
    String bid ="";
    
    
    
    BuchungsManagement bm=new BuchungsManagement();
    Customer c = (Customer) request.getSession().getAttribute("currentSessionCustomer");
    FlugManagement fm=new FlugManagement();
    ArrayList<Buchung> blist = (ArrayList<Buchung>) request.getSession().getAttribute("blist");
    int id=1;
      for(int i = 0; i< blist.size(); i++){
        if (request.getParameter(Integer.toString(blist.get(i).getID())) != null) {
            bid = request.getParameter(Integer.toString(blist.get(i).getID()));
          }
      }
    String bids[] = bid.split("\\s+");
    Buchung b = bm.getBuchungDAO().getBuchungbyId(Integer.parseInt(bids[1]));
    /*if(bm.getBuchungDAO().getBuchungList().isEmpty()){
       b =new Buchung(id, c.getId(), fids[0]);
    }else{
      for(int i = 0; i<bm.getBuchungDAO().getBuchungList().size(); i++){
        id++;
      }
       b =new Buchung(id, c.getId(), fids[0]);
    }*/      
    
    
    try {
    //  for(int i=0; i<fm.getFlugList().size();i++){
          bm.deleteBuchung(b);
          int seats = fm.getFlugbyId(b.getFlightId()).getReservedSeats();
          seats = seats-1;          
          Flug f = fm.getFlugbyId(b.getFlightId());
          f.setReservedSeats(seats);
          fm.getFlugDAO().deleteFlug(f);
          fm.addFlug(f);
          response.sendRedirect("indexcustomer.jsp");
      //}
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }

}