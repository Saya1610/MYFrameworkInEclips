package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFilePractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:read the file and load file input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		//step2:Create workbook factory
		Workbook wb = WorkbookFactory.create(fis);
		//step3:navigate to sheet
		Sheet sh = wb.getSheet("Contact");
		//step4:navigate to required row inside sheet
		Row r = sh.getRow(1);
		//step5:navigate to required cell inside sheet
		Cell ce = r.getCell(2);
		//step6:read the value present in that cell
		String value = ce.getStringCellValue();
		System.out.println(value);
		
		
		//step3:navigate to sheet
				Sheet shet = wb.getSheet("Contact");
				//step4:navigate to required row inside sheet
				Row row = shet.getRow(4);
				//step5:navigate to required cell inside sheet
				Cell cel = row.getCell(3);
				//step6:read the value present in that cell
				String val = cel.getStringCellValue();
				System.out.println(val);
	}

}
