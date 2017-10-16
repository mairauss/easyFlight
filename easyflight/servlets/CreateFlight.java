package easyflight.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easyflight.flug.Flug;
import easyflight.flug.FlugManagement;
import easyflight.fluggesellschaft.Fluggesellschaft;


/**
 * Servlet implementation class CreateFlight
 */
@WebServlet("/CreateFlight")
public class CreateFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	/**
     * Konstruktor von servlet CreateFlight
     */
    public CreateFlight() {
        super();
    }

    /**
     * Die Fluggesellschaft kann die Fluege erstellen
     * Wenn ein Wert fehlt und ID schon vergeben ist,
     * dann erhlt FG eine Fehlermeldung "'WERT' field is required!"
     * oder "Id is already taken!"
     * Bei erfolgreicher aenderung, wird ein Flug erstellt
     * 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html;charset=utf-8");
    FlugManagement fm = new FlugManagement();
		
    String ID = request.getParameter("ID");
    String StartCountry = request.getParameter("StartCountry");
    String DestinationCountry = request.getParameter("DestinationCountry");
    String StartAirport = request.getParameter("StartAirport");
    String DestinationAirport = request.getParameter("DestinationAirport");
    String Date = request.getParameter("date");
    String StartTime = request.getParameter("StartTime");
    String ArrivalTime = request.getParameter("ArrivalTime");
    int Capacity = 0;
    if(!request.getParameter("Capacity").isEmpty())
    {
    Capacity = Integer.parseInt(request.getParameter("Capacity"));
    }
    int ReservedSeats = 0;
    if(!request.getParameter("ReservedSeats").isEmpty())
    {
    ReservedSeats = Integer.parseInt(request.getParameter("ReservedSeats"));
    }
    double Miles = 0;
    if(!request.getParameter("Miles").isEmpty())
    {
    Miles = Double.parseDouble(request.getParameter("Miles"));
    }
    double TicketPrice = 0;
    if(!request.getParameter("TicketPrice").isEmpty())
    {
    	TicketPrice = Double.parseDouble(request.getParameter("TicketPrice"));
    }
    String AddInfo = request.getParameter("AddInfo");
    Fluggesellschaft fg = (Fluggesellschaft) request.getSession().getAttribute("currentSessionFG");
    String airline = fg.getName();  
    String[] gefaerlich={"Sudan","Pakistan","Syria","Syrien","Iraq","Irak","Sudan","Bangladesh","Bangladesch","Kenia","Kenya",
    		"Somalia","Venezuela","Turkey","Tuerkei","Ukraine","Yemen","Jemen","Lebanon","Libanon","North Korea","Nord Korea","Afghanistan","Congo","Kongo"};
    
    
    PrintWriter out = response.getWriter();
    boolean check=true;
    if(ID.isEmpty() || ID.contains(" ") ||StartCountry.isEmpty() || StartCountry.contains(" ")||DestinationCountry.isEmpty() || DestinationCountry.contains(" ")
    		||StartAirport.isEmpty()|| StartAirport.contains(" ") || DestinationAirport.contains(" ") || Date.contains(" ") || StartTime.contains(" ")
    		|| ArrivalTime.contains(" ")
    		||DestinationAirport.isEmpty()||Date.isEmpty()||StartTime.isEmpty()||ArrivalTime.isEmpty()
    		||Capacity==0||ReservedSeats==0||Miles==0||TicketPrice==0||airline.isEmpty())
      {     	 
     	 
    	if(ID.isEmpty())
    	{out.println("<font color=red>'ID' field is required!</font>");}
    	if(StartCountry.isEmpty())
    	{out.println("<font color=red>'Start Country' field is required! </font>");}
    	if(DestinationCountry.isEmpty())
    	{out.println("<font color=red>'Destination Country' field is required! </font>");}
    	if(StartAirport.isEmpty())
    	{out.println("<font color=red>'Start Airport' field is required! </font>");}
    	if(DestinationAirport.isEmpty())
    	{out.println("<font color=red>'Destination Airport' field is required! </font>");}
    	if(Date.isEmpty())
    	{out.println("<font color=red>'Date' field is required! </font>");}
    	if(StartTime.isEmpty())
    	{out.println("<font color=red>'Start Time' field is required! </font>");}
    	if(ArrivalTime.isEmpty())
    	{out.println("<font color=red>'Arrival Time' field is required!</font>");}
    	if(Capacity==0)
    	{out.println("<font color=red>'Capacity' field is required! </font>");}
    	if(ReservedSeats==0)
    	{out.println("<font color=red>'Reserved Seats' field is required!</font>");}
    	if(Miles==0)
    	{out.println("<font color=red>'Miles' field is required!</font>");}
    	if(TicketPrice==0)
    	{out.println("<font color=red>'Ticket Price' field is required!</font>");}
    	out.println("<font color=red> Some of your Data contains whitespaces !</font>");
        check=false;
    	RequestDispatcher rd=request.getRequestDispatcher("CreateFlight.jsp");
     	 rd.include(request, response);
      }

    
 
    
    else if(ReservedSeats>Capacity)
    {
    	check=false;
    	out.println("<font color=red>'Reserved Seats' kann nicht mehr als 'Capacity' sein!</font>");
    	RequestDispatcher rd=request.getRequestDispatcher("CreateFlight.jsp");
    	rd.include(request, response);
    }
   
    else if(AddInfo.isEmpty() || AddInfo.startsWith(" "))
	{
    		if(Arrays.asList(gefaerlich).contains(DestinationCountry)){
    			
    			out.println("<font color=red>Additional Information ohne fuehrendes Leerrzeichen fuer das gefaehrliche Land hinzufuegen!</font>");    			
    			check=false;
    			RequestDispatcher rd=request.getRequestDispatcher("CreateFlight.jsp");
    	    	rd.include(request, response);
    	    	
    		}
    	
		AddInfo="-";
	}

    
    
    else
    {
    	try {
			for (int i = 0; i < fm.getFlugList().size(); i++) {
				if(ID.equals(fm.getFlugList().get(i).getId()))
				 {
					check=false;
					out.println("<font color=red>Id is already taken!</font>");
					RequestDispatcher rd=request.getRequestDispatcher("CreateFlight.jsp");
			     	 rd.include(request, response);
				 }
				}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }   
    
    if(check==true){
    Flug f = new Flug(ID, StartCountry, DestinationCountry, StartAirport, DestinationAirport, Date,
			StartTime, ArrivalTime, Capacity, ReservedSeats, Miles, TicketPrice, AddInfo, airline);
	try {
		fm.addFlug(f);
			 RequestDispatcher rd=request.getRequestDispatcher("cfResult.jsp");
			 request.setAttribute("Flug", "Created");
			    rd.include(request, response);		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
     out.close();
	}
}