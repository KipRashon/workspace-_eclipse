package code1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class user {
	int userid;
	String username;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
