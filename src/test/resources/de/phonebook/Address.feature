Feature: Address

  Scenario: I add random address
    Given I have a valid access token
    And I add random contact
    And I have random address
    When I send POST request to 'address' endpoint
    Then I see the status code 201


  Scenario: I add random address and delete contact then
    Given I have a valid access token
    And I add random contact
    And I have random address
    When I send POST request to 'address' endpoint
    Then I see the status code 201
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200