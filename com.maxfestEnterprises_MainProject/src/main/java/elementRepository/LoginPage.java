package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	WebElement userNameTextBox;
	
	@FindBy(id = "password")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement rememberMeCheckbox;
	
	@FindBy(css = "button[type='submit']")
	WebElement loginButton;
	
	@FindBy(css = "a[href='https://qalegend.com/billing/public/password/reset']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//div[contains(@class,'panel-heading') and text()= 'Login']")
	WebElement loginText;
	
	@FindBy(xpath = "//strong[text()='These credentials do not match our records.']")
	WebElement errorMessageForIncorrectCredentials;
	
	
	public String getTextOfLogin() {
		return gl.getTextOfElement(loginText);
	}
	
	public DashboardPage login(String username,String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginButton.click();
		return new DashboardPage(driver);
		
		
	}
	
	public String getTextOfErrorMesage() {
		return gl.getTextOfElement(errorMessageForIncorrectCredentials);
	}
	
	public ResetPasswordPage clickOnForgotPasswordLink() {
		gl.clickOnAnElement(forgotPasswordLink);
		return new ResetPasswordPage(driver);
	}
	
}
