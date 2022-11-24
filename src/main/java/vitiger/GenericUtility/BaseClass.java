package vitiger.GenericUtility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This is a generic class which consists of all basic configuration annotations
 * 
 * @author Chaitra M
 *
 */
public class BaseClass {

	public PropertyFileLibrary pLib = new PropertyFileLibrary();
	public ExcelFileLibrary eLib = new ExcelFileLibrary();
	public JavaLibrary jLib = new JavaLibrary();
	public WebDriverLibrary wLib = new WebDriverLibrary();
	public WebDriver driver = null;
	public static WebDriver sDriver = null;

	@BeforeSuite(groups = { "smokeSuite", "regressionSuite" })
	public void bsConfig() {
		System.out.println("--- database connected successfully ---");
	}

	// @Parameter
	// @BeforeTest
	@BeforeClass(groups = { "smokeSuite", "regressionSuite" })
	public void bcConfig(/* String BROWSER */) throws IOException {
		String BROWSER = pLib.readFromPropertyFile("browser");
		String URL = pLib.readFromPropertyFile("url");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("--- Browser launched successfully -> " + BROWSER + " ---");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("--- Browser launched successfully -> " + BROWSER + " ---");
		} else {
			System.out.println("invalid browser name");
		}
		sDriver = driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);

	}

	@BeforeMethod(groups = { "smokeSuite", "regressionSuite" })
	public void bmConfig() throws IOException {
		String USERNAME = pLib.readFromPropertyFile("username");
		String PASSWORD = pLib.readFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println(" --- login is successfull ---");
	}

	@AfterMethod(groups = { "smokeSuite", "regressionSuite" })
	public void amConfig() {
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		System.out.println("--- Logout successfull ---");
	}

	@AfterClass(groups = { "smokeSuite", "regressionSuite" })
	public void acConfig() {
		driver.quit();
		System.out.println("--- browser closed successfully ---");
	}

	@AfterSuite(groups = { "smokeSuite", "regressionSuite" })
	public void asConfig() {
		System.out.println("--- database closed successfully ---");
	}

}
