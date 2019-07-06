package derek_banas;
import java.util.*;
import java.text.*;

public class CheckSystemTime extends Thread {

	public void run() {
		Date rightnow;
		Locale currentlocale;
		DateFormat timeformatter;
		DateFormat dateformatter;
		
		String timestr;
		String datestr;
		for(int i=1;i<=20;i++) {
			rightnow=new Date();
			currentlocale= new Locale("en");

			timeformatter= DateFormat.getTimeInstance(DateFormat.DEFAULT,currentlocale);
			dateformatter= DateFormat.getDateInstance(DateFormat.DEFAULT,currentlocale);
			
			timestr=timeformatter.format(rightnow);
					datestr=dateformatter.format(rightnow);
					System.out.println(timestr);
					System.out.println(datestr);
					System.out.println();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
	}
	public static void main(String args[]) {
		Thread th= new CheckSystemTime();
		th.start();
	}

}

