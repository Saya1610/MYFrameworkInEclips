package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverLibrary;

public class OrganizationsInfopage {
	//declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement OrgHeaderText;
		
		//initialize 
		public OrganizationsInfopage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		//utilization

		public WebElement getOrgHeaderText() {
			return OrgHeaderText;
		}
		//buisness library
		/**
		 * This method will get the header text for organization
		 * @author Shine
		 */
		public String getOrgHeader() {
			String orgHeader = OrgHeaderText.getText();
			return orgHeader;
		}
}
