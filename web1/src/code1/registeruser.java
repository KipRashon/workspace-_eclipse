package code1;

public class registeruser {
	private String fname,lname,password,country;
	private int age;
	//generating the no argument constructor
	public registeruser() {
		
	}
	//generating the getters and setter methods
	
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//the to string method
	@Override
	public String toString() {
		return "registeruser [fname=" + fname + ", lname=" + lname + ", password=" + password + ", country=" + country
				+ ", age=" + age + "]";
	}
}
