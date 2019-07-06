package beans;

public class LoginUser {
	@Override
	public String toString() {
		return "LoginUser [username=" + username + ", password=" + password + "]";
	}
	private String username,password;
	public LoginUser() {}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	};
	
}
