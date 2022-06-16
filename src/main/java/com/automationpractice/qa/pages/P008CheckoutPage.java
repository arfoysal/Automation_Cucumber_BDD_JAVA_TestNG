package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P008CheckoutPage extends BasePage {

    public P008CheckoutPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    public WebElement SummaryProceedToCheckoutButton;

    @FindBy(name = "message")
    public WebElement commentField;

    @FindBy(css = "button[name='processAddress'] span")
    public WebElement addressProceedToCheckoutButton;

    @FindBy(id = "cgv")
    public WebElement termsOfServiceCheckbox;

    @FindBy(css = "button[name='processCarrier'] span")
    public WebElement shippingProceedToCheckoutButton;

    @FindBy(css = "a[title='Pay by check.']")
    public WebElement payByCheck;

    @FindBy(xpath = "//span[normalize-space()='I confirm my order']")
    public WebElement confirmMyOrderButton;

    public String checkoutpageTitle = "Order - My Store";

    public void clickSummaryProceedToCheckout() {
        scrollToElement(SummaryProceedToCheckoutButton);
        SummaryProceedToCheckoutButton.click();

    }

    public void addCommentAndProceedToCheckout(String comment) {
        scrollToElement(addressProceedToCheckoutButton);
        sendText(commentField, comment);
        addressProceedToCheckoutButton.click();

    }

    public void checkTOSAndProceedToCheckout() {
        scrollToElement(shippingProceedToCheckoutButton);
        termsOfServiceCheckbox.click();
        shippingProceedToCheckoutButton.click();

    }

    public void clickPaybyCheque() {
        scrollToElement(payByCheck);
        payByCheck.click();

    }

    public void clickConfirmOrder() {
        confirmMyOrderButton.click();

    }
}
