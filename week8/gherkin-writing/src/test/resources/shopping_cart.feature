@cart
Feature: Shopping Cart Management
  As an online shopper
  I want to manage items in my shopping cart
  So that I can purchase the products I need

  Background:
    Given the user is logged in
    And the product catalog is available

  @smoke
  Scenario: Add single item to cart
    # TODO: Write the scenario
    Given the user is on a product page
    When the user clicks add to cart
    Then the Item appears in cart
    And cart count updates

  Scenario: Add multiple quantities of an item
    # TODO: Write the scenario
    # Consider quantity selector interaction
    Given the user is on a product page
    When the user selects quantity "3"
    And the user clicks add to cart
    Then the Item appears in cart with quantity "3"
    And cart count updates

  Scenario: View cart contents
    # TODO: Write the scenario
    # Include verification of item details shown
    Given the user has added items to the cart
    When the user navigates to the cart page
    Then the cart displays all added items with correct details

  Scenario: Update item quantity in cart
    # TODO: Write the scenario
    # Include before/after quantity and price verification
    Given the user has an item in the cart
    When the user updates the item quantity to "5"
    Then the cart reflects the updated quantity

  Scenario: Remove item from cart
    # TODO: Write the scenario
    # Verify item no longer appears and price updates
    Given the user has an item in the cart
    When the user removes the item from the cart
    Then the item no longer appears in the cart

  Scenario: Empty cart displays message
    # TODO: Write the scenario
    # Verify appropriate message when cart is empty
    Given the user has no items in the cart
    When the user views the cart page
    Then the cart displays an "empty cart" message

  Scenario: Cart total calculates correctly
    Given the user has the following items in cart:
      | Product  | Price | Quantity |
      | Widget A | 10.00 |        2 |
      | Widget B | 25.00 |        1 |
    Then the cart subtotal should be "$45.00"
