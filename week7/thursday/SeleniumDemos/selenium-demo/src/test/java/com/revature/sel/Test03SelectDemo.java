package com.revature.sel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

@DisplayName("Basic Selenium Test")
public class Test03SelectDemo {

    private final String BASE_URL = "https://the-internet.herokuapp.com/dropdown"

    private WebDriver driver;

    @AfterEach
    void teardown() {
        if dri
    }

    @Test
    public void testDelcetDemo() {
        driver.get(BASE_URL + "/dropdown");

        WebElement dropElement = driver.findElement((By.id("dropdown")));

        Select dropdown = new Select(dropElement);
        dropdown.selectByVisibleText("Option 2");

        WebElement selectedOption = dropdown.getFirstSelectedOption();
        assertEquals("Option 1", selectedOption.getText());
    
}
