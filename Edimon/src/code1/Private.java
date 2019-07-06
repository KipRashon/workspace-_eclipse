package code1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Private
 */
@WebServlet("/Private")
@MultipartConfig
public class Private extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Private() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userBean bean;
		InputStream file;
		String email,levelDefinition,studentYear,religion,
		studentCourse,likeAttendChurch,reasonforAttend;
		
		//getting the data from the  request
		
		Part p= request.getPart("file");
		
		file=p.getInputStream();
		bean=(userBean) request.getAttribute("loggenIn");
		email=request.getParameter("email");
		studentYear=request.getParameter("year");
		levelDefinition=request.getParameter("you");
		 religion=request.getParameter("religion");
		 studentCourse=request.getParameter("course");
		 likeAttendChurch=request.getParameter("attend");
		 reasonforAttend=request.getParameter("reason");
		 //call the bean and set the values to the bean
		PrivatedataBean pd= new PrivatedataBean();
		pd.setFile(file);
		pd.setEmail(email);
		pd.setLevelDefinition(levelDefinition);
		pd.setStudentCourse(studentCourse);
		pd.setStudentyear(studentYear);
		pd.setReligion(religion);
		pd.setLikeAttendChurch(likeAttendChurch);
		pd.setReasonforAttend(reasonforAttend);
		//recording the data into the database
		DAO d= new DAO();
		d.recordPrivate(pd);
		//erico4134
		
		//set the object into the request
		request.setAttribute("private", pd);
		//call the request dispatcher to send the page to the the next level
		RequestDispatcher rd= request.getRequestDispatcher("rela.jsp");
		rd.forward(request, response);
		
	}

}
