Feature: Forgot Password Functionality

  @ForgotPasswordTest
  Scenario Outline: Successfully Reset Password
    Given Login URL and login credentials "<username>" "<password>"
    Then Add some products into the cart
    And Click on cart and verify the total
    And Click on check out
    Then Verify the details are present for Shipping and Billing Address
    And Submit the order Verify that Order ID is display at thank you page

    Examples: 
      | username |  | password |
      | Charat12 |  | password |
