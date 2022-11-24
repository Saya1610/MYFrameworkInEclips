package vtiger.Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrganisationWithIndustryTypeTest {

	public static void main(String[] args) {
		Random r=new Random();
		int random = r.nextInt();
		//launch the browser
		WebDriver driver=new ChromeDriver();
		//login to app
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//navigate to organisation
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//create new organisation with industry type Healthcare
		driver.findElement(By.name("accountname")).sendKeys("spiders"+random);
		WebElement dropdown = driver.findElement(By.name("industry"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Healthcare");
		//save 
		driver.findElement(By.name("button")).click();
		//logout
		 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Organisation created with healthacer dropdown successfully");
				driver.close();
	}

}
