package toDoApp;
import java.sql.*;

import javax.swing.JOptionPane;

public class DAO {
	Connection con;
	public DAO() {
		
		String url="jdbc:mysql://localhost:3306/todo";
		String username="root";
		String password="kiptoo";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con=DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//method to add new user into the database
	public void insertUser(signUpBean bean) {
		try {
			PreparedStatement pt=con.prepareStatement("insert into users (firstname,lastname,username,gender,password,location)"
					+ "values(?,?,?,?,?,?)");
			pt.setString(1, bean.getFirstname());
			pt.setString(2, bean.getLastname());
			pt.setString(3, bean.getUsername());
			pt.setString(4, bean.getGender());
			pt.setString(5, bean.getPassword());
			pt.setString(6, bean.getLocation());
			
			//execute the update
			pt.executeUpdate();	
			JOptionPane.showMessageDialog(null, "Success data saved");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkIfExist(String username,String password) {
		try {
			PreparedStatement pt=con.prepareStatement("select * from users where username=? and password=?");
		pt.setString(1, username);
		pt.setString(2, password);
		ResultSet rs=pt.executeQuery();
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
	}


















