package code1;

import java.io.InputStream;

public class PrivatedataBean {
	userBean user;
	InputStream file;
	
	
	String email,levelDefinition,Studentyear,religion,
	studentCourse,likeAttendChurch,reasonforAttend;
	
	//generate a no argument constructor
	public PrivatedataBean() {
	
	}

	public userBean getUser() {
		return user;
	}

	public void setUser(userBean user) {
		this.user = user;
	}



	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLevelDefinition() {
		return levelDefinition;
	}

	public void setLevelDefinition(String levelDefinition) {
		this.levelDefinition = levelDefinition;
	}

	public String getStudentyear() {
		return Studentyear;
	}

	public void setStudentyear(String studentyear) {
		Studentyear = studentyear;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public String getLikeAttendChurch() {
		return likeAttendChurch;
	}

	public void setLikeAttendChurch(String likeAttendChurch) {
		this.likeAttendChurch = likeAttendChurch;
	}

	public String getReasonforAttend() {
		return reasonforAttend;
	}

	public void setReasonforAttend(String reasonforAttend) {
		this.reasonforAttend = reasonforAttend;
	}

	

	
}