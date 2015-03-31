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
 * Servlet implementation class DeletePicServlet
 */
@WebServlet("/DeletePicServlet")
public class DeletePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePicServlet() {
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
		String username = request.getParameter("username");
		String picture = request.getParameter("picture");
		String caption = request.getParameter("caption");
		String pic_id = request.getParameter("pic_id");
		PicDBManager pdb = new PicDBManager();
		
		HttpSession session = request.getSession();
		
		if(pdb.delete(username, picture, caption, pic_id))
		{
			session.setAttribute("username", username);
			System.out.println("Delete SUCCESS");
			request.getRequestDispatcher("ViewPic.jsp").forward(request, response);
		}
		else
		{
			System.out.println("Delete FAIL");
			response.sendRedirect("ViewPic.jsp");
		}
	}

}
