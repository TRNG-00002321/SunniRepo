package com.revature.cucumber.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        // TODO: Implement this step
        // 1. Set up WebDriverManager for Chrome
        // 2. Initialize ChromeDriver
        // 3. Navigate to login page

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/login");
    }

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        // TODO: Implement this step
        // Find username field and enter the provided username

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

    }

    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        // TODO: Implement this step
        // Find password field and enter the provided password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        // TODO: Implement this step
        // Find and click the login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
    }

    @Then("the user should be redirected to the secure area")
    public void theUserShouldBeRedirectedToTheSecureArea() {
        // TODO: Implement this step
        // Verify the URL contains "/secure"
        assertTrue(driver.getCurrentUrl().contains("/secure"),
                "User was not redirected to secure area");
    }

    @Then("the user should see a success message containing {string}")
    public void theUserShouldSeeSuccessMessageContaining(String expectedMessage) {
        // TODO: Implement this step
        // Find the flash message element and verify it contains expected text
        WebElement flash = driver.findElement(By.id("flash"));
        String flashMessage = flash.getText();
        assertTrue(flashMessage.contains("You logged into a secure area!"));
    }

    @Then("the user should remain on the login page")
    public void theUserShouldRemainOnTheLoginPage() {
        // TODO: Implement this step
        // Verify URL still contains "/login"
        assertTrue(driver.getCurrentUrl().contains("/login"),
                "User was redirected away from login page");
    }

    @Then("the user should see an error message containing {string}")
    public void theUserShouldSeeErrorMessageContaining(String expectedMessage) {
        // TODO: Implement this step
        // Find the flash message element and verify it contains expected error
        WebElement flash = driver.findElement(By.id("flash"));
        String flashMessage = flash.getText();
        assertTrue(flashMessage.contains(expectedMessage));
    }
}
