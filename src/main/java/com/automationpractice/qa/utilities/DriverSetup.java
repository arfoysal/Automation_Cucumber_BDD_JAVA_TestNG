package com.automationpractice.qa.utilities;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;
import java.util.logging.Level;

public class DriverSetup {
    private static ResourceUtils resource = new ResourceUtils().getResource("config");
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static synchronized void launchBrowser(String browser) {
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        WebDriver webDriver = getBrowser(browser);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(resource.getInteger("wait")));
        setDriver(webDriver);
    }

    public static synchronized void quiteBrowser(Scenario scenario) {
        takeScreenshot(scenario);
        getDriver().quit();
    }

    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    public static WebDriver getBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new RuntimeException("Browser Not Found For This Name: " + browser);
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverSetup.driver.set(driver);
    }
}
