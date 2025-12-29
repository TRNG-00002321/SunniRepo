package com.revature.sel;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Basic Selenium Test")
public class Test03SelectDemo {

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
    public void testDelcetDemo() {
        driver.get(BASE_URL + "/dropdown");

        WebElement dropElement = driver.findElement((By.id("dropdown")));

        Select dropdown = new Select(dropElement);
        dropdown.isMultiple(); // returns boolean value 
        // dropdown.selectByVisibleText("Option 2");
        dropdown.selectByValue("1");
        WebElement selectedOption = dropdown.getFirstSelectedOption();

        // assertEquals("Option 1", selectedOption.getText());
        assertEquals("1", selectedOption.getAttribute("value"));

    }
}
