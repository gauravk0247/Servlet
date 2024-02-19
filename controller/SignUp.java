package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

//import model.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/userSignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		// Setting the content type with response object
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("fn");
		String dob = request.getParameter("dt");
		String address = request.getParameter("addr");
		String ph = request.getParameter("ph");
		String email = request.getParameter("email");
		String gender = request.getParameter("gen");
		// String[] getParameterValues(String parameter)
		// The above is the method of HttpServletRequest
		String[] quali = request.getParameterValues("ch1");
		String state = request.getParameter("st");
		String userType = request.getParameter("ut");
		
		writer.println(name+ " "+ dob+" "+ address+ " "+ ph+" "+email+" "+gender+" "+Arrays.toString(quali)+" "+state+" "+userType);
		
		// I want generate password by taking last 4 digit from phone number and 2 chars from Date Of Birth 
		String last4Digit = ph.substring(ph.length()-4);
		String first2Char = dob.substring(0,2);
		String password = last4Digit.concat(first2Char);
		writer.println("Your unique password is "+" "+password);
		
		String str = " ";
		for(String s:quali) {
			str=s+" "+str;
		}
//		writer.println(str);
		//construct the object of Usr Class
		User user = new User();
		user.setName(name);
		// Parsing stirng date into Localdate
		// static LocalDate 
		LocalDate db = LocalDate.parse(dob);
		user.setDob(db);
		user.setEmailId(email);
		user.setGender(gender);
		user.setAddress(address);
		user.setPassword(password);
		Long phone = Long.parseLong(ph);
		user.setPhone(phone);
		user.setQualification(str);
		user.setState(state);
		user.setUserType(userType);
		// I want to call the method od UserDao
		UserDao daoObj = new UserDao();
		User obj = daoObj.addUser(user);
		if(obj!=null) {
			writer.println("<script type='text/javascript'>alert('congratulations You have register successfully')</script>");
			writer.println("You can login by clicking the below link");
			writer.println("<a href='UserLogin.html'><input type='button' value='login'></a>");
		}
			else {
				response.sendRedirect("error.html");
			}
	}
}