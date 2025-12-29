package com.training.cucumber.hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    private static WebDriver driver;

    /**
     * Runs before each scenario.
     */
    @Before(order = 1)
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * Runs before scenarios tagged with @headless.
     */
    @Before(value = "@headless", order = 0)
    public void setUpHeadless() {
        System.out.println("Configuring headless mode...");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    /**
     * Runs before scenarios tagged with @slow.
     */
    @Before("@slow")
    public void configureSlowTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /**
     * Runs only for scenarios tagged with @database.
     */
    @Before("@database")
    public void setUpDatabase(Scenario scenario) {
        System.out.println("Setting up database for: " + scenario.getName());
        // Integration logic would go here, e.g.:
        // DatabaseUtils.connect();
        // DatabaseUtils.runScript("setup.sql");
    }

    /**
     * Runs only for scenarios tagged with @database.
     */
    @After("@database")
    public void tearDownDatabase(Scenario scenario) {
        System.out.println("Cleaning up database after: " + scenario.getName());
        // DatabaseUtils.close();
    }

    /**
     * Runs for scenarios tagged with @api.
     */
    @Before("@api")
    public void setUpApi() {
        // Example for RestAssured:
        // RestAssured.baseURI = "https://api.example.com";
    }

    /**
     * Runs for scenarios tagged with both @login AND @admin.
     */
    @Before("@login and @admin")
    public void setUpAdminLogin() {
        System.out.println("Setting up admin login context");
        // Logic to set admin credentials or tokens
    }

    /**
     * Runs for scenarios tagged with @login but NOT @admin.
     */
    @Before("@login and not @admin")
    public void setUpRegularLogin() {
        System.out.println("Setting up regular user login context");
        // Logic to set standard user credentials
    }

    /**
     * Runs after each scenario.
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            captureScreenshot(scenario);
        }

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Finished scenario: " + scenario.getName() +
                " - Status: " + scenario.getStatus());
    }

    /**
     * Captures screenshot and attaches to Cucumber report.
     */
    private void captureScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "Screenshot: " + scenario.getName());
    }

    /**
     * Optional: Runs after each step.
     */
    @AfterStep
    public void afterStep(Scenario scenario) {
        // Example: Log the status of each step
        System.out.println("Step finished. Scenario status: " + scenario.getStatus());
    }

    /**
     * Provides access to WebDriver for step definitions.
     */
    public static WebDriver getDriver() {
        return driver;
    }
}
