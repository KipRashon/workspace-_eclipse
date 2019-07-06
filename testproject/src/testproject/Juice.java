package testproject;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Juice {
	public static void main(String args[]) throws Exception
	{
	XSSFWorkbook workbook= new XSSFWorkbook();
	//create a file system using specific name
	FileOutputStream out= new FileOutputStream(new File("create.xlsx"));
	//write operation using file out object
	workbook.write(out);
	out.close();
	System.out.println("The file was written succesfully");
	}
}
