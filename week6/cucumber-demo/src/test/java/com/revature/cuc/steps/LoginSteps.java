package com.revature.cuc.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginSteps {
    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/login";

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @After
    public void teardown() {
        if (driver != null)
            driver.quit();
    }



    @Given("the application is running")
    public void theApplicationIsRunning() {
        assertTrue(driver.getTitle().contains("The Internet"));
    }

    @And("the test database is already seeded with users")
    public void theTestDatabaseIsAlreadySeededWithUsers() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("the test database is already seeded with users");
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        assertTrue(driver.getTitle().contains("The Internet"));
    }

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    @And("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("the user should be redirected to the secure area")
    public void theUserShouldBeRedirectedToTheSecureArea() {
        String flashMessage = driver.findElement(By.id("flash")).getText();
        assertTrue(flashMessage.contains("secure area"));
    }

    @And("the page should display a message containing {string}")
    public void thePageShouldDisplayAMessageContaining(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("the page should display a message containing " + string);
    }
}
