package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vitiger.GenericUtility.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary{

	//Declaration
@FindBy(name="accountname")
private WebElement orgNameEdt;

@FindBy(name="industry")
private WebElement industryDropdown;

@FindBy(name = "accounttype")
private WebElement typeDropdown;

@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
private WebElement saveBtn;

//Initialization
public CreateNewOrganizationPage(WebDriver driver){
PageFactory.initElements(driver, this);	
}
//utilization

public WebElement getOrgName() {
	return orgNameEdt;
}

public WebElement getIndustryDropdown() {
	return industryDropdown;
}

public WebElement getTypeDropdown() {
	return typeDropdown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
//Buisness Library
/**
 * this method will create organization with org name
 * @param Orgname
 */
public void createNewOrg(String OrgName) {
	orgNameEdt.sendKeys(OrgName);
	saveBtn.click();
}
/**
 * this method will handle the create org with industry dropdown
 * @param OrgName
 * @param induStryType
 */
public void createNewOrg(String OrgName,String induStryType) {
	orgNameEdt.sendKeys(OrgName);
	handleDrpoDown(induStryType, industryDropdown);
	saveBtn.click();
}
/**
 * this method will create org with type and industry dropdown
 * @param OrgName
 * @param IndustryType
 * @param type
 */
public void createOrg(String OrgName,String IndustryType,String type) {
	orgNameEdt.sendKeys(OrgName);
	handleDrpoDown(IndustryType, industryDropdown);
	handleDrpoDown(type, industryDropdown);
	saveBtn.click();
}
}
