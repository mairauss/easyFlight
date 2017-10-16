package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
import easyflight.customer.CustomerManagement;
import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;

/**
 * Servlet implementation class Miles
 */
@WebServlet("/Miles")
public class Miles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Miles() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");
        //PrintWriter out=response.getWriter();
        HttpSession session=request.getSession(true);  
        PrintWriter output = response.getWriter();
        
        
       Buchung b = (Buchung) session.getAttribute("buchung");
       CustomerManagement cm = new CustomerManagement();
       BuchungsManagement bm = new BuchungsManagement();
       double fmiles = (double) session.getAttribute("fmeilen");
       System.out.println(fmiles);
       Customer c = (Customer) session.getAttribute("currentSessionCustomer");
        double miles =0;
        if((request.getParameter("Miles")).isEmpty()){
        	
        }else{
        	 miles = Double.parseDouble(request.getParameter("Miles"));
        }
        System.out.println(miles);
        Customer x = c;
        if(c.getmiles()<0)c.setmiles(0);
        if(miles > c.getmiles()){
        	output.println("<h1>Sie haben nicht so viele Meilen</h1>");
        	request.getRequestDispatcher("miles.jsp").include(request,response);
        }else{
        	
        	x.setmiles(c.getmiles()-miles);     
        	System.out.println(x.getmiles());
        	
        }
        x.setmiles(x.getmiles()+fmiles);
        try {
			cm.deletebyId(c.getId());
			cm.addCustomer(x);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       double preis = b.getPreis()-0.01*miles;
       if(preis <0)preis =0;
       bm.deleteBuchung(b);
       b.setPreis(preis);
       bm.addBuchung(b);
       request.getRequestDispatcher("indexcustomer.jsp").include(request,response);
}
}
