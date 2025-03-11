Feature: Password Reset
  @PasswordResetTest
  Scenario: User resets password
    Given the user is on the forgot password page
    When the user enters their email address
    And the user clicks the "Retrieve password" button
    Then the user receives a password reset email

  @Before
  Scenario: User navigates to forgot password page
    Given the user is on the login page
    When the user clicks the "Forgot password" link
    Then the user is redirected to the forgot password page

  @After
  Scenario: User closes the browser
    Given the user is on the forgot password page
    When the user closes the browser
    Then the browser is closed
