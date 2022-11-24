package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	// declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;

	// Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	// business library
	/**
	 * this method will click on create organisation look up img
	 */
	public void clickOnCreateNewOrgImg() {
		createOrgLookUpImg.click();
	}
}
