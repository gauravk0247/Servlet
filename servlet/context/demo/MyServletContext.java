package servlet.context.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServletContext
 */
@WebServlet("/contextCall")
public class MyServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		ServletContext ctx = getServletContext();
//		out.println(ctx.getServerInfo());
//		out.println(ctx.getServletContextName());
//		out.println(ctx.getSessionTimeout());
//		Enumeration<Servlet> en = ctx.getServlets();
//		while(en.hasMoreElements()) {
//			Servlet ser = en.nextElement();
//			String servletInfo = ser.getServletInfo();
//			out.println(servletInfo);
//		}
		
		ServletConfig config = getServletConfig();
		ServletContext ctx = config.getServletContext();
		String driver_name = ctx.getInitParameter("driver");
		String url = ctx.getInitParameter("url");
		String user = ctx.getInitParameter("user-name");
		String password = ctx.getInitParameter("user-password");
		
		try {
			Class.forName(driver_name);
			Connection con = DriverManager.getConnection(url,user,password);
			out.println("connected with DB");
		}catch(Exception e) {
			out.println(e);
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
