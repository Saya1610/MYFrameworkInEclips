package vitiger.GenericUtility;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.interfaces.RSAPublicKey;
import java.sql.Driver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contain all generic methods related to webDriver action 
 * @author Shine
 *
 */
public class WebDriverLibrary {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will wait for 20sec to load page
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	/**
	 * This method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));	
	}
	/**
	 * 
	 * This method will wait for element to be clickable
	 * @param driver
	 * @param ele
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement ele) {
		WebDriverWait wait =new WebDriverWait(driver, 10L);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	/**
	 * This is custuome wait used to wait for element and perform click action
	 * @param ele
	 * @throws InterruptedException 
	 */
	public void waitAndClickOnElement(WebElement ele) throws InterruptedException
	{
		int count = 0;
		 while (count<10) 
		{
		try
		{
			ele.click();
			break;
		}
		catch (Exception e) {
			Thread.sleep(1000);
			count++;
		}
		}	
	 }
	/**
	 * This method will perform mousehover on perticuler element
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebDriver driver,WebElement ele) {
		 Actions a=new Actions(driver);
		 a.moveToElement(ele).perform();
	}
	/**
	 * This method will mouseHover using offset value for x and y co-ordinate
	 * @param driver
	 * @param xOff
	 * @param yOff
	 */
	public void mouseHoverOn(WebDriver driver,int xOff,int yOff) {
		 Actions a=new Actions(driver);
		 a.moveByOffset(xOff, yOff);
	}
	/**
	 * this method will perform right-click on the webpage
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * this method will perform rightclick on particular webElement
	 * @param driver
	 * @param ele
	 */
	public void rightClickOn(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	/**
	 * This method will perform doubleclick on WebPage
	 * @param driver
	 * @param ele
	 */
	public void doubleClickOn(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * This method will perform doubleclick on a perticuler webelement
	 * @param driver
	 * @param ele
	 */
	public void doubleClickOn(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	/**
	 * This method will perform draganddrop from src element to dest element
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src,dest).perform();

	}
	/**
	 * This method will handle drop-down through select class and select data by index
	 * @param ele
	 * @param index
	 */
	public void handleDropDown(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	/**
	 * This method will handleDropdown through select class and select data by value
	 * @param ele
	 * @param value
	 */
	public void handleDrpoDown(WebElement ele,String value)
	{
		Select s=new Select(ele);
		s.selectByValue(value);	
	}
	/**
	 * This method will handle drop-down through select class and data by visibleText
	 * @param value
	 * @param ele
	 */
	public void handleDrpoDown(String value,WebElement ele)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(value);	
	}
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method switch to frame based on name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will switch to frame based on element
	 * @param driver
	 * @param element
	 */
	public void SwitchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will switch from current frame to immediate parent 
	 * @param driver
	 * @param element
	 */
	public void SwitchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch from current fame to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will click in alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will click on cancel in alert popup
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will return the text of alert pop up to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	/**
	 * this methos will press enter key
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will switch from parent window to any child window or from any child window
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//Step 1: get all the window handles
		Set<String> windowIds = driver.getWindowHandles();
		
		//Step 2: iterate through all the window ids --- similar to foreach loop
		Iterator<String> it = windowIds.iterator();
		
		//Step 3: navigate to each window and check the title
		while(it.hasNext())
		{
			//Step 4: capture the individual window id
			String winID = it.next();
			
			//Step 5: switch to that window and capture the title
			String currentTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 6: compare current title with partial title
			if(currentTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
		
	}
	/**
	 * this method taking screenshot
	 * @param driver
	 * @param screenshotname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver,String screenshotname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Ram = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(".\\Screenshot\\"+screenshotname+".png");//last "//" for folder
		FileUtils.copyFile(Ram, dest);//from commens io
		return dest.getAbsolutePath();//used for extends reports
	}
	/**
	 * This method will scroll down for 500 units
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	/**
	 * This method will scroll untill the specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", element);//arg[o] 1st scrollbar take
		
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
}

