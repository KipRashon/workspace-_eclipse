package code;

import java.util.Random;

public class Practice {

	public static void main(String[] args) throws Exception{
		System.out.println(ifGeneratedisEqualToMyName("rasho"));
		}

	
	public static Character generateRandomChar ()throws Exception {
		Random rand= new Random();
		int a= rand.nextInt(122);
		if(a<65) {
//			System.out.println("The number i generated is less than 65 let me redo it");
//			Thread.sleep(1000);
		return	generateRandomChar();
			
			
		}
		else {
			if(checkIfAlphabet((char)a)) {
				return (char)a;
			}
			else {
//				System.out.println("The number i generated is not in the alphabet Redoing this tiring job");
//				Thread.sleep(1000);
				return generateRandomChar();
				
			}
			
		}
	}
	private static boolean checkIfAlphabet(char generatedChar) throws Exception {
		String smallLetters="abcdefghijklmnopqrstuvwxyz";
		String capitalLetters=smallLetters.toUpperCase();
		boolean tof=false;
		char []smallChar=smallLetters.toCharArray();
		char[]capitalChar=capitalLetters.toCharArray();
		
		
		for(int i=0;i<26;i++) {
			
			if(smallChar[i]==generatedChar) {
			
				tof=true;
				break;
			}
			else {
				if(generatedChar==capitalChar[i]) {
					tof=true;
					break;
				}
				else {
					tof=false;
				}
			}
		}
	return tof;
		
	}
	
	private static boolean ifGeneratedisEqualToMyName(String anyName)throws Exception {
		boolean tof=false;
		char array[]= new char[anyName.length()];
		while(tof==false) {
			for(int i=0;i<anyName.length();i++) {
				array[i]=generateRandomChar();
				
			}
			
			if(String.valueOf(array).equalsIgnoreCase(anyName)) {
				System.out.println("found your name as");
				System.out.println(String.valueOf(array));
				tof=true;
				break;
			}
			else {
//				System.out.println("oops the name i generated does not equal that");
				System.out.println(String.valueOf(array));
				tof=false;
			}
		}
		return tof;
		
	}
}
