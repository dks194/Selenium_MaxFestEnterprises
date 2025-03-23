package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AddProductPage {

	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id = "name")
	WebElement productNameInput;

	@FindBy(id = "unit_id")
	WebElement unit;

	@FindBy(id = "alert_quantity")
	WebElement alertQuantity;

	@FindBy(id = "barcode_type")
	WebElement barCodeType;

	@FindBy(id = "upload_image")
	WebElement productImage;

	@FindBy(id = "tax_type")
	WebElement taxType;
	
	@FindBy(id = "type")
	WebElement productType;

	@FindBy(id = "single_dpp")
	WebElement excTaxInput;

	@FindBy(id = "single_dpp_inc_tax")
	WebElement incTaxInput;

	@FindBy(xpath = "//button[contains(@class, 'submit_product_form') and text()='Save']")
	WebElement saveButton;
	
	

	public void addProduct(String productName, String quantity,String excTax,String incTax ) {
		productNameInput.sendKeys(productName);
		gl.selectValuesUsingIndex_Dropdown(unit, 3);
		alertQuantity.sendKeys(quantity);
		gl.selectValuesUsingIndex_Dropdown(barCodeType, 2);
		productImage.sendKeys("C:\\Users\\91949\\Downloads\\Selenium-Training-NareshIT");
		gl.selectValuesUsingIndex_Dropdown(taxType, 1);
		gl.selectValuesUsingIndex_Dropdown(productType, 1);
		excTaxInput.sendKeys(excTax);
		incTaxInput.sendKeys(incTax);gl.clickOnAnElement(saveButton);
	}
}
