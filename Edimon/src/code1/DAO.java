package code1;
import java.sql.*;


public class DAO {
	String username="root";
	String password="kiptoo";
	String url="jdbc:mysql://localhost:3306/Edimon";
	//method to record the person that is logged in
	public void insertLogin(userBean us) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement("insert into loginrecord (username,password)"
					+ "values(?,?)");
			
			st.setString(1, us.getUsername());
			st.setString(2, us.getPassword());
			//execute the query
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//method to record the data of the private data in the private page
	public void recordPrivate(PrivatedataBean pr)  {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement("insert into privaterecord "
					+ "(image,email,levelDefinition,studentYear,religion,studentCourse,likeChurch,reasonforAttend)"
					+ "values(?,?,?,?,?,?,?,?)");
			//set the values as from the private bean
			
			//create an input stream to turn the file into a blob
			
		//insert the data into the database
			st.setBlob(1, pr.getFile());
			st.setString(2, pr.getEmail());
			st.setString(3,pr.getLevelDefinition() );
			st.setString(4,pr.getStudentyear() );
			st.setString(5,pr.getReligion() );
			st.setString(6,pr.getStudentCourse() );
			st.setString(7, pr.getLikeAttendChurch());
			st.setString(8, pr.getReasonforAttend());
			
			//make sure to execute the update
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
	}
	//method to insert the data from the relationship page
	public void recordRelationShip(relaBean rel) {
		//been importance yes currentStatus futureStatus relationshipView
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement("insert into relationshiprecord"
					+ "(been,importance,currentStatus,futureStatus,relationshipView) "
					+ "values(?,?,?,?,?)");
			st.setString(1,rel.getBeen() );
			st.setString(2, rel.getImp());		
			st.setString(3,rel.getCurrent() );
			st.setString(4, rel.getFuture());
			st.setString(5,rel.getViews() );
			
			//remember to execute the update
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
