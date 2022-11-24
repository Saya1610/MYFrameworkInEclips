package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverLibrary;

public class CreatecontactsPage extends WebDriverLibrary {
	//declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement createContactLookUpImg;
		
	//Initialization
		public CreatecontactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	//utilization

		public WebElement getCreateContactLookUpImg() {
			return createContactLookUpImg;
		}
	//Buisness library
		
		public void clickOnCreateContactLookUpImg() {
			createContactLookUpImg.click();
		}	
}
