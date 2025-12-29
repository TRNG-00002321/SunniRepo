package com.revature.sel.pom;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("POM Implementation")
public class TestPomImpl {

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
        driver.get(BASE_URL + "/login");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testLoginValid() {
        LoginPage loginPage = new LoginPage(driver);
        // SecurePage securePage = loginPage
        //         .enterUsername("tomsmith")
        //         .enterPassword("SuperSecretPassword!")
        //         .clickLogin();

        SecurePage securePage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        assertTrue(securePage.getFlashMessage().contains("logged"));

    }
}
// 1-3 exercises and review
// 3-5 project work;
