package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		//load the file into java stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		//create obj of property file
		Properties p=new Properties();
		//load file in properties
		p.load(fis);
		//read data from property file
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		System.out.println(BROWSER);
		
		WebDriver driver =new ChromeDriver();
		driver.get(URL);
		
	}

}
