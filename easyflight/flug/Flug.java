
package easyflight.flug;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Flug implements Serializable{ 
	private static final long serialVersionUID = 1L;
	private String Id;
	private String Datum;
	private int year;
	private String StartAirport;
	private String Destination;
	private String StartTime;
	private String ArrivalTime;
	private int Capacity;	
	private String StartCountry;
	private String DestinationCountry;
	private double TicketPrice;
	private int ReservedSeats;
	private double Miles;
	private String AddInfo;
	private String airline;
	

	/**
	 * Konstruktor von class Flug
	 * @param Id
	 * @param StartAirport
	 * @param Destination
	 * @param StartTime
	 * @param ArrivalTime
	 * @param Capacity
	 * @param StartCountry
	 * @param DestinationCountry
	 * @param TicketPrice
	 * @param ReservedSeats
	 * @param AddInfo
	 * @param airline
	 */
	public Flug(String Id, String StartCountry, String DestinationCountry, String StartAirport, String Destination, String Datum, String StartTime,
			String ArrivalTime, int Capacity,  int ReservedSeats, double Miles,  double TicketPrice, String AddInfo, String airline)
	{
	setId(Id); setStartAirport(StartAirport); setDestination(Destination);
	setStartTime(StartTime); setArrivalTime(ArrivalTime); setCapacity(Capacity);
	setStartCountry(StartCountry); setDestinationCountry(DestinationCountry);
	setDatum(Datum);setTicketPrice(TicketPrice); setReservedSeats(ReservedSeats); 
	setAddInfo(AddInfo); setMiles(Miles);
	this.airline = airline;
	}
	
	/**
	 * @return Id;
	 */
	public String getId() {
		return Id;
	}
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		Id = id;
	}
	
	/**
	 * @return StartAirport;
	 */
	public String getStartAirport() {
		return StartAirport;
	}
	
	/**
	 * @param startAirport
	 */
	public void setStartAirport(String startAirport) {
		StartAirport = startAirport;
	}
	
	/**
	 * @return Destination;
	 */
	public String getDestination() {
		return Destination;
	}
	
	/** 
	 * @param destination
	 */
	public void setDestination(String destination) {
		Destination = destination;
	}
	
	/**
	 * @return StartTime;
	 */
	public String getStartTime() {
		return StartTime;
	}
	
	/**
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	
	/**
	 * @return ArrivalTime;
	 */
	public String getArrivalTime() {
		return ArrivalTime;
	}
	
	/**
	 * @param arrivalTime
	 */
	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	
	/**
	 * @return Capacity;
	 */
	public int getCapacity() {
		return Capacity;
	}
	
	/**
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	
	/**
	 * @return StartCountry;
	 */
	public String getStartCountry() {
		return StartCountry;
	}
	
	/**
	 * @param startCountry
	 */
	public void setStartCountry(String startCountry) {
		StartCountry = startCountry;
	}
	
	/**
	 * @return DestinationCountry;
	 */
	public String getDestinationCountry() {
		return DestinationCountry;
	}
	
	/**
	 * @param destinationCountry
	 */
	public void setDestinationCountry(String destinationCountry) {
		DestinationCountry = destinationCountry;
	}
	
	/**
	 * @return TicketPrice;
	 */
	public double getTicketPrice() {
		return TicketPrice;
	}
	
	/**
	 * @param ticketPrice
	 */
	public void setTicketPrice(double ticketPrice) {
		TicketPrice = ticketPrice;
	}
	
	/**
	 * @return ReservedSeats;
	 */
	public int getReservedSeats() {
		return ReservedSeats;
	}
	
	/**
	 * @param reservedSeats
	 */
	public void setReservedSeats(int reservedSeats) {
		ReservedSeats = reservedSeats;
	}
	
	/**
	 * @return AddInfo;
	 */
	public String getAddInfo() {
		return AddInfo;
	}
	
	/**
	 * @param addInfo
	 */
	
	public void setAddInfo(String addInfo) {
		AddInfo = addInfo;
	}
	
	
	/**
	 * @return year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @param Datum
	 * @throws IllegalArgumentException - wenn datum groesser als heutige Datum ist; 
	 */
	public Calendar getCalendar(String Datum) {
       	String[] parts = Datum.split("-");
       	Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));    		
        // SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Calendar cal = java.util.Calendar.getInstance();
           int jahr = calendar.get(Calendar.YEAR);
           //String s =calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-"+calendar.get(Calendar.DAY_OF_MONTH);
           setYear(jahr);
           return cal;
       }
	
	/**
	 * @return Datum;
	 */
	public String getDatum() {
		return Datum;
	}

	/**
	 * @param datum
	 */
	public void setDatum(String datum) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
	    int HDatum = cal.get(java.util.Calendar.YEAR);
	    getCalendar(datum);
	    if(getYear() > HDatum)
	    {
	    	throw new IllegalArgumentException("Datum ist groesser als heutige Datum!");
	    }
	    else this.Datum = datum;
	}

	/**
	 * @return Miles;
	 */
	public double getMiles() {
		return Miles;
	}

	/**
	 * @param miles
	 */
	public void setMiles(double miles) {
		Miles = miles;
	}
	
	/**
	 * return airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * @param airline
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	public String toString()
	{
	return "Id: " + getId() + "\n" + "Start Country: " + getStartCountry() + "\n" + "Destination Country: " + getDestinationCountry() + "Start Airport: " + 
	getStartAirport() + "\n" +	"Destination Airport: " + getDestination() + "\n" + "Start Time: " + getStartTime() + "\n" + 
	"Arrival Time: " + getArrivalTime() + "\n" + "Date: " + getDatum() + "Ticket Price: " + getTicketPrice() + "\n"+ "Capacity: " + getCapacity() + "\n" +
	"Reserved Seats: " + getReservedSeats() +  "\n"	+ "Miles: " + getMiles() + "\n" +
	"Additional Information: " + getAddInfo()  + "\n";
	}
	
}