package elementRepository;

import java.util.Locale;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import utilities.GeneralUtilities;
import utilities.RandomAccessUtilities;
import utilities.WaitUtilities;

public class UsersPage {
	WebDriver driver;
	UsersPage up;
	GeneralUtilities gl = new GeneralUtilities();
	WaitUtilities waitElement = new WaitUtilities();

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Users') ]")///small[contains(text(),'Manage users')]
	WebElement usersPageHeading;
	
	@FindBy(css = "a[href='https://qalegend.com/billing/public/users/create']")
	WebElement addUsers;
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "email")
	WebElement emailid;
	
	@FindBy(id = "role")
	WebElement roleDropdown;
	
	@FindBy(id = "password")
	WebElement passwordBox;
	
	@FindBy(id = "confirm_password")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//div[@class='icheckbox_square-blue']")
	WebElement isActiveCheckbox;
	
	@FindBy(id = "submit_user_button")
	WebElement saveButton;
	
	@FindBy(css = "input[type='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[4]")
	WebElement searchedEmail;
	
	@FindBy(id = "first_name-error")
	WebElement firstNameError;
	
	@FindBy(css = ".delete_user_button")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[text()='OK']")
	WebElement deleteButtonConfirmationPopup;
	
	@FindBy(xpath = "//table/tbody/tr/td[text()='No matching records found']")
	WebElement NoMatchingRecordMessage;
	
	@FindBy(xpath = "//div[text()='Are you sure ?']")
	WebElement deletePopupText;

	@FindBy(xpath = "//table/tbody/tr/td[5]/a[1]")
	WebElement editButton;
	
	@FindBy(xpath = "//h1[text()='Edit user']")
	WebElement editUserPageHeading;
	
	@FindBy(id = "last_name")
	WebElement editLastNameTextBox;
	
	@FindBy(id = "submit_user_button")
	WebElement updateButton;
	
	@FindBy(xpath = "//table[@id='users_table']/tbody/tr/td[2]")
	WebElement nameAfterEditing;
	
	public String getHeadingOfUsersPage() {
		return gl.getTextOfElement(usersPageHeading);
	}
	
	public void AddUser(String firstname,String email,String password) {
		gl.clickOnAnElement(addUsers);
		firstName.sendKeys(firstname);
		emailid.sendKeys(email);
		gl.selectValuesUsingIndex_Dropdown(roleDropdown, 1);
		passwordBox.sendKeys(password);
		confirmPassword.sendKeys(password);
		gl.clickOnAnElement(saveButton);	
		waitElement.waitForElementToBeVisibleByElement(searchField, 10);
		searchField.sendKeys(firstname);
		gl.keyDown(driver, Keys.ENTER);
		gl.keyUp(driver, Keys.ENTER);
	}
	
	public void mandatoryErrorInfirstname(String email,String password) {
		gl.clickOnAnElement(addUsers);
		emailid.sendKeys(email);
		gl.selectValuesUsingIndex_Dropdown(roleDropdown, 1);
		passwordBox.sendKeys(password);
		confirmPassword.sendKeys(password);
		gl.clickOnAnElement(saveButton);
	}
	
	public String firstNameErrorMessage() {
		return gl.getTextOfElement(firstNameError);
	}
	
	public String searchEmailText() {
		return gl.getTextOfElement(searchedEmail);
	}
	
	public boolean checkboxStatus() {
		return gl.isElementEnabled(isActiveCheckbox);
	}
	
	public void clickOnAddButton() {
		gl.clickOnAnElement(addUsers);
	}
	
	public void clickOnDeleteButton() {
		gl.clickOnAnElement(deleteButton);
	}
	
	public void clickOnDeleteButtonConfirmationPopup() {
		gl.clickOnAnElement(deleteButtonConfirmationPopup);
	}
	
	public String messageAfterDeletingUser() {
		return gl.getTextOfElement(NoMatchingRecordMessage);
	}
	 
	public String deletePopupText() {
		return gl.getTextOfElement(deletePopupText);
	}
	
	public void clickOnEditButton() {
		gl.clickOnAnElement(editButton);
	}
	
	public String getEditUserPageHeading() {
		return gl.getTextOfElement(editUserPageHeading);
	}
	
	public void editlastName(String lastname) {
		 editLastNameTextBox.sendKeys(lastname);
		 
	}
	
	public void clickUpdateButton() {
		gl.clickOnAnElement(updateButton);
	}
	
	public void searchUpdatedUser(String name) {
		waitElement.waitForElementToBeVisibleByElement(searchField, 10);
		searchField.sendKeys(name);
	}
	
	public String getUpdatedName() {
		return gl.getTextOfElement(nameAfterEditing);
	}
}
