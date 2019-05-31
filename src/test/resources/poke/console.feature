Feature: Registry of the users
  Scenario: Obtention of invalid pokemon in CLI
    Given I am in CLI application
    When I enter "-1"
    Then I get "Unknown Pokemon" in System.out
    Then I get error code 1
