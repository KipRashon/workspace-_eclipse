package beans;

public class SignUp {
	private String email,name,password,username;

	//no argument constructor
	public SignUp() {}
	//gettters and setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "SignUp [email=" + email + ", name=" + name + ", password=" + password + ", username=" + username + "]";
	}
	
	
}
