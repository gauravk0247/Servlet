package servlet.config.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankServer1
 */
//@WebServlet("/BankServer1")
public class BankServer1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServer1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		// Getting the object of the servlerConfig
		ServletConfig config = getServletConfig();
		String servletName = config.getServletName();
		ServletContext context = config.getServletContext();
		writer.println(servletName);
		
		String value = config.getInitParameter("security_code");
		if(value.equals("SBI0868") && servletName.equalsIgnoreCase("First")) {
			writer.println("<h1><font color='purple'>Your are Authorized Banker</h1>");
			RequestDispatcher rd =request.getRequestDispatcher("server2");
			rd.include(request, response);
		}else {
			response.sendRedirect("error.html");
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
