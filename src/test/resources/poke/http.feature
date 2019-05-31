Feature: Registry of the users
  Scenario: Obtention of invalid pokemon in HTTP
    Given I am in HTTP application
    When I send "1" to pokemon-type endpoint
    Then I get ["poison","grass"]
