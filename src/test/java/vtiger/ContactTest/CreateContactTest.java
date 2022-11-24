package vtiger.ContactTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.model.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.BaseClass;
import vitiger.GenericUtility.ExcelFileLibrary;
import vitiger.GenericUtility.JavaLibrary;
import vitiger.GenericUtility.PropertyFileLibrary;
import vitiger.GenericUtility.WebDriverLibrary;
import vtiger.ObjectRepository.ContactsInfoPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreatecontactsPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

@Listeners(vitiger.GenericUtility.ListenerImplementationLibrary.class)

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeSuite")
	public void CreateContactTest() throws IOException // testng script
	{
		// public static void main(String[] args) throws IOException {
		// step1:create object of all library
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		// step2:read all the required data
		String BROWSER = pLib.readFromPropertyFile("browser");
		String URL = pLib.readFromPropertyFile("url");
		String USERNAME = pLib.readFromPropertyFile("username");
		String PASSWORD = pLib.readFromPropertyFile("password");

		String LASTNAME = eLib.readFromExcelFile("Contact", 1, 2) + jLib.getRandomNumber();
		WebDriver driver = null;

		// step3:launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			// WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			Reporter.log("Invalid browser",true);
		}

		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);

		// step 4:Login To Application
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successfully",true);

		// Step 5: Navigate to Contacts Link
		//driver.findElement(By.linkText("Contacts")).click();
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("click on contact link",true);

		// Step 6: Navigate to create Contact Look up image
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		CreatecontactsPage cp=new CreatecontactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("click on contact look up image",true);
		
		// Step 7: create contact with mandatory details and save
		/*
		 * driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 */
		CreateNewContactPage ccp=new CreateNewContactPage(driver);
		ccp.createNewContact(LASTNAME);
		Reporter.log("save contact",true);
		
		// step 8:Validate
		//String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME));
//		if(contactHeader.contains(LASTNAME))
//		{
//			System.out.println("Pass");
//		}
//		else 
//		{
//			System.out.println("Fail");
//		}
		// Step 9: Logout of Application
		/*
		 * WebElement adminImg =
		 * driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 * wLib.mouseHover(driver, adminImg);
		 * driver.findElement(By.linkText("Sign Out")).click();
		 */
		hp.signOutOfApp(driver);
		Reporter.log("logout sucesfull",true);
	}

	@Test(groups = "regressionSuite")
	// @Test(groups= {"smokesuite","regreessionsuite"})
	public void createContactDemo() {
		Reporter.log("demo test",true);
		//Assert.fail();
	}

	@Test
	public void createContactWithLeadSource() {
		Reporter.log("Lead source",true);
		//Assert.fail();
	}

	@Test
	public void createContactWithLeadSourceAndOrg() {
		Reporter.log("Lead source with org",true);
	}
}

