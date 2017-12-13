Feature:
  As a web shopper
  I want to be able to purchase products from the atsea website
  So that I can spend my money and make the company rich


  Scenario: Ordering product in stock
    Given I am an authenticated user
    When I add "Unusable Security" to my shopping cart
    Then my shopping cart should display "1" products
    And Total price should be "$26.50"
    When I enter card information
      | firstname | lastname | cardNumber | cvv | expiryDate |
      | Sarndeep  | Nijjar   | 12315321   | 221 | 12/21      |
    And I enter billing information
      | company     | title | address     | city   |
      | ecs-digital | Mr    | London Road | London |
    And Submit the order to the system
    Then the system will return "Please login before completing order..." message