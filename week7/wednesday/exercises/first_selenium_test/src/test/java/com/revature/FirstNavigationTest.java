package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FirstNavigationTest extends BaseTest {

    private final String BASE_URL = "https://the-internet.herokuapp.com/";

    @DisplayName("Navgate to 'the-internet' and verify title")
    @Test
    void testNavigation() {
        driver.get(BASE_URL);
        String title = driver.getTitle();
        assertTrue(title.contains("The Internet"));
    }

    @DisplayName("Navigate to site and find elements")
    @Test
    void testFindElements() {
        driver.get(BASE_URL + "/login");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        WebElement flash = driver.findElement(By.id("flash"));
        String flashMessage = flash.getText();
        assertTrue(flashMessage.contains("invalid"));
    }

    @DisplayName("Navigate to 'the-internet.herohuapp.com/dropdown' and select 'Option 1'")
    @Test
    void testDropdown() {
        driver.get(BASE_URL + "/dropdown");

        String url = driver.getCurrentUrl();
        assertTrue(url.contains(("dropdown")));
        WebElement element = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Option 1");
        String option = dropdown.getFirstSelectedOption().getText();
        assertTrue(option.contains("Option 1"));
    }

    @DisplayName("Test link clicking and navigation")
    @Test
    public void testLinkClicking() {
        driver.get(BASE_URL);

        driver.findElement(By.linkText("Checkboxes")).click();
        assertTrue(driver.getCurrentUrl().contains("checkboxes"));

        driver.navigate().back();

        assertTrue(driver.getCurrentUrl().equals(BASE_URL));
    }

    @DisplayName("Test checkbox interaction")
    @Test
    public void testCheckboxes() {
        driver.get(BASE_URL + "/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox"));
        assertEquals(2, checkboxes.size());
        WebElement c1 = checkboxes.get(0);
        WebElement c2 = checkboxes.get(1);

        checkboxes.get(0).click();
        assertTrue(c1.isSelected());

        checkboxes.get(1).click();
        assertFalse(c2.isSelected());
    }
}
