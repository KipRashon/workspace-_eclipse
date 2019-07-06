package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class History {
    String action,time,date;
    public History(String action)
    {
        this.action=action;
        Date d= new Date();
        SimpleDateFormat sd= new SimpleDateFormat("dd,MMMM,yyyy");
        SimpleDateFormat tm= new SimpleDateFormat("hh:mm:ss a");
        this.time=tm.format(d);
        this.date=sd.format(d);
    }

    public String getAction() {
        return action;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}
