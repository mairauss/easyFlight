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

import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;
import easyflight.analyst.Analyst;
import easyflight.buchung.*;
import easyflight.customer.Customer;


@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet{
  
  int buchungID = 0;
  
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
    response.setContentType("text/html");
    //PrintWriter out=response.getWriter();
    HttpSession session=request.getSession(true);  
    String fid ="";
    PrintWriter output = response.getWriter();
    
    
    BuchungsManagement bm=new BuchungsManagement();
    Customer c = (Customer) request.getSession().getAttribute("currentSessionCustomer");
    FlugManagement fm=new FlugManagement();
    ArrayList<Flug> fluglist = (ArrayList<Flug>) request.getSession().getAttribute("fluglist");
    
    int id=1;
      for(int i = 0; i< fluglist.size(); i++){
        if (request.getParameter(fluglist.get(i).getId()) != null) {
            fid = request.getParameter(fluglist.get(i).getId());
          }
      }
    String fids[] = fid.split("\\s+");
    Buchung b = null;
    double meilen = 0;
    if(bm.getBuchungDAO().getBuchungList().isEmpty()){
       try {
		b =new Buchung(id, c.getId(), fids[1], fm.getFlugbyId(fids[1]).getTicketPrice());
		meilen = fm.getFlugbyId(fids[1]).getMiles();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }else{
      for(int i = 0; i<bm.getBuchungDAO().getBuchungList().size(); i++){
        id++;
      }
       try {
		b =new Buchung(id, c.getId(), fids[1], fm.getFlugbyId(fids[1]).getTicketPrice());
		meilen = fm.getFlugbyId(fids[1]).getMiles();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }      
    
    
    try {
    //  for(int i=0; i<fm.getFlugList().size();i++){
        if(fm.getFlugbyId(fids[1]).getReservedSeats()<fm.getFlugbyId(fids[1]).getCapacity()){
          bm.addBuchung(b);
          int seats = fm.getFlugbyId(fids[1]).getReservedSeats();
          seats = seats+1;
          Flug f = fm.getFlugbyId(fids[1]);
          f.setReservedSeats(seats);
          fm.getFlugDAO().deleteFlug(f);
          fm.addFlug(f);
           
	        session.setAttribute("buchung",b); 
	        session.setAttribute("fmeilen", meilen); 
	        RequestDispatcher rd=request.getRequestDispatcher("miles.jsp");  
	        rd.include(request,response);
        }else{ 
          session.setAttribute("plaetzefrei", "nein");
          request.getRequestDispatcher("indexcustomer.jsp").include(request,response);
        }
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