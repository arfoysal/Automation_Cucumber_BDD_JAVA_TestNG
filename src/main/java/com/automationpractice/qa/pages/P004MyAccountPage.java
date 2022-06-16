package com.automationpractice.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class P004MyAccountPage extends BasePage {

    public P004MyAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(css = "a[title='Log me out']")
    private WebElement signOutButton;

    @FindBy(css = "a[title='View my customer account'] span")
    private WebElement userName;

    @FindBy(css = "div#center_column span")
    private List<WebElement> accountSections;


    public void clickSignOutButton() {
        signOutButton.click();
    }

    public int getAccountsSectionCount() {
        return accountSections.size();
    }

    public List<String> getAccountsSectionsList() {
        List<String> accountsList = new ArrayList<>();
        for (WebElement e : accountSections) {
            accountsList.add(e.getText());
        }
        return accountsList;
    }
}
