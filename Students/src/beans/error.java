package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class error {
    String message;
    String date;
    String time;

    public error(String errorMessage){
        Date d= new Date();
        SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sd1= new SimpleDateFormat("hh:mm:ss a");
        date=sd.format(d);
        time=sd1.format(d);
        this.message=errorMessage;


    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

}
