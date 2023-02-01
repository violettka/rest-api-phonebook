Feature: Contact API Endpoints

  Scenario: Delete one contact
    Given I have a valid access token
    And I add random contact
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200


  Scenario: Delete many contacts
    Given I have a valid access token
    And I add a few 'Rex' contacts
    When I send GET request to 'contact/' endpoint
    Then I see the status code 200

    When I get id list of 'Rex' contacts
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200

    When I send GET request to 'contact/' endpoint
    Then I see the status code 200
    And I see none 'Rex' contacts

  Scenario: Edit one contact
    Given I have a valid access token
    And I add random contact
    And I edit random contact
    When I send PUT request to 'contact/' endpoint
    Then I see the status code 200

