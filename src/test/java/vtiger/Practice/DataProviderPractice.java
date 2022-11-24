package vtiger.Practice;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vitiger.GenericUtility.ExcelFileLibrary;


/*public class DataProviderPractice {
@Test(dataProvider = "getData")
public void addProductToCartTest(String name,String model,int price,int qty)
{
	System.out.println("phone name= "+name+"model= "+model+"price= "+price+"quantity= "+qty);
}

@DataProvider
public Object[][] getData()
{
	Object[][] d = new Object[3][4];
	
	d[0][0]="samsung";
	d[0][1]="A80";
	d[0][2]="2500";
	d[0][3]="10";
	
	d[1][0]="Iphone";
	d[1][1]="11pro";
	d[1][2]="5000";
	d[1][3]="5";
	
	d[2][0]="vivo";
	d[2][1]="Y21";
	d[2][2]="1000";
	d[2][3]="15";
	
	return d;
	
}
}*/
public class DataProviderPractice {
	
/*	@Test(dataProvider = "getData")
	public void addProductToCartTest(String name,String model, int price,String feature, int qty)
	{
		System.out.println(name+"-"+model+"-"+price+"-"+feature+"-"+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{                            //row //columns
		Object[][] d = new Object[4][5];
		
		d[0][0] = "samsung";
		d[0][1] = "A80";
		d[0][2] = 3000;
		d[0][3] = "Camera";
		d[0][4] = 12;
		
		d[1][0] = "Vivo";
		d[1][1] = "A8";
		d[1][2] = 300;
		d[1][3] = "Camera";
		d[1][4] = 10;
		
		d[2][0] = "Oppo";
		d[2][1] = "V1";
		d[2][2] = 30000;
		d[2][3] = "Security";
		d[2][4] = 12;
		
		d[3][0] = "iphone";
		d[3][1] = "13Pro";
		d[3][2] = 30009;
		d[3][3] = "Secure";
		d[3][4] = 15;
		
		return d;
 	}*/
	
///////////////////////////////////////
	/****read from excel***/
	@Test(dataProvider = "OrgName")
	public void addProductToCartTest(String Orgname,String IndusrtyType)
	{
		System.out.println(Orgname+"-"+IndusrtyType);
	}
	@DataProvider(name="OrgName")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelFileLibrary eUtil=new ExcelFileLibrary();
		Object[][] data = eUtil.readMultipleData("MultipleOrg");
		return data;
	}
	
}
