package com.databaseAccess;

import java.sql.*;
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
			PreparedStatement pt= con.prepareStatement("insert into  SignUpRecord"
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
	public SignUp checkLoggedIn(LoginUser us) {
		
		try {
			PreparedStatement st=con.prepareStatement("select Name,Username,Email from SignUpRecord where username=? and password=?");
			st.setString(1,us.getUsername());
			st.setString(2, us.getPassword());
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				SignUp loggedIn= new SignUp();
				loggedIn.setName(rs.getString("Name"));
				loggedIn.setUsername(rs.getString("Username"));
				loggedIn.setEmail(rs.getString("Email"));
				
				return loggedIn;
			}
			else {
			return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
}
