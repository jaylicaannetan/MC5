package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import db.UserDBManager;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		UserDBManager udb = new UserDBManager();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cfmpassword = request.getParameter("cfmpassword");

		if(udb.checkUsername(username))
		{
			System.out.println("Username is already in use.");
			response.sendRedirect("Login.jsp");
		}
		
		else if(password.equals(cfmpassword))
		{
			System.out.println("Register SUCCESS");
			User u = new User(username, password);
			udb.createUser(u);
		}
		
		else
		{
			System.out.println("Password don't match!");
			response.sendRedirect("Login.jsp");
		}
	}
}
