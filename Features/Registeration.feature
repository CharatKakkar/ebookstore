Feature: Registeration  Functionality

  @Register
  Scenario Outline: Successfully Register a user
    Given Registeration URl
    And User Details "<username>" "<password>" "<EmailId>" "<securityPhrase>" "<unitNumberBilling>" "<streetNumberBilling>" "<cityBilling>" "<provinceBilling>" "<countryBilling>" "<zipCodeBilling>"
    When I click on Go Button
    Then should get the successful message
    And should be able to login with the credentials "<username>" "<password>"

    Examples: 
      | username    |  | password |  | EmailId      |  | securityPhrase |  | unitNumberBilling |  | streetNumberBilling |  | cityBilling |  | provinceBilling |  | countryBilling |  | zipCodeBilling |
      | NAeAwiki5211 |  | password |  | ck@gmail.com |  | myPassword     |  |                90 |  | carling             |  | ottawa      |  | on              |  | Canada         |  | k1g3r4         |
      | SAAPseih625l |  | password |  | ck@gmail.com |  | myPassword     |  |                90 |  | carling             |  | ottawa      |  | on              |  | Canada         |  | k1g3r4         |
