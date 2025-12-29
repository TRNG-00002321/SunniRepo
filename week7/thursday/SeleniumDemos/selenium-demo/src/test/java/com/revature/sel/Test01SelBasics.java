package com.revature.sel;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Basic Selenium Test")
public class Test01SelBasics {

    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setup() {
        // Set up you web driver manager
        // WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        // initialize webdriver
        // driver = new ChromeDriver();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testBasic() throws InterruptedException {

        // Navigate to the website
        driver.get("https:/www.selenium.dev/");
        Thread.sleep(5000);
        // Get the page Title
        String title = driver.getTitle();
        System.out.println("Title: " + title);
    }

    @Test
    public void testBasic01() throws InterruptedException {

        // Navigate to the website
        driver.get("https:/www.selenium.dev/documentation");
        Thread.sleep(5000);
        // Get the page Title
        String url = driver.getCurrentUrl();
        Assertions.assertTrue(url.contains("documentation"));
    }

    @DisplayName("Test By Id")
    @Test
    public void testById() {
        driver.get(BASE_URL + "/login");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        assertTrue(username.isDisplayed());
        assertTrue(password.isDisplayed());
    }

    @DisplayName("Test By Name")
    @Test
    public void testByName() {
        driver.get(BASE_URL + "/login");
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        assertTrue(username.isDisplayed());
        assertTrue(password.isDisplayed());
    }

    @DisplayName("Test By Tag Name")
    @Test
    public void testByTagName() {
        driver.get(BASE_URL + "/login");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        assertEquals("input", inputs.get(0).getTagName());
        assertEquals("input", inputs.get(1).getTagName());
    }

    @DisplayName("Test By Class Name")
    @Test
    public void testByClassName() {
        driver.get(BASE_URL + "/login");
        WebElement element = driver.findElement(By.className("radius"));
        assertEquals("Login", element.getText());
    }

    @DisplayName("Test By Abs Xpath")
    @Test
    public void TetByAbsXpath() {
        driver.get(BASE_URL);
        WebElement element = driver.findElement(By.xpath("/html/body/div[2]/div/h2"));
        assertEquals("Available Examples", element.getText());
    }

    @DisplayName("Test Title By Relavtive XPath")
    @Test
    public void testTitleByRelativeXpath() {
        driver.get(BASE_URL + "/login");
        WebElement element = driver.findElement(By.className("radius"));
        assertEquals("Login", element.getText());
    }

    @Test
    @DisplayName("Complete login form interaction")
    void completeForm_loginFlow() throws InterruptedException {

        driver.get(BASE_URL + "/login");

        // Find elements
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.className("radius"));

        // Verify elements are displayed and enabled
        assertTrue(usernameInput.isDisplayed());
        assertTrue(usernameInput.isEnabled());

        assertTrue(passwordInput.isDisplayed());
        assertTrue(passwordInput.isEnabled());

        assertTrue(loginButton.isDisplayed());
        assertTrue(loginButton.isEnabled());

        // Clear and enter credentials
        usernameInput.clear();
        usernameInput.sendKeys("tomsmith");

        passwordInput.clear();
        passwordInput.sendKeys("SuperSecretPassword!");

        // Verify input values
        assertEquals("tomsmith", usernameInput.getAttribute("value"));
        assertEquals("SuperSecretPassword!", passwordInput.getAttribute("value"));

        // Click login
        loginButton.click();
        // Verify success (check for success message or URL)
        String flashText = driver.findElement(By.xpath("//div[@id ='flash']")).getText();
        assertTrue(flashText.contains("You logged into a secure area!")
                || driver.getCurrentUrl().contains("secure"));
    }

    @DisplayName("Actions API In Action..")
    @Test
    public void actionAPIDemo() throws InterruptedException {
        driver.get(BASE_URL + "/login");
        // Find elements
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        Actions action = new Actions(driver);

        action.click(usernameInput)
                .sendKeys("tomsmith")
                .sendKeys(Keys.TAB)
                .sendKeys("SuperSecretPassword!")
                .click(loginButton)
                .perform();

        Thread.sleep(5000);

    }
}
// What is WebDriver and what is WebDriverManager
