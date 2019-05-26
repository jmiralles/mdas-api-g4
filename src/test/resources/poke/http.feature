Feature: Registry of the users
  Scenario: Obtention of invalid pokemon in HTTP
    Given I am in HTTP application
    When I enter "1"
    Then I get correct response
