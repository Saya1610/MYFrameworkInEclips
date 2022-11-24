package vtiger.Practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContaactWithOrganisation {

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
		//create new organisation with mandatory field
		driver.findElement(By.name("accountname")).sendKeys("Infosys"+random);
		//save 
		driver.findElement(By.name("button")).click();
		System.out.println("Organisation created successfully");
		//navigate to contact create new contact with organisation
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys("1234567890"+random);
		//select org
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		driver.findElement(By.id("search_txt")).click();
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("Aspiders")).click();
		//save 
		driver.findElement(By.name("button")).click();
		//logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Organisation created successfully");
		driver.close();
	}

}
