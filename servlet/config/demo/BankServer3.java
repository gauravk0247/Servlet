package servlet.config.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankServer3
 */
@WebServlet("/server3")
public class BankServer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static double bal;
    static{
    	bal = 10000.00;
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServer3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		double balance = Double.parseDouble(request.getParameter("t1"));
		bal = bal-balance;
		out.println("after transfer balance your current balance is "+" "+bal);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
