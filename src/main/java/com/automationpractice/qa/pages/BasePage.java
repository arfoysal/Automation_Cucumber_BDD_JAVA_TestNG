package com.automationpractice.qa.pages;

import java.time.Duration;

import com.automationpractice.qa.utilities.DriverSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends DriverSetup{
	
	/************************
	 * Get Current Page URL * 
	 * **********************
	 */
	public String currentPageUrl() {
		return getDriver().getCurrentUrl();
	}
	
	/**************************
	 * Get Current Page Title * 
	 * ************************
	 */
	public String getTitle() {
		return getDriver().getTitle();
	}
	
	/**************************
	 * Write in a input field 
	 * @param element This is the target element where to write
	 * @param value what to write
	 * ************************
	 */
	public void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	/******************************
	 * Perform Hover on an element 
	 * @param element This is the target element where to perform hover action
	 * ****************************
	 */
	public void hover(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.clickAndHold(element).build().perform();
	}
	
	/*********************************************
	 * Handle Select Tag Related Element Task    *
	 * @param element locator of Select tag      *
	 * @param value attribute value of option tag* 
	 * *******************************************
	 */
	public void selectItem(WebElement element, String value) {
		Select selectItems = new Select(element);
		selectItems.selectByValue(value);
	}

	/*********************************************
	 * Scroll to an element
	 * @param element This is the target element * 
	 * *******************************************
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/********************************************
	 * Wait for completely load current Features.automationpractice.website page*
	 * ******************************************
	 */
	WebDriverWait wait;
	public void waitForPageLoad() {
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
				.executeScript("return document.readyState;").equals("complete"));
	}

}
