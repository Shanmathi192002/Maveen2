@SearchTest
Feature: Search Functionality

  Scenario: User searches for a product
    Given I am on the Google homepage
    When I search for "iPhone"
    Then I should see search results
