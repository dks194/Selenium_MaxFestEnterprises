package elementRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class DashboardPage {
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	DashboardPage dp;
	WaitUtilities wu = new WaitUtilities();

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//section[@class='content-header']/h1[contains(text(),'Welcome Admin')]")
	WebElement welcomeAdminText;

	@FindBy(xpath = "//span[@class='title' and text()='User Management']")
	WebElement usermanagementTab;

	@FindBy(xpath = "//span[contains(text(),'Users')]")
	WebElement usersTab;

	@FindBy(xpath = "//button[text()='End tour']")
	WebElement endTourPopup;

	@FindBy(id = "view_todays_profit")
	WebElement todayProfitTooltip;
	
	@FindBy(id = "tour_step5_menu")
	WebElement productTab;
	
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/products/create']")
	WebElement addProduct;

	public String getTitleOfDashboardPage() {
		return gl.getTextOfElement(welcomeAdminText);
	}

	public void clickOnUsermanagement() {
		usermanagementTab.click();
	}

	public UsersPage clickOnUsersTab() {
		usersTab.click();
		return new UsersPage(driver);
	}

	public void clickOnEndTourButton() {
		gl.clickOnAnElement(endTourPopup);
	}

	public void mouseHoverToTodaysProfitIcon() {
		gl.mouseHover(driver, todayProfitTooltip);
	}

	public String textInTodaysProfitToolTip() {
		return gl.getAttributeOfAnElement(todayProfitTooltip, "data-original-title");
	}

	public void clickOnProducts() {
		gl.clickOnAnElement(productTab);
	}
	
	public AddProductPage clickOnaddProduct() {
		gl.clickOnAnElement(addProduct);
		return new AddProductPage(driver);
	}

}
