Feature: User Registration

  Background:
    Given I am on the Demoblaze signup page

  Scenario: User registers with valid details
    When I enter valid registration details
      | username | password |
      | Shanmathi    | 24379    |
    And I click on the signup button
    #And I click on the OK button