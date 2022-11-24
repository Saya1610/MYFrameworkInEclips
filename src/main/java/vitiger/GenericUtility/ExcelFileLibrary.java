package vitiger.GenericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class contain read and write data from excelsheet
 * @author Shine
 *
 */

public class ExcelFileLibrary {
	/**
	 * this method will read the data from excelsheet for the sheet name,row num,cell num given by user
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readFromExcelFile(String sheet,int row,int cel) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheet);
	Row r = sh.getRow(row);
	Cell ce = r.getCell(cel);
	String value = ce.getStringCellValue();
	return value;
}
	/**
	 * This method will give last row number utilized in sheet to know how many rows excel file contain
	 * @param sheetName
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
/**
 * This method will write data into excel for user specified row num,cel num,sheet name
 * @param sheetName
 * @param row
 * @param cel
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.createCell(cel);
		c.setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(IConstantLibrary.excelFilePath);
		wb.write(fos);
		wb.close();
		System.out.println("data write succesfully");
	}
	/**
	 * This method will read all the data present in the particular sheet
	 * @param sheetName
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IConstantLibrary.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastcell = sh.getRow(0).getLastCellNum();//we cant directly go to last cell num so we go thr get row num
		
		Object[][] data=new Object[lastRow][lastcell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();//avoid header i.e Org name and Industry by adding 1 i.e i+1
			}
		}
		return data;
	}
	
}
