Feature: Purchasing a bike

  Scenario: User purchases a bike
    Given the user has a bike in the shopping cart
    When the user click the checkout button
     And the user provides correct data
    Then the user should receive information about successful purchase