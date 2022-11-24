package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDDT {

	public static void main(String[] args) throws IOException {
		// Read the data from file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String BROWSER = p.getProperty("browser");

		Random r = new Random();
		int RANDOM = r.nextInt();
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contact");
		Row row = sh.getRow(1);
		Cell cel = row.getCell(2);
		String LastNAME = cel.getStringCellValue();
		WebDriver driver = null;
		// launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("===" + BROWSER + "is launched===");
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("===" + BROWSER + "is launched===");
		} else {
			driver = new ChromeDriver();
			System.out.println("default browser launched");
		}

		// login to application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// Navigate to contact
		driver.findElement(By.linkText("Contacts")).click();
		
		// create new contact with mandatory fields
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LastNAME+RANDOM);
		// save
		driver.findElement(By.name("button")).click();
		// logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Organisation created successfully");
		driver.close();
	}

}
