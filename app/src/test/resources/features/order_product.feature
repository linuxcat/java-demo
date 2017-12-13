Feature:
  As a web shopper
  I want to be able to purchase products from the atsea website
  So that I can spend my money and make the company rich


  Scenario: Ordering product in stock
    Given I am an authenticated user
    When I add "Unusable Security" to my shopping cart
    Then my shopping cart should display "1" products
    And Total price should be "$25.00"
    When I checkout
    And enter valid card details
    Then the system will return "" message