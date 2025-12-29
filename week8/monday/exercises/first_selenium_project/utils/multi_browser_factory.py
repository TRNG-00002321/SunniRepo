"""
Multi-browser driver factory with webdriver-manager.

Supports:
- Chrome
- Firefox
- Edge
"""

from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service as ChromeService
from selenium.webdriver.firefox.service import Service as FirefoxService
from selenium.webdriver.edge.service import Service as EdgeService
from webdriver_manager.chrome import ChromeDriverManager
from webdriver_manager.firefox import GeckoDriverManager
from webdriver_manager.microsoft import EdgeChromiumDriverManager


@contextmanager
def create_driver(browser: str = "chrome", headless: bool = False):
    """
    Create a WebDriver instance for the specified browser.
    
    Args:
        browser: Browser name ("chrome", "firefox", "edge")
        headless: Run in headless mode if True
    
    Yields:
        WebDriver instance
    
    Example:
        with create_driver("firefox", headless=True) as driver:
            driver.get("https://example.com")
    """
    # configs = {
    #     "chrome":{
    #         'driver' : webdriver.Chrome,
    #         'options' : webdriver.ChromeOptions,
    #         'driver_manager': ChromeDriverManager,
    #         'service' :  ChromeService},
    #     "firefox":{
    #         'driver' : webdriver.Firefox,
    #         'options' : webdriver.FirefoxOptions,
    #         'driver_manager':GeckoDriverManager,
    #         'service' :  FirefoxService},
    #     "edge":{
    #         'driver' : webdriver.Edge,
    #         'options' : webdriver.EdgeOptions,
    #         'driver_manager': EdgeChromiumDriverManager,
    #         'service' :  EdgeService
    #     }}
    # config = configs[browser]
    # options = config['options']()
    # service = config['service'](config['driver_manager'].install())
    # if headless:
    #     options.add_argument('--headless')

    # driver = config['driver'](service=service, options=options)
    # try: 
    #     yield driver
    # finally:
    #     driver.quit()
    driver = None
    try:
        if browser.lower() == "chrome":
            options = webdriver.ChromeOptions()
            if headless:
                options.add_argument('--headless')
            service = ChromeService(ChromeDriverManager().install())
            driver = webdriver.Chrome(service=service, options=options)
            
        elif browser.lower() == "firefox":
            options = webdriver.FirefoxOptions()
            if headless:
                options.add_argument('-headless')
            service = FirefoxService(GeckoDriverManager().install())
            driver = webdriver.Firefox(service=service, options=options)
            
        elif browser.lower() == "edge":
            options = webdriver.EdgeOptions()
            if headless:
                options.add_argument('--headless')
                options.add_argument('--disable-gpu')
            service = EdgeService(executable_path=EdgeChromiumDriverManager().install())
            driver = webdriver.Edge(service=service, options=options)
        
        else:
            raise ValueError(f"Unsupported browser: {browser}")
        
        driver.implicitly_wait(10)
        yield driver
        
    finally:
        if driver:
            driver.quit()


"""
Get the installed browser version.
"""
def get_browser_version(browser: str) -> str:
    with create_driver(browser) as driver:
        return driver.capabilities.get('browserVersion')
