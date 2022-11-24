package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindAll({@FindBy(linkText = "Sign Out"),@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")})
	private WebElement signOutLnk;
	
//	Initialization
	public HomePage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
//create getter method
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}

	public WebElement getSignOut() {
		return signOutLnk;
	}
	
//Buisness Library
	/**
	 * this method perform signOut operation
	 * @param driver
	 */
	public void signOutOfApp(WebDriver driver) {
		mouseHover(driver, adminstratorImg);
		signOutLnk.click();
	}
	/**
	 * this method will perform click action on organisation link
	 * @author Shine
	 */
	public void clickOnOrgLink() {
		OrganizationsLnk.click();
	}
	/**
	 * this method will perform click action on contact link
	 */
	public void clickOnContactsLink() {
		ContactLink.click();
	}
	
}

