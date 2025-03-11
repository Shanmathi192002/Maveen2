Feature: Product Filter

  Background:
    Given I am logged in to Saucedemo

  Scenario: User applies product filters
    When I select the filter option "Price (low to high)"
    Then I should see the filtered products
