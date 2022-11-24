 package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	//Declaration
		@FindBy(xpath="//span[@class='dvHeaderText']")
		private WebElement contactHeaderText;
		
	//Initialization
		public ContactsInfoPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
	//Utilization
		public WebElement getContactHeaderText() {
			return contactHeaderText;
		}
	//Business library
		/**
		 * This method will return header text
		 * @return
		 */
		public String getContactHeader() {
			return contactHeaderText.getText();
		}
}
