Feature: Adding bike to shopping cart

  Scenario: User adds bike to a shop cart
    Given the user is on the bike buying page
    When the user searches for "Trek Mountain Bike"
    And the user adds the bike to the cart
    Then the bike should be added to the cart
