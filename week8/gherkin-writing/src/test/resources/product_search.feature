@search
Feature: Product Search
  As a customer
  I want to search for products
  So that I can quickly find what I'm looking for

  Background:
    Given the product catalog contains:
      | Name           | Category    | Price  |
      | Laptop Pro     | Electronics | 999.00 |
      | Laptop Basic   | Electronics | 599.00 |
      | Wireless Mouse | Electronics |  29.00 |
      | Desk Chair     | Furniture   | 199.00 |
      | Standing Desk  | Furniture   | 449.00 |

  @smoke
  Scenario: Search by exact product name
    # TODO: Write the scenario
    When the user searches for "Laptop Pro"
    Then the search result should contain 1 product
    And the results should include "Laptop Pro"

  Scenario: Search by partial product name
    When the user searches for "Laptop"
    Then the search results should contain 2 products
    And the results should include "Laptop Pro"
    And the results should include "Laptop Basic"

  Scenario: Search by category
    # TODO: Write the scenario
    When the user searches for "Furniture"
    Then the search results should contain 2 products
    And the results should include "Desk Chair"
    And the resuits should include "Standing Desk"

  Scenario: Empty search returns all products
    # TODO: Write the scenario
    When the user searches for ""
    Then the search results should contain all products

  Scenario: No matching results shows message
    # TODO: Write the scenario
    When the user searches for "unrelated search term"
    Then the search results should be empty
    And the user should see a message indicating "No matching results"

  Scenario: Sort results by price ascending
    Given the user has searched for "Electronics"
    When the user sorts by "Price: Low to High"
    Then the first result should be "Wireless Mouse"
    And the last result should be "Laptop Pro"

  Scenario: Filter results by price range
    # TODO: Write the scenario
    # Filter to products between $100 and $500
    Given the user has searched for ""
    When the user filters by "Price Range:" "100" - "500"
    Then the results should include "Desk Chair"
    And the resuits should include "Standing Desk"
