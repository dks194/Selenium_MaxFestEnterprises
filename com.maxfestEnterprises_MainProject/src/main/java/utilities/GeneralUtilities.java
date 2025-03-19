package utilities;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public String getAttributeOfAnElement(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	

	
	public String getCSSValueOfAnElemnt(WebElement element, String propertyName) {
		return element.getCssValue(propertyName);
	}

	public void clickOnAnElement(WebElement element) {
		element.click();
	}

	// javascriptExecutor click
	public void clickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	// javascriptExecutor scrollIntoView
	public void scrollIntoViewUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	// To hover mouse
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// Drag and drop
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// keyDown for any key
	public void keyDown(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	// KeyUp
	public void keyUp(WebDriver driver, Keys key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key).perform();
	}

	// doubleClick
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		 actions.doubleClick(element).perform();

	}
	public void leftclick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}
	
	

	// fileupload using sendkeys
	public void fileUpload(WebElement element, String filePath) {
		element.sendKeys(filePath);
	}

	// DropDown
	// Select by index
	public void selectValuesUsingIndex_Dropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void deSelectDropdownValueByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	// Select by value
	public void selectValuesUsingValue_Dropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void deSelectDropdownValueByValue(WebElement element,String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	

	// Select by visible text
	public void selectValuesUsingVisibleText_Dropdown(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void deSelectDropdownValueByVisibleText(WebElement element,String visibleText) {
		Select select = new Select(element);
		select.deselectByVisibleText(visibleText);
	}

	public void deSelectAllDropdownValues(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();;
	}
	// Dropdown is mutliselect or not

	public boolean isMultiselectDropdown(WebElement element) { 
		Select select = new Select(element);
		return select.isMultiple();
	}
		
		

	// get first selected option
	public String getFirstSelectedOption(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	// getAllSelectedOption
	public List<String> getAllSelectedOptions(WebElement element) {
		Select select = new Select(element);
		// using a stream method
		return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	// getAllOptions
	public List<String> getAllOptions(WebElement element) {
		Select select = new Select(element);
		// using a stream method
		return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
	}

	// Alert accept
	public void alert_Accept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	// Alert dismiss
	public void alert_Dismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	// Alert getText
	public String alert_getText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	// Alert sendKeys
	public void alert_sendKeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// SwitchTo Frames-by index
	public void switchToFrames_ByIndex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	// SwitchTo Frames-by webElement
	public void switchToFrames_ByWebElement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	// SwitchTo Frames-by id/name
	public void switchToFrame_ByNameOrID(WebDriver driver,String NameOrID) {
		driver.switchTo().frame(NameOrID);		
	}
	// SwitchBack to from frame to main page
	public void switchBackToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();		
	}
	
	public void switchBackToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();		
	}
	
	
	public String getParenetWindowhandle(WebDriver driver) {
		return driver.getWindowHandle();
		
	}
	
	public Set<String> getAllWindowhandles(WebDriver driver) {
		return driver.getWindowHandles();
	}
	
	public void switchToWindowhandle(WebDriver driver,String windowhandle) {
		driver.switchTo().window(windowhandle);
	}
	

	// Thread.sleep()
	public void threadSleep(long timeout) throws InterruptedException {
		Thread.sleep(timeout);

	}

}
