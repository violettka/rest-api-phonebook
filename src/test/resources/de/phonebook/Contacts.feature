Feature: Contact API Endpoints

  Scenario: Delete one contact
    Given I have a valid access token
    And I add new 'random' contact
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200

    Scenario: Bulk delete contacts
      Given I have a valid access token
      And I add new 'Max Mustermann' contact

      When I send GET request to 'contact/' endpoint
      Then I see the status code 200
      And I see at least one 'Max Mustermann' contact

      When I extract 'Max Mustermann' bulk contact IDs
      And I send DELETE request to 'contact/' endpoint
      Then I see the status code 200
      And I see none 'Max Mustermann' contact


