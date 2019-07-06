package code1;

public class loginuser {

	private String fname,lname,password;
	//creating a no arg constructor
	public loginuser() {
		
	}
	//generate the getters and setters methods

	public String getFname() {
		return fname;
	}

	

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//generating the to string  method
	@Override
	public String toString() {
		return "loginuser [fname=" + fname + ", lname=" + lname + ", password=" + password + "]";
	}
}
