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


  Scenario: Search one contact
    Given I have a valid access token
    And I add random contact
    When I send GET request to 'contact/' endpoint
    Then I see added random contact


  Scenario: Search, edit and delete one contact
    Given I have a valid access token
    And I add random contact
    When I send GET request to 'contact/' endpoint
    And I edit random contact
    And I send PUT request to 'contact/' endpoint
    Then I see added random contact
    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200


  Scenario: Contact
    Given I have a valid access token
    And I add random contact
    And I have random address
    When I send POST request to 'address' endpoint
    Then I see the status code 201

    When I have random email
    And I send POST request to 'email' endpoint
    Then I see the status code 201

    When I have random phone number
    And I send POST request to 'phone' endpoint
    Then I see the status code 201

    When I edit random contact
    And I send PUT request to 'contact/' endpoint
    Then I see the status code 200

    When I send DELETE request to 'contact/' endpoint
    Then I see the status code 200
