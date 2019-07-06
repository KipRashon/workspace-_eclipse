package code;

import java.text.SimpleDateFormat;
import java.util.Date;

public class rss {
	String title,description,time,date;
	public rss() {
		Date d= new Date();
		SimpleDateFormat tm= new SimpleDateFormat("hh:mm:ss a");
		SimpleDateFormat dt= new SimpleDateFormat("dd/MM/yyyy");
		this.time=tm.format(d);
		this.date=dt.format(d);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}

}
