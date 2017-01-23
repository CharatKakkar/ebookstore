Feature: Registeration  Functionality

@Register
  Scenario Outline: Successfully Register a user
    Given Registeration URl
    And User Details"<username>" "<password>" "<EmailId>" "<unitNumberBilling>" "<streetNumberBilling>" "<cityBilling>" "<provinceBilling>" "<countryBilling>" "<zipCodeBilling>" "<shippingBillingSame>"
    And user Response on Shipping/Billing Address "<Response>"
    When I click on Go Button
    Then should get the successful message
    And should be able to login with the credentials "<username>" "<password>"
    
 

    Examples: 
      | username |  | password | |EmailId| |unitNumberBilling| |streetNumberBilling| |cityBilling| |provinceBilling| |countryBilling| |zipCodeBilling| |Response|
      | charat129900   |  |password| |ck@gmail.com| |90| |carling| |ottawa| |on| |Canada| |k1g3r4| |Yes|
