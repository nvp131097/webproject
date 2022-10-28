package webproject5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		
		String firstname1 = request.getParameter("fname1");
		String lastname1 = request.getParameter("lname1");
		String email1 = request.getParameter("mail1");
		String username1 = request.getParameter("uname1");
		String password1 = request.getParameter("pass1");

		ServletContext con = getServletContext();
		String s1 = (String) con.getAttribute("uname");
		String s2 = (String) con.getAttribute("pass");
		String s3 = (String) con.getAttribute("mail");
		
		HttpSession session = request.getSession();
		
		
		
		if(email1.equals(s3)) {
		if(password1.equals(s2) && username1.equals(s1))
		{
			session.setAttribute("uname", username1);
			
			Cookie ck=new Cookie("name", firstname1);
			response.addCookie(ck);
			
			response.sendRedirect("ProfileServlet");
		}
		else
		{
			out.println("Please enter correct Username and password.....");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			//response.sendRedirect("login.jsp");
		}
		}
		else
		{
			out.println("Please enter correct email address....");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		
		
	}
}
