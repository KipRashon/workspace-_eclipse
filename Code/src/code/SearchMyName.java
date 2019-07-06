package code;

import java.util.Random;

public class SearchMyName {
	static String smallLetters="abcdefghijklmnopqrstuvwxyz";
	String capitalLetters=smallLetters.toUpperCase();
	
	static char []smallChar=smallLetters.toCharArray();
	char[]capitalChar=capitalLetters.toCharArray();
	
	public static void main(String[] args) throws Exception{
		checkMyName("Rashon");
	}

	//method to generate a random character
	public static char generateRandomChar() {
		Random rand= new Random();
		int num=rand.nextInt(26);
		return smallChar[num];
	}
	
	public static void checkMyName(String myname) throws Exception {
		char array[]=new char[myname.length()];
		boolean tof=false;
		String generatedName;
	  while(tof==false) {
		for(int i=0;i<array.length;i++) {
			array[i]=generateRandomChar();
		}
		generatedName=String.copyValueOf(array);
//		System.out.println("Generated name "+generatedName);
		if(generatedName.equals(myname)) {
			System.out.println("\n Hurray got ya");
			tof=true;
			break;
		}
		else if(generatedName.equalsIgnoreCase(myname)) {
			System.out.println("Close but the caps is not the same\n continuing with search...");
			Thread.sleep(2000);
			
		}
		else {
			
		}
	}
	
	}
}
