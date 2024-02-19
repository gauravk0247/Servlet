package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calc")
public class Calculator extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Now I want to fetch all values from HTML element
	//String getParameter(String name_of_parameter)
	//The above method is the method pf HttpServletRequest interface
	String num1=request.getParameter("t1");
	int n1=Integer.parseInt(num1);
	
	String num2=request.getParameter("t2");
	int n2=Integer.parseInt(num2);
	
	int result=0;
	PrintWriter pw=response.getWriter();
	
	String bt1val=request.getParameter("bt1");
	String bt2val=request.getParameter("bt2");
	String bt3val=request.getParameter("bt3");
	String bt4val=request.getParameter("bt4");

	response.setContentType("text/html");
	
	
	
		if(bt1val!=null && bt1val.equalsIgnoreCase("Add"))
	{
		result=n1+n2;
		pw.println("<h2><font color='green'>"+" "+"Addition is"+" "+result+" "+"</font></h2>");
	}else if(bt2val!=null && bt2val.equalsIgnoreCase("Multiply"))
	{
		result=n1*n2;
		pw.println("<h2><font color='green'>"+" "+"Multiplication is"+" "+result+" "+"</font></h2>");
	}else if(bt3val!=null && bt3val.equalsIgnoreCase("Div"))
	{
		result=n1/n2;
		pw.println("<h2><font color='green'>"+" "+"Division is"+" "+result+" "+"</font></h2>");
	}else if(bt4val!=null && bt4val.equalsIgnoreCase("Sub"))
	{
		result=n1-n2;
		pw.println("<h2><font color='green'>"+" "+"Addition is"+" "+result+" "+"</font></h2>");
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