/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author KIPTOO
 */
import java.io.*;
import javax.swing.*;
public class LastExam {
//School Management System
	String filename = "txt.txt";
	String Filename = "gradingSystem.txt";
	String FIlename = "libraryInventory.txt";
	
	static int totalSubject;

	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		intro();
		
	} public static void intro() {
		
		JOptionPane.showMessageDialog(null, "OloSemaj School Management System");
		String choice = JOptionPane.showInputDialog("1 - Adding entry\n"
				+ "2 - Grading System\n"
				+ "3 - Library\n"
				+ "4 - Done"); 
		
		switch (choice) {
		case "1": JOptionPane.showMessageDialog(null, "You choose Adding Entry");
		{entry();}
		break;
		case "2": JOptionPane.showMessageDialog(null, "You choose Grading System");
		{computegrade();}
		break;
		case "3": JOptionPane.showMessageDialog(null, "You choose Library");
		{library();}
		break;
		case "4": {JOptionPane.showMessageDialog(null, "Done");}
		break;
		default: JOptionPane.showMessageDialog(null, "Please input the appropriate letter.");
		}
		
	}
	public static void library() {
		String lib=JOptionPane.showInputDialog(null, "LIBRARY:\n\n"
				+ "A - Enter new books\n"
				+ "B - Input Borrowed books").toUpperCase();
		switch(lib) {
		case "A":{ String bookname = JOptionPane.showInputDialog(null, "Book Name: ").toUpperCase();
					String bookcode = JOptionPane.showInputDialog(null, "Book number code").toUpperCase();
					String bookCategory = JOptionPane.showInputDialog(null, "Book Category: ").toUpperCase();
					String bookdate = JOptionPane.showInputDialog(null, "DATE RECEIVED: " ).toUpperCase();
		
		try { PrintWriter outputStream = new PrintWriter("libraryInventory.txt");
		outputStream.println("NEW BOOKS ENTRY");
		outputStream.println("BOOK NAME: "+ bookname);
		outputStream.println("BOOK CODE: "+ bookcode);
		outputStream.println("BOOK CATEGORY: "+ bookCategory);
		outputStream.println("RECEIVED DATE: "+ bookdate);
		outputStream.close();
		System.out.println("DONE INPUTING BOOK INVENTORY INFO");
		}catch (FileNotFoundException y) { y.printStackTrace();}	
		}
		break;
		case "B": { String borrower = JOptionPane.showInputDialog(null, "Name of borrower: ");
				String idcode = JOptionPane.showInputDialog(null, "ID/Strudent code: ");
				String bookname = JOptionPane.showInputDialog(null, "Book Name: ");
				String bookcode = JOptionPane.showInputDialog(null, "Book number code");
				String bookdate = JOptionPane.showInputDialog(null, "Date Borrowed: "); 
				try { PrintWriter outputStream = new PrintWriter("libraryInventory.txt");
				outputStream.println("BOOK BORROWER ENTRY");
				outputStream.println("BORROWER: "+ borrower);
				outputStream.println("ID/STUDENT CODE: " + idcode);
				outputStream.println("BOOK NAME: "+ bookname);	
				outputStream.println("BOOK CODE: "+ bookcode);
				outputStream.println("RECEIVED DATE: "+ bookdate);
				outputStream.close();
				System.out.println("DONE INPUTING BOOK BORROWER INFO");
				}catch (FileNotFoundException y) { y.printStackTrace();}	}
		}
	}
	public static void computegrade() {
		
		
			
		String Studentsname = JOptionPane.showInputDialog(null, "Enter the students name:").toUpperCase();
		String studentcode = JOptionPane.showInputDialog(null, "Enter student code:").toUpperCase();
		String course = JOptionPane.showInputDialog(null,"Enter students course:").toUpperCase();
		String yearlevel = JOptionPane.showInputDialog(null, "Enter the students year level:").toUpperCase();
		String semester = JOptionPane.showInputDialog(null,"Enter semester year [Ex. 2010-2011:");
		totalSubject = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter how many subjects do student have:"));	
		for (int x=0; x<totalSubject; x++) { //to limit the input subject. so the user can decide how many subject does the student have...
		
		
		 String subject[];
		 int preliminaryGrade[];
		 int midtermGrade[];
		 int prefinalGrade[];
		 int finalGrade[];
		
		 int average[];
		 
		subject = new String [totalSubject];
		preliminaryGrade = new int [totalSubject];
		midtermGrade = new int [totalSubject];
		prefinalGrade = new int [totalSubject];
		finalGrade = new int [totalSubject];
		
		average = new int [totalSubject];
		for (int y= 0; y < totalSubject; y++) {
			subject[y] = JOptionPane.showInputDialog("Enter Subject").toUpperCase();
			preliminaryGrade[y] = Integer.parseInt(JOptionPane.showInputDialog("Enter Preliminary Grade"));
			midtermGrade[y] = Integer.parseInt(JOptionPane.showInputDialog("Enter Midterm Grade"));
			prefinalGrade[y] = Integer.parseInt(JOptionPane.showInputDialog("Enter Pre-Finals Grade"));
			finalGrade[y] = Integer.parseInt(JOptionPane.showInputDialog("Enter Finals Grade"));
			
			average[y] = (preliminaryGrade[y]+midtermGrade[y]+prefinalGrade[y]+finalGrade[y])/4;
		
			try {PrintWriter outputStream = new PrintWriter("gradingSystem.txt");
			outputStream.println("**************************************************************************************");
			outputStream.println("Students name: "+ Studentsname);
			outputStream.println("Students code: "+ studentcode);
			outputStream.println("Course: "+ course);
			outputStream.println("Year: "+ yearlevel +"\t\t\tSemester: "+semester);
			outputStream.println("**************************************************************************************\n");
			
			
			outputStream.println("Subject Title----------Preliminary Grade----------Midterm Grade----------Prefinal grade----------Final Grade----------Average----------Remarks");
			
			for ( y= 0; y < totalSubject;y++) {
				
			if (average[y] >= 75) {
			outputStream.println(subject[y]+"--------------------"+preliminaryGrade[y]+"--------------------"+midtermGrade[y]+"--------------------"+prefinalGrade[y]+"--------------------"+finalGrade[y]+"--------------------"+average[y]+"--------------------"+"PASSED");
			
			}else {
			outputStream.println(subject[y]+"--------------------"+preliminaryGrade[y]+"--------------------"+midtermGrade[y]+"--------------------"+prefinalGrade[y]+"--------------------"+finalGrade[y]+"--------------------"+average[y]+"--------------------"+"FAILED");
			
			}
			}
				outputStream.close();
				System.out.println("DONE COMPUTING GRADES");
			}catch (FileNotFoundException i) {i.printStackTrace();}
			}
			String balik = JOptionPane.showInputDialog(null, "Again? [yes/no").toUpperCase();
			switch (balik) {
			case "YES": {computegrade();}
			
			break;
			case "NO": {intro();}
			
			break;
			default: JOptionPane.showMessageDialog(null, "Please inpute appropriate text.");
			}
	}
	}
	
	public static void entry() {
		
		String letter = JOptionPane.showInputDialog(null, "A - Adding Students\n"
				+ "B - Adding Teachers\n"
				+ "C - Adding Vehicles\n"
				+ "D - Adding Classrooms\n"
				+ "E - Adding Subjects\n"
				+ "F - Done").toUpperCase();
		
		
		switch (letter) {
		case "A":
		String studentsName = JOptionPane.showInputDialog(null, "Students full name: ").toUpperCase();
		String studentAge = JOptionPane.showInputDialog(null, "Age: ").toUpperCase();
		String studentCode = JOptionPane.showInputDialog(null, "ID code: ").toUpperCase();
		String course = JOptionPane.showInputDialog(null, "Course: ").toUpperCase();
		String year = JOptionPane.showInputDialog(null, "Year: ").toUpperCase();
		String semester = JOptionPane.showInputDialog(null, "Semester: ");
		String contactNumber = JOptionPane.showInputDialog(null, "Contact No. ");
				
				try { PrintWriter outputStream = new PrintWriter("txt.txt");
				outputStream.println("STUDENT ENTRY");
				outputStream.println("NAME: "+studentsName);
				outputStream.println("AGE: "+studentAge);
				outputStream.println("STUDENT CODE: "+studentCode);
				outputStream.println("COURSE: "+course);
				outputStream.println("YEAR: "+year);
				outputStream.println("SEMESTER:"+semester);
				outputStream.println("Contact Number: "+contactNumber);
				outputStream.close();
				System.out.println("DONE ADDING STUDENT INFO");
				} catch (FileNotFoundException x) { x.printStackTrace();}
				
				String balik = JOptionPane.showInputDialog("Again? [yes/no]").toUpperCase();
				if (balik == "YES") {
					entry();
				}else {
					intro();
				}
				
				//pag buhat ug output statement!!!
				break;
		case "B":  String teachersName = JOptionPane.showInputDialog(null, "Teachers full name: ").toUpperCase();
				String teachersAge = JOptionPane.showInputDialog(null, "Age: ");
				String teacherCode = JOptionPane.showInputDialog(null, "ID code").toUpperCase();
				String joiningDate = JOptionPane.showInputDialog(null, "Joining date: ").toUpperCase();
				
				try {PrintWriter outputStream = new PrintWriter ("txt.txt");
				outputStream.println("TEACHER");
				outputStream.println("NAME: " + teachersName);
				outputStream.println("AGE: " + teachersAge);
				outputStream.println("ID CODE: " + teacherCode);
				outputStream.println("JOINING DATE: " +joiningDate);
				outputStream.close();
				System.out.println("DONE ADDING TEACHER INFO");
				}catch (FileNotFoundException x) {x.printStackTrace();}
				
				balik = JOptionPane.showInputDialog("Again? [yes/no]").toUpperCase();
				if (balik == "YES") {
					entry();
				}else {
					intro();
				}
				break;
		case "C": String plateNumber = JOptionPane.showInputDialog(null, "Plate number: ").toUpperCase();
				String type = JOptionPane.showInputDialog(null, "Type of vehivle [car,motorcycle,etc]").toUpperCase();
				String ownerName = JOptionPane.showInputDialog(null, "Owner name: ").toUpperCase();
				String owner = JOptionPane.showInputDialog(null, "Owner type [student, teacher, staff]").toUpperCase();
				
				try {PrintWriter outputStream = new PrintWriter ("txt.txt");
				
				
				outputStream.println("VEHICLE");
				outputStream.println("PLATE NUMBER: "+ plateNumber);
				outputStream.println("TYPE: "+ type);
				outputStream.println("OWNER NAME: "+ ownerName);
				outputStream.println(owner);
				outputStream.close();
				System.out.println("DONE ADDING VEHICLE INFO");
				}catch (FileNotFoundException x) {x.printStackTrace();}
				
				balik = JOptionPane.showInputDialog("Again? [yes/no]").toUpperCase();
				if (balik == "YES") {
					entry();
				}else {
					intro();
				}
				
				break;
		case "D": String roomNumber = JOptionPane.showInputDialog(null, "Room code number: ").toUpperCase();
				String buildingname = JOptionPane.showInputDialog(null, "Building name: ").toUpperCase();
				
				try {PrintWriter outputStream = new PrintWriter ("txt.txt");
				outputStream.println("ROOM");
				outputStream.println("ROOM NUMBER: "+roomNumber);
				outputStream.println("BUILDING: "+ buildingname);
				outputStream.close();
				System.out.println("DONE");
				}catch (FileNotFoundException x) {x.printStackTrace();}
				
				balik = JOptionPane.showInputDialog("Again? [yes/no]").toUpperCase();
				if (balik == "YES") {
					entry();
				}else {
					intro();
				}
				
				break;
		case "E": String bookName = JOptionPane.showInputDialog(null, "Book name: ");
				String subjectCode = JOptionPane.showInputDialog(null, "Subject code: ");
				
				try {PrintWriter outputStream = new PrintWriter ("txt.txt");
				outputStream.println("BOOK");
				outputStream.println("BOOK NAME: "+ bookName);
				outputStream.println("SUBJECT CODE: "+ subjectCode);
				outputStream.close();
				outputStream.println("DONE");
				}catch (FileNotFoundException x) {x.printStackTrace();}
				 
				balik = JOptionPane.showInputDialog("Again? [yes/no]").toUpperCase();
				switch (balik) { 
				case "YES" :
					entry();
				 case "NO":
					intro();
			break;
			default: JOptionPane.showMessageDialog(null, "Try again.\nPlease enter the appropriate key.");
				entry();
				
				}
			}
		}
	}

		
	

