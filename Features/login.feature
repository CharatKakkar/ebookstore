Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Title of your scenario
    Given Login URL
    And Login Credentials "<username>" and "<password>"
    When I click Login Button
    Then the login credentials should be valid
    And Products tab should be clicked
    And Logout should be clicked

    Examples: 
      | username |  | password |
      | charat   |  | charat   |
      | charat   |  | charat13 |

  Scenario Outline: Login should fail
    Given Login URL
    And Login Credentials "<username>" and "<password>"
    When I click Login Button
    Then invalid credentials message should be passed

    Examples: 
      | username |  | password |
      | charat   |  | charat13 |
      | charat   |  | charat   |
