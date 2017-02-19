Feature: Forgot Password Functionality

  @ForgotPasswordTest
  Scenario Outline: Successfully Reset Password
    Given Login URL
    Then Click on Forgot Password
    And Fill in the details "<username>" "<Secret Phrase>" "<New Password>" "<Email Id>"
    Then Click Reset Password button
    Then Verify that Success message is received
    And Login with new credentials "<username>" "<New Password>"

    Examples: 
      | username |  | New Password |  | Secret Phrase |  | Email Id               |
      | Charat13 |  | password     |  |phrase|  | charatkakkar@gmail.com |
