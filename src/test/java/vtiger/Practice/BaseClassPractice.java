package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("Before class");
		
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("Before method");
	}
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite");
	}
	@BeforeTest
	public void btConfig1()
	{
		System.out.println("Before test");
	}
	@AfterClass
	public void acConfig()
	{
		System.out.println("After class");
	}
	@AfterMethod
	public void amConfig()
	{
		System.out.println("After method");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("After suite");
	}
	@AfterTest
	public void atConfig()
	{
		System.out.println("After test");
	}
	@Test
	public void test1() 
	{
		System.out.println("Test1");
	}
}
