package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PalindromeChecker
 */
@WebServlet("/PalindromeChecker")
public class PalindromeChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PalindromeChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * PrintWriter pw = response.getWriter();
		 * --> the above method is the method of HttpServletResponse
		 */
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<center><h2><font color='green'>Welcome to My Website</font></h2></center>");
		
		// I want to fetch name and number from user or from html element
		/*
		 * String getParameter(String paramName)
		 * ---> The above method is the method HttpServletRequest interface
		 */
		
		String name = request.getParameter("t1");
		String num = request.getParameter("t2");
		
		// Now I want to process with the data from Html
		
		// Converting String into Integer
		int n = Integer.parseInt(num);
		int rev = 0;
		int rem =0;
		int temp = n;
		
		while(n>0) {
			rem = n % 10;
			rev = (rev*10)+rem;
			n = n/10;
		}
		if(temp==rev) {
			pw.println("<center><font color='green'>"+" "+"congratulations!! "+ " "+name+ " "+ num);
		}
		else {
			/*
			 * void sendRedirect(String resource)
			 * ---> The above method is the method of HttpServletResponse interface
			 * ---> The method is used to send request to next resource, resource can 
			 * be HTML, JSP, Servlet, e.t.c
			 * 
			 * 
			 * ---> but incase of sendRedirect() method it delegates to client
			 * beacause we are invoking the above method using the object 
			 * HttpServletResponse
			 */
			response.sendRedirect("Error.html");
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
