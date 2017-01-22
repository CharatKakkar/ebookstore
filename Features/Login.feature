Feature: Login Feature


@Login
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

