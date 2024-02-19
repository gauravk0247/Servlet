package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightDao;
import model.FlightClass;

/**
 * Servlet implementation class ViewAllFlight
 */
@WebServlet("/viewFlight")
public class ViewAllFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><center><body bgcolor='green' color:'blue>");
		out.println("<table border='2'><thead>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Source</th>");
		out.println("<th>Destination</th>");
		out.println("<th>FlyDate</th>");
		out.println("<th>Price</th>");
		out.println("<th>EDIT</th>");
		out.println("<th>Delete</th>");
		// calling the getAllFlight() of FlightDao
		FlightDao dao = new FlightDao();
		Set<FlightClass> flights = dao.getAllFlight();
		for(FlightClass f:flights) {
			out.println("<tr><td>"+f.getFlightId()+"</td>");
			out.println("<td>"+f.getFlightName()+"</td>");
			out.println("<td>"+f.getFlightSrc()+"</td>");
			out.println("<td>"+f.getFlightDesc()+"</td>");
			out.println("<td>"+f.getFlightDate()+"</td>");
			out.println("<td>"+f.getFlightPrice()+"</td>");
			out.println("<td>"+"<a href='editFlight?fId="+f.getFlightId()+"'>"+"EDIT"+"</a></td>");
			out.println("<td>"+"<a href='deleteFlight?fId="+f.getFlightId()+"'>"+"DELETE"+"</a></td>");
			out.println("</tr>");
		}
		out.println("</table></body></center></html>");
	}

}
