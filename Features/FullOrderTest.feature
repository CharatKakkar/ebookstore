Feature: Complete Order Feature

@CompleteOrder
  Scenario Outline: Successful Login

    And Add some products into the cart
    Then Click on Checkout
    And Verify the details are present for Shipping and Billing Address
    Then Submit the order Verify that Order ID is display at thank you page

    Examples: 
      | username |  | password |
  
