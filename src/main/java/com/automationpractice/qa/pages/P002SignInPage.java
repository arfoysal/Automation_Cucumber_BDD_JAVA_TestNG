package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class P002SignInPage extends BasePage {

    public P002SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }

    final String text = "haha";
    @FindBy(id = text)
    private WebElement emailInputField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email")
    private WebElement emailLoginField;

    @FindBy(id = "passwd")
    private WebElement passwordLoginField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPasswordLink;

    public String signInPageTitle = "Login - My Store";


    public void createAccountWithEmail(String email) {
        sendText(emailInputField, email);
        createAccountButton.click();
    }

    public boolean isForgotPasswordLinkExist() {
        return forgotPasswordLink.isDisplayed();
    }

    public void enterEmailAddress(String email) {
        sendText(emailLoginField, email);
    }

    public void enterPassword(String password) {
        sendText(passwordLoginField, password);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public P004MyAccountPage doSignIn(String email, String password){
        sendText(emailLoginField, email);
        sendText(passwordLoginField, password);
        signInButton.click();
        return new P004MyAccountPage();
    }
}
