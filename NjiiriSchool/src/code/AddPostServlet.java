package code;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.databaseAccess.ConnectionProvider;
import com.databaseAccess.DAO;

import beans.rss;

/**
 * Servlet implementation class AddPostServlet
 */
@WebServlet("/addpost")
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO dao;
	private rss rs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
        super();
        dao=new DAO();
        rs=new rss();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rs.setDescription(request.getParameter("description"));
		rs.setTitle(request.getParameter("eventname"));
		insertFeeds(rs, response, request);
	}
		private void insertFeeds(rss rs,HttpServletResponse response,HttpServletRequest request) {
			String title=rs.getTitle();
			String description=rs.getDescription();
			try {
				
				if(!title.equals("") && !description.equals("") ) {
					PreparedStatement st=ConnectionProvider.getConnected().prepareStatement("insert into rss values(?,?,?,?)");
					st.setString(1, rs.getDate());
					st.setString(2, rs.getTime());
					st.setString(3, title);
					st.setString(4, description);
					
					st.executeUpdate();
					ResultSet result=dao.selectEverything();
					request.setAttribute("feeds", result);
					RequestDispatcher rd= request.getRequestDispatcher("blog.jsp");
					rd.forward(request, response);
					
				}
				else {
					response.sendRedirect("admin.html");
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
			}
		}
		
	}


