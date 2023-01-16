Feature: Login to Phonebook

  Scenario: Login to Phonebook with valid credentials
    Given I have a valid user credentials
    When I send POST request to 'user/login' endpoint
    Then I see the status code 200
