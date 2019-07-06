package triangle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware,BeanNameAware {
	
	ApplicationContext context;

	private Points A,B,C;

	public Points getA() {
		return A;
	}

	public void setA(Points a) {
		A = a;
	}

	public Points getB() {
		return B;
	}

	public void setB(Points b) {
		B = b;
	}

	public Points getC() {
		return C;
	}

	public void setC(Points c) {
		C = c;
	}
	
	public void draw() {
		System.out.println("The triangle is going to be drawn as follows: "
				+ "\n"+"A "+getA()
				+ "\n"+"B "+getB()
				+ "\n"+"C "+getC());
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("The bean name for this object is : "+beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context=context;
	}
	
}
