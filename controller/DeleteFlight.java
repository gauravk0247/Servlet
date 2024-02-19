package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FlightDao;

/**
 * Servlet implementation class DeleteFlight
 */
@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("fId");
		// converting into int
		int flight_id = Integer.parseInt(id);
		FlightDao dao = new FlightDao();
		int status = dao.deleteFlight(flight_id);
		if(status>0) {
			out.println("<script type='text/javascript'>alert('Flight Deleted Successfully')</script>");
			RequestDispatcher rd = request.getRequestDispatcher("viewFlight");
			rd.include(request, response);
		}else {
			out.println("<h1><font color='red'>Not able to delete</font></h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
