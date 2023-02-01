Feature: Email

  Scenario: I add random email number
    Given I have a valid access token
    And I add random contact
    And I have random email
    When I send POST request to 'email' endpoint
    Then I see the status code 201


  Scenario: I add random email and delete contact then
    Given I have a valid access token
    And I add random contact
    And I have random email
    When I send POST request to 'email' endpoint
    Then I see the status code 201
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200
