package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.PicDBManager;

/**
 * Servlet implementation class EditPicServlet
 */
@WebServlet("/EditPicServlet")
public class EditPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPicServlet() {
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
		HttpSession session = request.getSession();
		
		String username = (String) session.getAttribute("username");
		System.out.println(username);
		String picture = request.getParameter("picture");
		System.out.println(picture);
		String caption = request.getParameter("caption");
		System.out.println(caption);
		String pic = request.getParameter("pic_id");
		System.out.println(pic);
		int pic_id = Integer.parseInt(pic);
		
		PicDBManager pdb = new PicDBManager();
		
		if(pdb.edit(username, picture, caption, pic_id))
		{
			session.setAttribute("username", username);
			System.out.println("Edit SUCCESS");
			request.getRequestDispatcher("/ViewPicServlet").forward(request, response);
		}
		else
		{
			System.out.println("Edit FAIL");
			response.sendRedirect("ViewPic.jsp");
		}
	}

}
