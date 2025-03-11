@CheckoutTest
Feature: Checkout Process

  Background: 
    Given I am on the Saucedemo homepage
    And I login with valid credentials

  Scenario: User completes the checkout process
    When I add a product to the cart
    And I click on the shopping cart link
    And I click on the checkout button
    When I enter my personal details
      | firstName | lastName | postalCode |
      | Shanmathi | 24379    | 625009     |
    And I click on the continue button
    And I click on the finish button
    Then I should see the order confirmation message