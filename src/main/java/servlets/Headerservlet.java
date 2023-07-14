package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entities.*;

@WebServlet("/header")
public class Headerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		User u =(User)session.getAttribute("loggedinuser");
		if(u !=null)
		{
			out.print("<h1> Welcome "+u.getFname()+" "+u.getLname()+ "</h1>");
		}
		else
		{
			out.print("<h1> Welcome GUEST !!</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
