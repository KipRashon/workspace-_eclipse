package test;

import java.math.BigInteger;

public class hashing {

	public static void main(String[] args) {
/*	String binaryString="10";
	int binaryRadix=2;
	BigInteger builder=new BigInteger(binaryString,binaryRadix);
	System.out.println(builder);*/
	
/*	byte[]unsignedbytes= {(byte)0x80};
	BigInteger valuefrombytes= new BigInteger(unsignedbytes);
	System.out.println(valuefrombytes);*/
		byte[]signedbytes= {(byte)0x80};
/*		int sign=1;
		BigInteger valuefrombytes= new BigInteger(sign,signedbytes);
		System.out.println(valuefrombytes);*/
		
		BigInteger big= new BigInteger("100");
		BigInteger small= new BigInteger("72");
		BigInteger medium= new BigInteger("60");
		System.out.println(big.gcd(small).gcd(medium));
	}

}
