package webproject5;

import java.awt.Checkbox;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
		String gender = request.getParameter("user_gender");
		String course = request.getParameter("user_course");
		String cond = request.getParameter("condition");
		
//		ServletContext con = getServletContext();
//		con.setAttribute("uname", username);
//		con.setAttribute("pass", password);
//		con.setAttribute("mail", email);
		
		if(cond!=null) {
			if(password.equals(rpass) && cond.equals("checked"))
			{
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root","Nvp@0710");
			PreparedStatement ps = con.prepareStatement("insert into Employees values(?,?,?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			ps.setString(6, rpass);
			ps.setString(7, gender);
			ps.setString(8, course);
			int i = ps.executeUpdate();
			
			if(i>0) {
				out.print("You are successfully registered....");
			}
			
		}catch(Exception e){
			
			System.out.println(e);
			
		}

		
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
