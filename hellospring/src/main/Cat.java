package main;

public class Cat {
	String name;
	private int age;
	public int getAge() {
		return age;
	}
	public Cat(String nm,int a) {
		this.name=nm;
		this.age=a;
	}
	public String getName() {
		return name;
	}
	/*public void setName(String name) {
		this.name = name;
	}*/
	public void cry() {
		System.out.println(getName()+"miaaooo my age is "+getAge());
	}
}
