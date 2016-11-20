Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Title of your scenario
    Given Login URL
    And Login Credentials "<username>" and "<password>"
    When I click Login Button
    Then the login credentials will be validated
    And Products tab should be clicked
    And Logout should be clicked

    Examples: 
      | username |  | password |
      | charat   |  | charat   |

  Scenario Outline: Login should fail
    Given Login URL
    And Login Credentials "<username>" and "<password>"
    When I click Login Button
    Then the login credentials will be validated
    And invalid credentials message should be passed

    Examples: 
      | username |  | password |
      | charat   |  | charat13 |
      
    
