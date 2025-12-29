package com.revature.sel.pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurePageFac {

    @FindBy(id = "flash")
    private WebElement flashMessage;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public SecurePageFac(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getFlashMEssage() {
        return flashMessage.getText();
    }
}
