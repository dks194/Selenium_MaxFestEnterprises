package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ResetPasswordPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public ResetPasswordPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Reset Password']")
	WebElement resetPasswordText;
	
	public String getTextOfResetPasswordPage() {
		return gl.getTextOfElement(resetPasswordText);
	}
	

}
