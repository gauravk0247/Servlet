package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/adminTask")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
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
		String userName = (String)request.getAttribute("user-name-key");
		PrintWriter out = response.getWriter();
		out.println("<h2><font color='red'>Hello"+" "+userName+"</font></h2>");
		out.println("<html><head><title>My Flight Booking</title><style>body{color: white; font-size: 30px; display: flex; align-items: center;justify-content: center;} form{background-color: orangered; padding: 37px 23px; border-radius: 12px;} input{padding: 6px; margin: 9px;} select{padding: 7px}</style></head><center><body>");
		out.println("<form action='addtoDB' method='post'>");
		out.println("<label for='Enter Flight Name'>Enter Flight Name</label>");
		out.println("<input type='text' name='t1' size='10' pattern='[A-Za-z]+' required><br>");
		
		out.println("<label for='Enter Flight Date'>Enter Flight Date</label>");
		out.println("<input type='date' name='t2' required><br>");
		 
		out.println("<label for='Enter Flight Source'>Enter Flight Source</label>");
		out.println("<select name='t3'><option value='kol'>Kolkata</option>");
		out.println("<option value='pune'>Pune</option>");
		out.println("<option value='delhi'>Delihi</option>");
		out.println("<option value='chandigarh'>Chandigarh</option>");
		out.println("<option value='nashik'>Nashik</option>");
		out.println("<option value='chennai'>Chennai</option></select><br>");
		
		out.println("<label for='Enter Flight Destination'>Enter Flight Destination</label>");
		out.println("<select name='t4'><option value='kol'>Kolkata</option>");
		out.println("<option value='pune'>Pune</option>");
		out.println("<option value='delhi'>Delihi</option>");
		out.println("<option value='chandigarh'>Chandigarh</option>");
		out.println("<option value='nashik'>Nashik</option>");
		out.println("<option value='chennai'>Chennai</option></select><br>");
		
		out.println("<label for='Enter Flight Price'>Enter Flight Price</label>");
		out.println("<input type='text' name='t5' required><br>");
		out.println("<input type='submit' value='ADD FLIGHT'>");
		
		out.println("</form></body></center>");
		out.println("</html>");
	}
}