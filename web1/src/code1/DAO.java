package code1;

import java.sql.*;

public class DAO {
	//getting the connection to the database
	private String username="root";
	private String password="kiptoo";
	private String url="jdbc:mysql://localhost:3306/login";
	
	//create the method to store data in the database
	public void storeRegistered(registeruser us) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement("insert into login_record (firstname,lastname,country,password,age)"
					+ "values(?,?,?,?,?)");
			//set the values here
			
			st.setString(1, us.getFname());
			st.setString(2, us.getLname());
			st.setString(3, us.getCountry());
			st.setString(4, us.getPassword());
			st.setInt(5, us.getAge());
			
			st.executeUpdate();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//create the method to validate the login
	public Boolean validateLogin(loginuser us) {
		Boolean tof=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement("select firstname,lastname,password from login_record where firstname=?"
					+ "and lastname=? and password=?");
		
			st.setString(1, us.getFname());
			st.setString(2, us.getLname());
			st.setString(3, us.getPassword());
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				tof=true;
				return tof;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tof;
		
	}
}














