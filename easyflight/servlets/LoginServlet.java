package easyflight.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;

import easyflight.analyst.Analyst;
import easyflight.analyst.AnalystManagement;
import easyflight.customer.Customer;
import easyflight.customer.CustomerManagement;
import easyflight.fluggesellschaft.FGesellschaftManagement;
import easyflight.fluggesellschaft.Fluggesellschaft;  

/**
 * @author Team2
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String id=request.getParameter("id");  
	    String p=request.getParameter("psw");  
	   
	    switch(id.substring(0, 1)){
	    case "a":
	    	CustomerManagement cm = new CustomerManagement(); 
		    boolean match = false;
		    Customer c = null;
		    for(int i = 0; i< cm.getCustomerList().size(); i++){
		    	if(id.equals(cm.getCustomerList().get(i).getId()) && p.equals(cm.getCustomerList().get(i).getPassword())){
		    		match = true;
		    		c = cm.getCustomerList().get(i);
		    	}
		    }
		    if(match == true){  
		    	HttpSession session = request.getSession(true); 
		        session.setAttribute("currentSessionCustomer",c); 
		        response.sendRedirect("indexcustomer.jsp"); //logged-in page 
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		        rd.include(request,response);  
		    }  
	    	break;
	    case "b":
	    	AnalystManagement am = new AnalystManagement(); 
		    boolean match1 = false;
		    Analyst a = null;
		    for(int i = 0; i < am.getAnalystdao().getAnalystList().size(); i++){
		    	if(id.equals(am.getAnalystdao().getAnalystList().get(i).getId()) && p.equals(am.getAnalystdao().getAnalystList().get(i).getPassword())){
		    		match1 = true;
		    		a = am.getAnalystdao().getAnalystList().get(i);
		    	}
		    }
		    if(match1 == true){  
		    	HttpSession session = request.getSession(true); 
		        session.setAttribute("currentSessionAnalyst",a); 
		        response.sendRedirect("indexanalyst.jsp"); //logged-in page  
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		        rd.include(request,response);  
		    }  
	    	
	    	break;
	    case "c":
	    	FGesellschaftManagement fgm = new FGesellschaftManagement();
			Fluggesellschaft fg = null;
			 boolean match11 = false;
			  for(int i = 0; i < fgm.listGesellschaften().size(); i++){
			    	if(id.equals(fgm.listGesellschaften().get(i).getId()) && p.equals(fgm.listGesellschaften().get(i).getPassword())){
			    		match11 = true;
			    		fg = fgm.listGesellschaften().get(i);
			    	}
			    }
			    if(match11 == true){  				        
			        HttpSession session = request.getSession(true); 
			        session.setAttribute("currentSessionFG",fg); 
			        response.sendRedirect("indexFG.jsp"); //logged-in page 
			    }  
			    else{  
			        out.print("Sorry Id oder Passwort falsch");  
			        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			        rd.include(request,response);  
			    } 
		   
	    	break;
	    	default:
	    		 out.print("Sorry Id oder Passwort falsch");  
			        RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			        rd.include(request,response);
			        break;
	    }
	    
	    
	          
	    out.close();  
	    }  
}

