package com.automationpractice.qa.step_definitions;

import com.automationpractice.qa.utilities.DriverSetup;
import com.automationpractice.qa.pages.P002SignInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginPageSteps {
    private P002SignInPage signInPage = new P002SignInPage();
    private String title ;
    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverSetup.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = signInPage.getTitle();
        System.out.println("Login Page Title: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        Assert.assertTrue(title.contains(expectedTitle));

    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
        Assert.assertTrue(signInPage.isForgotPasswordLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String emailAddress) {
        signInPage.enterEmailAddress(emailAddress);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        signInPage.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        signInPage.clickOnSignInButton();

    }

}
