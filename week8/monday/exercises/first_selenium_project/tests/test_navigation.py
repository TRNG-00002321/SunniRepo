"""
Test navigation functionality using Python Selenium.

Implement tests that:
1. Navigate to https://the-internet.herokuapp.com/
2. Click on "Form Authentication" link
3. Verify URL changed to /login
4. Use back/forward navigation
5. Capture screenshots at key points
"""

from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver

BASE_URL = "https://the-internet.herokuapp.com/"

def test_navigate_to_login_page():
    """
    Test: Navigate from home to login page
    
    Steps:
    1. Go to the-internet homepage
    2. Find and click "Form Authentication" link
    3. Assert URL contains "/login"
    4. Assert page contains "Login Page" heading
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get(BASE_URL + '/login')
        assert 'login' in driver.current_url
        assert 'Login Page' in driver.find_element(By.CSS_SELECTOR, 'h2').text
    



def test_back_forward_navigation():
    """
    Test: Browser navigation (back/forward)
    
    Steps:
    1. Navigate to homepage
    2. Click a link to go to another page
    3. Use driver.back() to return
    4. Assert you're on homepage
    5. Use driver.forward() to go forward
    6. Assert you're on the second page again
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get(BASE_URL)
        driver.find_element(By.LINK_TEXT, 'Form Authentication').click()
        driver.back()
        assert driver.current_url == BASE_URL
        driver.forward()
        assert 'login' in driver.current_url

        

def test_capture_screenshot():
    """
    Test: Screenshot capture
    
    Steps:
    1. Navigate to any page
    2. Take a full page screenshot
    3. Save it to screenshots/homepage.png
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get(BASE_URL)
        driver.save_screenshot("../screenshots/homepage.png")
