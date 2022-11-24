package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
//rule1:Create a separate class for every page
public class LoginPage {

//rule2:Identify the ele using @FindBy,@FindBys,@FindBys
	//declaration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
//rule3: create a constructor to initialize
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//rule4:provide getters to access the element
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * this method will login to app with username and password
	 * @author Shine
	 * @param username
	 * @param password
	 */
	//step5:Business library
	public void loginToApp(String username,String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}	
}

