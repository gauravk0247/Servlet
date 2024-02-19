package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RowCreator
 */
/*
 * In advance version of Servlet api introduced one technique by which web container can map a request from client
 * 
 * @WebServlet annotation reside in javax.servlet.annotation.WebServlet;
 *  @WebServlet is annotation which takes a value as a string
 *  
 *  The value inside @WebServlet should be a requested URL.
 *  This is class level annotation.
 */
@WebServlet("/rowmap")
public class RowCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RowCreator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter wr = response.getWriter();
		int rowcount = Integer.parseInt(request.getParameter("t1"));
		for(int i=0; i<rowcount; i++) {
			wr.println("<table border='2' height= '100' width= '100'><tr></tr></table>");
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
