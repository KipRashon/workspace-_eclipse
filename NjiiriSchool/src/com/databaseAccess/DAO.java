package com.databaseAccess;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;

public class DAO {

	private ConnectionProvider connector;
	private  Connection con;
	public DAO() {
		
		connector=new ConnectionProvider();
		con=connector.getConnected();
	}
	
	//method to record the values from the sign in
	public void recordNewUser(SignUp user) {
		try {
			PreparedStatement pt= con.prepareStatement("insert into  adminsignup"
					+ "(Name,Username,Email,Password)  "
					+ "values(?,?,?,?)");
			//set the data from the bean
			pt.setString(1, user.getName());
			pt.setString(2, user.getUsername());
			pt.setString(3, user.getEmail());
			pt.setString(4, user.getPassword());
			
			pt.executeUpdate();
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//method to check the logged in user
	public boolean checkLoggedIn(LoginUser us) {
		
		try {
			PreparedStatement st=con.prepareStatement("select Name,Username,Email from adminsignup where username=? and password=?");
			st.setString(1,us.getUsername());
			st.setString(2, us.getPassword());
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
			return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	//check if anyone exists in the database
	public boolean checkIfExist() {
		boolean tof;
		try {
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery("select * from adminsignup");
			if(rs.next()) {
				tof=true;
			}
			else {
				tof=false;
			}
			return tof;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}


/*public void insertFeeds(rss rs,HttpServletResponse response,HttpServletRequest request) {
		String title=rs.getTitle();
		String description=rs.getDescription();
		try {
			
			if(!title.equals("") && !description.equals("") ) {
				PreparedStatement st=con.prepareStatement("insert into rss values(?,?,?,?)");
				st.setString(1, rs.getDate());
				st.setString(2, rs.getTime());
				st.setString(3, title);
				st.setString(4, description);
				
				st.executeUpdate();
				ResultSet result=selectEverything();
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
	}*/


	public ResultSet selectEverything() {
		try {
			
			Statement st= con.createStatement();
			ResultSet result=st.executeQuery("select * from rss order by date desc,time desc");
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		return null;
	}


	}
	
/*//	public static void main(String args[]) {
//		DAO d= new DAO();
//		ResultSet rs=d.selectEverything();
//		try {
//			while(rs.next()) {
//				System.out.println(rs.getString("date"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
*/	
	}






























