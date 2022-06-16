package com.automationpractice.qa.step_definitions;

import com.automationpractice.qa.utilities.DriverSetup;
import com.automationpractice.qa.pages.P002SignInPage;
import com.automationpractice.qa.pages.P004MyAccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class AccountPageSteps {
    private P002SignInPage signInPage = new P002SignInPage();
    private P004MyAccountPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable credTable) {

        List<Map<String, String>> credList = credTable.asMaps();
        String email = credList.get(0).get("email");
        String password = credList.get(0).get("password");

        DriverSetup.getDriver()
                .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        accountsPage = signInPage.doSignIn(email, password);
    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
        String title = accountsPage.getTitle();
        System.out.println("Accounts Page title is: " + title);
    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionsTable) {

        List<String> expAccountSectionsList = sectionsTable.asList();

        System.out.println("Expected accounts section list: " + expAccountSectionsList);

        List<String> actualAccountSectionsList = accountsPage.getAccountsSectionsList();
        System.out.println("Actual accounts section list: " + actualAccountSectionsList);

        Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));

    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(Integer expectedSectionCount) {
        Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
    }

}
