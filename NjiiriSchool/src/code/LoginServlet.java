package code;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseAccess.DAO;

import beans.LoginUser;
import beans.SignUp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private LoginUser user;
	private DAO dao;
	private SignUp loggedInUser;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        user=new LoginUser();
        dao= new DAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("pass"));
		boolean tof=dao.checkLoggedIn(user);
		
		if(tof=false) {
			response.sendRedirect("admin.html");
		}
		else {
			
			request.setAttribute("currentUser", loggedInUser);
			RequestDispatcher rd= request.getRequestDispatcher("addpost.html");
			rd.forward(request, response);
		}
	}

}
