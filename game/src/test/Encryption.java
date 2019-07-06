package test;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encryption {
	public static String MD5(String input) {
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[]messageDigest=md.digest(input.getBytes());
			BigInteger number= new BigInteger(1,messageDigest);
			System.out.println("Big integer number "+number);
			String hashtext=number.toString(16);
			System.out.println("the hashtext "+hashtext);
			while(hashtext.length()<32) {
				hashtext="0"+hashtext;
			}
			return hashtext;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public static String SHAI(String input) {
		try {
			MessageDigest mdigest= MessageDigest.getInstance("SHAI");
			byte[] result=mdigest.digest(input.getBytes());
			StringBuffer sb= new StringBuffer();
			for(int i=0;i<result.length;i++) {
				sb.append(Integer.toString((result[i] & 0xff)+0x100,16).substring(1));
				
			}
			return sb.toString();
			}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String args[]) {
		
		String txt=Encryption.SHAI("This is my fucking password");
		System.out.println(txt);
	}
}
