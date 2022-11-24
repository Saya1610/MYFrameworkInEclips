package vtiger.Practice;

import java.io.IOException;

import vitiger.GenericUtility.ExcelFileLibrary;
import vitiger.GenericUtility.JavaLibrary;
import vitiger.GenericUtility.PropertyFileLibrary;

public class GenericMetodPractice {

	public static void main(String[] args) throws IOException {
		JavaLibrary jlib=new JavaLibrary();
		String date = jlib.getSystemDate();//current date
		System.out.println(date);
		
		String dateInFormat = jlib.getSystemDateInFormat();
		System.out.println(dateInFormat);
		
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		String value = pLib.readFromPropertyFile("browser");
		System.out.println(value);
		
		ExcelFileLibrary eLib=new ExcelFileLibrary();
		String val = eLib.readFromExcelFile("Organization", 1, 2);
		System.out.println(val);
		
		int count = eLib.getRowCount("Contact");
		System.out.println(count);
		
		eLib.writeDataIntoExcel("Organization", 1, 6, "sayali");
	}

}
