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
 * Servlet implementation class DeleteEditServlet
 */
@WebServlet("/DeleteEditServlet")
public class DeleteEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEditServlet() {
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
		
		if (request.getParameter("delete") != null) {
	        //update button is clicked
	        //Do the update action or forward the request to the servlet to do update action 
			request.getRequestDispatcher("/DeletePicServlet").forward(request, response);

	    } else if (request.getParameter("edit") != null) {
	          //delete button is clicked
	          //Do the delete action or forward the request to the servlet to do delete action
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
				session.setAttribute("username", username);
				session.setAttribute("picture", picture);
				session.setAttribute("caption", caption);
				session.setAttribute("pic_id", pic_id);
				request.getRequestDispatcher("Edit.jsp").forward(request, response);

	    	
	    }
	}

}
