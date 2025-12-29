from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

service = Service(ChromeDriverManager().install())
driver = webdriver.Chrome(service=service)

try:
    driver.get("https://python.org")
    print(f"Page Title: {driver.title}")

    search_box = driver.find_element(By.ID, "id-search-field")
    search_box.send_keys("selenium")

    search_box.submit()

    print(f"Current URL: {driver.current_url}")
finally:
    driver.quit()
