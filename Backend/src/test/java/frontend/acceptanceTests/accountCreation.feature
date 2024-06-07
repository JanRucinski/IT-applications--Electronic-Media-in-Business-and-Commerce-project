Feature: Creating and logging into account
  Scenario: User creates an account
    Given the user is on the sign-up page
    And the user has filled in all of the sing-up form fields
    When the user clicks create account button
    Then the user logs in using provided credentials