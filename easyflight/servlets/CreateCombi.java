package  easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import easyflight.combi.Combi;
import easyflight.combi.CombiManagment;
import easyflight.fluggesellschaft.Fluggesellschaft;
import easyflight.flug.*;

/**
 * Servlet implementation class CreateCombi
 */
@WebServlet("/CreateCombi")
public class CreateCombi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * Konstruktor von servlet CreateCombi
     */
    public CreateCombi() {
        super();
    }

    /**
     * Die Fluggesellschaft kann Combis erstellen
     * Wenn ein Wert fehlt und ID schon vergeben ist,
     * dann erhlt FG eine Fehlermeldung "'WERT' field is required!"
     * oder "Id is already taken!"
     * Bei erfolgreicher speichern, wechselt FG auf die Seite des Ergebnisses
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
    CombiManagment cm = new CombiManagment(); 
		
    int ID = 0;
    if(!request.getParameter("ID").isEmpty())
    {
    ID = Integer.parseInt(request.getParameter("ID"));
    }
    String Description = request.getParameter("Description");
    String Link = request.getParameter("Link"); 

    Fluggesellschaft fg = (Fluggesellschaft) request.getSession().getAttribute("currentSessionFG");

    PrintWriter out = response.getWriter();
    boolean check=true;
    
    if(ID==0 || Description.isEmpty() || Link.isEmpty() || Link.contains(" ") || Description.startsWith(" ") || Description.endsWith(" "))
      {     	 
      	if(ID==0)
    	{out.println("<font color=red>'ID' field is required!</font>");}
    	if(Description.isEmpty())
    	{out.println("<font color=red>'Description' field is required! </font>");}
    	if(Link.isEmpty())
    	{out.println("<font color=red>'Link' field is required! </font>");}
    	if(Link.contains(" "))
    	{out.println("<font color=red>'Link' contains whitespace! </font>");}
    	if(Description.startsWith(" ") || Description.endsWith(" "))
    	{out.println("<font color=red>'Description' starts or ends with whitspace! </font>");}

        check=false;
    	RequestDispatcher rd=request.getRequestDispatcher("CreateCombi.jsp");
     	 rd.include(request, response);
      }

    else
    {
    	try {
			for (int i = 0; i < cm.getCombiDAO().getCombiList().size(); i++) {
				if(ID==cm.getCombiDAO().getCombiList().get(i).getID())
				 {
					check=false;
					out.println("<font color=red>Id is already taken!</font>");
					RequestDispatcher rd=request.getRequestDispatcher("CreateCombi.jsp");
			     	 rd.include(request, response);
				 }
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }   
    
    if(check==true){
   Combi c = new Combi(ID, Description, Link, fg.getName());
	try {
		cm.addCombi(c);;
			 RequestDispatcher rd=request.getRequestDispatcher("cfResult.jsp");
			 request.setAttribute("Flug", "Created");
			    rd.include(request, response);		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
     out.close();
	}
}
