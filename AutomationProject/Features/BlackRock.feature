@blackrock
Feature: BlackRock

Scenario: Search on BalckRock portal
Given BalckRock portal is open
When User searches for below on BlackRock Portal
|Term|
|Central|
Then the search result is displayed on BlackRock portal
