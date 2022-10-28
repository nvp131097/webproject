package webproject5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		Cookie ck = new Cookie("name", "");
		ck.setMaxAge(0);
		response.addCookie(ck);
	
		
        out.print("You are successfully Logged out.....");
		
		out.print("<br><a href='welcome.jsp'>Welcome!!!</a>");
		
		
	}

	

}
