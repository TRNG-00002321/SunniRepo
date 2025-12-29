"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""

from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver

BASE_URL = 'https://the-internet.herokuapp.com/'
def test_page_title():
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get(BASE_URL)
        assert BASE_URL == driver.current_url

def test_heading_text():
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get(BASE_URL)
        element = driver.find_element(By.CSS_SELECTOR, 'h1.heading')
        assert 'Welcome to the-internet' in element.text

def test_links_present():
    """Verify that all example links are present on the page."""
    # YOUR CODE HERE
    # Use find_elements to get all links
    # Use list comprehension to extract link texts
    with create_chrome_driver() as driver:
        driver.get(BASE_URL)
        # Get all links and extract their text
        links = driver.find_elements(By.TAG_NAME, "a")
        link_texts = [link.text for link in links if link.text]
        for text in link_texts:
            assert driver.find_element(By.LINK_TEXT, text).is_enabled


def test_link_attributes():
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    with create_chrome_driver() as driver:
        driver.get(BASE_URL)
        links = driver.find_elements(By.TAG_NAME, "a")
        hrefs = [link.get_attribute('href') for link in links if link.get_attribute('href')]

        assert len(hrefs) == len(links), "Some links missing href attribute"
