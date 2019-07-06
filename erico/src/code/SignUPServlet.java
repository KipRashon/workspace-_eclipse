package code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseAccess.DAO;

import beans.SignUp;

/**
 * Servlet implementation class SignUPServlet
 */
@WebServlet("/signUp")
public class SignUPServlet extends HttpServlet {
	private DAO dao;
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignUPServlet() {
        // TODO Auto-generated constructor stub
    	dao=new DAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   SignUp sc= new SignUp();
	   String password1=request.getParameter("pass");
		String password2=request.getParameter("repeat-pass");
	   //check the password if it is in the correct format
	   if(checkPassword(password1,password2)) {
		   sc.setPassword(password2);
	   }
	   else {
		   String message=checkError(password1,password2);
		   response.sendError(400, message);
		   
	   }
	   sc.setName(request.getParameter("name"));
	   sc.setEmail(request.getParameter("email"));
	   sc.setUsername(request.getParameter("username"));
	   //send the bean to be saved
	   dao.recordNewUser(sc);
	   System.out.println("Wonderful data saved ");
	   response.sendRedirect("Login.html");
	}

	private String checkError(String password1, String password2) {
		if(password1.length()<6) {
			return "The length of your password should be at least 6 characters";
		}
		else if(password1!=password2) {
			return "Your first password should be equal to the second password";
		}
		return null;
	}

	private Boolean checkPassword(String parameter, String parameter2) {
		if(parameter.equals(parameter2) && parameter.length()>=6) {
			return true;
		}
		else {
			return false;
		}
	
	}

}
