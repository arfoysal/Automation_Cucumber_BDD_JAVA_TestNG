package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class P001HomePage extends BasePage {
    public P001HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "a[title='Log in to your customer account']")
    public WebElement signInButton;

    @FindBy(xpath = "(//a[@title='Dresses'])[2]")
    public WebElement dressesButton;

    @FindBy(xpath = "(//a[@title='Casual Dresses'])[2]")
    public WebElement casualDressesButton;

    @FindBy(xpath = "(//a[@title='T-shirts'])[2]")
    public WebElement tShirtsButton;
    public String homePageTitle = "My Store";


    public void clickSignInButton() {
        signInButton.click();
    }

    public void hoverAndClickCasualDresses() {
        hover(dressesButton);
        casualDressesButton.click();
    }

    public void clickOnTShirtsButton() {
        tShirtsButton.click();
    }

}
