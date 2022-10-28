package webproject5;

import java.awt.Checkbox;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JCheckBox;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("mail");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		String rpass = request.getParameter("rpass");
		String cond = request.getParameter("condition");
		
		ServletContext con = getServletContext();
		con.setAttribute("uname", username);
		con.setAttribute("pass", password);
		con.setAttribute("mail", email);
		
//		con.getInitParameter(username);
//		con.getInitParameter(password);
//		
		
		
		if(cond!=null) {
		if(password.equals(rpass) && cond.equals("checked"))
		{
			out.print("Welcome to on board....");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else
		{
			out.print("please check password and accept condition....");
			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
			rd.include(request, response);
		}
		}
		else {
			out.print("You have not accept terms and condition.....");
		}
		
	}

}
