Feature: Purchase flow

  Scenario: Checkout with product from inventory page
    Given user is logged in as standard_user
    When user adds to cart a product from inventory page
    And user opens cart page
    Then product is saved in the cart

    When user proceeds to checkout step one
    And user submits address from with
      | First Name | Last Name | Zip   |
      | Test       | Example   | 12345 |
    Then summary page with proper info is shown

    When user submits the order
    Then thank you page is shown


  Scenario: Checkout with product from product details page
    Given user is logged in as standard_user
    When user adds to cart a product from product details page
    And user opens cart page
    Then product is saved in the cart

    When user proceeds to checkout step one
    And submits address from with
      | First Name | Last Name | Zip   |
      | Test       | Example   | 12345 |
    Then summary page with proper info is shown

    When user submits the order
    Then thank you page is shown

  Scenario: Checkout after removing one cart item
    Given user is logged in as standard_user
    When user adds to cart several products from inventory page
    And user opens cart page
    Then product is saved in the cart

    When user proceeds to checkout step one
    And submits address from with
      | First Name | Last Name | Zip   |
      | Test       | Example   | 12345 |
    Then summary page with proper info is shown
    When user removes a product from the cart
    And proceeds through checkout
    And user submits the order
    Then thank you page is shown

  #Bug in application, checkout without products is allowed
  Scenario: Checkout with no products is not allowed
    Given user is logged in as standard_user
    And user opens cart page

    When user proceeds to checkout step one
    Then proceed to checkout button is disabled


  Scenario: Checkout with empty address is not allowed
    Given user is logged in as standard_user
    When user adds to cart several products from inventory page
    And user opens cart page
    Then product is saved in the cart

    When user proceeds to checkout step one
    And submits address from with
      | First Name | Last Name | Zip   |
      | Test       | Example   | 12345 |
    Then address validation messages are displayed

