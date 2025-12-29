package com.revature.sel;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Basic Selenium Test")
public class Test02Waits {

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
    void without_wait() {
        driver.get(BASE_URL + "/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement result = driver.findElement(By.id("finish"));
        assertEquals("Hello World!", result.getText());
    }

    @DisplayName("Test Implicit Wait")
    @Test
    void testImplicitWait() {
        // Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((10)));
        try {
            driver.get(BASE_URL + "/dynamic_loading/1");

            driver.findElement(By.xpath("//button[text()='Start']")).click();

            WebElement result = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/h4[1]"));
            assertTrue(result.isEnabled());
            String text = result.getText();
            assertTrue(text.contains("Hello World!"));
        } finally {
        }
    }

    @DisplayName("Testing Explicit Waits")
    @Test
    void testExplicitWait() {
        driver.get(BASE_URL + "/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        String text = result.getText();
        System.out.println(text);
        assertTrue(text.contains("Hello World!"));

    }

    @Test
    void testFluentWait() {
        driver.get(BASE_URL + "/dynamic_loading/1");

        WebElement button = driver.findElement(By.xpath("//button[text()='Start']"));
        button.click();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .withMessage("Waiting for the result element");
        WebElement result = fluentWait.until(driver -> {
            WebElement element = driver.findElement(By.id("finish"));
            return element.isDisplayed() ? element : null;
        });

        String text = result.getText();
        System.out.println(text);
        assertTrue(text.contains("Hello World!"));

    }
}
