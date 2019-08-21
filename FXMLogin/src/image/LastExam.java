/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image;

/**
 *
 * @author KIPTOO
 */
import java.io.*;
import javax.swing.*;
public class LastExam {
//School Management System
	String filename = "txt.txt";
	String FIlename = "gradingSystem.txt";
		
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		intro();
		
	} public static void intro() {
		
		JOptionPane.showMessageDialog(null, "JameSolo Student Management System");
		
		String choice = JOptionPane.showInputDialog("1 - Adding entry\n"
				+ "2 - Grading System\n"
				+ "3 - Library"); 
		
		switch (choice) {
		case "1": JOptionPane.showMessageDialog(null, "You choose Adding Entry");
		{entry();}
		break;
		case "2": JOptionPane.showMessageDialog(null, "You choose Grading System");
		{gradingSystem();}
		break;
		case "3": JOptionPane.showMessageDialog(null, "You choose Library");
		
		break;
		default: JOptionPane.showMessageDialog(null, "Please input the appropriate letter.");
		}
		
	}
	public static void gradingSystem() {
		
		String studentname = JOptionPane.showInputDialog(null, "Student Name: ").toUpperCase();
		String studentcode = JOptionPane.showInputDialog(null, "Student ID code: ").toUpperCase();
		String course = JOptionPane.showInputDialog(null, "Course:").toUpperCase();
		int totalSub= Integer.parseInt(JOptionPane.showInputDialog(null, "Total subject: "));
		int preliminaryGrade = Integer.parseInt(JOptionPane.showInputDialog(null, "Preliminary Grade: "));
		String subjectName = JOptionPane.showInputDialog(null, "Subject Code: ");
		int midtermGrade = Integer.parseInt(JOptionPane.showInputDialog(null, "Midterm Grade: "));
		int prefinalGrade = Integer.parseInt(JOptionPane.showInputDialog(null, "Pre Final Grade: "));
		int finalGrade = Integer.parseInt(JOptionPane.showInputDialog(null, "Final Grade: "));
		
		 
		
		for (int x = 0; x < totalSub; x++) {
		int average = (preliminaryGrade[totalSub] + midtermGrade[totalSub] + prefinalGrade[totalSub] + finalGrade)[totalSub]/4;
		
		try { PrintWriter outputStream = new PrintWriter("gradingSystem.txt");
		outputStream.println("NAME: " + studentname);
		outputStream.println("STUDENT CODE: "+ studentcode);
		outputStream.println("COURSE: "+ course);
		outputStream.println("\nTOTAL SUBJECTS: "+ totalSub);
		outputStream.println("GRADES: "+ preliminaryGrade[totalSub] + " " + midtermGrade[totalSub] + " " + prefinalGrade[totalSub] + " " + finalGrade[totalSub]);
		outputStream.println("AVERAGE: "+ average);	
		
		outputStream.close();
		System.out.println("DONE COMPUTING GRADES");
		}catch (FileNotFoundException z) { z.printStackTrace();}	
	}
		String balik = JOptionPane.showInputDialog("Again? [yes/no]").toUpperCase();
		if (balik == "YES") {
			gradingSystem();
		}if (balik == "NO"){
			intro();
		}else { JOptionPane.showInputDialog("Please enter the appropriate text.");
		}
	}
	
	public static void done() {
		JOptionPane.showMessageDialog(null, "Your done");
	}
	
	public static void entry() {
		
		String letter = JOptionPane.showInputDialog(null, "A - Adding Students\n"
				+ "B - Adding Teachers\n"
				+ "C - Adding Vehicles\n"
				+ "D - Adding Classrooms\n"
				+ "E - Adding Subjects\n"
				+ "F - Done");
		
		
		switch (letter) {
		case "A":
		String studentsName = JOptionPane.showInputDialog(null, "Students full name: ");
		String studentAge = JOptionPane.showInputDialog(null, "Age: ");
		String studentCode = JOptionPane.showInputDialog(null, "ID code: ");
		String course = JOptionPane.showInputDialog(null, "Course: ");
		String year = JOptionPane.showInputDialog(null, "Year: ");
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
				
				//pagbuhat ug output statement!!!
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
				
				//pagbuhat ug output statement!!!
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
				if (balik == "YES") {
					entry();
				}else {
					intro();
				}
				
		
			break;
			default: JOptionPane.showMessageDialog(null, "Try again.\nPlease enter the appropriate key.");
				entry();
				
		
		}
	}
}
		
	

