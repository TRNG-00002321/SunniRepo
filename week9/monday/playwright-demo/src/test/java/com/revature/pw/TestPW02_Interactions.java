package com.revature.pw;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.revature.base.BaseTest;

public class TestPW02_Interactions extends BaseTest {

    @Test
    public void demoWaits() {
        navigateTo("/dynamic_loading/1");

        page.locator("#start button").click();
        String result = page.locator("#finish h4").textContent();

        System.out.println("Result ::: " + result);
    }

    @Test
    public void demoLocators() {
        navigateTo("/login");

        Locator byId = page.locator("#username");
        Locator byText = page.locator("text=login");
        Locator byRole = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
        Locator byPlaceHolder = page.getByPlaceholder("User name");
        Locator byLabel = page.getByLabel("username");
        // ARIA - ACCESSABLE RICH INTERNET APPLICATION

    }
}
