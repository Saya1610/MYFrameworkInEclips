package vtiger.organisationTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vitiger.GenericUtility.ExcelFileLibrary;
import vitiger.GenericUtility.JavaLibrary;
import vitiger.GenericUtility.PropertyFileLibrary;
import vitiger.GenericUtility.WebDriverLibrary;

/**
 * @author Shine
 *
 */
public class CreateMultipleOrganizationWithIndustryTest {
	ExcelFileLibrary eLib = new ExcelFileLibrary();
	@Test(dataProvider = "MultilpeOrganization")
	//@Test
	public void createMultipleOrgTest(String OrgName, String IndustryType) throws IOException {
		// step 1: create object of all library
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		//ExcelFileLibrary eLib = new ExcelFileLibrary();
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
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println("Organization created succesfully");
		} else {
			System.out.println("Organization not created");
		}
		// Step 9: Logout of Application
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, adminImg);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

	 @DataProvider(name = "MultilpeOrganization")
	 public Object[][] getData() throws EncryptedDocumentException, IOException 
	 { Object[][] data =eLib.readMultipleData("MultilpeOrganization");
	 return data; }
	 
}
