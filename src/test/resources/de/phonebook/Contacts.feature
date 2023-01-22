Feature: Contact API Endpoints

    Scenario: Delete one contact
        Given I have valid access token
        And I add new contact
        When I send DELETE request to 'contact/' endpoint
        Then I see the status code 200

    Scenario: Search for contact
        Given I have valid access token
        When I send GET request to 'contact/' endpoint
        Then I get contact with "Tim"
        Then I see the status code 200
