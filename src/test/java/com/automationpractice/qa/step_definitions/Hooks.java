package com.automationpractice.qa.step_definitions;

import com.automationpractice.qa.utilities.DriverSetup;
import com.automationpractice.qa.utilities.ResourceUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private ResourceUtils resource = new ResourceUtils().getResource("config");
    private String browser = System.getProperty("browser") == null ? resource.getString("browser") : System.getProperty("browser");

    @Before()
    public void launchBrowser() {
        DriverSetup.launchBrowser(browser);
    }

    @After()
    public void quiteBrowser(Scenario scenario) {
        DriverSetup.quiteBrowser(scenario);
    }
}
