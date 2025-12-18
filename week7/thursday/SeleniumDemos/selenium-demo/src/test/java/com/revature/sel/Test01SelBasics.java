package com.revature.sel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Basic Selenium Test")
public class Test01SelBasics {

    private WebDriver driver;

    @Test
    public void testBasic() throws InterruptedException {
        // Set up you web driver manager
        WebDriverManager.chromedriver().setup();

        // initialize webdriver
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https:/www.selenium.dev/");
        Thread.sleep(5000);
        // Get the page Title
        String title = driver.getTitle();
        System.out.println("Title: " + title);

    }
}
