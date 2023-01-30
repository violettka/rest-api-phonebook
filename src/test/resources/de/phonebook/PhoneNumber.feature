Feature: Phone number

  Scenario: I add random phone number
    Given I have a valid access token
    And I add random contact
    And I have random phone number
    When I send POST request to 'phone' endpoint
    Then I see the status code 201
