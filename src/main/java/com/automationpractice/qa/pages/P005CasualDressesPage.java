package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P005CasualDressesPage extends BasePage {

    public P005CasualDressesPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(className = "product-container")
    public WebElement product;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[normalize-space()='More']")
    public WebElement moreButton;

    public String casualDressesPageTitle = "Casual Dresses - My Store";

    public void productAddToCart() {
        scrollToElement(product);
        hover(product);
        addToCartButton.click();
    }

    public void productMore() {
        scrollToElement(product);
        hover(product);
        moreButton.click();
    }
}
