package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import dao.FlightDao;
import model.FlightClass;

/**
 * Servlet implementation class AddDBFlight
 */
@WebServlet("/addtoDB")
public class AddDBFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDBFlight() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String flightName = request.getParameter("t1");
		String flightDate = request.getParameter("t2");
		String flightSrc = request.getParameter("t3");
		String flightDest = request.getParameter("t4");
		String price = request.getParameter("t5");
		
		FlightClass flightObj = new FlightClass();
		flightObj.setFlightName(flightName);
		LocalDate ld = LocalDate.parse(flightDate);
		flightObj.setFlightDate(ld);
		flightObj.setFlightSrc(flightSrc);
		flightObj.setFlightDesc(flightDest);
		flightObj.setFlightPrice(Double.parseDouble(price));
		FlightDao dao = new FlightDao();
		FlightClass flight = dao.addFlight(flightObj);
		if(flight!=null)
		{
			out.println("<h1>Flight Added Successfully</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("viewFlight");
			rd.include(request, response);
			
		}else {
			out.println("<h1>Not able to add</h1>");
		}
	}
}