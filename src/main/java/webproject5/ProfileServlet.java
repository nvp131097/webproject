package webproject5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		String uname = (String) session.getAttribute("uname");
		out.print("<h3>Welcome to Profile</h3>");
		out.print("<br>Username: "+uname);
		
		Cookie ck[] = request.getCookies();
		
		boolean f = false;
		String name="";
		
		if(ck == null)
		{
			out.print("Please login first....");
			return;
		}
		else
		{
			for(Cookie c : ck)
			{
				String tname = c.getName();
				if(tname.equals("name"))
				{
					f = true;
					name=c.getValue();
				}
			}
		}
		if(f) {
			out.print("<br>Hello "+name+" welcome to my page...");
		}
		
		
		
		
		
		
//		if(ck != null)
//		{
//			String name = ck[0].getValue();
//			if(!name.equals("") || name != null)
//			{
//				out.print("<br> Welcome "+name);
//			}
//		}
//		else
//		{
//			
//			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//			rd.include(request, response);
//		}
		
		
		
		out.print("<br><a href='welcome.jsp'>Welcome!!!!</a>");
		out.print("<br><a href='LogoutServlet'>Logout</a>");
		
		}
	}

	


