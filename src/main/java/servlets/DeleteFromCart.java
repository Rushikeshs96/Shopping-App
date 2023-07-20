package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteitem")
public class DeleteFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int spid = Integer.parseInt(request.getParameter("pid"));
		
		HttpSession session = request.getSession();
		List<Integer> products =(List<Integer>)session.getAttribute("cart");
		products.remove(spid);
		session.setAttribute("cart", products);
		
		response.sendRedirect("/Shoppingapp/viewcart");
 		
	}

}





