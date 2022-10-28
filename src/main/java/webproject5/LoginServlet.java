package webproject5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		 response.setHeader("Cache-Control", "no-cache");
		 response.setHeader("Cache-control", "no-store");
		 response.setHeader("Pragma", "no-cache");
		 response.setHeader("Expires","0");
		 response.setDateHeader("Expires",0);
		
		String firstname1 = request.getParameter("fname1");
		String lastname1 = request.getParameter("lname1");
		String email1 = request.getParameter("mail1");
		String username1 = request.getParameter("uname1");
		String password1 = request.getParameter("pass1");

//		ServletContext con = getServletContext();
//		String s1 = (String) con.getAttribute("uname");
//		String s2 = (String) con.getAttribute("pass");
//		String s3 = (String) con.getAttribute("mail");
		
		HttpSession session = request.getSession();
		if(email1 == null || email1.equals("")) {
			out.print("invalid email.....");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		if(password1 == null && username1 == null)
		{
			out.print("invalid username and password...");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root","Nvp@0710");
			PreparedStatement ps = con.prepareStatement("select * from Employees where Email=? and USER_NAME=? and password=?");
			
			ps.setString(1, email1);
			ps.setString(2, username1);
			ps.setString(3, password1);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{	
				session.setAttribute("uname", username1);
				
				Cookie ck=new Cookie("name", firstname1);
				response.addCookie(ck);
				
				response.sendRedirect("ProfileServlet");
				
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}
			catch(Exception e) {
				System.out.println(e);
			}
		
		
		
	
}
}
