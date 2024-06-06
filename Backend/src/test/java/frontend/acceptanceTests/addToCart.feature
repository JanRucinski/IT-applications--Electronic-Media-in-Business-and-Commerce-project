Feature: Adding bike to shopping cart

  Scenario: User adds bike to a shop cart
    Given the user is on the bike buying page
    When the user searches for "Trek Mountain Bike"
    And the user adds the bike to the cart
    Then the bike should be added to the cart

  Scenario: User adds part to a shop cart
    Given the user is on the part buing page
    When the user searches for "Bontrager Wheels" part
    And the user adds the part to the cart
    Then the part should be added to the cart
