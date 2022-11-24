package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {
	//Declaration
		@FindBy(name="lastname")
		private WebElement ContactNameEdt;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@title='Select']")
		private WebElement orgNameLookUpImg;
		
		@FindBy(name="search_text")
		private WebElement searchBoxEdt;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		@FindBy(name = "leadsource")
		private WebElement leadsourseDropdown;
		
		@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
		private WebElement saveBtn;
		
		//Initialization
		public CreateNewContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		//utilization

		public WebElement getContactNameEdt() {
			return ContactNameEdt;
		}

		public WebElement getOrgNameLookUpImg() {
			return orgNameLookUpImg;
		}

		public WebElement getSearchBoxEdt() {
			return searchBoxEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}

		public WebElement getLeadsourseDropdown() {
			return leadsourseDropdown;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		//Business library
		/**
		 * This method will create a contact using mandatory fields and save
		 * @param lastname
		 */
		public void createNewContact(String lastname) {
			ContactNameEdt.sendKeys(lastname);
			saveBtn.click();
		}
		/**
		 * this method will create contact with contact name and lead source dropdown
		 * @param laStname
		 * @param leadsourceType
		 */
		public void createNewContact(String laStname,String leadsourceType) {
			ContactNameEdt.sendKeys(laStname);
			handleDrpoDown(leadsourceType, leadsourseDropdown);
			saveBtn.click();
		}
		/**
		 * this method will create contact with last name and organization name
		 * @param lastname
		 * @param orgname
		 * @param driver
		 */
		public void createNewContact(String lastname,String orgname,WebDriver driver) {
			ContactNameEdt.sendKeys(lastname);
			orgNameLookUpImg.click();
			switchToFrame(driver, "Accounts");
			searchBoxEdt.sendKeys(orgname);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgname+"']"));//dynamic xpath 
			switchToWindow(driver, "Contacts");
			saveBtn.click();
		}
}
