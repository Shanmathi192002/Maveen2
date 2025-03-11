Feature: Login Test

  Scenario: User logs in with valid credentials
    Given I am on the login page
    When I enter valid credentials
    Then I should see a successful login message
