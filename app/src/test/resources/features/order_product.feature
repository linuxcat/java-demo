Feature: Authenticated User can only order products
  As a Web shopper
  I want to be able to purchase products if I am registered in the system
  So that unauthorised users can not create orders



  Scenario: User not registered can not order products
    Given I am an un-authenticated user
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
    Then the order will be successfully place