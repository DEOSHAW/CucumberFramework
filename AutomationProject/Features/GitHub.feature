@GitHub
Feature: GitHub Feature

  Scenario Outline: Get Repository names
    Given Github portal is launched
    When Login is successful with "<Username>" and "<Password>"
    Then Find the names of the repositories

    Examples: 
      | Username           | Password    |
      | deoshaw3@gmail.com | Devanshi@03 |
