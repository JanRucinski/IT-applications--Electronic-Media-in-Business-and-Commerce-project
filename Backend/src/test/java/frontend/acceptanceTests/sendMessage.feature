Feature: Ability to send messages to shop via form
  Scenario: User successfully sends message via form
    Given the user is on the contact page
    And the user has filled in all the form fields
    When the user clicks send message button
    Then the success popup should be shown

  Scenario: User forgets to put an email into the form
    Given the user is on the contact page
    And the user has filled in almost the form fields
    When the user clicks send message button
    Then the error about filling form should be shown