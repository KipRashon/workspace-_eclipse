package code1;

public class userBean {
	@Override
	public String toString() {
		return "userBean [username=" + username + ", password=" + password + "]";
	}

	String username,password;
	
	//create a no argument constructor
	public userBean() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword( String password) {
		this.password = password;
	}
}
