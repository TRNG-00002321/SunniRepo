package com.revature.tests;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.revature.base.BaseTest;

// import java.util.regex.Pattern;

public class LoginTests extends BaseTest {

    @Test
    void shouldLoginSuccessfully() {
        navigateTo("/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();

        // assertThat(page).hasURL(Pattern.compile(".*dashboard"));
        assertThat(page.locator(".flash")).containsText("You logged into a secure area!");
    }

    @Test
    void shouldShowErrorForInvalidCredentials() {
        navigateTo("/login");

        page.locator("#username").fill("invalid");
        page.locator("#password").fill("wrong");
        page.locator("button[type='submit']").click();

        assertThat(page.locator("#flash")).isVisible();
        assertThat(page.locator("#flash")).containsText("Your username is invalid!");
    }
}
