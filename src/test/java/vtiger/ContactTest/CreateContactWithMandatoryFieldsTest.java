package vtiger.ContactTest;

import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.ExcelFileLibrary;
import vitiger.GenericUtility.JavaLibrary;
import vitiger.GenericUtility.PropertyFileLibrary;
import vitiger.GenericUtility.WebDriverLibrary;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreatecontactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class CreateContactWithMandatoryFieldsTest {

	public static void main(String[] args) throws IOException {
		//create object of utilities
		JavaLibrary jLib=new JavaLibrary();
		PropertyFileLibrary pLib=new PropertyFileLibrary();
		ExcelFileLibrary eLib=new ExcelFileLibrary();
		WebDriverLibrary wLib=new WebDriverLibrary();
		
		//read all the required data
		String BROWSER = pLib.readFromPropertyFile("browser");
		String URL = pLib.readFromPropertyFile("url");
		String USERNAME = pLib.readFromPropertyFile("username");
		String PASSWORD = pLib.readFromPropertyFile("password");
		
		WebDriver driver=null;
		String LASTNAME = eLib.readFromExcelFile("Contact", 1, 2);
		//launch the browser
		if(BROWSER.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			System.out.println("chrome launched");
		}
		else if(BROWSER.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			System.out.println("firefox launched");
		}
		else
		{
			System.out.println("Invalid browser name");
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		//login to app
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		//navigates to contacts link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		//Navigate to create contact img
		CreatecontactsPage ccp=new CreatecontactsPage(driver);
		ccp.clickOnCreateContactLookUpImg();
		//create contact with mandatory field
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.createNewContact(LASTNAME);
		//validate
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if (contactHeader.contains(LASTNAME)) 
			{
				System.out.println("pass");
			}
		else {
				System.out.println("fail");
			}
		//logout
		hp.signOutOfApp(driver);
		}
		
	}

