package main;

public class dog {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void bark() {
		System.out.println(getName()+" barks");
	}
}
