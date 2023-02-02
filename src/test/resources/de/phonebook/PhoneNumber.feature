Feature: Phone number

  Scenario: I add random phone number
    Given I have a valid access token
    And I add random contact
    And I have random phone number
    When I send POST request to 'phone' endpoint
    Then I see the status code 201


  Scenario: I add random phone number and delete contact then
    Given I have a valid access token
    And I add random contact
    And I have random phone number
    When I send POST request to 'phone' endpoint
    Then I see the status code 201
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200


  Scenario: Edit phone number
    Given I have a valid access token
    And I add random contact
    And I have random phone number
    When I send POST request to 'phone' endpoint
    And I see the status code 201
    And I edit phone number
    When I send PUT request to 'phone' endpoint
    Then I see the status code 200
