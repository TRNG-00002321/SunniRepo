package com.revature.sel;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Basic Selenium Test")
public class Test04Alerts {

    private WebDriver driver;
    private final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setup() {
        // Set up you web driver manager
        // WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("browser.link.open_newwindow", 2);
        // initialize webdriver
        // driver = new ChromeDriver();
        driver = new FirefoxDriver(options);

        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAlerts() {
        driver.get(BASE_URL + "/javascript_alerts");

        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();

        Alert alert = driver.switchTo().alert();

        // Get message
        String message = alert.getText();
        assertEquals("I am a JS Alert", message);

        // Accept (click OK)
        alert.accept();

        // Alert is now closed, back to main page
        assertTrue(driver.findElement(By.id("result")).getText().contains("You successfully clicked an alert"));
    }

    @Test
    void testPromptDialog() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Alert prompt = driver.switchTo().alert();
        assertEquals("I am a JS prompt", prompt.getText());

        // Type response
        prompt.sendKeys("Testing");

        // Accept
        prompt.accept();

        assertTrue(driver.findElement(By.id("result")).getText().contains("Testing"));
    }

    @Test
    void testMultipleWindows() throws InterruptedException {
        driver.get(BASE_URL + "/windows");

        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Thread.sleep(5000);

        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("new"));

        // Close new window
        driver.close();

        // Switch back to original
        driver.switchTo().window(originalWindow);

        // Verify we're back
        assertTrue(!driver.getCurrentUrl().contains("new"));

    }
}
