package code1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class rel
 */
@WebServlet("/rel")
public class rel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		relaBean rel=new relaBean();
		rel.setBeen(request.getParameter("been"));
		rel.setImp(request.getParameter("imp"));
		rel.setCurrent(request.getParameter("current"));
		rel.setFuture(request.getParameter("future"));
		rel.setViews(request.getParameter("views"));
		
		//adding the data into the database
		DAO d= new DAO();
		d.recordRelationShip(rel);
		
		//set the object to the request and then call the dispatcher
		request.setAttribute("rel", rel);
		RequestDispatcher rd= request.getRequestDispatcher("thank.jsp");
	rd.forward(request, response);
	}

}
