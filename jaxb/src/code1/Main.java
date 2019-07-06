package code1;

import java.io.File;

import javax.xml.bind.JAXB;

public class Main {

	public static void main(String[] args) {

		try {
			/*user us=JAXB.unmarshal(new File("user.xml"), user.class);
			System.out.println(us.getUsername());
			System.out.println(us.getUserid());*/
			user us= new user();
			us.setUserid(75325712);
			us.setUsername("Kiptoo Rashon");
			JAXB.marshal(us, new File("user.xml"));
			
			
		}
		catch(Exception e) 
		{
			System.out.println("Your exception was caught what do you wanna do");
		}
	}

}
