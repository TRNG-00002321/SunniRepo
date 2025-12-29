"""
Cross-browser compatibility tests.

Run the same tests across Chrome, Firefox, and Edge.
"""

import pytest
from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from utils.multi_browser_factory import create_driver

# Parameterize tests to run on multiple browsers
BROWSERS = ["chrome", "firefox", "edge"]  # Add "edge" if installed


@pytest.mark.parametrize("browser", BROWSERS)
def test_page_loads_correctly(browser):
    """
    Verify the page loads correctly in each browser.
    
    Steps:
    1. Navigate to the-internet homepage
    2. Verify page title
    3. Verify heading text
    """
    with create_driver(browser, headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com/")
        
        assert "The Internet" in driver.title
        
        heading = driver.find_element(By.TAG_NAME, "h1")
        assert "Welcome to the-internet" in heading.text


@pytest.mark.parametrize("browser", BROWSERS)
def test_form_interaction(browser):
    """
    Verify form interaction works in each browser.
    
    Steps:
    1. Navigate to login page
    2. Enter credentials
    3. Submit form
    4. Verify result
    """
    # TODO: Implement cross-browser form test
    with create_driver(browser, headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com/login")
        
        username_field = driver.find_element(By.ID, 'username')
        username_field.send_keys('tomsmith')
        password_field = driver.find_element(By.ID, 'password')
        password_field.send_keys('SuperSecretPassword!')
        login_button = driver.find_element(By.XPATH, "//button[@type='submit']")
        login_button.click()
        flash_message = driver.find_element(By.ID, 'flash')
        assert 'You logged into a secure area!' in flash_message.text
        


@pytest.mark.parametrize("browser", BROWSERS)
def test_screenshot_capture(browser):
    """
    Verify screenshot capture works in each browser.
    
    Steps:
    1. Navigate to a page
    2. Take screenshot
    3. Verify file was created
    """
    # TODO: Implement screenshot test
    # Save to screenshots/{browser}_screenshot.png
    with create_driver(browser, headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com/")
        driver.save_screenshot(f"../screenshots/{browser}_screenshot.png")

        