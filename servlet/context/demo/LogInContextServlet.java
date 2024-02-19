package servlet.context.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

/**
 * Servlet implementation class LogInContextServlet
 */
@WebServlet("/loginContext")
public class LogInContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInContextServlet() {
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
		ServletConfig config = getServletConfig();
		ServletContext ctx = config.getServletContext();
		String driver_name = ctx.getInitParameter("driver");
		String url = ctx.getInitParameter("url");
		String user = ctx.getInitParameter("user-name");
		String password = ctx.getInitParameter("user-password");
		
		try {
			String un = request.getParameter("t1");
			String pw = request.getParameter("t2");
			Class.forName(driver_name);
			Connection con = DriverManager.getConnection(url,user,password);
			out.println("connected with DB");
			PreparedStatement ps = con.prepareStatement("select user_email, user_password from UserInfo where user_email=? and user_password=?");
			ps.setString(1, un);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String user_name = rs.getString(1);
				String user_password = rs.getString(2);
				ArrayList<String> a1 = new ArrayList();
				a1.add(user_name);
				a1.add(user_password);
				ctx.setAttribute("user-info", a1);
				out.println("<h1><center><font color='green'>Hi " + user_name +"you have logged in successfully"+"</font></center></h1>");
			}
		}catch(Exception e) {
			out.println(e);
		}
	}

}
