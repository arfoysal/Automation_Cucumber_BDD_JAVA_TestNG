package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P006TShirtsPage extends BasePage {

    public P006TShirtsPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(id = "layered_id_attribute_group_14")
    public WebElement filterBlueColorCheckbox;

    @FindBy(className = "product-container")
    public WebElement product;

    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    public WebElement addToCartButton;

    public String t_ShirtsPageTitle = "T-shirts - My Store";

    public void filterBlueColor() {
        filterBlueColorCheckbox.click();

    }

    public void productAddToCart() {
        scrollToElement(product);
        hover(product);
        addToCartButton.click();
    }
}
