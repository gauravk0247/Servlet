package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet("/userLogin")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInServlet() {
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
		String emailId = request.getParameter("t1");
		String password = request.getParameter("t2");
		
		
		// Calling getLogin(String, String) of UserDao
		UserDao dao = new UserDao();
		User user = dao.getLogIn(emailId, password);
		if(user.getUserType().equalsIgnoreCase("admin"))
		{
			System.out.println("hello admin..");
			/*
			 * void setAttribute(String key, Object object)
			 * ---> The above method is the method of HttpServletRequest interface
			 * ---> The method is used to bind the object with the given key value as String
			 * ---->The Object which we have binded with request object will be available 
			 * for the current request once request scope will complete the associated object will be lost.
			 */
			request.setAttribute("user-name-key", user.getName());
			RequestDispatcher rd = request.getRequestDispatcher("adminPage");
			rd.forward(request, response);
			
			
		}else if(user.getUserType().equalsIgnoreCase("customer")){
			request.setAttribute("user-name-key", user.getName());
			RequestDispatcher rd = request.getRequestDispatcher("custTask");
			rd.forward(request, response);
			
		}
		else {
			out.println("<h2><font color='red'>you are invalid user</font></h2>");
		}
	}
}
