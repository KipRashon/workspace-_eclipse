package code;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveFeed
 */
@WebServlet("/savefeed")
public class SaveFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveFeed() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		//SELECT * FROM `history` ORDER BY date asc,time ASC
		rss rs=new rss();
		rs.setDescription(description);
		rs.setTitle(title);
		insertFeeds(rs,response,request);
		
		
	}
	
	private void insertFeeds(rss rs,HttpServletResponse response,HttpServletRequest request) {
		String title=rs.getTitle();
		String description=rs.getDescription();
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rss","root","kiptoo");
			if(!title.equals("") && !description.equals("") ) {
				PreparedStatement st=con.prepareStatement("insert into feeds values(?,?,?,?)");
				st.setString(1, rs.getDate());
				st.setString(2, rs.getTime());
				st.setString(3, title);
				st.setString(4, description);
				
				st.executeUpdate();
				ResultSet result=selectEverything();
				request.setAttribute("feeds", result);
				RequestDispatcher rd= request.getRequestDispatcher("homepage.jsp");
				rd.forward(request, response);
				
			}
			else {
				response.sendRedirect("rssEdit.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private ResultSet selectEverything() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rss","root","kiptoo");
			Statement st= con.createStatement();
			ResultSet result=st.executeQuery("select title,description from feeds order by date desc,time desc");
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
