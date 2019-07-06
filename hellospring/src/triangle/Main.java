package triangle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring2.xml");
		Triangle t=(Triangle)context.getBean("triangle");
		t.draw();
	}

}
