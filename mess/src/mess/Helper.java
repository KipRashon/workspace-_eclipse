package mess;

import java.util.*;

public class Helper {
	private int totalPrice;
	private String foodList[]= {"Ugali","Chapati","Beans","Ndengu","Vegetable","Egg Curry","Rice"};
	private int prices[]= {5,10,13,13,5,15,12};
	private List<String> theChosenValues=new ArrayList<>();
	Scanner s= new Scanner(System.in);
	//method to display the food 
	public void display() {
		System.out.println();
		System.out.println("\tWelcome to  our Mess Menu");
		
		System.out.println("***************************");
		System.out.println("Choose the food you want to sell");
		for(int i=0;i<foodList.length;i++) {
			System.out.println((i+1)+"."+foodList[i]);
		}
		System.out.println("***************************");
		processChoice(s.nextInt()-1);
		processAfterChoosing();
	}
	//process choice
	private String processChoice(int choice) {
		String theChosen=foodList[choice];
		int priceOfChosen=prices[choice];
		totalPrice=totalPrice+priceOfChosen;
		String formated=String.format("%s\t%s", theChosen,priceOfChosen);
		theChosenValues.add(formated);
		return formated;
	}
	
	private void processAfterChoosing() {
		System.out.println("\nYou have chosen the following food");
		System.out.println("***************************");
		for(String a:theChosenValues) {
			System.out.println(a);
		}
		System.out.println("\tTotal Price\t"+totalPrice);
		System.out.println("***************************");
		processNext();
		
	}
	private void processNext() {
		System.out.println("\nPlease Enter the choice for next action");
		System.out.println("***************************");
		System.out.println("1.Done");
		System.out.println("2.More food");
		System.out.println("***************************");
		int choice=s.nextInt();
		if(choice==1) {
			showReceipt();
		}
		else if(choice==2) {
			display();
		}
		else {
			System.out.println("\nPlease Enter the right choice");
			processNext();
		}
	}
	
	private void showReceipt(){
		System.out.println("\n\t THIS IS YOUR RECEIPT\n");
		System.out.println("***************************");
		for(String a:theChosenValues) {
			System.out.println(a);
		}
		System.out.println("\tTotal Price\t"+totalPrice);
		System.out.println("**************  All done take your food and go *************");
		
		
	}

}
