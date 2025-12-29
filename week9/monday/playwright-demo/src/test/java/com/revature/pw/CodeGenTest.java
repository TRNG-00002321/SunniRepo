package com.revature.pw;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;

public class CodeGenTest {

        static Playwright playwright;
        static Browser browser;
        BrowserContext context;
        Page page;

        @BeforeAll
        static void launchBrowser() {
                playwright = Playwright.create();
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                                .setHeadless(false));
        }

        @BeforeEach
        void createContextAndPage() {
                context = browser.newContext();
                page = context.newPage();
        }

        @AfterEach
        void closeContext() {
                context.close();
        }

        @AfterAll
        static void closeBrowse() {
                browser.close();
                playwright.close();
        }

        @Test
        public void testLogin() {

                page.navigate("https://the-internet.herokuapp.com/login");
                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"))
                                .fill("tomsmith");

                page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password"))
                                .fill("SuperSecretPassword!");

                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(" Login")).click();
                assertThat(page.locator("#flash")).containsText("You logged into a secure area");
                assertThat(page.locator("h2")).containsText("Secure Area");

        }
}
