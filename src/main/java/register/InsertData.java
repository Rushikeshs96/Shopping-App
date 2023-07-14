package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Insertdata")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/shoppingdb";
			con = DriverManager.getConnection(jdbcUrl, "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String fname = request.getParameter("fn");
		String mname = request.getParameter("mn");
		String lname = request.getParameter("ln");
		String email = request.getParameter("email");
		String contact = request.getParameter("cno");

		PreparedStatement ps = null;
		
		
		try {
			ps = con.prepareStatement("insert into users values(?,?,?,?,?,?,?);");
			ps.setString(1, uid);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, lname);
			ps.setString(6, email);
			ps.setString(7, contact);

			int n = ps.executeUpdate();   //record pointer - zeroth record
			if(n>0)
			{
				out.print("SuccessFully Inserted");
				response.sendRedirect("/Shoppingapp/login.jsp");
			}
			else
			{
				out.print("Registration Failed");
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ps.close();
			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
	}
		
			

	
}
