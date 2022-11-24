package vtiger.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;

public class PomPracticeLogin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("http://localhost:8888/");
		
		LoginPage lp=new LoginPage(driver);
		lp.getUsernameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getLoginBtn().click();
		
		

	}

}
