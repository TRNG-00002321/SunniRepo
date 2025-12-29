package com.revature.sel.pom;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageFactoryTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DisplayName("Login with Factory pages")
    @Test
    void testLogin() {
        LoginPageFac loginPage = new LoginPageFac(driver);
        SecurePageFac securePage = loginPage.enterUsername("tomsmith").enterPassword("SuperSecretPassword!").clickLogin();
        String flashMessage = securePage.getFlashMEssage();
        assertTrue(flashMessage.contains("secure"));

    }
}
