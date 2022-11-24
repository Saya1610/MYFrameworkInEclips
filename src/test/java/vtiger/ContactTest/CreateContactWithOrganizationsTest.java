package vtiger.ContactTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.BaseClass;
import vitiger.GenericUtility.ExcelFileLibrary;
import vitiger.GenericUtility.JavaLibrary;
import vitiger.GenericUtility.PropertyFileLibrary;
import vitiger.GenericUtility.WebDriverLibrary;

public class CreateContactWithOrganizationsTest extends BaseClass{
	
	@Test(groups="regressionSuite")
	public void CreateContactWithOrganizationsTest() throws IOException
	{
	//public static void main(String[] args) throws IOException {
		// step 1: create object of all library
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();

		// step 2: read all required data
		String BROWSER = pLib.readFromPropertyFile("browser");
		String URL = pLib.readFromPropertyFile("url");
		String USERNAME = pLib.readFromPropertyFile("username");
		String PASSWORD = pLib.readFromPropertyFile("password");

		String LASTNAME = eLib.readFromExcelFile("Contact", 4, 2) + jLib.getRandomNumber();
		String ORGNAME = eLib.readFromExcelFile("Contact", 4, 3) + jLib.getRandomNumber();
		WebDriver driver = null;

		// step 3:launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			 WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser name");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);

		// step 4:Login To Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// step 5:navigate to organization
		driver.findElement(By.linkText("Organizations")).click();
		// navigate to create organization lookup image
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// enter org name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		// save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		// validate organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME),"Organization created");
//		if (OrgHeader.contains(ORGNAME)) {
//			System.out.println("Organization created succesfully");
//		} else {
//			System.out.println("Organization not created");
//		}
		// Step 5: Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 6: Navigate to create Contact Look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 7: create contact with mandatory details
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath(" //input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		
		// switch to window
		wLib.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		wLib.switchToWindow(driver, "Contacts");
		
		// save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// step 8:Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(contactHeader);
		Assert.assertTrue(contactHeader.contains(LASTNAME),"contact created");
//		if (contactHeader.contains(LASTNAME)) {
//			System.out.println("Contact created");
//		} else {
//			System.out.println("contact creation Fail");
//		}
		
		// Step 9: Logout of Application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
