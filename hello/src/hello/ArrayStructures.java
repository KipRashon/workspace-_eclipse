package hello;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ArrayStructures {

	private int theArray[]= new int[50];
	private static int arraysize=10;
	
	public void generateRandom() {
		for(int i=0;i<arraysize;i++) {
			theArray[i]=(int)(Math.random()*10)+10;
			
		}
		
	}
	//method to print the array
	public void printArray() {
	
		for(int i=0;i<arraysize;i++) {
			System.out.println("------------");
			System.out.print("|"+i+"|");
			System.out.println(theArray[i]+"|");
			
		}
		System.out.println("------------");
		
	}
	//create the method to return the value of an array at an index
	public int getValueAtIndex(int index) {
		if(index<arraysize)return theArray[index];
		//otherwise
		return 0;
		
	}
	//method to check if an array contains a certain value
	public boolean doesItContain(int value) {
		boolean tof=false;
		for(int i=0;i<arraysize;i++) {
			if(theArray[i]==value) {
				tof=true;
				return tof;
				
			}
			else {
				tof=false;
			}
			
			
		}
		return tof;
	}
	//method to remove an array at an index and add up
	public void deleteIndex(int index) {
	 if(index<arraysize) {
		for(int i=index;i<(arraysize-1);i++) {
			theArray[i]=theArray[i+1];
		}
		arraysize--;
	 }
		
	}
	
	//now the method to insert a value into the array
	public void insertValue(int value) {
		
		if(arraysize<50) {
			theArray[arraysize]=value;
			arraysize++;
		}
	
	

	
	}
	//create the method to do linear search
	public String doLinearSearch(int value) {
		String valuesfound="";
		boolean valuefound=false;
		System.out.println("The value you searched was found at:");
		for(int i=0;i<arraysize;i++) {
			if(value==theArray[i]) {
				System.out.print(i+" ");
				valuesfound=i+"";
				 valuefound=true;
			}
			
		
		}
		return valuesfound;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStructures arr= new ArrayStructures();
		arr.generateRandom();
		arr.printArray();
		arr.insertValue(45);
		arr.insertValue(56);
		
		arr.doLinearSearch(17);

	
	}

}
