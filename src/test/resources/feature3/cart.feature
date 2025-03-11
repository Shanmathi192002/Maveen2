@CartTest
Feature: Add to Cart

Background:
    Given I am on the Saucedemo homepage
    And I login with valid credentials

Scenario: User adds a product to the cart
    When I add a product to the cart
    Then I should see the product in the cart
