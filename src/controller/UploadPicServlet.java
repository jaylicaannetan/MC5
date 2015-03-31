package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.PicDBManager;

/**
 * Servlet implementation class UploadPicServlet
 */
@WebServlet("/UploadPicServlet")
public class UploadPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = "";
		String picture = request.getParameter("picture");
		String caption = request.getParameter("caption");
		
		PicDBManager pdb = new PicDBManager();
		
		HttpSession session = request.getSession();
		username = (String) session.getAttribute("username");
		System.out.println("eto na" + username);
		System.out.println(picture);
		System.out.println(caption);
		if(pdb.upload(username, picture, caption))
		{
			System.out.println("Upload SUCCESS");
		}
		else
		{
			System.out.println("Upload FAIL");
		}
		session.setAttribute("picture", picture);
		session.setAttribute("caption", caption);
		request.getRequestDispatcher("ViewPicServlet").forward(request, response);
	}

}
