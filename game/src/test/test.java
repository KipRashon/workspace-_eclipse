package test;


import java.security.Provider;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.*;

public class test{

		public static void main(String args[]) {
			//defines the input string
			byte[]input;
			//defines the key bites for the secret key spec you can give your own
			byte[]keyBytes="12345678".getBytes();
			//defines the iv parameter spec bytes you can give your own too
			byte[]ivBytes="input123".getBytes();
			//takes two parameters the key bytes and  a string
			SecretKeySpec key= new SecretKeySpec(keyBytes, "DES");
			//takes one parameter the ivbytes
			IvParameterSpec ivspec= new IvParameterSpec(ivBytes);
			//creating the cipher 
			Cipher cipher;
			//the text that is going to be obtained from the cipher and its length
			byte[]cipherText;
			int ctLength;
			
			
			//doing the encryption
			try {
				
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			input="Hello Rashon".getBytes();
			cipher=Cipher.getInstance("DES/CTR /NoPadding","BC");
			cipher.init(Cipher.ENCRYPT_MODE, key,ivspec);
			cipherText=new byte[cipher.getOutputSize(input.length)]; 
			ctLength=cipher.update(input, 0,input.length,cipherText,0);
			ctLength +=cipher.doFinal(cipherText, ctLength);
			System.out.println(cipherText);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	
}