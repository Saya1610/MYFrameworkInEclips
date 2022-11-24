package vtiger.ContactTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.ExcelFileLibrary;
import vitiger.GenericUtility.JavaLibrary;
import vitiger.GenericUtility.PropertyFileLibrary;
import vitiger.GenericUtility.WebDriverLibrary;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.CreatecontactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfopage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException {
		// create object of utilities
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		// read all the required data
		String BROWSER = pLib.readFromPropertyFile("browser");
		String URL = pLib.readFromPropertyFile("url");
		String USERNAME = pLib.readFromPropertyFile("username");
		String PASSWORD = pLib.readFromPropertyFile("password");

		WebDriver driver = null;
		String LASTNAME = eLib.readFromExcelFile("Contact", 1, 2);
		String ORGNAME = eLib.readFromExcelFile("Contact", 4, 3)+jLib.getRandomNumber();
		// launch the browser
		if (BROWSER.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.out.println("chrome launched");
		} else if (BROWSER.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.out.println("firefox launched");
		} else {
			System.out.println("Invalid browser name");
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		// login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		//navigate to org link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLink();
		//navigate to create org img
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateNewOrgImg();
		//create org with mandatory field
		CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
		cop.createNewOrg(ORGNAME);
		//navigate
		OrganizationsInfopage oip=new OrganizationsInfopage(driver);
		String OrgHeader = oip.getOrgHeader();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
		}
		else {
			System.out.println("fail");
		}
		//navigate to contacts link
		hp.clickOnContactsLink();
		//navigate to create contacts img
		CreatecontactsPage cp=new CreatecontactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		//create contact with org details
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME,ORGNAME,driver);
		
		//validate
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		//logout
		hp.signOutOfApp(driver);
		//
	}

}
