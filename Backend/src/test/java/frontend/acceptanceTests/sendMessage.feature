Feature: Ability to send messages to shop via form
  Scenario: User sends message via form
    Given the user is on the contact page
    And the user has filled in all the form fields
    When the user clicks send message button
    Then the success popup should be shown